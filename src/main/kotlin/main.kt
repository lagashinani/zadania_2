package ru.netology

fun payAdditional(amount: Int, cardType: String = "Vk Pay", transferBefore: Int = 0): Int {
    var addPerc: Int = amount * 75 / 10000
    if (addPerc < 35) { addPerc = 35 }
    /*val masterMaestroAdditional = when (amount+transferBefore) {
        in 0..299 -> (amount * 60 / 10000) + 2000
        in 300..75000 -> 0
        else -> (amount * 60 / 10000) + 2000
    }*/
    return when (cardType) {
        "Vk Pay" -> 0
        in "Visa", "Мир" -> addPerc;
        else -> when (amount+transferBefore) { // MasterCard, Maestro
            in 0..299 -> (amount * 60 / 10000) + 2000
            in 300..75000 -> 0
            else -> (amount * 60 / 10000) + 2000
        }
    }
}

fun main() {
    val amount = 750000
    val cardType: String = "MasterCard"
    val transferBefore: Int = 587
    println(payAdditional(amount,cardType,transferBefore))
}