package com.example.soal1

class OrderItem (
    val menu: menu,
    var qty: Int
) {
    fun subtotal(): Int= menu.price * qty
}