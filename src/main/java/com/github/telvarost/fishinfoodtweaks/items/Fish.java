package com.github.telvarost.fishinfoodtweaks.items;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

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

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    void registerItems(ItemRegistryEvent event) {
        raw_common_fish = new NewFish(NAMESPACE.id("raw_common_fish"), 2, false).setMaxCount(1).setTranslationKey(NAMESPACE, "RawCommonFish");
        cooked_common_fish = new NewFish(NAMESPACE.id("cooked_common_fish"), 5, false).setMaxCount(1).setTranslationKey(NAMESPACE, "CookedCommonFish");
        raw_river_fish = new NewFish(NAMESPACE.id("raw_river_fish"), 2, false).setMaxCount(1).setTranslationKey(NAMESPACE, "RawRiverFish");
        cooked_river_fish = new NewFish(NAMESPACE.id("cooked_river_fish"), 5, false).setMaxCount(1).setTranslationKey(NAMESPACE, "CookedRiverFish");
        raw_sea_fish = new NewFish(NAMESPACE.id("raw_sea_fish"), 2, false).setMaxCount(1).setTranslationKey(NAMESPACE, "RawSeaFish");
        cooked_sea_fish = new NewFish(NAMESPACE.id("cooked_sea_fish"), 5, false).setMaxCount(1).setTranslationKey(NAMESPACE, "CookedSeaFish");
        raw_ocean_fish = new NewFish(NAMESPACE.id("raw_ocean_fish"), 2, false).setMaxCount(1).setTranslationKey(NAMESPACE, "RawOceanFish");
        cooked_ocean_fish = new NewFish(NAMESPACE.id("cooked_ocean_fish"), 5, false).setMaxCount(1).setTranslationKey(NAMESPACE, "CookedOceanFish");

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