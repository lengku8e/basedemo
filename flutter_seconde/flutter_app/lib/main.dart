import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';

void main() {
  // 开启布局边界

  debugPaintSizeEnabled = false;
  runApp(new MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Flutter Demo',
      theme: new ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or press Run > Flutter Hot Reload in IntelliJ). Notice that the
        // counter didn't reset back to zero; the application is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: new MyStatefulWidget(),
      debugShowCheckedModeBanner: false,
      // 应用程序性能图开关
//        showPerformanceOverlay :true,
      // 对齐网格，用来看view是否对其
//        debugShowMaterialGrid : true,
    );
  }
}

class MyStatefulWidget extends StatefulWidget {
  @override
  createState() => new RandomWordsState();
}

class RandomWordsState extends State<MyStatefulWidget> {
  final _suggestions = <String>["sun", "hai", "long"];

  final _biggerFont = const TextStyle(fontSize: 18.0);

  // 调取java方法
  static const MethodChannel _channel = const MethodChannel('getToastPlugins');

  static Future<bool> getNaToast() {
    return _channel.invokeMethod('getToast');
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('first_page'),
        actions: <Widget>[
          new IconButton(icon: new Icon(Icons.list), onPressed: _pressAction),
          new FlatButton(
              onPressed: () {
//          debugDumpApp();
                getNaToast();
                debugDumpRenderTree();
              },
              child: new Text('icon')),
          new IconButton(
              icon: new Icon(Icons.account_balance), onPressed: _toggle)
        ],
      ),
      body: _getView(),
    );
  }

  _pressAction() {
    Navigator.of(context).push(
      new MaterialPageRoute(
        builder: (context) {
          return new MyStatelessWidget();
        },
      ),
    );
  }

  var isCard = true;

  _getView() {
    if (isCard) {
      return new MyCard();
    } else {
      return new MaterialButton(
          onPressed: () {}, child: new Text('调起原生activity'));
    }
  }

  void _toggle() {
    setState(() {
      isCard = !isCard;
    });
  }
}

class MyStatelessWidget extends StatelessWidget {
  var _checkState = false;
  @override
  Widget build(BuildContext context) {
    final title = 'list';
    return new MaterialApp(
      title: title,
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text(title),
        ),
        body: new Center(
          child: new ListView(
            //控制方向 默认是垂直的
//           scrollDirection: Axis.horizontal,
            children: <Widget>[
              _getContainerItem('maps', Icons.map),
              _getContainerItem('phone', Icons.phone),
              _getContainerItem('alarm', Icons.alarm),
            ],
          ),
        ),
      ),
    );
  }

  // item 列表ui
  Widget _getContainerItem(String test, IconData icon) {
    return new Container(
      width: 160.0,
//      ListTile
      child: new ListTile(
//       显示在title之前
        leading: new Icon(icon),
        // statelesswidget无法动态改变状态
        trailing: new Checkbox(
            value: _checkState,
            onChanged: (bool newValue) {
              setState() {
                _checkState = newValue;
              }
            }),

        title: new Text(test),
        subtitle: new Text("我是subtitle"),
      ),
    );
  }
}

class MyCard extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return new MyCardState();
  }
}

class MyCardState extends State<MyCard> with TickerProviderStateMixin {
  var _throwShotAway = false;

  AnimationController controller;
  CurvedAnimation incurve;
  CurvedAnimation outcurve;
  @override
  Widget build(BuildContext context) {
    debugPrint("我是调试信息" + TimeOfDay.now().toString());
    return new Scaffold(
        floatingActionButton: new FloatingActionButton(
            tooltip: 'Fade',
            child: new Icon(Icons.brush),
            onPressed: () {
              controller.forward();
            }),
        body: new Center(
            child: new Card(
                child: new Column(children: <Widget>[
          new ListTile(
              title: new Text("ListTile_title"),
              subtitle: new Text("ListTile_title_subtitle"),
              //之前显示icon
              leading: new Icon(Icons.email, color: Colors.blueAccent),
              //之后显示checkBox

              onTap: () {
                setState(() {
                  if (_throwShotAway) {
                    _throwShotAway = false;
                  } else {
                    _throwShotAway = true;
                  }
                });
              },
              selected: true,
              isThreeLine: true,
              trailing: new Checkbox(
                  value: _throwShotAway,
                  onChanged: (bool newValue) {
                    setState(() {
                      _throwShotAway = newValue;
                    });
                  })),
          new Container(
              child: new FadeTransition(
                  opacity: _getCurve(),
                  child: new FlutterLogo(
                    size: 100.0,
                  )))
        ]))));
  }

  var isIn = true;
  _getCurve() {
    if (isIn) {
      isIn = false;
      return incurve;
    } else {
      isIn = true;
      return outcurve;
    }
  }

  @override
  void initState() {
    controller = new AnimationController(
        duration: const Duration(milliseconds: 200), vsync: this);
    incurve = new CurvedAnimation(parent: controller, curve: Curves.easeIn);
    outcurve = new CurvedAnimation(parent: controller, curve: Curves.easeOut);
  }
}
