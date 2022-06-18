Feature: Create a comercial account and provide drugs to DrugDrop

    Scenario: Create comercial account
    When I navigate to register 'http://localhost:9014/registerStore'
    And I set the Email as Admin "store4@store.pt"
    And I set the Password as Admin "store4"
    And I set the Name as "Store 4"
    And I set the Address as "Rua da Store 4"
    And I click on the register button 
    And I am redirected to "http://localhost:9014/" to Login
    And I set the Email as "store4@store.pt"
    And I set the Password as "store4"
    And I click on the login button
    Then I should see be redirected to "http://localhost:9014/storeIndex"

    Scenario: Provide drugs to DrugDrop
    When I navigate to login "http://localhost:9014/"
    And I set the Email as Admin "store4@store.pt"
    And I set the Password as Admin "store4"
    And I click on the Login button
    And I should see be redirected back to "http://localhost:9014/storeIndex"
    And I set the Drugs's Name as "Pantoprazol"
    And I set the Drug's Description as "The best we have to offer"
    And I set the Drug's Price as "7.98"
    And I click on the Add Drug button
    Then I should see "Ilvico" on the table of the provided drugs
