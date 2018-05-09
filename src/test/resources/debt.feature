Feature: debt

  Scenario: register debt
    Given person "A" and person "B" are square
    When person "A" borrows $"10" from "B"
    Then person "A" owes person "B" $"10"

  Scenario: settle debt
    Given person "A" borrowed $"25" from person "B"
    When person "B" borrows $"26" from "A"
    Then person "A" owes nothing person "B"
    And person "B" owes person "A" $"1"

  Scenario: list debts
    Given a person has some debt
    When  he lists his debts
    Then his debts are on the list