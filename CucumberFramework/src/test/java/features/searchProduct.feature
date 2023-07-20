Feature: Search and Place the order for Products

@OfferPage
Scenario Outline: Search Experience for product search in both Home and Offer page

Given User is on GreenKart landing page
When User searched with shortname <name> and extracted actual name of product
Then User searched for <name> shortname in offers page
And Validate product name in offers page matches with landing page

Examples:
|name	|
|tom	|
|beet	|