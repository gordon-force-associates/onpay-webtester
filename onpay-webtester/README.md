# onpay-webtester

This is the example jbehave project referred to in Behavior Driven Development talks given 
by Gordon Force.  

### Depended-on Technologies

JDK required: 6.0 (or above). JDK 7.02 used during development.
[Maven](http://maven.apache.org) required (2.2.1 or above, 3.0 or above for reporting).
[jbehave](http://jbehave.org) version 3.5.4
[slf4j](http://www.slf4j.org/) version 1.6.4 as the logging api
[log4j](http://logging.apache.org/log4j/1.2/) version 1.4.2 as the  logging implementation

### Encoding

Configure IDE to use UTF-8 for all files
Configure Maven by adding "-Dfile.encoding=UTF-8" to $MAVEN_OPTS 
 
### Running the example

    mvn integration-test
    
The index page for test results is found at target/jbehave/view/index.html 

The standard maven javadoc target generates javadocs for the example in the target/apidocs directory.

    mvn javadoc:javadoc 

### Logging
The log4j.properties file in the src/main/resources directory configures logging for this example.
