package com.ess

import grails.gorm.services.Service

@Service(Transactions)
interface TransactionsService {

    Transactions get(Serializable id)

    List<Transactions> list(Map args)

    Long count()

    void delete(Serializable id)

    Transactions save(Transactions transactions)

}