package com.gildedrose;

class GildedRose {
    private static final String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AgedBrie = "Aged Brie";
    private static final String Sulfuras = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            handleItem(item);
        }
    }

    private static void handleItem(Item item) {
        switch (item.name) {
            case Sulfuras:
                break;
            case TAFKAL80ETC:
                handleTAFKAL80ETC(item);
                break;
            case AgedBrie:
                handleAgedBrie(item);
                break;
            default:
                handleNormalItem(item);
                break;
        }
    }

    private static void handleTAFKAL80ETC(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11)
                item.quality = item.quality + 1;

            if (item.sellIn < 6)
                item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0)
            item.quality = 0;

    }

    private static void handleAgedBrie(Item item) {
        if (item.quality < 50)
            item.quality = item.quality + 1;

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality < 50)
            item.quality = item.quality + 1;
    }

    private static void handleNormalItem(Item item) {
        if (item.quality > 0)
            item.quality = item.quality - 1;

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0)
            item.quality = item.quality - 1;
    }
}

