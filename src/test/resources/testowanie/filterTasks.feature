Feature: Filtrowanie zadań

  Scenario: Wyświetlenie listy zadań
    Given Użytkownik uruchamia aplikację
    When Na liście są zadania
    Then Wszystkie zadania są wyświetlone

  Scenario: Wyświetl tylko ukończone zadania
    Given Na liście są ukończone zadania
    When Zaznacza opcję Filtruj po ukończonych
    Then Wyświetlone są tylko ukończone zadania

  Scenario: Wyświetl tylko nieukończone zadania
    Given Na liście są nieukończone zadania
    When Zaznacza opcję Filtruj po nieukończonych
    Then Wyświetlone są tylko nieukończone zadania