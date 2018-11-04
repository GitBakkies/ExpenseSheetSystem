package expensesheetsystem

import grails.gorm.transactions.Transactional

@Transactional
class CurrencyService {

    static def convertRandToDollar(def randValue) {
        def exchangeRate = (new groovy.json.JsonSlurper()).parse(
                new InputStreamReader(
                        (new URL("http://data.fixer.io/api/latest?access_key=73aea855d465bf797f0999cc11d652b3")).newInputStream()
                )
        )

        double dollarRate = exchangeRate['rates'].USD
        double randRate = exchangeRate['rates'].ZAR

        double euroValue = randValue / randRate
        double dollarValue = euroValue * dollarRate
        println randRate
        println dollarRate
        return dollarValue
    }
}
