# Sweep-AI

This is a Java minesweeper ai, which can play the windows 10 variant of minesweeper: minesweeperX available [**here**](http://www.minesweeper.info/downloads/MinesweeperX.html).  
Unfortunately, because the AI relies on using screenshots and having constant window border sizes, it will only work on win10 computers.

[More Info](http://tomscherlis.com/otw-portfolio/minesweeper-ai/)
Author: [Tom Scherlis](http://tomscherlis.com/)

## Updates
This has been updated to include the use of [Maven](https://maven.apache.org/) and has an embedded wrapper command.

To use from the command line issue the following

*Windows*
```
set JAVA_HOME=<JDK HOME DIRECTORY>
mvnw exec:java
```

*Linux*
```
export JAVA_HOME=<JDK HOME DIRECTORY>
mvnw exec:java
```
