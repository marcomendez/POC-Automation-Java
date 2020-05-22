@smoke
Feature: Login


  Scenario: Login testing
    Given I navigate to Login Page
    When I set 'marco@test.com' in UserName on Login
    And I set 'hola123' in Password on Login
    Then I should see 'Sign In' displayed on Login



  Scenario: Login testing2
    Given I navigate to Login Page
    When I set 'marco@teeeeeeeeeeeeeeeeeeest.com' in UserName on Login



  Scenario: Login testing3
    Given I navigate to Login Page
    When I set 'marco@test.com' in UserName on Login

