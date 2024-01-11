describe("Filtrowanie zadań", () => {
  beforeEach(() => {
    cy.visit("http://localhost:8080/");
  });

  it("Wyświetlenie listy zadań", () => {
    cy.get("table").should("exist");
    cy.get("table tbody tr").should("have.length", 5);
  });


  it("Wyświetl tylko nieukończone zadania", () => {
    cy.get("table tbody").should("exist");
    cy.get(".filter-button").contains("In Progress").click(); // Kliknij przycisk filtrujący nieukończone zadania
    cy.get("table tbody tr")
      .should("have.length", 5)
      .each((task) => {
        cy.wrap(task)
          .find("td")
          .eq(3)
          .then((statusCell) => {
            expect(statusCell.text().trim()).to.equal("IN_PROGRESS"); // Sprawdź status
          });
      });
  });
});
