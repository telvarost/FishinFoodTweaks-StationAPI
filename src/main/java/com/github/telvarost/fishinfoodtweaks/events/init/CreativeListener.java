package com.github.telvarost.fishinfoodtweaks.events.init;

import com.github.telvarost.fishinfoodtweaks.ModHelper;
import com.github.telvarost.fishinfoodtweaks.items.Fish;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;

public class CreativeListener {
    public static CreativeTab tabFishinFoodTweaksFish;

    @EventListener
    public void onTabInit(TabRegistryEvent event){
        tabFishinFoodTweaksFish = new SimpleTab(ModHelper.NAMESPACE.id("raw_common_fish"), Fish.raw_common_fish);
        event.register(tabFishinFoodTweaksFish);
        for (Item item : Fish.items){
            tabFishinFoodTweaksFish.addItem(new ItemStack(item, 1));
        }
    }
}