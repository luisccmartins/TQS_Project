Feature: Login and Check Performance of Riders

    Scenario: Login
    When I navigate to "http://localhost:9010/"
    And I set the Email as "admin@expressdelivery.com"
    And I set the Password as "admin"
    And I click on the "Login" button
    Then I should see the message "Welcome, Admin"

    Scenario: Check Performance of Riders
    When I navigate to "http://localhost:9010/"
    And I set the Email as "admin@expressdelivery.com"
    And I set the Password as "admin"
    And I click on the "Login" button
    And I click on the "Dashboard" button on the side bar
    Then I should see a table with the names of the riders, such as "Pedro Porro"