package com.github.telvarost.fishinfoodtweaks.items;

import com.github.telvarost.fishinfoodtweaks.Config;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Fish {
    public static ItemBase[] items;
    public static ItemBase raw_sepia_fish;
    public static ItemBase cooked_sepia_fish;
    public static ItemBase raw_salmon_fish;
    public static ItemBase cooked_salmon_fish;
    public static ItemBase raw_violet_fish;
    public static ItemBase cooked_violet_fish;
    public static ItemBase raw_ocean_fish;
    public static ItemBase cooked_ocean_fish;
//    public static ItemBase raw_big_fish;
//    public static ItemBase cooked_big_fish;

    @Entrypoint.Namespace
    final Namespace namespace = Null.get();
    final Namespace NAMESPACE = Null.get();

    @EventListener
    void registerItems(ItemRegistryEvent event) {
        raw_sepia_fish = new NewFish(namespace.id("raw_sepia_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "RawSepiaFish");
        cooked_sepia_fish = new NewFish(namespace.id("cooked_sepia_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "CookedSepiaFish");
        raw_salmon_fish = new NewFish(namespace.id("raw_salmon_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "RawSalmonFish");
        cooked_salmon_fish = new NewFish(namespace.id("cooked_salmon_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "CookedSalmonFish");
        raw_violet_fish = new NewFish(namespace.id("raw_violet_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "RawVioletFish");
        cooked_violet_fish = new NewFish(namespace.id("cooked_violet_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "CookedVioletFish");
        raw_ocean_fish = new NewFish(namespace.id("raw_ocean_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "RawOceanFish");
        cooked_ocean_fish = new NewFish(namespace.id("cooked_ocean_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "CookedOceanFish");
//        raw_big_fish = new NewFish(namespace.id("raw_big_fish"), 2, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
//        cooked_big_fish = new NewFish(namespace.id("cooked_big_fish"), 5, false).setMaxStackSize(1).setTranslationKey(namespace, "Fish");
        items = new ItemBase[]{
//                ItemBase.rawFish,
//                ItemBase.cookedFish,
                Fish.raw_sepia_fish,
                Fish.cooked_sepia_fish,
                Fish.raw_salmon_fish,
                Fish.cooked_salmon_fish,
                Fish.raw_violet_fish,
                Fish.cooked_violet_fish,
                Fish.raw_ocean_fish,
                Fish.cooked_ocean_fish,
        };
    }

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            //if (Config.ConfigFields.enableNonVanillaFish) {
                SmeltingRegistry.addSmeltingRecipe(new ItemInstance(Fish.raw_sepia_fish.id, 1, -1), new ItemInstance(Fish.cooked_sepia_fish, 1));
                SmeltingRegistry.addSmeltingRecipe(new ItemInstance(Fish.raw_salmon_fish.id, 1, -1), new ItemInstance(Fish.cooked_salmon_fish, 1));
                SmeltingRegistry.addSmeltingRecipe(new ItemInstance(Fish.raw_violet_fish.id, 1, -1), new ItemInstance(Fish.cooked_violet_fish, 1));
                SmeltingRegistry.addSmeltingRecipe(new ItemInstance(Fish.raw_ocean_fish.id, 1, -1), new ItemInstance(Fish.cooked_ocean_fish, 1));
            //}
        }
    }
}