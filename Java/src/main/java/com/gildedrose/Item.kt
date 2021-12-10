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
        update1()
        update2()
        update3()
    }

    private fun update3() {
        if (sellIn < 0) {
            if (name != "Aged Brie") {
                if (name != "Backstage passes to a TAFKAL80ETC concert") {
                    if (quality > 0) {
                        if (name != "Sulfuras, Hand of Ragnaros") {
                            this.quality = quality - 1
                        }
                    }
                } else {
                    this.quality = quality - quality
                }
            } else {
                if (quality < 50) {
                    this.quality = quality + 1
                }
            }
        }
    }

    private fun update2() {
        if (name != "Sulfuras, Hand of Ragnaros") {
            this.sellIn = sellIn - 1
        }
    }

    protected open fun update1() {
        if (name != "Aged Brie"
                && name != "Backstage passes to a TAFKAL80ETC concert") {
            if (quality > 0) {
                if (name != "Sulfuras, Hand of Ragnaros") {
                    this.quality = quality - 1
                }
            }
        } else {
            if (quality < 50) {
                this.quality = quality + 1
                if (name == "Backstage passes to a TAFKAL80ETC concert") {
                    if (sellIn < 11) {
                        if (quality < 50) {
                            this.quality = quality + 1
                        }
                    }
                    if (sellIn < 6) {
                        if (quality < 50) {
                            this.quality = quality + 1
                        }
                    }
                }
            }
        }
    }
}

class Brie(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun update1() {
        if (quality < 50) {
            this.quality = quality + 1
        }
    }
}

class Pass(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun update1() {
        if (quality < 50) {
            this.quality = quality + 1
            if (sellIn < 11) {
                if (quality < 50) {
                    this.quality = quality + 1
                }
            }
            if (sellIn < 6) {
                if (quality < 50) {
                    this.quality = quality + 1
                }
            }
        }
    }
}

class Sulfuras(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun update1() {}
}
