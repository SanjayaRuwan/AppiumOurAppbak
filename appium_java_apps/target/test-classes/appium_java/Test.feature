Happy Path

1. Sign up
	Given user stay in Signup page
	When user enter the username
	 And user enter the email
	 And user enter the password
	 And user clicks the Signup button
	Then alert shown 'User SignUp Successfully'
	 And user should be able to navigate home page
	
2. Login:
	Given user should be able to SignUp
	When user clicks login button
	 And user enter vaild username
     And user enter vaild password
     And user clicks login
    Then user should be able to navigate home page
    
    
3. Logout:
	Given user should be able to Login the app
	When user clicks the logout 
	Then user logout and goto navigate login page
	

4. Reset password:
    Given user already SignUp
	When user clicks login button
	 And user clicks reset password button
	 And user enter registered email in input field
	 And user clicks reset password button
	Then reset link should be received email inbox
	When user clicks reset password link
	Then user should be able to see Appspotr reset password link
	

5. Change password:
	 Given user already SignUp
     When user clicks login button
      And user enter vaild username
      And user enter vaild password
      And user clicks login
      And user clicks change password button
      And user enter old password
      And user enter new password
      And user clicks change password button
     Then alert shown 'Change Password Successfully'
      And page navigate to login page
     When enter username
      And user enter new password
      And user clicks login button
     Then user should be able to navigate home page
     
 6.1 Get User- Before login 
 	 Given user should not be login the app
 	 When user clicks the login button
 	  And user clicks the get user button
 	 Then user should be able to visible anonymous 'User Details: anonymous.2344221913066243299@appspotr.app' user details
	  And alert shown 'Get user success'

     
 6.2 Get User- After login 
	Given user should be able to login the app
 	 When user clicks the get user button
 	 Then user should be able to visible logged user 'email' details
	  And alert shown 'Get user success'
	  
-------------------------------------------------------------------------------------------------------
	  
1. Text:
	Given user already SignUp
	When user clicks the login button
	 And user enter the username
	 And user enter the password
	 And user clicks login button
	Then user should be able to verify text in the home page
	
2. Switch:
	Given user already SignUp
	When user clicks the login button
	 And user enter the username
	 And user enter the password
	 And user clicks login button
	Then user should be able to see disable switch in home page
	When user clicks the switch
	Then switch should be enabled 
	
3. Button: Automatically verified
4. Input: Automatically verified

