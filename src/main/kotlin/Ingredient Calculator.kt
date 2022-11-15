fun main() {
    println("Write how many cups of coffe you will need :")
    val tazasCafe: Int? = readLine()?.toInt()

    println("For $tazasCafe cups of coffe you will need:")

    if (tazasCafe != null ){
        var waterBuy = operation(numero = tazasCafe, numero2 = water)
        println("$waterBuy ml of water")
        var milkBuy = operation(numero = tazasCafe, numero2 = milk)
        println("$milkBuy ml of milk")
        var coffeBeansBuy = operation(numero = tazasCafe, numero2 = coffeBeans)
        println("$coffeBeansBuy g of coffe beans")

    }

}

fun operation(numero: Int, numero2: Int): Int {
    return numero * numero2
}
