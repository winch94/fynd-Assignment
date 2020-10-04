# API Test
#### *Author: Sourav Kumar Mohanty*
#### Automated test suite to test all the CRUD operations for the APIs of: http://dummy.restapiexample.com/ based on:
- Java
- rest-assured 4.3.1
- cucumber-java 6.8.0
- cucumber-core 6.8.0
- maven-cucumber-reporting 5.3.0
- maven-surefire-plugin 2.22.0

# What does it test? 
All the GET, POST, PUT and DELETE APIs of http://dummy.restapiexample.com/

# How to execute the tests?
Pre-Requisites:
- Maven 
- Java 8 or above

Step 1: Clone the repository to your local
Step 2: Import as a maven project into your choice of IDE
Step 3: On the project directory: `mvn clean install` to run all tests and install the dependencies.

# How to execute specific scenarios?
You can use tags to run tagged scenarios. Check the feature files to know the tags used.

Pre-defined tags in the feature files:
- `@getAllEmpTest` - *Tests all scenarios for GET All Employees Request*
- `@getSingleEmpTest` - *Tests all scenarios for GET Single Employee Request*
- `@getSingleEmpPositiveTest`- *Tests all positive scenarios for GET Single Employee Request*
- `@getSingleEmpNegativeTest`- *Tests all negative scenarios for GET Single Employee Request*
- `@deleteEmpTest`- *Tests all scenarios for DELETE Employee Request*
- `@deleteEmpPositiveTest`- *Tests all positive scenarios for DELETE Employee Request*
- `@deleteEmpNegativeTest`- *Tests all negative scenarios for DELETE Employee Request*
- `@createEmpTest`- *Tests all scenarios for POST Create Employee Request*
- `@createEmpPostiveTest`- *Tests all postive scenarios for POST Create Employee Request*
- `@createEmpNegativeTest`- *Tests all negative scenarios for POST Create Employee Request*
- `@updateEmpTest`- *Tests all scenarios for PUT Update Employee Request*
- `@updateEmpNegativeTest`- *Tests all negative scenarios for PUT Update Employee Request*
- `@updateEmpPositiveTest`- *Tests all positive scenarios for PUT Update Employee Request*

To Execute Tests: `mvn clean test -Cucumber.filter.tags="<@tagname>"`

# How to view reports?

After test is executed, reports are generated in the project directory `target/cucumber-html-reports/`

Open the `overview-features.html` in any web browser to view the reports. The reports UI will let you to click on the features and see the detailed report and status of execution of each step in each scenario.

## Hope that helped.
Thanks! Keep Testing!

## In case of any queries, drop a mail: sourav.mohanty94@gmail.com
## *Author: Sourav Kumar Mohanty*




