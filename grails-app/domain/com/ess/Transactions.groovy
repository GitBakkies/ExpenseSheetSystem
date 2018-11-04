package com.ess

class Transactions {

    String transactionName
    Long transactionPrice
    Person person
    Double dollarValue


    static hasMany = [person: Person]
    static belongsTo = Person

    static constraints = {
        person blank: false, nullable: false
        transactionName blank: false, nullable: false
        transactionPrice blank: false, nullable: false
        dollarValue editable: false, nullable: true
    }
}
