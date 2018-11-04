package com.ess

import static org.springframework.http.HttpStatus.OK

class CsvDownloadController {

    def index() {
        final String filename = 'transactions.csv'
        def lines = "Person, Transaction, Rand Value, Dollar Value/n"
        lines += Transactions.findAll().collect { [it.person, it.transactionName, it.transactionPrice, it.dollarValue].join(';') } as List<String>

        def outs = response.outputStream
        response.status = OK.value()
        response.contentType = "text/csv;charset=UTF-8";
        response.setHeader "Content-disposition", "attachment; filename=${filename}"

        lines.each { String line ->
            outs << "${line}\n"
        }

        outs.flush()
        outs.close()
    }
}
