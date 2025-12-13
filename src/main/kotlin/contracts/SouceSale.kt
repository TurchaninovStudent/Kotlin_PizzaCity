package contracts

import models.foods.Souce

/**
 * Соус
 */
interface SouceSale {
    /**
     * Продажа соусов
     */
    fun souceSale()

    /**
     * Количество проданных соусов
     */
    var souceCount: Int

    /**
     * Список доступных соусов
     */
    var avaibleSouces: List<Souce>

    /**
     * Словарь из соусов, к их продажам
     */
    var souceSaleMap: MutableMap<Souce, Double>
}