@smoke
Feature: Login


  Scenario: Login testing
    Given I navigate to Login Page
    When I set 'AaaaAAAAAAAAAAAAAAAAAAAAAAA' in UserName on Login
    And I set 'hola123' in Password on Login
    Then I should see 'Sign In' displayed on Login

  Scenario: Login testing2
  Given I navigate to Login Page
  When I set 'BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB' in UserName on Login
  And I set 'hola123' in Password on Login
  Then I should see 'Sign In' displayed on Login



  Scenario: Login testing3
    Given I navigate to Login Page
    When I set 'CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC' in UserName on Login
    And I set 'hola123' in Password on Login
    Then I should see 'Sign In' displayed on Login

