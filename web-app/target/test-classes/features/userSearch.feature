
  Feature: User carrying out a search using Google search engine
    As  I user on google browser
    I want to search for an item
    So that I can see a list of resulting items

    Scenario Outline: user carrying of a search for a specific item <search-term>
      Given I am on a browser
      When I enter a search term <search-term> in the searchbox and submit
      Then I should be taken to the search results page with page title containing <search-term>
      Examples:
      |search-term|
      | cheese    |
      | milk      |

