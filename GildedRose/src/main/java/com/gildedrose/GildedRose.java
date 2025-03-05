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
        if (!item.name.equals(AgedBrie) && !item.name.equals(TAFKAL80ETC)) {
            if (item.quality > 0) {
                if (!item.name.equals(Sulfuras)) {
                    item.quality = item.quality - 1;
                }
            }
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(AgedBrie)) {
                if (!item.name.equals(TAFKAL80ETC)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(Sulfuras)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    public static void Sulfuras(Item item) {

    }
}
