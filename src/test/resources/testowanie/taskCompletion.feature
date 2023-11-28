Feature: Wykonywanie zadań

  Scenario: Wykonanie niewykonanego zadania
    Given Na liście jest niewykonane zadanie
    When Wciskamy przycisk Change status_tc_1
    Then Zadanie pokazuje się jako wykonane

  Scenario: Cofnięcie wykonania zadania
    Given Na liście jest wykonane zadanie
    When Wciskamy przycisk Change status_tc_2
    Then Zadanie pokazuje się jako niewykonane
