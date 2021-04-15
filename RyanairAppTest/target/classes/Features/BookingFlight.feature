Feature: Declined payment for flight


Scenario: Checking to see if booking flight fails

Given browser is open
And user is on booking flight page
When user enters in their flight information (date, one way trip, one adult, desintation, departure location)
And selects search button
Then user is navigated to select flight page
And user selects flight
When user enters in passenger details
Then user is navigated to select seat page
Given user selects seat
And clicks continue
Then user will be directed to luggage page
Given user selects one small bag 
And clicks continue
Then user will be directed to insurance page
Given User selects continue
Then user will be directed to overview page
When user selects basket
And selects check out
Then user should be directed to Payment page
When user selects in payment information
And slects pay now
Then Payment should fail 

