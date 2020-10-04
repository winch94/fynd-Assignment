Feature: Test all the POST/PUT requests for creating employee data

  @createEmpTest @createEmpPostiveTest
  Scenario: Create employee using post request
    When I perform post operation to create employee record
    Then the status response code must be 200
    And the status in the body must be "success"
    And message in the body must be "Successfully! Record has been added."
    And the returned employee data must contain the input body data

  @createEmpTest @createEmpNegativeTest
  Scenario: Test create employee API with invalid params
    When I perform post operation to create employee record with invalid params
    Then the status response code must be 400

  @createEmpTest @createEmpNegativeTest
  Scenario: Test create employee API with null params
    When I perform post operation to create employee record with null params
    Then the status response code must be 400

  @updateEmpTest @updateEmpPositiveTest
  Scenario Outline: Update employee record with valid data
    When I perform put operation to update employee record for id <id>
    Then the status response code must be 200
    And the status in the body must be "success"
    And message in the body must be "Successfully! Record has been updated."
    And the returned updated data must contain the input body data
    Examples:
      | id   |
      | "23" |

  @updateEmpTest @updateEmpNegativeTest
  Scenario Outline: Update employee record with invalid or null id in path parameter
    When I perform put operation to update employee record for id <id>
    Then an error status code must be returned

    Examples:
      | id    |
      | "*&^" |
      | ""    |

  @updateEmpTest @updateEmpNegativeTest
  Scenario Outline: Update employee record with valid id and invalid json data
    When I perform put operation to update employee record for id <id> with invalid json data
    Then an error status code must be returned

    Examples:
      | id   |
      | "21" |

  @updateEmpTest @updateEmpNegativeTest
  Scenario Outline: Update employee record with valid id and invalid json data
    When I perform put operation to update employee record for id <id> with null parameters in json data
    Then an error status code must be returned

    Examples:
      | id   |
      | "21" |