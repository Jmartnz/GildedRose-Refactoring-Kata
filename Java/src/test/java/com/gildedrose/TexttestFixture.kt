package com.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TexttestFixture {
    @Test
    fun test() {
        val outputStream = ByteArrayOutputStream()
        val out = PrintStream(outputStream)
        out.println("OMGHAI!")
        val items: Array<Item> = arrayOf(
            BaseItem("+5 Dexterity Vest", 10, 20),  //
            brie("Aged Brie", 2, 0),  //
            BaseItem("Elixir of the Mongoose", 5, 7),  //
            sulfuras("Sulfuras, Hand of Ragnaros", 0, 80),  //
            sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
            pass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            pass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            pass("Backstage passes to a TAFKAL80ETC concert", 5, 49),  // this conjured item does not work properly yet
            BaseItem("Conjured Mana Cake", 3, 6))
        val app = GildedRose(items)
        val days = 2
        for (i in 0 until days) {
            out.println("-------- day $i --------")
            out.println("name, sellIn, quality")
            for (item in items) {
                out.println(item)
            }
            out.println()
            app.updateQuality()
        }
        Assertions.assertEquals(expected, outputStream.toString())
    }

    private val expected = ("OMGHAI!" + System.lineSeparator()
        + "-------- day 0 --------" + System.lineSeparator()
        + "name, sellIn, quality" + System.lineSeparator()
        + "+5 Dexterity Vest, 10, 20" + System.lineSeparator()
        + "Aged Brie, 2, 0" + System.lineSeparator()
        + "Elixir of the Mongoose, 5, 7" + System.lineSeparator()
        + "Sulfuras, Hand of Ragnaros, 0, 80" + System.lineSeparator()
        + "Sulfuras, Hand of Ragnaros, -1, 80" + System.lineSeparator()
        + "Backstage passes to a TAFKAL80ETC concert, 15, 20" + System.lineSeparator()
        + "Backstage passes to a TAFKAL80ETC concert, 10, 49" + System.lineSeparator()
        + "Backstage passes to a TAFKAL80ETC concert, 5, 49" + System.lineSeparator()
        + "Conjured Mana Cake, 3, 6" + System.lineSeparator()
        + System.lineSeparator()
        + "-------- day 1 --------" + System.lineSeparator()
        + "name, sellIn, quality" + System.lineSeparator()
        + "+5 Dexterity Vest, 9, 19" + System.lineSeparator()
        + "Aged Brie, 1, 1" + System.lineSeparator()
        + "Elixir of the Mongoose, 4, 6" + System.lineSeparator()
        + "Sulfuras, Hand of Ragnaros, 0, 80" + System.lineSeparator()
        + "Sulfuras, Hand of Ragnaros, -1, 80" + System.lineSeparator()
        + "Backstage passes to a TAFKAL80ETC concert, 14, 21" + System.lineSeparator()
        + "Backstage passes to a TAFKAL80ETC concert, 9, 50" + System.lineSeparator()
        + "Backstage passes to a TAFKAL80ETC concert, 4, 50" + System.lineSeparator()
        + "Conjured Mana Cake, 2, 5" + System.lineSeparator()
        + System.lineSeparator())
}
