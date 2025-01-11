// update dependency in pom.xml
// <dependency>
// <groupId>io.rest-assured</ groupId>
// <artifactId> rest-assured</artifactId>
// <version>5.3.0</version>
// </dependency>
// <dependency>
// <groupId>org.testng</ groupId>
// <artifactId>testng</artifactId>
// <version>7.7.1</version>
// </dependency>


// Automation code

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.Assert;

public class ApiAutomationTest {
public static void main(String [] args){
//1.set the base uri

RestAssured.baseURI ="https//api.coindesk.com/v1/bpi/currentprice.json";

//2. Send get req
public static void main(String[] args) { RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json"; 
Response response = RestAssured.given().get();

//3.verify status code
int statusCode = response.getStatusCode(); 


//Step4 :Validate BPI Currencies(USD,GBP,EUR)


String usdCode = response.jsonPath().getString("bpi.USD.code"); 
String gbpCode = response.jsonPath().getString("bpi.GBP.code"); 
String eurCode = response.jsonPath().getString("bpi.EUR.code"); 

Assert.assertEquals(statusCode, 200, "Status Code is not 200!");

Assert.assertEquals(usdCode, "USD", "USD code is missing!");
Assert.assertEquals(gbpCode, "GBP", "GBP code is missing!"); 
Assert.assertEquals(eurCode, "EUR", "EUR code is missing!");

//Validation gbp description
String gbpDescription = response.jsonPath().getString("bpi.GBP.description");
Assert.assertEquals(gbpDescription, "British Pound Sterling", "GBP description is incorrect!");
 } 
}

//Final O/p
System.out.println("Test passed: All validations are successful");
}
}
