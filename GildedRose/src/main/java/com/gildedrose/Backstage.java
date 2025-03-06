package com.gildedrose;

public class Backstage extends Item{
    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (quality < 50) {
            quality++;

            if (sellIn < 11)
                quality++;

            if (sellIn < 6)
                quality = quality + 1;
        }

        sellIn--;

        if (sellIn < 0)
            quality = 0;
    }
}
