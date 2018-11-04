@Regression_Test
  Feature: search for a Tesco store near you
    As I user on a Tesco website
    I want to enter a postcode
    So I can find the store nearest to my location

    @Test-X
    Scenario Outline: searching for a store nearest to my location
      Given I am on Tesco's website
      When I click the FindStore tab
      And I enter a postcode <postcode>
      Then I should see a list of stores around that postcode
      Examples:
      | postcode |
      | NN16 9FT |
#      | RM7 2JR  |
