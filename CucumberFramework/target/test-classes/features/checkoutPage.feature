Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experience for product search in both Home and Offer page

Given User is on GreenKart landing page
When User searched with shortname <name> and extracted actual name of product
And Added "3" items of the selected product to cart 
Then User proceeds to checkout and validate the <name> items in checkout page
And User has ability to enter promo code and place the order

Examples:
|name	|
|tom	|