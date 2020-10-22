Feature: Retail Test Scenarios 
Background: 
	Given User is on Retail website 
	
	
@RegisterForm 
Scenario: Register Account for new Retail user 
	When User click  on MyAccount 
	And User click on Register 
	And User fill out Register form with below information 
		|firstName|lastName|email|phone|password|
		|James|Madison|jmadison121@test.com|1112223344|james123|
	And User select 'yes' for Subscribe 
	And User click on privacy and policy check box 
	And User click on Continue button 
	Then User Should see message 'Your Account Has Been Created!'