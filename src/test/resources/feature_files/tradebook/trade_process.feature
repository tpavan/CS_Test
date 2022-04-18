Feature: Aa a Trader to validate different orders for SPOT,FOREWORD

   #Single Trade booking scenario
  @GingleTrade
  Scenario: Validate value date and trade date for single FOREWORD trade
    Given trade service is up and running
    When create single trade request for value date "Forward"
    Then validate value date cannot be before trade date

  @GingleTrade
  Scenario: Validate value date and trade date for single VANILLAOPTION trade
    Given trade service is up and running
    When create single trade request for value date "VanillaOption"
    Then validate value date cannot be before trade date

  @GingleTrade
  Scenario: Validate value date and trade date for single SPOT trade
    Given trade service is up and running
    When create single trade request for value date "Spot"
    Then validate value date cannot be before trade date

  @GingleTrade
  Scenario: value date cannot fall on weekend for "spot" trade
    Given trade service is up and running
    When create single trade request for weekend with value date "Spot"
    Then value date cannot fall on weekend

  @GingleTrade
  Scenario: value date cannot fall on weekend for "foreword" trade
    Given trade service is up and running
    When create single trade request for weekend with value date "Forward"
    Then value date cannot fall on weekend

  @GingleTrade
  Scenario: value date cannot fall on weekend for "VanillaOption" trade
    Given trade service is up and running
    When create single trade request for weekend with value date "VanillaOption"
    Then value date cannot fall on weekend

  @GingleTrade
  Scenario: Validate trade should booked with only selected entity only for CS Zurich
    Given trade service is up and running
    When create single trade request for weekend with value date "VanillaOption" and legal entity "CS,Zurich"
    Then validate legal entity is "CS Zurich"

  @GingleTrade
  Scenario: Validate trade should booked with only selected entity only for USA
    Given trade service is up and running
    When create single trade request for weekend with value date "VanillaOption" and legal entity "USA"
    Then validate legal entity is "USA"

  @GingleTrade
  Scenario: Validate trade with valid currency with "EURUSD"
    Given trade service is up and running
    When create single trade request for value date "Spot" with "EURUSD"
    Then service validation for incorrect currency

  @GingleTrade
  Scenario: Validate trade with invalid currency with "TESTUSD"
    Given trade service is up and running
    When create single trade request for value date "VanillaOption" with "TESTUSD"
    Then service validation for incorrect currency

  @GingleTrade
  Scenario:Validate trade with valid INR and USD currency
    Given trade service is up and running
    When create single trade request for value date "Foreword" with "INRUSD"
    Then service validation for incorrect currency

  @GingleTrade
  Scenario:Validate trade with valid USD and USD currency
    Given trade service is up and running
    When create single trade request for value date "VanillaOption" with "USDUSD"
    Then service validation for incorrect currency

  #Batch Trade booking scenario
  @BatchScenario
  Scenario: Validate create batch trade request for "VanillaOption"
    Given trade service is up and running
    When create batch trade request for "VanillaOption"
    Then validate batch trade request response

  @BatchScenario
  Scenario: Validate create batch trade request for "Spot"
    Given trade service is up and running
    When create batch trade request for "Spot"
    Then validate batch trade request response

  @BatchScenario
  Scenario: Validate only one legal entity is used for upload trade
    Given trade service is up and running
    When create batch trade request for "Spot"
    Then only one legal entity is used "CS Zurich"

  @BatchScenario
  Scenario: Validate OPTIONS trade style as American
    Given trade service is up and running
    When create batch trade request for "Spot"
    Then validate trade style as "American"

  @BatchScenario
  Scenario: Validate OPTIONS trade style as European
    Given trade service is up and running
    When create batch trade request for "Spot"
    Then validate trade style as "European"

  @BatchScenario
  Scenario: Validate OPTIONS trade style contains different parameters
    Given trade service is up and running
    When create batch trade request for "Spot"
    Then validate trade style as "American"
    And validate  expiryDate and premium date shall be before deliveryDate