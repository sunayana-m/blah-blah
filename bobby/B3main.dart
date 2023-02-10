import 'dart:typed_data';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(title: Text('xylophone'), centerTitle: true,),
      body: XyloPage(),
    ),
  ));
}

class XyloPage extends StatefulWidget{
  const XyloPage({Key?key}):super(key:key);
  @override
  _XyloState createState() => _XyloState();
}

class _XyloState extends State<XyloPage>{
  void playAudio(int n) async{
    AudioPlayer player=AudioPlayer();
    String audioAsset = 'assets/note$n.wav' ; // plays the passed ith audio file
    ByteData bytes = await rootBundle.load(audioAsset);
    Uint8List audiobytes = bytes.buffer.asUint8List(bytes.offsetInBytes,bytes.lengthInBytes);
    int result = await player.playBytes(audiobytes);
    if(result == 1){ //play success
      print("audio is playing.");
    }else{
      print("Error while playing audio.");
    }
  }
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Expanded(child: TextButton(style: TextButton.styleFrom(
          backgroundColor: Colors.deepPurple
        ),
          onPressed: () {
          playAudio(1);
          }, child: Text('First'),
        ),
        ),
        Expanded(child: TextButton(style: TextButton.styleFrom(
            backgroundColor: Colors.deepOrange
        ),
          onPressed: () {
            playAudio(2);
          }, child: Text('Second'),
        ),
        ),
        Expanded(child: TextButton(style: TextButton.styleFrom(
            backgroundColor: Colors.amber
        ),
          onPressed: () {
            playAudio(3);
          }, child: Text('Third'),
        ),
        ),
        Expanded(child: TextButton(style: TextButton.styleFrom(
            backgroundColor: Colors.green
        ),
          onPressed: () {
            playAudio(4);
          }, child: Text('Fourth'),
        ),
        ),
        Expanded(child: TextButton(style: TextButton.styleFrom(
            backgroundColor: Colors.blue
        ),
          onPressed: () {
            playAudio(5);
          }, child: Text('Fifth'),
        ),
        ),
        Expanded(child: TextButton(style: TextButton.styleFrom(
            backgroundColor: Colors.orangeAccent
        ),
          onPressed: () {
            playAudio(6);
          }, child: Text('Sixth'),
        ),
        ),
        Expanded(child: TextButton(style: TextButton.styleFrom(
            backgroundColor: Colors.indigo
        ),
          onPressed: () {
            playAudio(7);
          }, child: Text('Seventh'),
        ),
        ),
      ],
    );
  }

}

