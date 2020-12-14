#Author: Zulfikar Ayub
Feature: search result Heladera filter samsung

  @Sample123
  Scenario Outline: 
    To check samsumg Heladersa is dispalyed in display result

    Given user Lauch the application url "<URL>" and verfiy page title
    And user click on search box and enter Heladera and click on ok
    And user filter with only Heladera in left side breadcum
    When User select brand as samsung only in the filter
    Then User get that result display and validate samsung is diaplyed in all the result

    Examples: 
      | URL     |
      | BaseUrl |
