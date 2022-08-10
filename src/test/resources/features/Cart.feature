@cart
Feature: Checking the functionality of adding and removing items to the cart

	Background:
		Given user opens Flipkart home page

  @addCart @TC-100 @sanity
  Scenario: Add items to the cart
    When user searches for the "tv smart tv"
    And user clicks on the first search result in the results page
    And user switches to the next tab and clicks on Add to Cart button
    Then item count should be equal to 1 in the Place Order page
    
  @addCart @TC-100 @sanity
  Scenario Outline: Add items to the cart
    When user searches for the <SearchString>
    And user clicks on the first search result in the results page
    And user switches to the next tab and clicks on Add to Cart button
    Then item count should be equal to 1 in the Place Order page
    
  Examples:
  	| SearchString |
  	| tv smart tv  |
  	| laptops      |
  	| grocery      |
