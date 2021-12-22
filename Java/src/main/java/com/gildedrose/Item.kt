package com.gildedrose

open class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString(): String = "$name, $sellIn, $quality"
}

class BaseItem(
    name: String,
    sellIn: Int = 0,
    quality: Int = 0,
    private val aging: () -> Int = { 1 },
    private val degradation: (Int, Int) -> Int = { _, _ ->
        when {
            sellIn < 0 -> 2
            else -> 1
        }
    },
    private val saturation: (Int) -> Int = {
        when {
            it < 0 -> 0
            it > 50 -> 50
            else -> it
        }
    }
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
    degradation = { _, _ ->
        when {
            sellIn < 0 -> -2
            else -> -1
        }
    }
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
    aging = { 0 },
    degradation = { _, _ -> 0 },
    saturation = { it }
)
