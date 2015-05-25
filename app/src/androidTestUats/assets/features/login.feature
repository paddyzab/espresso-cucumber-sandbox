@bucket-1
Feature: Login

    Scenario: Login button is disabled
        Given I expect login button to be disabled

    Scenario: Display error when user is not using email as login
        Given I type as login paddy
        And I type as password qwerty12
        And I click on login button
        Then I expect error on login input field "Enter valid email."

    Scenario: Login button is disabled if either login or password field is not filled
        Given I type as login john@doe.com
        Then I expect login button to be disabled

    Scenario: Perform login with the username and password
            Given I type as login john@doe.com
            And I type as password qwerty12
            And I click on login button
            And I select country "Greece"
            And I click on confirm button
            And I type as name John
            And I type as last name Doe
            And I type as street name Sesame Street
            And I type as street number 123
            And I type as city NYC
            And I type as postal number 1234
            And I click on submit button
            Then I expect to see "Hi and Welcome John Doe" as result
