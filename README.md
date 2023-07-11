# remotecanvas
This Maven project contains five parts:
1. _svghttpd-interface_: The interface to _svghttpd_
2. _svghttpd_: A swing application with an SVG canvas and an attached HTTP server
3. _svgclient-interface_: The interface to _svgclient_
4. _svgclient_: A client library to issue drawing commands to the swing application via HTTP
5. _svgdemo_: A demo application that shows how to use the client library

To build the applications:
- _cd_ into the directory, e.g. svghttpd
- mvn clean compile assembly:single
- java -jar target\svghttpd-1.0-jar-with-dependencies.jar

The two interface jars are used in the JetBrains MPS project [RemoteAdapterGenerator](https://github.com/janradeck/RemoteAdapterGenerator)
- svgclient-interface-1.0.jar
- svghttpd-interface-1.0.jar
