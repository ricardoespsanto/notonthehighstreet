# notonthehighstreet
A checkout system that understands promotion rules.

## Build
This project is built with Gradle so simply invoke:

`./gradlew build`

from a *nix machine or 

`gradlew.bat build` from a windows one.

## Running the tests
Right now, the easiest way to run the tests for this application is to open the 
[CheckoutTest class](src/test/java/notonthehighstreet/CheckoutTest.java) on your favourite IDE and 
execute the tests. 

## Assumptions
The promotion rules applied in this project **have an order** which will influence the behaviour and 
therefore the final checkout value.

The promotion rules are configured in code but could easily be loaded from a database or some other
form of dynamic configuration.

A rule is described by the following two attributes:
1. A condition (`Predicate<Basket>`)
2. An effect (`Function<Basket, Double>`)

The condition will be responsible to check the rule applicability. It's with this concept that we 
check if a Basket will receive this promotional effect or not.

The effect describes what value of discount the basket will receive.

Given that this project will not be used in production, formal aspects of it are not included. 
Namely: documentation, javadoc, java package separation, configuration, logging, deployment scripts, 
etc.
