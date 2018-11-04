package com.ess

import org.grails.datastore.mapping.multitenancy.resolvers.SystemPropertyTenantResolver

class Person {
    String name
    String surname
    Double budget
    String date = new Date()
    Double dollarValue


    static constraints = {
        surname blank: false, nullable: false
        name blank: false, nullable: false
        budget blank: false, nullable: false
        dollarValue display:true, nullable:true, editable: false
        date editable: false, display: true
    }
    String toString() {return name}
}
