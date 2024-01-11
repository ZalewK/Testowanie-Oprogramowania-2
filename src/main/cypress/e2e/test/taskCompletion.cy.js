describe("Wykonywanie zadań", () => {
  beforeEach(() => {
    cy.visit("http://localhost:8080/");
  });

  it("Wykonanie niewykonanego zadania", () => {
    cy.get("table tbody tr").should("contain", "IN_PROGRESS");
    cy.get("table tbody tr").first().find(".change-button").click();

    cy.get("table tbody tr")
      .first()
      .find("td")
      .eq(3)
      .should("have.text", "COMPLETED");
    cy.get("table tbody tr").first().find(".change-button").click();
  });

  it("Cofnięcie wykonania zadania", () => {
    cy.get("table tbody tr").should("contain", "IN_PROGRESS");
    cy.get("table tbody tr").first().find(".change-button").click();
    cy.get("table tbody tr").first().find(".change-button").click();

    cy.get("table tbody tr")
      .first()
      .find("td")
      .eq(3)
      .should("have.text", "IN_PROGRESS");
  });
});
