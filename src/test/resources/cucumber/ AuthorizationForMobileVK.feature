
	Feature: Authorization For Mobile VK
	
	@mobile 
 	Scenario: User can login, using his email
 		Given user is on the login page
 		When user loggin, using his login LOGIN, and password PASSWORD 
 		Then user gets on the profile page and doesnt see error message	
 	
	@mobile 
 	Scenario:  User can login, using his phone number
		Given user is on the login page
		When user loggin, using his login LOGIN, and password PASSWORD 
 		Then user gets on the profile page and doesnt see error message
 	
 	
 	@mobile 
 	Scenario:  User can see an error if login is incorrect
 		Given user is on the login page
 		When user loggin, using his login LOGIN, and password WRONGPASSWORD
 		Then user steel on the login page and see error message
 