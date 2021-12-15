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
        age()
        degrade()
        saturate()
    }

    protected open fun age() {
        sellIn -= 1
    }

    protected open fun degrade() {
        quality -= if (sellIn < 0) 2 else 1
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

    override fun age() {
        sellIn -= 1
    }

    override fun degrade() {
        quality += if (sellIn < 0) 2 else 1
    }
}

class Pass(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun age() {
        sellIn -= 1
    }

    override fun degrade() {
        quality = when {
            sellIn < 0 -> 0
            sellIn < 5 -> quality + 3
            sellIn < 10 -> quality + 2
            else -> quality + 1
        }
    }
}

class Sulfuras(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun age() {}
    override fun degrade() {}
    override fun saturate() {}
}
