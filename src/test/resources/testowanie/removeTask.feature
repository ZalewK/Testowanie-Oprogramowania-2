Feature: Usunięcie zadania z listy zadań

  Scenario: Usunięcie zadania z listy zadań
    Given Użytkownik uruchamia aplikację_r
    When Wciska przycisk Delete
    Then Zadanie zostaje usunięte z listy zadań