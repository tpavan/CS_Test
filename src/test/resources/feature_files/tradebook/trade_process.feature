Feature: Aa a Trader to validate different orders for SPOT,FOREWORD

  Scenario: Validate single trade request
    Given trade service is up and running
    When create single trade request
    Then validate single trade request response

  Scenario: Validate batch trade request
    Given trade service is up and running
    When create batch trade request
    Then validate batch trade request response

 Scenario: Validate value date and trade date for SPOT trade
   Given trade service is up and running
   When create single trade request for value date
   Then validate value date cannot be before trade date

  Scenario: Validate value date and trade date for FOREWORD trade
    Given trade service is up and running
    When create batch trade request
    Then validate value date cannot be before trade date

  Scenario: value date cannot fall on weekend
    Given trade service is up and running
    When create batch trade request
    Then value date cannot fall on weekend

  Scenario: value date cannot fall on non-working day for currency
    Given trade service is up and running
    When create batch trade request
    Then value date cannot fall on non-working day for currency

  Scenario: Validate only one legal entity is used for upload trade
    Given trade service is up and running
    When create batch trade request
    Then only one legal entity is used "CS Zurich"

  Scenario: Validate OPTIONS trade style as American
    Given trade service is up and running
    When create batch trade request
    Then validate trade style as "American"

  Scenario: Validate OPTIONS trade style as European
    Given trade service is up and running
    When create batch trade request
    Then validate trade style as "European"

  Scenario: Validate OPTIONS trade style contains different parameters
    Given trade service is up and running
    When create batch trade request
    Then validate trade style as "American"
    And validate  expiryDate and premium date shall be before deliveryDate