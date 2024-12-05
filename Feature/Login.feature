Feature:Login Functionality
Background:Steps common to all scenarios
Given Launch chrome browser
When User Opens url "https://demoqa.com/"
And Clicking on Elements section
Then Page title should be "DEMOQA"

Scenario: Successfully search by name


When Clicking on web table menu
And User enters Firstname as "Cierra" in the Text field
And Clicking on search button
Then User is able to find data by name in web table
And Browser Closed

Scenario: Successfully clicking on checkbox


When Clicking on Checkbox menu
And clicking on checkBox
Then Text should be displayed as "You have selected :"
And Browser Closed