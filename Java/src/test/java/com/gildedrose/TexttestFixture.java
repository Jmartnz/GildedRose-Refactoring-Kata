package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexttestFixture {

    @Test
    public void test() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        out.println("OMGHAI!");

        Item[] items = new BaseItem[] {
                new BaseItem("+5 Dexterity Vest", 10, 20), //
                new Brie("Aged Brie", 2, 0), //
                new BaseItem("Elixir of the Mongoose", 5, 7), //
                new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
                new Pass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Pass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Pass("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new BaseItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;

        for (int i = 0; i < days; i++) {
            out.println("-------- day " + i + " --------");
            out.println("name, sellIn, quality");
            for (Item item : items) {
                out.println(item);
            }
            out.println();
            app.updateQuality();
        }

        assertEquals(expected, outputStream.toString());
    }

  private final String expected =
      "OMGHAI!" + System.lineSeparator()
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
          + System.lineSeparator();
}
