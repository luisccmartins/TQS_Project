Feature: Make an order on DrugDrop

    Scenario: Make Order
    When I navigate to "http://localhost:9014/"
    And I set the Email as User "user1@drugdrop.pt"
    And I set the Password as User "user1"
    And I click on the login user button 
    And I head to the "Paracetamol" box
    And I click on the Add To Basket button
    And I clck on the Basket button
    Then I click on the Make Order button to finalize the order