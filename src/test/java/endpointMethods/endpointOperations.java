package endpointMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class endpointOperations {
    public static RequestSpecification requestSpecification = given().contentType("application/json");

    //GET Request to get all employees data
    public static Response getAllEmployees() throws IOException {
        return requestSpecification.log().all().when().get(baseURI + endpointFactory.getAllEmployeesPath);
    }

    //GET Request to get a single employee data by ID
    public static Response getEmployeeDataById(String id) {
        return requestSpecification.log().all().when().pathParam("id", id).get(baseURI + endpointFactory.getSingleEmployeePath);
    }

    //POST Request to create a single employee data with employee.json
    public static Response createEmployeeData(String json) {
        return requestSpecification.log().all().when().body(json).post(baseURI + endpointFactory.createEmployeePath);

    }
    //PUT Request to update a single employee data with identifier ID
    public static Response updateEmployeeData(String json, String id) {
        return requestSpecification.log().all().when().body(json).pathParam("id", id).put(baseURI + endpointFactory.updateEmployeePath);

    }

    //DELETE Request to delete a single employee data with identifier ID
    public static Response deleteEmployeeData(String id) {
        return requestSpecification.log().all().when().pathParam("id", id).delete(baseURI + endpointFactory.deleteEmployeePath);

    }
}
