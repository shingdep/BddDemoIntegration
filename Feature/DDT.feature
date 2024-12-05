Feature:Login functionality

Scenario:Successfully Login with valid credentials
Given User launches browser
    When User opens url as "https://www.saucedemo.com/"
    And User enters Username as "standard_user" and Password as "secret_sauce"
    And Clicking on login button
    Then Page redirects to homepage and Page title should be displayed as "Swag Labs".
    And Close browser
    
    
  Scenario Outline: Successfully Login with valid credentials
    Given User launches browser
    When User opens url as "https://www.saucedemo.com/"
    And User enters Username as "<username>" and Password as "<password>"
    And Clicking on login button
    Then Page redirects to homepage and Page title should be displayed as "Swag Labs".
    And Close browser

    Examples: 
      |username|password|
      |standard_user|secret_sauce|
      |performance_glitch_user|secret_sauce|
      |visual_user|secret_sauce|
