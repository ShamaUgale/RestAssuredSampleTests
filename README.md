# RestAssuredSampleTests
Sample REST API tests using restassured

The below repo is used for the tests
https://github.com/ShamaUgale/spring-boot-rest-example

Setup the the demo project

1. Clone the repo
  git clone https://github.com/ShamaUgale/spring-boot-rest-example.git
2. Build the project
  mvn clean package
3. Run the services
  java -jar -Dspring.profiles.active=test target/spring-boot-rest-example-0.5.0.war
  
Your Services are running opn localhost port 8090
You can look at the API Documentation here : http://localhost:8090/swagger-ui.html#!/hotels/

