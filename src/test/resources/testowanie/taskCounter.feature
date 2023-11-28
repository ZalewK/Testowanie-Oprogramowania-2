Feature: Licznik zadań

  Scenario: Wyświetlanie liczby zadań
    Given Użytkownik uruchamia aplikację_to_1
    When Na liście są zadania
    Then Wyświetla się liczba zadań

  Scenario: Wyświetlanie liczby ukończonych zadań
    Given Użytkownik uruchamia aplikację_to_2
    When Na liście są ukończone zadania
    Then Wyświetla się liczba ukończonych zadań

  Scenario: Wyświetlanie liczby nieukończonych zadań
    Given Użytkownik uruchamia aplikację_to_3
    When Na liście są nieukończone zadania
    Then Wyświetla się liczba nieukończonych zadań