package com.ecommerce.app.models.entity;

import com.ecommerce.app.models.entity.converter.JpaConverterJson;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@Entity(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"handler", "hibernate_lazy_initializer"})
@XmlRootElement
public class UserEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

    @Column(name = "device_id")
    private String deviceId;

    @Convert(converter = JpaConverterJson.class)
    @Column(name = "user_address")
    List<Address> userAddress;

    @NonNull
    private String role = "ROLE_CUSTOMER";

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore  // fix bi-direction toString() recursion problem
    private CartEntity cart;
}
