package com.github.telvarost.fishinfoodtweaks.mixin;

import com.github.telvarost.fishinfoodtweaks.Config;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.food.FoodBase;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FoodBase.class)
public class FoodBaseMixin extends ItemBase implements CustomTooltipProvider {

    public FoodBaseMixin(int i, int j, boolean bl) {
        super(i);
    }

    @Override
    public String[] getTooltip(ItemInstance itemInstance, String originalTooltip) {
        if (  (Config.ConfigFields.enableFishSizes)
           && (ItemBase.rawFish.id == itemInstance.itemId)
        ) {
            return new String[]{originalTooltip, "§c" + "Heals " + (Math.round(itemInstance.getDamage() / 100.0) / 2.0), "§7" + (itemInstance.getDamage() / 10.0) + " cm"};
        } else {
            return new String[]{originalTooltip};
        }
    }
}
