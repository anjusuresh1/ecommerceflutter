import 'package:flutter/material.dart';
import 'package:fluttercommerce/di/di.dart';
import 'package:fluttercommerce/features/app/global_listener/global_listener.dart';
import 'package:fluttercommerce/features/app/res/app_theme.dart';
import 'package:fluttercommerce/features/app/routes/navigation_handler.dart';
import 'package:fluttercommerce/features/module_init.dart';

class App extends StatefulWidget {
  const App({Key? key}) : super(key: key);

  @override
  _AppState createState() => _AppState();
}

class _AppState extends State<App> {
  @override
  void initState() {
    DI.container<GlobalListener>().refreshListener(
          GlobalListenerConstants.accountDetails,
          '',
        );
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      theme: AppTheme.appTheme(),
      debugShowCheckedModeBanner: false,
      routerDelegate: NavigationHandler.routerDelegate,
      routeInformationParser: NavigationHandler.routeInformationParser,
    );
  }

  @override
  void dispose() {
    super.dispose();
    ModuleInit.closeModules();
  }
}
