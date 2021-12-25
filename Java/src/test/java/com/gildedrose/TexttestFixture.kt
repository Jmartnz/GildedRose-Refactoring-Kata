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
        val items: Array<Item> = arrayOf(
            BaseItem("+5 Dexterity Vest", 10, 20),  //
            brie("Aged Brie", 2, 0),  //
            BaseItem("Elixir of the Mongoose", 5, 7),  //
            sulfuras("Sulfuras, Hand of Ragnaros", 0, 80),  //
            sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
            pass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            pass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            pass("Backstage passes to a TAFKAL80ETC concert", 5, 49),  // this conjured item does not work properly yet
            conjured("Conjured Mana Cake", 3, 6))
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

    private val expected = """-------- day 0 --------
name, sellIn, quality
+5 Dexterity Vest, 10, 20
Aged Brie, 2, 0
Elixir of the Mongoose, 5, 7
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 15, 20
Backstage passes to a TAFKAL80ETC concert, 10, 49
Backstage passes to a TAFKAL80ETC concert, 5, 49
Conjured Mana Cake, 3, 6

-------- day 1 --------
name, sellIn, quality
+5 Dexterity Vest, 9, 19
Aged Brie, 1, 1
Elixir of the Mongoose, 4, 6
Sulfuras, Hand of Ragnaros, 0, 80
Sulfuras, Hand of Ragnaros, -1, 80
Backstage passes to a TAFKAL80ETC concert, 14, 21
Backstage passes to a TAFKAL80ETC concert, 9, 50
Backstage passes to a TAFKAL80ETC concert, 4, 50
Conjured Mana Cake, 2, 4

"""

}
