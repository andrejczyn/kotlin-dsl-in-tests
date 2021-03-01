package com.andrejczyn.orderinvoices.api

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.andrejczyn.orderinvoices.Application
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.HttpStatusCode.Companion.OK
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import java.util.*

@SpringBootTest(webEnvironment = RANDOM_PORT)
class CreateInvoiceTest(@LocalServerPort val port: Int) {
    private val httpClient = HttpClient() {
        install(JsonFeature)
    }

    @Test
    fun `should create invoice`() = runBlocking {
        //given
        val orderId = UUID.randomUUID().toString()

        //when
        val response = httpClient.post<HttpResponse>("http://localhost:$port/orders/{$orderId}/invoices") {
            body = CreateInvoiceTestDto("FV 1/2021", "FV-1/2021.pdf")
            headers {
                contentType(Json)
            }
        }

        //then
        assertThat(response.status).isEqualTo(OK)
    }
}

data class CreateInvoiceTestDto(val invoiceNumber: String, val fileName: String)