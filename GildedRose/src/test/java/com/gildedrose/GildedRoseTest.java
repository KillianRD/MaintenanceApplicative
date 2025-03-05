package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String NORMAL_ITEM = "Item";

    @Test
    void AgedBrie() {
        Item[] items = new Item[] {
                new AgedBrie(AGED_BRIE, 10, 40),
                new AgedBrie(AGED_BRIE, 0, 40)
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
                new Sulfuras(SULFURAS, 10, 40),
                new Sulfuras(SULFURAS, 0, 40)
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
                new Backstage(BACKSTAGE, 10, 40),
                new Backstage(BACKSTAGE, 5, 40),
                new Backstage(BACKSTAGE, 0, 40)
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
                new NormalItem(NORMAL_ITEM, 10, 40),
                new NormalItem(NORMAL_ITEM, 0, 40)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(39, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);

        assertEquals(38, app.items[1].quality);
        assertEquals(-1, app.items[1].sellIn);
    }
}
