Feature: Create a comercial account and provide drugs to DrugDrop

    Scenario: Create comercial account
    When I navigate to "http://localhost:9014/registerStore"
    And I set the Email as "store4@store.pt"
    And I set the Password as "store4"
    And I set the Name as "Store 4"
    And I set the Address as "Rua da Store 4"
    And I click on the "Register" button 
    And I am redirected to "http://localhost:9014/" to Login
    And I set the Email as "store4@store.pt"
    And I set the Password as "store4"
    And I click on the "Login" button
    Then I should see my name "Store 4" on the side bar

    Scenario: Provide drugs to DrugDrop
    When I navigate to "http://localhost:9014/"
    And I set the Email as "store4@store.pt"
    And I set the Password as "store4"
    And I click on the "Login" button
    And I click on the "Add Drug" button
    And I set the Drugs's Name as "Ilvico"
    And I set the Drug's Description as "The best we have to offer"
    And I set the Drug's Price as "7.98"
    And I click on the "Add Drug" button
    Then I should see "Ilvico" on the table of the provided drugs
