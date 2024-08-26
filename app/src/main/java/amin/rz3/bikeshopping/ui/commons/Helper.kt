package amin.rz3.bikeshopping.ui.commons

import java.text.NumberFormat
import java.util.Locale

object Helper {
    fun formatPrice(amount: Int): String {
        val format = NumberFormat.getCurrencyInstance(Locale.US).apply {
            minimumFractionDigits = 0
            maximumFractionDigits = 0
        }
        return format.format(amount)
    }
}