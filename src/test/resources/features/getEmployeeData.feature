Feature: Test all the GET requests for employee data

  @getAllEmpTest
  Scenario: Get all employee data
    When I perform GET operation to get all employees data
    Then the status response code must be 200
    And the status in the body must be "success"
    And all the employees data must be returned

  @getSingleEmpTest @getSingleEmpPositiveTest
  Scenario Outline: Get a single employee data using id
    When I perform GET operation to get a single employee data for id <id>
    Then the status response code must be 200
    And the status in the body must be "success"
    And message in the body must be "Successfully! Record has been fetched."
    And the employee data must be returned
    Examples:
      | id  |
      | "1" |
      | "3" |

  @getSingleEmpTest @getSingleEmpNegativeTest
  Scenario Outline: When id consisting of alphabets/non existing ids are passed to the get API request for single employee
    When I perform GET operation to get a single employee data for id <id>
    Then an error status code must be returned
    And the status in the body must be "failure"
    And the data returned must be null

    Examples:
      | id          |
      | "test"      |
      | "100000789" |

  @getSingleEmpTest @getSingleEmpNegativeTest
  Scenario Outline: When special characters are passed in the get API request for single employee
    When I perform GET operation to get a single employee data for id <id>
    Then an error status code must be returned

    Examples:
      | id          |
      | "#%?"       |
      | "(*&&^*^%^" |
