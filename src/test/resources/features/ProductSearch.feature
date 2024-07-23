Feature: Amazon Main Search with different options

  Scenario Outline: SSearch for a product on Amazon
    Given I open the Amazon homepage
    When I enter <name> in the search box
    And I click on the search button
    Then I should see search results for product <name>

    Examples: 
      | name |
      | pen  |
      | laptop                   |
      | school bags for girl kid |
      | Chocolates               |