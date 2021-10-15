@calculator @non_ui
Feature: Calculator feature with data
  As a user,
  I should be able to use the calculator,
  so that I can do arithmetic operations.
  @wip
  Scenario Outline: Add 2 numbers multiple example
    Given calculator app is open
    When I add <num1> with <num2>
    Then I should get result <expectedResult> displayed
    Examples:
      | num1 | num2 | expectedResult |
      | 3    | 4    | 7              |
      | 4    | 7    | 11             |
      | 6    | 11   | 17             |
      | 13   | 4    | 17             |
      | 41   | 7    | 48             |
      | 60   | 11   | 77             |
