# Expense Sheet System

The project is an expense tracing system where the user enters a name and budget, afterwards the user can enter transaction details. The transactions will deduct the selected user's budget, while the prices will be converted from ZAR to USD. User profiles can be deleted as required and the transactions can be output in a CSV document.

## Getting Started

Copy the project to a folder and enter "grails run-app" in the console while inside the project folder.

### Installing

The user will need the latest Java distribution and Grails to run this project. Here is the official Grails guide on how to get Grails up and running: https://docs.grails.org/latest/guide/gettingStarted.html


* [Grails](https://github.com/grails/grails-core/releases)
* [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 
### Optimizations

When the project reaches 10,000 concurrent users the following optimizations will be made:
1. User will be able to change the base and target currency. At the moment ZAR is the base and USD is the target.
2. Different users will have different pages displaying their transaction history.
3. User will be able to import CSV documents containing transactions details.
4. At the moment the user profiles and transactions is stored in memory, therefore database saving will be implemented.

## Authors

* **Andre Strydom** - *Author*

## Acknowledgments

* Stephan Strydom
