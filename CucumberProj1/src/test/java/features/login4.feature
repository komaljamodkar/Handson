Feature: Application login

  Scenario Outline: Home page default login
    Given User is on NetBanking landing page
    When User login into application with <Username> and password <password>
    Then Home page is populated
    And Cards displayed "true"
    
  Examples:
    |Username|password|
    |user1   |pas123  |
    |user2   |pas123  |
    |user3   |pas143  |
    
    
    
