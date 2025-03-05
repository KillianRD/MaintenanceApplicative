package com.gildedrose;

public class NormalItem extends Item {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (quality > 0)
            quality = quality - 1;

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality > 0)
            quality = quality - 1;
    }
}
