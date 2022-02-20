@Smoke
Feature: User should be able to use Factoring calculator to find out invoice financing expenses

  Background:
    Given As a Swedbank user I open Factoring Calculator page and close the Cookies popup


  Scenario: User is getting correct calculated default results
    And click on the Calculate button
    Then "0.53" percent and "52.50" values are calculated


  Scenario: User is getting correct calculated results
    Given input "10000" invoice amount
    And select 75 advance rate
    And input "10" interest rate
    And select 90 payment term
    And input "0.3" commission fee
    And click on the Calculate button
    Then "2.17" percent and "217.50" values are calculated
