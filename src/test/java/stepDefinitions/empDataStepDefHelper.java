package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;

import static endpointMethods.endpointOperations.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

public class empDataStepDefHelper extends baseStepDefHelper {
    @When("I perform GET operation to get all employees data")
    public void iPerformGETOperationToGetAllEmpData() throws IOException {
        //api request to get all employees data
        response = getAllEmployees();
    }

    @Then("the status response code must be {int}")
    public void theStatusResponseCodeMustBe(int statCode) {
        //assert that the status code is 200
        response.then().statusCode(is(statCode));
    }

    @And("all the employees data must be returned")
    public void allTheEmployeesDataMustBeReturned() {

        //get data from response aslist
        List<String> id = response.getBody().jsonPath().getList("data.id");
        List<String> empName = response.getBody().jsonPath().getList("data.employee_name");
        List<String> empSalary = response.getBody().jsonPath().getList("data.employee_salary");
        List<String> empAge = response.getBody().jsonPath().getList("data.employee_age");

        //assert ID is not zero or null
        for (String i : id) {
            assertFalse(i.isEmpty());
            assertNotEquals("0", i);
        }

        //assert employee name not null
        for (String name : empName) {
            assertFalse(name.isEmpty());
        }

        //assert employee salary is not zero or null
        for (String salary : empSalary) {
            assertFalse(salary.isEmpty());
            assertNotEquals("0", salary);
        }

        //assert employee age is not zero or null
        for (String age : empAge) {
            assertFalse(age.isEmpty());
            assertNotEquals("0", age);
        }


    }

    @And("the status in the body must be {string}")
    public void theStatusInTheBodyMustBe(String statusMessage) {
        //assert that the body has status as success
        assertEquals(response.getBody().jsonPath().getString("status"), statusMessage);

    }

    @When("I perform GET operation to get a single employee data for id {string}")
    public void iPerformGETOperationToGetASingleEmployeeDataForIdId(String id) {
        //api request to get single employee data
        response = getEmployeeDataById(id);
    }

    @And("the employee data must be returned")
    public void theEmployeeDataMustBeReturned() {
        //get data from response asString
        String id = response.getBody().jsonPath().getString("data.id");
        String empName = response.getBody().jsonPath().getString("data.employee_name");
        String empSalary = response.getBody().jsonPath().getString("data.employee_salary");
        String empAge = response.getBody().jsonPath().getString("data.employee_age");

        //assertions that id is not null or zero
        assertFalse(id.isEmpty());
        assertNotEquals("0", id);

        //assertion that employee name is not null
        assertFalse(empName.isEmpty());

        //assertions that employee salary is not null or zero
        assertFalse(empSalary.isEmpty());
        assertNotEquals("0", empSalary);

        //assertions that employee age is not null or zero
        assertFalse(empAge.isEmpty());
        assertNotEquals("0", empAge);

    }


    @And("message in the body must be {string}")
    public void messageInTheBodyMustBe(String successMessage) {
        //assert the success message
        assertEquals(response.getBody().jsonPath().getString("message"), successMessage);
    }

    @And("the data returned must be null")
    public void theDataReturnedMustBeNull() {
        //assert that the data returned is null
        assertTrue((response.getBody().jsonPath().getString("data") == null));
    }

    @Then("an error status code must be returned")
    public void anErrorStatusCodeMustBeReturned() {
        response.then().statusCode(anyOf(equalTo(404), equalTo(400), equalTo(301)));
        //assert error code
        // assert (errorCode == 404 || errorCode == 400);
    }

    @When("I perform post operation to create employee record")
    public void iPeformPostOperationToCreateEmployeeRecord() throws IOException, ParseException {
        //post request to create employee data
        response = createEmployeeData(employeeJSONModifier("valid"));

    }

    @And("the returned employee data must contain the input body data")
    public void theReturnedEmployeeDataMustContainTheInputBodyData() throws IOException, ParseException {
        //assert that id is not null
        assertFalse(response.getBody().jsonPath().getString("data.id").isEmpty());
        //assert the name returned is same as the name in input json
        assertEquals(newName, response.getBody().jsonPath().getString("data.name"));
        //assert the salary returned is same as the salary in input json
        assertEquals(newSalary, response.getBody().jsonPath().getString("data.salary"));
        //assert the age returned is same as the age in input json
        assertEquals(newAge, response.getBody().jsonPath().getString("data.age"));
    }

    @And("the returned updated data must contain the input body data")
    public void theReturnedUpdatedDataMustContainTheInputBodyData() throws IOException, ParseException {
        //assert the name returned is same as the name in input json
        assertEquals(newName, response.getBody().jsonPath().getString("data.name"));
        //assert the salary returned is same as the salary in input json
        assertEquals(newSalary, response.getBody().jsonPath().getString("data.salary"));
        //assert the age returned is same as the age in input json
        assertEquals(newAge, response.getBody().jsonPath().getString("data.age"));
    }

    @When("I perform post operation to create employee record with invalid params")
    public void iPeformPostOperationToCreateEmployeeRecordWithInvalidParams() throws IOException, ParseException {
        //post request with invalid json data to create employee record
        response = createEmployeeData(employeeJSONModifier("invalid"));
    }

    @When("I perform post operation to create employee record with null params")
    public void iPeformPostOperationToCreateEmployeeRecordWithNullParams() throws IOException, ParseException {
        //post request with null json data/values to create employee record
        response = createEmployeeData(employeeJSONModifier("null"));
    }

    @When("I perform put operation to update employee record for id {string}")
    public void iPerformPutOperationToUpdateEmployeeRecord(String id) throws IOException, ParseException {
        //put request with valid json data to update employee record
        response = updateEmployeeData(employeeJSONModifier("valid"), id);
    }

    @When("I perform put operation to update employee record for id {string} with invalid json data")
    public void iPerformPutOperationToUpdateEmployeeRecordForIdIdWithInvalidJsonData(String id) throws IOException, ParseException {
        //put request with invalid json data to update employee record
        response = updateEmployeeData(employeeJSONModifier("invalid"), id);
    }

    @When("I perform put operation to update employee record for id {string} with null parameters in json data")
    public void iPerformPutOperationToUpdateEmployeeRecordForIdIdWithNullParametersInJsonData(String id) throws IOException, ParseException {
        //put request with null json data/values to update employee record
        response = updateEmployeeData(employeeJSONModifier("null"), id);
    }

    @When("I perform delete operation on employee record with id {string}")
    public void iPerformDeleteOperationOnEmployeeRecordWithId(String id) {
        //delete request with valid id
        response = deleteEmployeeData(id);
    }

    @And("data in the response body must be equal to the path parameter id {string}")
    public void dataInTheResponseBodyMustBeEqualToThePathParameterId(String id) {
        //assert returned data is equal to id in the input
        assertEquals(response.getBody().jsonPath().getString("data"), id);
    }
}
