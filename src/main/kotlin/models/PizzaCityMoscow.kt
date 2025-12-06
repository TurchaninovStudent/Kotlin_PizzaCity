package models

import contracts.CheckPhoto
import contracts.PizzaCity

/**
 * Пиццерия москвы
 * @param neapolitanPizzaPrice цена неаполитанской пиццы
 * @param romanPizzaPrice цена римской пиццы
 * @param sicilianPizzaPrice цена сицилианской пиццы
 * @param tyroleanPizzaPrice цена тирольской пиццы
 */
class PizzaCityMoscow(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), CheckPhoto {
    override var checkCount: Int = 0
    override var checkSale: Double = 50.0

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n 2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей с покупки")
            checkCount++
            additionalPrice -= checkSale
        }
    }

    override fun neapolitanPizzaSale() {
        super.neapolitanPizzaSale()
        println("Спасибо за покупу неаполитанской пиццы в Москве!")
    }
    override fun romanPizzaSale() {
        super.romanPizzaSale()
        println("Спасибо за покупу римской пиццы в Москве!")
    }
    override fun sicilianPizzaSale() {
        super.sicilianPizzaSale()
        println("Спасибо за покупу сицилианской пиццы в Москве!")
    }
    override fun tyroleanPizzaSale() {
        super.tyroleanPizzaSale()
        println("Спасибо за покупу тирольсокй пиццы в Москве!")
    }
}