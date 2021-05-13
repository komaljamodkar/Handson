Feature: Application login

  @tag1
  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User login into application with "abc" and password "245"
    Then Home page is populated
    And Cards displayed "true"

  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User login into application with "abcdf" and password "245345"
    Then Home page is populated
    And Cards displayed "false"

  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User signup with following details
    | Alpha | abc23@ |alpha@abcd.com | Aus |354745478|
    | bhd | vb23@ |alpha@abcd.com | Eng |354745478|
    | zeta | ahjz@ |alpha@abcd.com | US |354745478|
    
    Then Home page is populated
    And Cards displayed "false"
    
    
