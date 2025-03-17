Feature: Search Item
	
	@Functionality
  Scenario Outline: Searching a pet and validate it price
    Given the user is on home page
    When user search for a "<pet>", get the pet list and select a pet 
    Then user validate the price of the pet
	
		Examples: 
      | pet |  
      | Angelfish |  
      | Tiger Shark |  
      | Manx |  
      | Rattlesnake |  
      | Amazon Parrot |  
