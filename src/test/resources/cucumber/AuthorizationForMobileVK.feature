
	Feature: Authorization For Mobile VK
	
 	Scenario: User can login, using his email
 		Given user is on the login page
 		When user loggin, using his email 
 		Then user gets on the profile page
 		And browser closing


 Scenario:  User can login, using his phone number
	Given user is on the login page
	When user logs in using his phone number 
 	Then user gets on the profile page
 	And browser closing
 	
 	
 	Scenario:  User can see an error if login is incorrect
 		Given user is on the login page
 		When user logs in using wrong phone number 
 		Then user see error message
 		And browser closing
 	
 