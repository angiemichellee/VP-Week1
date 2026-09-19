package com.example.soal1

class Order (
    var name: String,
    var items: ArrayList<OrderItem> = ArrayList()
) {
    fun total(): Int {
        return items.sumOf { it.subtotal() }
    }

    fun viewOrder() {
        var indx = 1
        println("$name's Order")
        for (order: OrderItem in items) {
            println("$indx. ${order.menu.name} X ${order.qty}")
            println("Subtotal: ${order.subtotal()}")
            indx++
        }
        println("TOTAL: ${total()}")
    }
}

