# remotecanvas
This Maven project contains three parts:
1. _svghttpd_: A swing application with an SVG canvas and an attached HTTP server
2. _svgclient_: A client library to issue drawing commands to the swing application via HTTP
3. _svgdemo_: A demo application that shows how to use the client library

To build the applications:
- _cd_ into the directory, e.g. svghttpd
- mvn clean compile assembly:single
- java -jar target\svghttpd-1.0-jar-with-dependencies.jar

Two _stripped down_ libraries are created, that are used in the JetBrains MPS project [RemoteAdapterGenerator](https://github.com/janradeck/RemoteAdapterGenerator)
- svgclient-1.0-interface.jar
- svghttpd-1.0-interface.jar
