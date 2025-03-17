Feature: Shopping Cart
	
	@Functionality
  Scenario: User updating cart pets
    Given the user is on home page to buy pet
    When Open pet list 
    And add pets to cart
    And remove and update quantities
    Then validate proceeding to checkout
