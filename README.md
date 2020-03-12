# log-utils
Log util challenge


# Read log 

Log example format 
```
2015-10-26T16:11:27,724 TRACE [OperationsImpl] entry with (getData:17961)
```

# Demo run from IDE 

- import project 
- run LogParserDemo in any IDE


# Demo run from command line 
```
mvn clean compile exec:java
```

# Demo run in Docker 

- execute from root project folder
```
sudo docker build --no-cache -t my-image:1 -f ./Dockerfile .
```
```
sudo docker run -it --rm my-image:1 /bin/sh
```
- execute in docker console 
```
mvn clean compile exec:java
```