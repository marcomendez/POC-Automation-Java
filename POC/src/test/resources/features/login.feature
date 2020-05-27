@smoke
Feature: Login

  Scenario: Login testing 2
    Given I navigate to Login Page
    When I set 'AaaaAAAAAAAAAAAAAAAAAAAAAAA' in UserName on Login
    And I set 'hola123' in Password on Login
    Then I should see 'Sign In' displayed on Login

  Scenario: Login testing 3
  Given I navigate to Login Page
  When I set 'BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB' in UserName1 on Login
  And I set 'hola123' in Password on Login
  And I set with table
    |item   | value  |
    | hola  | mundo  |
    | holas | mundos |
  Then I should see 'Sign In' displayed on Login


