/// <reference types="cypress" />

// Welcome to Cypress!
//
// This spec file contains a variety of sample tests
// for a todo list app that are designed to demonstrate
// the power of writing tests in Cypress.
//
// To learn more about how Cypress works and
// what makes it such an awesome testing tool,
// please read our getting started guide:
// https://on.cypress.io/introduction-to-cypress

describe('example to-do app', () => {

  beforeEach(() => {
    // We'll take the command we used above to check off an element
    // Since we want to perform multiple tests that start with checking
    // one element, we put it in the beforeEach hook
    // so that it runs at the start of every test.
    cy.visit('http://localhost:3000')
  })

  it('verify the user can navigate to the landing page', () => {
    cy.get('h1').should('have.text', 'Welcome to Chace Place')
  })

  it('verify the user can navigate to the available places page', () => {
    cy.get(':nth-child(2) > .nav-links').click()
    cy.get('h1').should('have.text', 'To be able to see our available places, please first log in.')
  })

  it('verify the user can navigate to the About Us page', () => {
    cy.get(':nth-child(3) > .nav-links').click()
    cy.get('u').should('have.text', 'About Us')
  })

  it('verify the user can navigate to the Log In page', () => {
    cy.get(':nth-child(4) > .nav-links').click()
    cy.get('h2').should('have.text', 'LOG IN')
  })

  it('verify the user can navigate to the Sign Up page', () => {
    cy.get(':nth-child(5) > .nav-links').click()
    cy.get('h2').should('have.text', 'Registration')
  })
})
