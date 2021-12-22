package com.gildedrose

open class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString(): String = "$name, $sellIn, $quality"
}

object Aging {
    val none: () -> Int = { 0 }
    val standard: () -> Int = { 1 }
}

object Degradation {
    val none: (Int, Int) -> Int = { _, _ -> 0 }
    val standard: (Int, Int) -> Int = { sellIn, _ ->
        when {
            sellIn < 0 -> 2
            else -> 1
        }
    }
    val reverse: (Int, Int) -> Int = { sellIn, _ ->
        when {
            sellIn < 0 -> -2
            else -> -1
        }
    }
}

object Saturation {
    val none: (Int) -> Int = { it }
    val standard: (Int) -> Int = {
        when {
            it < 0 -> 0
            it > 50 -> 50
            else -> it
        }
    }
}

class BaseItem(
    name: String,
    sellIn: Int = 0,
    quality: Int = 0,
    private val aging: () -> Int = Aging.standard,
    private val degradation: (Int, Int) -> Int = Degradation.standard,
    private val saturation: (Int) -> Int = Saturation.standard
) : Item(name, sellIn, quality) {
    fun update() {
        sellIn -= aging()
        quality = saturation(quality - degradation(sellIn, quality))
    }
}

fun brie(
    name: String,
    sellIn: Int,
    quality: Int
) = BaseItem(
    name,
    sellIn,
    quality,
    degradation = Degradation.reverse
)

fun pass(
    name: String,
    sellIn: Int,
    quality: Int
) = BaseItem(
    name,
    sellIn,
    quality,
    degradation = { _, _ ->
        when {
            sellIn < 0 -> quality
            sellIn < 5 -> -3
            sellIn < 10 -> -2
            else -> -1
        }
    }
)

fun sulfuras(
    name: String,
    sellIn: Int,
    quality: Int
) = BaseItem(
    name,
    sellIn,
    quality,
    aging = Aging.none,
    degradation = Degradation.none,
    saturation = Saturation.none
)
