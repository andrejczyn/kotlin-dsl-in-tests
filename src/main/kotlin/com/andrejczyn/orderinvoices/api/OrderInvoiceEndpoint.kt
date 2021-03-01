package com.andrejczyn.orderinvoices.api

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderInvoiceEndpoint {
    @PostMapping("/orders/{orderId}/invoices")
    fun createInvoice(@RequestBody order: CreateOrderDto, @PathVariable orderId: String) {
        return TODO()
    }

    fun uploadFile() {

    }

    fun scan() {

    }

    fun verify() {

    }

    fun remove() {

    }
}

class CreateOrderDto(val invoiceNumber: String, val fileName: String)