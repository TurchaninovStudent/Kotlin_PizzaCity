package models

import contracts.Drink
import contracts.PizzaCity

/**
 * Пиццерия санкт-петербурга
 * @param neapolitanPizzaPrice цена неаполитанской пиццы
 * @param romanPizzaPrice цена римской пиццы
 * @param sicilianPizzaPrice цена сицилианской пиццы
 * @param tyroleanPizzaPrice цена тирольской пиццы
 */
class PizzaCityPeter(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), Drink {
    override var drinkCount: Int = 0
    override var drinkPrice: Double = 200.0

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да\n 2. Нет")
        if (readln() == "1") {
            println("С вас 200 руб.")
            drinkCount++
            additionalPrice += drinkPrice
        }
    }

    override fun neapolitanPizzaSale() {
        super.neapolitanPizzaSale()
        println("Спасибо за покупу неаполитанской пиццы в Санкт-петербурге!")
    }
    override fun romanPizzaSale() {
        super.romanPizzaSale()
        println("Спасибо за покупу римской пиццы в Санкт-петербурге!")
    }
    override fun sicilianPizzaSale() {
        super.sicilianPizzaSale()
        println("Спасибо за покупу сицилианской пиццы в Санкт-петербурге!")
    }
    override fun tyroleanPizzaSale() {
        super.tyroleanPizzaSale()
        println("Спасибо за покупу тирольсокй пиццы в Санкт-петербурге!")
    }
}