package contracts

/**
 * Напиток
 */
interface DrinkSale {
    /**
     * Продажа напитков
     */
    fun drinkSale(pizza: String)

    /**
     * Количество проданных напитков
     */
    var drinkCount: Int

    /**
     * Цена напитков
     */
    var drinkPrice: Double

    /**
     * Словарь из пицц, к которым покупают напитки
     */
    var drinkPizzaMap: MutableMap<String, Int>
}