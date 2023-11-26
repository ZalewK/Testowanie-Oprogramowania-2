Feature: Wykonywanie zadań

  Scenario: Wykonanie niewykonanego zadania
    Given Na liście jest niewykonane zadanie
    When Wciskamy przycisk Complete
    Then Zadanie pokazuje się jako wykonane
    And Przycisk Complete zmienia się w Undo

  Scenario: Cofnięcie wykonania zadania
    Given Na liście jest wykonane zadanie
    When Wciskamy przycisk Undo
    Then Zadanie pokazuje się jako niewykonane
    And Przycisk Undo zmienia się w Complete