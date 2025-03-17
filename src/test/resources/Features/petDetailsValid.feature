Feature: Pet Details Validate
	
	@Functionality
  Scenario: Validating the pet details
    Given The user is on home page
    When Select the pet,Get the pet list and select the pet you like
    Then Validating the product title, description, price, images, and availability.
    And Validate pet added products to the cart.

