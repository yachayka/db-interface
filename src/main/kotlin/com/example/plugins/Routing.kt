package com.example.plugins


import com.example.plugins.table.sql.MySQLDatabaseExampleKotlin.getConnection
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.*



fun Application.configureRouting() {
    routing {
        // Главная страница - выводим HTML файл index.html
        get("/") {
            call.respond(ThymeleafContent("table/standart/index", emptyMap()))
        }
        // Пример маршрута для отображения HTML файла
        post {
            //нужно будет убрать в templating
            val front = call.receiveParameters()
            val action = front["action"]
             if (action == "employee") {
                getConnection()
                call.respondRedirect("/employee")
            }
            if(action == "employee_supply") {
                getConnection()
                call.respondRedirect("/employee_supply")
            }
            if(action == "equipment") {
                getConnection()
                call.respondRedirect("/equipment")
            }
            if(action == "product_type") {
                getConnection()
                call.respondRedirect("/product_type")
            }
            if(action == "products") {
                getConnection()
                call.respondRedirect("/products")
            }
            if(action == "supplier") {
                getConnection()
                call.respondRedirect("/supplier")
            }
            if(action == "supply") {
                getConnection()
                call.respondRedirect("/supply")
            }
        }

        /*

         */
        get("/client_avr") {
            call.respond(ThymeleafContent("table/client/index", emptyMap()))
        }
        post ("/c"){
            //нужно будет убрать в templating
            val front = call.receiveParameters()
            val action = front["action"]
            if (action == "employee") {
                getConnection()
                call.respondRedirect("/employee_c")
            }
            if(action == "employee_supply") {
                getConnection()
                call.respondRedirect("/employee_supply_c")
            }
            if(action == "equipment") {
                getConnection()
                call.respondRedirect("/equipment_c")
            }
            if(action == "product_type") {
                getConnection()
                call.respondRedirect("/product_type_c")
            }
            if(action == "products") {
                getConnection()
                call.respondRedirect("/products_c")
            }
            if(action == "supplier") {
                getConnection()
                call.respondRedirect("/supplier_c")
            }
            if(action == "supply") {
                getConnection()
                call.respondRedirect("/supply_c")
            }
        }
        /*

         */
        get("/regestr") {
            call.respond(ThymeleafContent("reg", emptyMap()))
        }
        /*

         */
        get("/razrab") {
            call.respond(ThymeleafContent("table/razrab/index", emptyMap()))
        }
        // Пример маршрута для отображения HTML файла
        post ("/r"){
            //нужно будет убрать в templating
            val front = call.receiveParameters()
            val action = front["action"]
            if (action == "employee") {
                getConnection()
                call.respondRedirect("/employee_r")
            }
            if(action == "employee_supply") {
                getConnection()
                call.respondRedirect("/employee_supply_r")
            }
            if(action == "equipment") {
                getConnection()
                call.respondRedirect("/equipment_r")
            }
            if(action == "product_type") {
                getConnection()
                call.respondRedirect("/product_type_r")
            }
            if(action == "products") {
                getConnection()
                call.respondRedirect("/products_r")
            }
            if(action == "supplier") {
                getConnection()
                call.respondRedirect("/supplier_r")
            }
            if(action == "supply") {
                getConnection()
                call.respondRedirect("/supply_r")
            }
        }
        //
        staticResources("/static", "static")
    }
}


/** * Программа для вывода списка баз данных в MySQL с использованием Kotlin */





