# CS-320 Software Test Automation

Java contact, task and appointment services with input validation, tested with JUnit 5 unit tests.

## How have I ensured that my code is functional and secure?

I wrote unit tests for each class based on the project requirements, covering valid input, field length limits, null values and duplicate IDs. Each class validates its input and rejects bad data with an exception, so invalid values never get stored. I also tested requirements that looked obvious, because code with no visible errors can still hide them.

## How have I interpreted user needs and incorporated them into a program?

I turned each requirement into a specific rule in the code and a test that verifies it. For example, a contact's phone number must be exactly 10 digits, and an appointment can't be set in the past. I checked the requirements repeatedly as I wrote the code, and I asked questions when a requirement needed clarification.

## How did I approach designing software?

I analyzed the requirements first, then built each feature as a pair of classes: one holds and validates the data, and a service class manages adding, updating, deleting and finding records. Keeping the structure the same across all three features made the code easier to test. I wrote the tests after the initial code for each class, so I could confirm each piece worked as I went.
