Feature: Sortowanie zadań w liście

  Scenario: Sortowanie zadań alfabetycznie
    Given Na liście są zadania_st_1
    When Wciska przycisk Sortuj alfabetycznie
    Then Zadania są wyświetlone alfabetycznie

  Scenario: Sortowanie zadań po użytkowniku
    Given Na liście są zadania_st_2
    When Wciska przycisk Sortuj po użytkowniku
    Then Zadania są wyświetlone według użytkownika

  Scenario: Sortowanie zadań po priorytecie
    Given Na liście są zadania_st_3
    When Wciska przycisk Sortuj po priorytecie
    Then Zadania są wyświetlone według priorytetu
