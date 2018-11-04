package com.ess

import expensesheetsystem.CurrencyService
import grails.converters.JSON
import grails.validation.ValidationException
import org.grails.web.json.JSONObject

import static org.springframework.http.HttpStatus.*

class TransactionsController {

    TransactionsService transactionsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond transactionsService.list(params), model:[transactionsCount: transactionsService.count()]
    }

    def show(Long id) {
        respond transactionsService.get(id)
    }

    def create() {
        respond new Transactions(params)

    }

    def save(Transactions transactions) {
        def person = transactions.getPerson()
        def currencyService = new CurrencyService()

        person.setBudget(person.getBudget()-transactions.getTransactionPrice())
        person.setDollarValue(currencyService.convertRandToDollar(person.getBudget()))

        transactions.setDollarValue(currencyService.convertRandToDollar(transactions.getTransactionPrice()))

        if (transactions == null) {
            notFound()
            return
        }

        try {
            transactionsService.save(transactions)
        } catch (ValidationException e) {
            respond transactions.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'transactions.label', default: 'Transactions'), transactions.id])
                redirect transactions
            }
            '*' { respond transactions, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond transactionsService.get(id)
    }

    def update(Transactions transactions) {
        if (transactions == null) {
            notFound()
            return
        }

        try {
            transactionsService.save(transactions)
        } catch (ValidationException e) {
            respond transactions.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'transactions.label', default: 'Transactions'), transactions.id])
                redirect transactions
            }
            '*'{ respond transactions, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        transactionsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'transactions.label', default: 'Transactions'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'transactions.label', default: 'Transactions'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
