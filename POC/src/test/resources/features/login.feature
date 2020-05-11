Feature: Era Login

  Scenario: Login testing
    Given I navigate to ClickUp
    When I set 'hajoleb949@riv3r.net' in UserName on Login
    And I set '1234Qwert' in Password on Login
    And I click Login on Login
    Then I should see 'View' displayed on Home

  @PJ-1 @PJ-3 @OPEN
  Scenario: Test
    Given I navigate to ClickUp
    Given I navigate to ClickUp

  @ORPHAN
  Scenario: Test Test
    Then I should see 'View' displayed on Home
