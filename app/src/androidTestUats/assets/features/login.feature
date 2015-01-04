@bucket-1
Feature: Login

    @new
    Scenario: Perform login with the username and password
        Given I type as login paddy@zab.com
        And I type as password qwerty12
        Then I click on login button
        Then I select country "Greece"
        Then I expect country "Greece" to be selected

    #Scenario: Selecting a country adds

    #Scenario: Selecting a second country removed first selection

    Scenario: Display error when user is not using email as login
        Given I type as login paddy
        And I type as password qwerty12
        And I click on login button
        Then I expect error on login input field "Enter valid email."

    Scenario: Login button is disabled if both fields are not filled in
        Given I type as login paddy@zab.com
        Then I expect login button to be disabled