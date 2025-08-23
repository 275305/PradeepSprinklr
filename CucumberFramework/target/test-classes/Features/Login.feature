Feature: Login the application 

Scenario: Successful login with valid credential
Given The User is on the Login Page
When  User open the URL"https://practicetestautomation.com/practice-test-login/"
And User gives the "student" and "Password123" credential
And click on the login Button
Then Page Title Should be "Logged In Successfully | Practice Test Automation"
And close the browser

Scenario Outline:Login Data Driven
Given User Launch Chrome Browser
When User opens URL "https://practicetestautomation.com/practice-test-login/"
And User enters userName as "<uname>" and password as "<upassword>"
And click on the login Button
Then Page Title Should be "Logged In Successfully | Practice Test Automation"
When user click on Logout link
Then Page Title should bee "Test Login | Practice Test Automation"
And close the browser

Examples:
    | uname | Password |
    | student| Password123|
    | student |Password123 |



