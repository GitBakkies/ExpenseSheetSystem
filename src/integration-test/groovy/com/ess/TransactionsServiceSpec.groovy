package com.ess

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TransactionsServiceSpec extends Specification {

    TransactionsService transactionsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Transactions(...).save(flush: true, failOnError: true)
        //new Transactions(...).save(flush: true, failOnError: true)
        //Transactions transactions = new Transactions(...).save(flush: true, failOnError: true)
        //new Transactions(...).save(flush: true, failOnError: true)
        //new Transactions(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //transactions.id
    }

    void "test get"() {
        setupData()

        expect:
        transactionsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Transactions> transactionsList = transactionsService.list(max: 2, offset: 2)

        then:
        transactionsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        transactionsService.count() == 5
    }

    void "test delete"() {
        Long transactionsId = setupData()

        expect:
        transactionsService.count() == 5

        when:
        transactionsService.delete(transactionsId)
        sessionFactory.currentSession.flush()

        then:
        transactionsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Transactions transactions = new Transactions()
        transactionsService.save(transactions)

        then:
        transactions.id != null
    }
}
