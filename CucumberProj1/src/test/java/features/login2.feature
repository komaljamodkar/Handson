Feature: Application login

  @tag1
  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User login into application with username "abc" and password "245"
    Then Home page is populated
    And Cards are displayed

  Scenario: Home page default login
    When User login into application with sername "abcdf" and password "245345"
    And Cards are not displayed