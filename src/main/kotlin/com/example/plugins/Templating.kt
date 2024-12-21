package com.example.plugins

import com.example.plugins.table.sql.MySQLDatabaseExampleKotlin.select
import com.example.plugins.table.sql.MySQLDatabaseExampleKotlin.select_w
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.Thymeleaf
import io.ktor.server.thymeleaf.ThymeleafContent
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun Application.configureTemplating() {
    install(Thymeleaf) {
        setTemplateResolver(ClassLoaderTemplateResolver().apply {
            prefix = "templates/thymeleaf/"
            suffix = ".html"
            characterEncoding = "utf-8"
        })
    }
        routing {
            get("/employee"){//Запуск стронички с клиентами
                val employee = select("employee")
                call.respond(ThymeleafContent("table/standart/employee_table", mapOf("results" to employee)))
            }
            /*
            post {
                val front = call.receiveParameters()
                val action = front["action"]
                if (action == "count") {
                    val param = Client(
                        name = front["name"] ?: "",
                        surname = front["surname"] ?: "",
                        patronymic = front["patronymic"] ?: "",
                        orde = front["orde"] ?: "",
                        result = front["result"] ?: ""
                    )
                    getConnection()
                    println(param.toString())
                    into(param)
                    call.respondRedirect("/client")
                    //нужно будет убрать в templating
                }
            }

             */
            get("/employee_supply"){//Запуск стронички с заказами
                val employeesupplyt = select("employee_supply")
                call.respond(ThymeleafContent("table/standart/employee_supply", mapOf("results" to employeesupplyt)))
            }
            /*
            get("/order_work"){//Запуск стронички с заказом и работой
                val order_work = select("orde_work")
                call.respond(ThymeleafContent("table/order_work_table", mapOf("results" to order_work)))

                //call.respond("order_work")
            }

             */
            get("/order_work") {
                println("llllllllllllllllllllllll")
                val page = call.parameters["page"]?.toIntOrNull() ?: 1
                val limit = 3
                val offset = (page - 1) * limit
                val producttyped = select_w("products", limit, offset)

                call.respond(ThymeleafContent("table/standart/order_work_table", mapOf(
                    "results" to producttyped,
                    "currentPage" to page
                )))
            }
            get("/equipment"){ //Запуск стронички с ассортиментом
                val equipment = select("equipment")
                call.respond(ThymeleafContent("table/standart/equipment_table", mapOf("results" to equipment)))
            }
            get("/supplier"){//Запуск стронички с оборудованием
                val supplier = select("supplier")
                call.respond(ThymeleafContent("table/standart/supplier_table", mapOf("results" to supplier)))
            }
            get("/supply"){//Запуск стронички с работой
                val supply = select("supply")
                call.respond(ThymeleafContent("table/standart/supply_table", mapOf("results" to supply)))
            }
            get("/product_type"){//Запуск стронички с работниками
                val producttype = select("product_type")
                call.respond(ThymeleafContent("table/standart/product_type_table", mapOf("results" to producttype)))
            }
            /*






             */
            get("/employee_r"){ //Запуск стронички с клиентами
                val employee = select("employee")
                call.respond(ThymeleafContent("table/razrab/employee_table", mapOf("results" to employee)))
            }
            get("/employee_supply_r"){//Запуск стронички с заказами
                val employeesupply = select("employee_supply")
                call.respond(ThymeleafContent("table/razrab/employee_supply", mapOf("results" to employeesupply)))
            }
            /*
            get("/order_work"){//Запуск стронички с заказом и работой
                val order_work = select("orde_work")
                call.respond(ThymeleafContent("table/order_work_table", mapOf("results" to order_work)))

                //call.respond("order_work")
            }

             */
            get("/product_type_r") {
                val page = call.parameters["page"]?.toIntOrNull() ?: 1
                val limit = 3
                val offset = (page - 1) * limit
                val orderWorkData = select_w("product_type", limit, offset)

                call.respond(ThymeleafContent("table/razrab/product_type_table", mapOf(
                    "results" to orderWorkData,
                    "currentPage" to page
                )))
            }
            get("/equipment_r"){ //Запуск стронички с ассортиментом
                val equipment = select("equipment")
                call.respond(ThymeleafContent("table/razrab/equipment_table", mapOf("results" to equipment)))
            }
            get("/supplier_r"){//Запуск стронички с оборудованием
                val supplier = select("supplier")
                call.respond(ThymeleafContent("table/razrab/supplier_table", mapOf("results" to supplier)))
            }
            get("/supply_r"){//Запуск стронички с работой
                val supply = select("supply")
                call.respond(ThymeleafContent("table/razrab/supply_table", mapOf("results" to supply)))
            }
            get("/products_r"){//Запуск стронички с работниками
                val products = select("products")
                call.respond(ThymeleafContent("table/razrab/products_table", mapOf("results" to products)))
            }
            /*





             */
            get("/employee_c"){ //Запуск стронички с клиентами
                val employee = select("employee")
                call.respond(ThymeleafContent("table/client/employee_table", mapOf("results" to employee)))
            }
            get("/employee_supply_c"){//Запуск стронички с заказами
                val employeesupply = select("employee_supply")
                call.respond(ThymeleafContent("table/client/employee_supply_table", mapOf("results" to employeesupply)))
            }
            /*
            get("/order_work"){//Запуск стронички с заказом и работой
                val order_work = select("orde_work")
                call.respond(ThymeleafContent("table/order_work_table", mapOf("results" to order_work)))

                //call.respond("order_work")
            }

             */
            get("/product_type_c") {
                val page = call.parameters["page"]?.toIntOrNull() ?: 1
                val limit = 3
                val offset = (page - 1) * limit
                val producttypede = select_w("product_type", limit, offset)

                call.respond(ThymeleafContent("table/client/product_type_table", mapOf(
                    "results" to producttypede,
                    "currentPage" to page
                )))
            }
            get("/equipment_c"){ //Запуск стронички с ассортиментом
                val equipment = select("equipment")
                call.respond(ThymeleafContent("table/client/equipment_table", mapOf("results" to equipment)))
            }
            get("/supplier_c"){//Запуск стронички с оборудованием
                val supplier = select("supplier")
                call.respond(ThymeleafContent("table/client/supplier_table", mapOf("results" to supplier)))
            }
            get("/supply_c"){//Запуск стронички с работой
                val supply = select("supply")
                call.respond(ThymeleafContent("table/client/supply_table", mapOf("results" to supply)))
            }
            get("/products_c"){//Запуск стронички с работниками
                val products = select("products")
                call.respond(ThymeleafContent("table/client/products_table", mapOf("results" to products)))
            }
            ///
            post("/exits_r"){
                call.respondRedirect("/razrab")

            }
            post("/exits"){
                call.respondRedirect("/")
            }
            post("/exits_c"){
                call.respondRedirect("/client_avr")

            }
        }
    }
//}