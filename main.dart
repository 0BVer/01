import 'package:flutter/material.dart';

void main() => runApp(cross01App());

// ignore: camel_case_types
class cross01App extends StatelessWidget {

  Widget buildKey(Color color, int n){
    return Expanded(
      child: FlatButton(
        color: color,
        onPressed: () {
        },
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.black,
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            buildKey(Colors.black, 1),
            buildKey(Colors.white, 2),
            buildKey(Colors.black, 3),
            buildKey(Colors.white, 4),
            buildKey(Colors.black, 5),
            buildKey(Colors.white, 6),
            buildKey(Colors.black, 7),
            buildKey(Colors.white, 8),
          ],
        ),
      ),
    );
  }
}