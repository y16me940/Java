@search
Feature: searching for a product

Scenario: searching for a product with ShortName
Given user lands at the homepage of the greenKart application
And searches for a product with the shorname "Tom" by ectracting full name
Then searches for the same product in OffersPage with same shortname "Tom"
And vlidate the product names in both the pages