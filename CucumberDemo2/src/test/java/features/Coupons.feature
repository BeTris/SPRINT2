Feature: Coupons

Background:
	Given Initialize the browser with Chrome
	And Navigate to "https://www.payback.in//coupons//coupons" Site

@LowPriority  
Scenario Outline: Check the footer text
 	When Scroll down to cleartrip
 	And Click on the Cleartrip hyper link 
 	Then Verify that the page has elements present

@HighPriority 	
Scenario Outline: 
  	When Scroll down to login
 	And Click on Login Now button
    Then Prompts us to login
  	




