package com.github.telvarost.fishinfoodtweaks.items;

import com.github.telvarost.fishinfoodtweaks.ModHelper;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;

public class Fish {
    public static Item[] items;
    public static Item raw_common_fish;
    public static Item cooked_common_fish;
    public static Item raw_river_fish;
    public static Item cooked_river_fish;
    public static Item raw_sea_fish;
    public static Item cooked_sea_fish;
    public static Item raw_ocean_fish;
    public static Item cooked_ocean_fish;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        raw_common_fish = new NewFish(ModHelper.NAMESPACE.id("raw_common_fish"), 2, false).setMaxCount(1).setTranslationKey(ModHelper.NAMESPACE, "RawCommonFish");
        cooked_common_fish = new NewFish(ModHelper.NAMESPACE.id("cooked_common_fish"), 5, false).setMaxCount(1).setTranslationKey(ModHelper.NAMESPACE, "CookedCommonFish");
        raw_river_fish = new NewFish(ModHelper.NAMESPACE.id("raw_river_fish"), 2, false).setMaxCount(1).setTranslationKey(ModHelper.NAMESPACE, "RawRiverFish");
        cooked_river_fish = new NewFish(ModHelper.NAMESPACE.id("cooked_river_fish"), 5, false).setMaxCount(1).setTranslationKey(ModHelper.NAMESPACE, "CookedRiverFish");
        raw_sea_fish = new NewFish(ModHelper.NAMESPACE.id("raw_sea_fish"), 2, false).setMaxCount(1).setTranslationKey(ModHelper.NAMESPACE, "RawSeaFish");
        cooked_sea_fish = new NewFish(ModHelper.NAMESPACE.id("cooked_sea_fish"), 5, false).setMaxCount(1).setTranslationKey(ModHelper.NAMESPACE, "CookedSeaFish");
        raw_ocean_fish = new NewFish(ModHelper.NAMESPACE.id("raw_ocean_fish"), 2, false).setMaxCount(1).setTranslationKey(ModHelper.NAMESPACE, "RawOceanFish");
        cooked_ocean_fish = new NewFish(ModHelper.NAMESPACE.id("cooked_ocean_fish"), 5, false).setMaxCount(1).setTranslationKey(ModHelper.NAMESPACE, "CookedOceanFish");

        items = new Item[]{
                Fish.raw_common_fish,
                Fish.cooked_common_fish,
                Fish.raw_river_fish,
                Fish.cooked_river_fish,
                Fish.raw_sea_fish,
                Fish.cooked_sea_fish,
                Fish.raw_ocean_fish,
                Fish.cooked_ocean_fish,
        };
    }
}