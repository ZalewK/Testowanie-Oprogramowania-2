describe("Licznik zadań", () => {
  beforeEach(() => {
    cy.visit("http://localhost:8080/");
  });

  it("Wyświetlanie liczby zadań", () => {
    cy.get("table tbody tr").then((rows) => {
      const totalTasks = rows.length;
      cy.get(".status-container")
        .find("span")
        .eq(0)
        .should("have.text", totalTasks.toString());
    });
  });

  it("Wyświetlanie liczby ukończonych zadań", () => {
    cy.get("table tbody tr td:nth-child(4)")
      .filter(':contains("COMPLETED")')
      .then((completedTasks) => {
        const totalCompleted = completedTasks.length;
        cy.get(".status-container")
          .find("span")
          .eq(1)
          .should("have.text", totalCompleted.toString());
      });
  });

  it("Wyświetlanie liczby nieukończonych zadań", () => {
    cy.get("table tbody tr td:nth-child(4)")
      .filter(':contains("IN_PROGRESS")')
      .then((inProgressTasks) => {
        const totalInProgress = inProgressTasks.length;
        cy.get(".status-container")
          .find("span")
          .eq(2)
          .should("have.text", totalInProgress.toString());
      });
  });
});
