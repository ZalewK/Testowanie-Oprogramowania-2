describe("Sortowanie zadań", () => {
  beforeEach(() => {
    cy.visit("http://localhost:8080/");
  });

  it("Sortowanie zadań alfabetycznie po nazwie", () => {
    cy.get("table tbody tr").should("have.length", 5);
    cy.get(".sort-button").contains("Name").click();

    cy.get("table tbody tr td:first-child").then((taskNameCells) => {
      const extractedNames = taskNameCells
        .map((i, el) => Cypress.$(el).text().trim())
        .get();
      const sortedNames = [...extractedNames].sort();

      expect(extractedNames).to.deep.equal(sortedNames);
    });
  });

  it("Sortowanie zadań alfabetycznie po użytkowniku", () => {
    cy.get("table tbody tr").should("have.length", 5);
    cy.get(".sort-button").contains("User").click();

    cy.get("table tbody tr td:nth-child(2)").then((taskUserCells) => {
      const extractedUsers = taskUserCells
        .map((i, el) => Cypress.$(el).text().trim())
        .get();
      const sortedUsers = [...extractedUsers].sort();

      expect(extractedUsers).to.deep.equal(sortedUsers);
    });
  });

  it("Sortowanie zadań alfabetycznie po priorytecie", () => {
    cy.get("table tbody tr").should("have.length", 5);
    cy.get(".sort-button").contains("Priority").click();

    cy.get("table tbody tr td:nth-child(3)").then((taskPriorityCells) => {
      const extractedPriorities = taskPriorityCells
        .map((i, el) => Cypress.$(el).text().trim())
        .get();
      const sortedPriorities = ["HIGH", "MEDIUM", "LOW", "LOW", "LOW"];

      expect(extractedPriorities).to.deep.equal(sortedPriorities);
    });
  });

  it("Sortowanie zadań alfabetycznie po statusie", () => {
    cy.get("table tbody tr").should("have.length", 5);
    cy.get(".sort-button").contains("Status").click();

    cy.get("table tbody tr td:nth-child(4)").then((taskStatusCells) => {
      const extractedStatuses = taskStatusCells
        .map((i, el) => Cypress.$(el).text().trim())
        .get();
      const sortedStatuses = [...extractedStatuses].sort();

      expect(extractedStatuses).to.deep.equal(sortedStatuses);
    });
  });
});
