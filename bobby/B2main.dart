import 'dart:html';
import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(title: Text('dicee'),centerTitle: true,),
      body: DicePage(),
    ),
  ));
}

class DicePage extends StatefulWidget{
  const DicePage({Key?key}):super(key: key);
  @override
  _DicePageState createState() => _DicePageState();

}

class _DicePageState extends State<DicePage>{
  int left=1;
  int right=1;
  
  void changeFace(){
    setState(() {
      left=Random().nextInt(6)+1;
      right=Random().nextInt(6)+1;
    });
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Center(
      child: Container(
        child: Row(
          children: [
            Expanded(
              flex: 1,
              child: TextButton(
                style: TextButton.styleFrom(
                backgroundColor: Colors.deepPurple,
                ),
                child: Image.asset(images/dice$left.png),
                onPressed: (){
                  changeFace();
                  },
              ),
            ),
            Expanded(
                flex:1,
                child: TextButton(
                  style: TextButton.styleFrom(
                    backgroundColor: Colors.deepPurple,
                  ),
                  child: Image.asset(images/dice$right.png),
                  onPressed: () {
                    changeFace();
                    },
                ),
            ),
          ],
        ),
      ),
    );
  }
}