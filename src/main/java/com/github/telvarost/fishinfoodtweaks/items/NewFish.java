package com.github.telvarost.fishinfoodtweaks.items;

import com.github.telvarost.fishinfoodtweaks.Config;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;
import org.spongepowered.asm.mixin.Unique;

public class NewFish extends TemplateFoodItem implements CustomTooltipProvider {

    public NewFish(Identifier identifier, int healAmount, boolean isWolfFood) {
        super(identifier, healAmount, isWolfFood);
    }

    @Override
    public String[] getTooltip(ItemInstance itemInstance, String originalTooltip) {
        int fishSize = itemInstance.getDamage();
        if (Config.ConfigFields.enableFishHealingTooltip) {
            double healingDivisor = (fishinFoodTweaks_isRawFish(itemInstance.itemId)) ? 100.0 : 50.0;
            double healingAmount = (Math.floor(fishSize / healingDivisor) / 2.0);
            return new String[]{originalTooltip, "§4" + "Heals " + healingAmount, "§7" + (fishSize / 10.0) + " cm"};
        } else {
            return new String[]{originalTooltip, "§7" + (fishSize / 10.0) + " cm"};
        }
    }

    private boolean fishinFoodTweaks_isRawFish(int itemId) {
        return (  (ItemBase.rawFish.id     == itemId)
                || (Fish.raw_sepia_fish.id  == itemId)
                || (Fish.raw_salmon_fish.id == itemId)
                || (Fish.raw_violet_fish.id == itemId)
                || (Fish.raw_ocean_fish.id  == itemId)
        );
    }
}
