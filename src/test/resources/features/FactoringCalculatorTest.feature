@Smoke
Feature: User should be able to use Factoring calculator to find out invoice financing expenses

  Background:
    Given As a Swedbank user I open Factoring Calculator page and close the Cookies popup


  Scenario: User is getting correct calculated default results
    And click on the Calculate button
    Then "0.53" percent and "52.50" values are calculated


  Scenario Outline: User is getting correct calculated results
    Given input "<invoiceAmount>" invoice amount
    And select <advanceRate> advance rate
    And input "<interestRate>" interest rate
    And select <paymentTerm> payment term
    And input "<commissionFee>" commission fee
    And click on the Calculate button
    Then "<expectedResultPercent>" percent and "<expectedResult>" values are calculated
    Examples:
      | invoiceAmount | advanceRate | interestRate | paymentTerm | commissionFee | expectedResultPercent | expectedResult |
      | 10000         | 75          | 10           | 90          | 0.3           | 2.17                  | 217.50         |
      | 10000         | 80          | 10           | 90          | 0.3           | 2.30                  | 230.00         |
      | 10000         | 85          | 10           | 90          | 0.3           | 2.42                  | 242.50         |
      | 10000         | 90          | 10           | 90          | 0.3           | 2.55                  | 255.00         |
      | 10000         | 90          | 10           | 30          | 0.3           | 1.05                  | 105.00         |
      | 10000         | 90          | 10           | 60          | 0.3           | 1.80                  | 180.00         |
      | 10000         | 90          | 10           | 120         | 0.3           | 3.30                  | 330.00         |
