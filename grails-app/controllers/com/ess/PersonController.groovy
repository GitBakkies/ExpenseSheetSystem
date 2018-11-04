package com.ess

import expensesheetsystem.CurrencyService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PersonController {

    PersonService personService


    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personService.list(params), model:[personCount: personService.count()]
        println "okaokaa"
    }

    def show(Long id) {
        respond personService.get(id)
    }

    def create() {
        respond new Person(params)

    }

    def save(Person person) {
        if (person == null) {
            notFound()
            return
        }

        def currencyService = new CurrencyService()
        person.setDollarValue(currencyService.convertRandToDollar(person.getBudget()))

        try {
            personService.save(person)
        } catch (ValidationException e) {
            respond person.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect person
            }
            '*' { respond person, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond personService.get(id)
    }

    def update(Person person) {
        if (person == null) {
            notFound()
            return
        }

        try {
            personService.save(person)
        } catch (ValidationException e) {
            respond person.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect person
            }
            '*'{ respond person, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        Person person = Person.findById(id)
        def transactionList = Transactions.findAllByPerson(person)
        transactionList*.delete()

        personService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'Person'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
