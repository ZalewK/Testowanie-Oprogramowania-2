Feature: Wyszukiwanie zadań w liście

  Scenario: Wyszukiwanie po nazwie zadania
    Given Na liście są zadania_ts_1
    When Wprowadza nazwę zadania
    And Wciska przycisk Szukaj po nazwie
    Then Wyświetlają się zadania z pasującą nazwą zadania

  Scenario: Wyszukiwanie po użytkowniku
    Given Na liście są zadania_ts_2
    When Wprowadza nazwę użytkownika
    And Wciska przycisk Szukaj po użytkowniku
    Then Wyświetlają się zadania z pasującą nazwą użytkownika