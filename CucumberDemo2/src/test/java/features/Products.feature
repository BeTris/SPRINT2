Feature: Products

  Background:
  	Given Initialize the browser with Chrome
	And Navigate to "https://www.payback.in//catalogue" Site

@MediumPriority   	
Scenario Outline: check QUANTITY with input
	When Scroll down
    And Click on a product card 
   	And then click on inputbox to enter <quantity>
   	And Clicking on Confirm button
   	Then Prompts us to login
    
   	Examples:
      | quantity | 
      | "1" |
      | "a" |


@MediumPriority
Scenario Outline:  Get the product name
   	When Scroll down
   	And Click on a product card 
   	Then Verify that product name is correct in new page
     
@LowPriority   
Scenario Outline: Get the title of the page when we click on air miles
   	When We scroll down to the footer
   	And Click on the link air miles
   	Then Get the title of the page that opens
  
@HighPriority
Scenario Outline: Without logging in Confirm button prompts to login
   When Scroll down
   And Click on a product card 
   And Clicking on Confirm button
   Then Prompts us to login

@LowPriority
Scenario Outline: Right arrow takes us to the next picture
   	When Scroll down
   	And Click on a product card 
   	And We click on the right arrow beside picture
   	Then It takes us to the next picture of product
   	
@LowPriority
Scenario Outline: The product card is clickable everywhere
    When Scroll down
    Then The product text should be clickable 
        


   

 