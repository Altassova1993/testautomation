# UI Test Automation Framework
Production ready UI Test Automation Framework based 
on Selenium WebDriver and TestING. 
This lightweight test framework utilizes abstracted UI user elements
and produces extent HTML test report.

## Dependencies 
This project depends on the following external libraries.

* **selenium-java** : browser automation code
* **webdrivermanager** : managing driver binaries through code
* **testng** : creating and managing test cases
* **extentreports** : generating HTML based test execution report
* **javafaker** : generating randomized test data on the fly

## Framework Project Structure Diagram
```text
|- reports             # contains test report generated 
|- src
   |- test 
      |- java
         |- [+]base    # all the parent class is organized here
         |- [+]pages   # all the page object class is organized here
         |- [+]util    # all the commonly used class class is organized here
|-.gitignore           # add git ignore file config here 
|- pom.xml             # maven project config file          
```

## Pre-requisite 
* Download and install Chrome, Firefox, and Edge browser
* Download and install JDK v1.8+
* Download and install [Apache Maven v3.0+](https://maven.apache.org/download.cgi)
* Download and install Git v2.0+

## Internal Framework Structures 
This is a diagram that details the internal structure of this framework.
![screenshot](/images/FrameworkStructure.jpg)

## How to Run Test
All the test triggering is conducted by **`mvn`** command, this framework supports test 
execution by multiple different browsers as seen below. 

## Supported Browsers: 
| Browser | Maven Options      |
|------------------------------|
|Chrome  | `-Dbrowser=chrome`  |
|Firefox | `-Dbrowser=firefox` |
|MS Edge | `-Dbrowser=edge `   |
|Headless| `-Dbrowser=headless`|

To trigger all the test case execution:
```shell
mvn test
```
to trigger all the test grouped as `smoke`:
```shell
mvn test -Dgroups=smoke
```
To trigger all or specified test with desired browser"
````shell
mvn test -Dbrowser=chrome
mvn test -Dbrowser=chrome -Dgroups=smoke
````

## How to View Test Report 
All the test execution HTML report will be saved on the `reports` folder.
```text
|-reports 
  |-Index.html
```
Please navigate to this folder to view the test execution result, sample ExtentReport will look like 
this with some test cases. [Reference](https://www.extentreports.com/docs/v5/wiki/spark/spark.html#)
![screenshot](/images/extentreport_screenshot.png)
