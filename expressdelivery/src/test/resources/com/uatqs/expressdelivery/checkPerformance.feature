Feature: Login and Check Performance of Riders

    Scenario: Login
    When I navigate to "http://localhost:9010/"
    And I set the Email as "admin@expressdelivery.com"
    And I set the Password as "admin"
    And I click on the "Login" button
    Then I should be redirected to "http://localhost:9010/dashboard"

    Scenario: Check Performance of Riders
    When I navigate to "http://localhost:9010/"
    And I set the Email as "admin@expressdelivery.com"
    And I set the Password as "admin"
    And I click on the "Login" button
    And I should be redirected back to "http://localhost:9010/dashboard"
    Then I should see a table with the names of the riders, such as "Pedro Porro"