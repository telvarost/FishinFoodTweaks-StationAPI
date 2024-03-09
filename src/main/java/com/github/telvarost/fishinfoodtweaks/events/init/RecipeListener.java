package com.github.telvarost.fishinfoodtweaks.events.init;

import com.github.telvarost.fishinfoodtweaks.Config;
import com.github.telvarost.fishinfoodtweaks.items.Fish;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            if (Config.ConfigFields.enableNonVanillaFish) {
                SmeltingRegistry.addSmeltingRecipe(new ItemInstance(Fish.raw_sepia_fish, 1), new ItemInstance(Fish.cooked_sepia_fish, 1));
                SmeltingRegistry.addSmeltingRecipe(new ItemInstance(Fish.raw_salmon_fish, 1), new ItemInstance(Fish.cooked_salmon_fish, 1));
                SmeltingRegistry.addSmeltingRecipe(new ItemInstance(Fish.raw_violet_fish, 1), new ItemInstance(Fish.cooked_violet_fish, 1));
                SmeltingRegistry.addSmeltingRecipe(new ItemInstance(Fish.raw_ocean_fish, 1), new ItemInstance(Fish.cooked_ocean_fish, 1));
            }
        }
    }
}