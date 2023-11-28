Feature: Filtrowanie zadań

  Scenario: Wyświetlenie listy zadań
    Given Użytkownik uruchamia aplikację_f
    When Na liście są zadania_f
    Then Wszystkie zadania są wyświetlone

  Scenario: Wyświetl tylko ukończone zadania
    Given Na liście są ukończone zadania_f
    When Zaznacza opcję Filtruj po ukończonych
    Then Wyświetlone są tylko ukończone zadania

  Scenario: Wyświetl tylko nieukończone zadania
    Given Na liście są nieukończone zadania_f
    When Zaznacza opcję Filtruj po nieukończonych
    Then Wyświetlone są tylko nieukończone zadania