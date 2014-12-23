@bucket-1
Feature: Login

    Scenario: Perform login with the username and password
        When I type as login paddy@zab.com
        Then I type as password qwerty12
        Then I click on login button

    Scenario: Display error when user is not using email as login
        When I type as login paddy
        Then I type as password qwerty12
        Then I click on login button