# Java-Keyboard-Robot-Control
This uses JNativehook and Diozero to control a robot that uses the CamJam Edukit 3

## Getting Started

To run this application be sure to have Maven installed. You can download via this [link](https://maven.apache.org/download.cgi). After installing Maven you can package the application with `mvn package`. Make sure you are in the main directory that has the `pom.xml` file. Then change to the newly created target directory and then run the application with `java -jar -DPIGPIOD_HOST=<your-pi-ipaddres> movement-1.0-SNAPSHOT-jar-with-dependencies.jar`. Make sure you have Remote GPIO enabled on the robot with `sudo pigpiod` or you can enable it in the Interfaces menu by running `sudo raspi-config` or going to the Raspberry Pi Configuration Menu. Use the cursor keys for movement but wait as there is a delay. I will be using pi4J V 2 once it is finalized.
