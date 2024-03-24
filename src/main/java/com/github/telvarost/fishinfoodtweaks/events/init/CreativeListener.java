package com.github.telvarost.fishinfoodtweaks.events.init;

import com.github.telvarost.fishinfoodtweaks.items.Fish;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import paulevs.bhcreative.api.CreativeTab;
import paulevs.bhcreative.api.SimpleTab;
import paulevs.bhcreative.registry.TabRegistryEvent;

public class CreativeListener {
    public static CreativeTab tabFishinFoodTweaksFish;

    @EventListener
    public void onTabInit(TabRegistryEvent event){
        tabFishinFoodTweaksFish = new SimpleTab(Fish.NAMESPACE.id("raw_common_fish"), Fish.raw_common_fish);
        event.register(tabFishinFoodTweaksFish);
        for (ItemBase item : Fish.items){
            tabFishinFoodTweaksFish.addItem(new ItemInstance(item, 1));
        }
    }
}