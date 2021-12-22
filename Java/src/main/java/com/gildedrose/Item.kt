package com.gildedrose

open class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString(): String = "$name, $sellIn, $quality"
}

open class BaseItem(
    name: String,
    sellIn: Int = 0,
    quality: Int = 0
) : Item(name, sellIn, quality) {

    fun update() {
        sellIn -= aging()
        quality -= degradation(sellIn, quality)
        saturate()
    }

    protected open fun aging() = 1

    protected open fun degradation(sellIn: Int, quality: Int) = when {
        sellIn < 0 -> 2
        else -> 1
    }

    protected open fun saturate() {
        when {
            quality < 0 -> quality = 0
            quality > 50 -> quality = 50
        }
    }
}

class Brie(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun degradation(sellIn: Int, quality: Int) = when {
        sellIn < 0 -> -2
        else -> -1
    }
}

class Pass(
    name: String,
    sellIn: Int,
    quality: Int


) : BaseItem(name, sellIn, quality) {

    override fun degradation(sellIn: Int, quality: Int) = when {
        sellIn < 0 -> quality
        sellIn < 5 -> -3
        sellIn < 10 -> -2
        else -> -1
    }
}

class Sulfuras(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun aging() = 0
    override fun degradation(sellIn: Int, quality: Int) = 0
    override fun saturate() {}
}
