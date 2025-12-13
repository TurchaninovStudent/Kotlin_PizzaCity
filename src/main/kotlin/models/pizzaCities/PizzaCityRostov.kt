package models.pizzaCities

import contracts.DrinkSale
import contracts.CheckPhoto
import contracts.PizzaCity
import contracts.SouceSale
import models.foods.Souce
import kotlin.system.exitProcess

/**
 * Пиццерия ростова на дону
 * @param neapolitanPizzaPrice цена неаполитанской пиццы
 * @param romanPizzaPrice цена римской пиццы
 * @param sicilianPizzaPrice цена сицилианской пиццы
 * @param tyroleanPizzaPrice цена тирольской пиццы
 */
class PizzaCityRostov(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), DrinkSale, CheckPhoto, SouceSale {
    override var drinkCount: Int = 0
    override var drinkPrice: Double = 200.0
    override var drinkPizzaMap: MutableMap<String, Int> = mutableMapOf()
    override var souceSaleMap: MutableMap<Souce, Double> = mutableMapOf()

    override var checkCount: Int = 0
    override var checkSale: Double = 50.0

    override var avaibleSouces: List<Souce> = listOf(
        Souce("Кетчуп", 60.0),
        Souce("Майонез", 50.0)
    )

    override var souceCount: Int = 0

    override fun souceSale() {
        println("Вы будете соус?")
        println("1. Да\n2. Нет")

        //TODO: сделать от списка avaibleSouces а не вручную
        if (readln() == "1") {
            println("Какой именно?")
            println("1. Кетчуп\n2. Майонез")

            val chosenSouce = when (readln()) {
                "1" -> avaibleSouces[0]
                "2" -> avaibleSouces[1]
                else -> {
                    println("Неправильный ввод данных")
                    exitProcess(1)
                }
            }

            souceCount++
            additionalPrice += chosenSouce.price
            incrementSaleForSouce(chosenSouce)
        }
    }

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей с покупки")
            checkCount++
            additionalPrice -= checkSale
        }
    }

    override fun drinkSale(pizza: String) {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("С вас 200 руб.")
            drinkCount++
            additionalPrice += drinkPrice
            incrementAmountForPizza(pizza)
        }
    }

    override fun neapolitanPizzaSale(): String {
        println("Спасибо за покупу неаполитанской пиццы в Ростове на дону!")
        return super.neapolitanPizzaSale()
    }

    override fun romanPizzaSale(): String {
        println("Спасибо за покупу римской пиццы в Ростове на дону!")
        return super.romanPizzaSale()
    }

    override fun sicilianPizzaSale(): String {
        println("Спасибо за покупу сицилианской пиццы в Ростове на дону!")
        return super.sicilianPizzaSale()
    }

    override fun tyroleanPizzaSale(): String {
        println("Спасибо за покупу тирольсокй пиццы в Ростове на дону!")
        return super.tyroleanPizzaSale()
    }

    override fun showSpecialStatistics() {
        println("Количество проданных соусов: $souceCount")
        println("Выручка за каждый соус: ")

        for ((key, value) in souceSaleMap) {
            println("${key.name} = $value")
        }

        println("Показано чеков: $checkCount")
        if (customerCount != 0) {
            println(
                "Соотношение людей, которых показывают фотографию чека к тем, которые не показывают:" +
                        " ${(checkCount.toDouble() / customerCount.toDouble()) * 100}%"
            )
        }
        println("\nПродано напитков: $drinkCount")
        println("\nСоотношение людей, которых покупают напитков к тем, которые отказываются:" +
                " ${(drinkCount.toDouble() / customerCount.toDouble()) * 100}%")

        println("\nТоп пицц, к которым покупают напитки: ")
        println("\nВ количественном соотношении: ")
        for ((key, value) in drinkPizzaMap) {
            println("$key = $value")
        }

        println("\nВ процентном соотношении: ")
        for ((key, value) in drinkPizzaMap) {
            println("$key = ${getPercentForAmount(value) * 100} %")
        }
    }

    private fun incrementAmountForPizza(pizza: String) {
        if (drinkPizzaMap[pizza] == null) {
            drinkPizzaMap[pizza] = 1
        }

        drinkPizzaMap[pizza]!!.plus(1)
    }

    private fun incrementSaleForSouce(selectedSouce: Souce) {
        if (souceSaleMap[selectedSouce] == null) {
            souceSaleMap[selectedSouce] = selectedSouce.price
        }

        souceSaleMap[selectedSouce]!!.plus(selectedSouce.price)
    }

    private fun getPercentForAmount(value: Int): Double {
        return (value.toDouble() / drinkPizzaMap.values.sum().toDouble())
    }
}