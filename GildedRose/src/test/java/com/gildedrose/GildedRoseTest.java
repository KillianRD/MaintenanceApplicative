package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void AgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 10, 40),
                new Item("Aged Brie", 0, 40)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(41, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);

        assertEquals(42, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
    }

    @Test
    void Sulfuras() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 10, 40),
                new Item("Sulfuras, Hand of Ragnaros", 0, 40)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(40, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);

        assertEquals(40, app.items[1].quality);
        assertEquals(0, app.items[1].sellIn);
    }

    @Test
    void TAFKAL80ETC() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(42, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);

        assertEquals(43, app.items[1].quality);
        assertEquals(4, app.items[1].sellIn);

        assertEquals(0, app.items[2].quality);
        assertEquals(-1, app.items[2].sellIn);
    }

    @Test
    void randomString() {
        Item[] items = new Item[] {
                new Item("foo", 10, 40),
                new Item("Bonjour", 0, 40)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(39, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);

        assertEquals(38, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
    }
}
