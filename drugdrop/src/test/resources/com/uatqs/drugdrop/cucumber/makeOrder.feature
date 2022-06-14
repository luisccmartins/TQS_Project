Feature: Make an order on DrugDrop

    Scenario: Make Order
    When I navigate to "http://localhost:9012/"
    And I set the Email as ""
    And I set the Password as ""
    And I click on the "Login" button 
    And I head to the "Paracetamol" box
    And I select "2" as the quantity
    And I click on the "Add to Basket" button
    And I clck on the "Basket" button
    Then I click on the "Make Order" button to finalize the order