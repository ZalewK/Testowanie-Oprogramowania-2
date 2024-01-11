Feature: Dodanie zadania do listy zadań

  Scenario: Dodanie zadania z jego nazwą
    Given Użytkownik uruchamia aplikację_1
    When Wprowadza poprawną nazwę zadania
    And Wciska przycisk Add_1
    Then Nowe zadanie z samą nazwą zostaje dodane na listę zadań

  Scenario: Dodanie zadania z długą nazwą
    Given Użytkownik uruchamia aplikację_1p
    When Wprowadza długą nazwę zadania
    And Wciska przycisk Add_1p
    Then Nowe zadanie z długą nazwą zostaje dodane na listę zadań

  Scenario: Dodanie zadania z jego nazwą oraz szczegółami
    Given Użytkownik uruchamia aplikację_2
    When Wprowadza poprawną nazwę zadania oraz jego szczegóły
    And Wciska przycisk Add_2
    Then Nowe zadanie z nazwą oraz szczegółami zostaje dodane na listę zadań

  Scenario: Dodanie zadania z długą nazwą oraz długimi szczegółami
    Given Użytkownik uruchamia aplikację_2p
    When Wprowadza długą nazwę zadania oraz długie szczegóły
    And Wciska przycisk Add_2p
    Then Nowe zadanie z długą nazwą oraz długimi szczegółami zostaje dodane na listę zadań

  Scenario: Dodanie zadania z jego nazwą oraz przypisanym użytkownikiem
    Given Użytkownik uruchamia aplikację_3
    When Wprowadza poprawną nazwę zadania oraz użytkownika
    And Wciska przycisk Add_3
    Then Nowe zadanie z nazwą oraz przypisanym użytkownikiem zostaje dodane na listę zadań

  Scenario: Dodanie zadania z jego nazwą, przypisanym użytkownikiem oraz priorytetem
    Given Użytkownik uruchamia aplikację_4
    When Wprowadza poprawną nazwę zadania, użytkownika oraz priorytet
    And Wciska przycisk Add_4
    Then Nowe zadanie z nazwą, przypisanym użytkownikiem oraz priorytetem zostaje dodane na listę zadań

  Scenario: Dodanie zadania z jego nazwą, szczegółami oraz przypisanym użytkownikiem
    Given Użytkownik uruchamia aplikację_5
    When Wprowadza poprawną nazwę zadania, jego szczegóły oraz użytkownika
    And Wciska przycisk Add_5
    Then Nowe zadanie z nazwą, szczegółami oraz przypisanym użytkownikiem zostaje dodane na listę zadań

  Scenario: Dodanie zadania z jego nazwą, szczegółami, przypisanym użytkownikiem oraz priorytetem
    Given Użytkownik uruchamia aplikację_6
    When Wprowadza poprawną nazwę zadania, jego szczegóły, użytkownika oraz priorytet
    And Wciska przycisk Add_6
    Then Nowe zadanie z nazwą, szczegółami, przypisanym użytkownikiem oraz priorytetem zostaje dodane na listę zadań

  Scenario: Dodanie zadania z długą nazwą, długimi szczegółami, długim użytkownikiem oraz priorytetem
    Given Użytkownik uruchamia aplikację_6p
    When Wprowadza długą nazwę zadania, długie szczegóły, długiego użytkownika oraz priorytet
    And Wciska przycisk Add_6p
    Then Nowe zadanie z długą nazwą, długimi szczegółami, długim użytkownikiem oraz priorytetem zostaje dodane na listę zadań

  Scenario: Dodanie dużej ilości zadań
    Given Użytkownik uruchamia aplikację_7
    When Wprowadza dane zadań i wciska przycisk Add 10000000 razy
    Then Wszystkie 10000000 zadań zostaje poprawnie dodane na listę zadań