package com.github.telvarost.fishinfoodtweaks.items;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Fish {
    public static ItemBase[] items;
    public static ItemBase raw_common_fish;
    public static ItemBase cooked_common_fish;
    public static ItemBase raw_river_fish;
    public static ItemBase cooked_river_fish;
    public static ItemBase raw_sea_fish;
    public static ItemBase cooked_sea_fish;
    public static ItemBase raw_ocean_fish;
    public static ItemBase cooked_ocean_fish;

    @Entrypoint.Namespace
    final Namespace namespace = Null.get();

    @EventListener
    void registerItems(ItemRegistryEvent event) {
        raw_common_fish = new NewFish(namespace.id("raw_common_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "RawCommonFish");
        cooked_common_fish = new NewFish(namespace.id("cooked_common_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "CookedCommonFish");
        raw_river_fish = new NewFish(namespace.id("raw_river_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "RawRiverFish");
        cooked_river_fish = new NewFish(namespace.id("cooked_river_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "CookedRiverFish");
        raw_sea_fish = new NewFish(namespace.id("raw_sea_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "RawSeaFish");
        cooked_sea_fish = new NewFish(namespace.id("cooked_sea_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "CookedSeaFish");
        raw_ocean_fish = new NewFish(namespace.id("raw_ocean_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "RawOceanFish");
        cooked_ocean_fish = new NewFish(namespace.id("cooked_ocean_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "CookedOceanFish");

        items = new ItemBase[]{
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