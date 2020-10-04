Feature: Test API to delete an employee record

  @deleteEmpTest @deleteEmpPositiveTest
  Scenario Outline: Delete an employee record with id
    When I perform delete operation on employee record with id <id>
    Then the status response code must be 200
    And the status in the body must be "success"
    And message in the body must be "Successfully! Record has been deleted"
    And data in the response body must be equal to the path parameter id <id>
    Examples:
      | id  |
      | "3" |

  @deleteEmpTest @deleteEmpNegativeTest
  Scenario Outline: Test delete employee record with invalid/null id
    When I perform delete operation on employee record with id <id>
    Then an error status code must be returned
    Examples:
      | id     |
      | ""     |
      | "%$^#" |
