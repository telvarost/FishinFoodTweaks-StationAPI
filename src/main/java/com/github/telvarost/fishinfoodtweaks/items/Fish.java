package com.github.telvarost.fishinfoodtweaks.items;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.item.TemplateMusicDiscItem;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Fish {
    public static ItemBase[] items;
    public static ItemBase raw_big_fish;
    public static ItemBase cooked_big_fish;
    public static ItemBase raw_indigo_fish;
    public static ItemBase cooked_indigo_fish;
    public static ItemBase raw_purple_fish;
    public static ItemBase cooked_purple_fish;
    public static ItemBase raw_rainbow_fish;
    public static ItemBase cooked_rainbow_fish;
    public static ItemBase raw_red_fish;
    public static ItemBase cooked_red_fish;

    @Entrypoint.Namespace
    final Namespace namespace = Null.get();
    final Namespace NAMESPACE = Null.get();

    @EventListener
    void registerItems(ItemRegistryEvent event) {
        raw_big_fish = new NewFish(namespace.id("raw_big_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        cooked_big_fish = new NewFish(namespace.id("cooked_big_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        raw_indigo_fish = new NewFish(namespace.id("raw_indigo_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        cooked_indigo_fish = new NewFish(namespace.id("cooked_indigo_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        raw_purple_fish = new NewFish(namespace.id("raw_purple_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        cooked_purple_fish = new NewFish(namespace.id("cooked_purple_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        raw_rainbow_fish = new NewFish(namespace.id("raw_rainbow_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        cooked_rainbow_fish = new NewFish(namespace.id("cooked_rainbow_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        raw_red_fish = new NewFish(namespace.id("raw_red_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        cooked_red_fish = new NewFish(namespace.id("cooked_red_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        items = new ItemBase[]{
                ItemBase.rawFish,
                ItemBase.cookedFish,
                Fish.raw_big_fish,
                Fish.cooked_big_fish,
                Fish.raw_indigo_fish,
                Fish.cooked_indigo_fish,
                Fish.raw_purple_fish,
                Fish.cooked_purple_fish,
                Fish.raw_rainbow_fish,
                Fish.cooked_rainbow_fish,
                Fish.raw_red_fish,
                Fish.cooked_red_fish
        };
    }
}