package com.ess

import org.grails.datastore.mapping.multitenancy.resolvers.SystemPropertyTenantResolver

class Person {
    String name
    String surname
    Double budget
    String date = new Date()




    static constraints = {
        surname blank: false, nullable: false
        name blank: false, nullable: false
        budget blank: false, nullable: false
        date editable: false, display: false
    }
    String toString() {return name}
}
