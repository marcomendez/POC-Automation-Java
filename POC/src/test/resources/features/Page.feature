@Page
Feature: Page


  Scenario: Login testing 4
    Given I navigate to Login Page
    When I set 'CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC' in UserName1 on Login
    And I set 'hola123' in Password on Login
    Then I should see 'Sign In' displayed on Login