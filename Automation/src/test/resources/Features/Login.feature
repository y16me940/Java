@all
Feature: user logging page process

##Background:
##Given create the entries in Database Mongo / Given create the entries in Database SQL
##And user opens the browser
##And clears the cache
##Then opens the URL

@mongo
Scenario: user logs with valid email/pwd   *****1******
Given user at the login page window
When user enters email "a@gmail.com" and pwd 1234
And click the login button
Then successfully logged in 
And lands at the dashboard page

@mongo
Scenario: user logs with invalid email/pwd *****2******
Given user at the login page window
When user enters email "i@gmail.com" and pwd "1234"
And click the login button
Then does not lands at the dashboard page 

@mongo
Scenario: user logs with invalid email/pwd  *****3******
Given user at the login page window
When user enters email "i@gmail.com" and pwd "1234"
And click the login button
Then does not lands at the dashboard page

@mongo
Scenario: user logs with invalid email/pwd   *****4******
Given user at the login page window
When user enters email "i@gmail.com" and pwd "1234"
And click the login button
Then does not lands at the dashboard page

@mongo
Scenario: user logs with invalid email/pwd   *****4******
Given user at the login page window
When user enters detals
|rajak|
|shaik|
|7995174217|
|abc@gmail.com|
And click the login button
Then does not lands at the dashboard page

@SQL
Scenario Outline: diff users logging to Pay page 
Given user at the login page window
When user enters email "<email>" and pwd "<pwd>"
And click the login button
Then does not lands at the dashboard page
  Examples:
  |email|pwd|
  |abc@gmail|123|
  |awd@gmail|1234323|
  |dqwdq@gmail|32432|
  |qd@gmail|2341|
  |de@gmail|3213|
  |deqdq@gmail|123|

