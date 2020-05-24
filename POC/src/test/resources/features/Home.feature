@smoke
Feature: Home

  Scenario: Login testing
    Given I navigate to Login Page
    When I set 'marco@test.com' in UserName on Login
    And I set 'hola123' in Password on Login
    And I click Sign In on Login
    Then I should see 'My Personal Information' displayed on Home


