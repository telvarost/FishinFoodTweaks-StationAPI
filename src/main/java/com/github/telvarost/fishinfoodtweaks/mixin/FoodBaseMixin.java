package com.github.telvarost.fishinfoodtweaks.mixin;

import com.github.telvarost.fishinfoodtweaks.Config;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.food.FoodBase;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FoodBase.class)
public abstract class FoodBaseMixin extends ItemBase implements CustomTooltipProvider {

    @Shadow private int healAmount;

    public FoodBaseMixin(int i, int j, boolean bl) {
        super(i);
    }

    @Inject(method = "use", at = @At(value = "HEAD"), cancellable = true)
    public void fishinFoodTweaks_useFood(ItemInstance itemInstance, Level arg2, PlayerBase arg3, CallbackInfoReturnable<ItemInstance> cir) {
        if (  (Config.ConfigFields.enableFishSizes)
           && (  (ItemBase.rawFish.id    == itemInstance.itemId)
              || (ItemBase.cookedFish.id == itemInstance.itemId)
              )
        ) {
            --itemInstance.count;
            double healingDivisor = (ItemBase.rawFish.id == itemInstance.itemId) ? 100.0 : 50.0;
            int healingAmount = (int)Math.round(itemInstance.getDamage() / healingDivisor);
            arg3.addHealth(healingAmount);
            cir.setReturnValue(itemInstance);
        }
    }

    @Override
    public String[] getTooltip(ItemInstance itemInstance, String originalTooltip) {
        if (  (Config.ConfigFields.enableFishSizes)
           && (  (ItemBase.rawFish.id    == itemInstance.itemId)
              || (ItemBase.cookedFish.id == itemInstance.itemId)
              )
        ) {
            double healingDivisor = (ItemBase.rawFish.id == itemInstance.itemId) ? 100.0 : 50.0;
            double healingAmount = (Math.round(itemInstance.getDamage() / healingDivisor) / 2.0);
            return new String[]{originalTooltip, "§4" + "Heals " + healingAmount, "§7" + (itemInstance.getDamage() / 10.0) + " cm"};
        } else {
            return new String[]{originalTooltip};
        }
    }
}
