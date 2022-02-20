@Smoke
Feature: User should be able to use Factoring calculator to find out invoice financing expenses

  Background:
    Given As a Swedbank user I open Factoring Calculator page and close the Cookies popup


  Scenario: User is getting correct calculated default results
    And click on the Calculate button
    Then "0.53" percent and "52.50" values are calculated


  Scenario: User is getting correct calculated results
    Given input "10000" invoice amount
    And select "75" advance rate
    And interest rate ""
    And "" payment term
    And "" comission fee
    And click on the Calculate button
    Then invoice expenses is calculated