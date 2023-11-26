Feature: Wyświetlenie szczegółów zadania

  Scenario: Wyświetlenie szczegółów zadania
    Given Użytkownik posiada dodane zadanie
    When Wciska przycisk Details
    Then Wyświetla się okno z detalami zadania