package com.github.telvarost.fishinfoodtweaks.mixin;

import com.github.telvarost.fishinfoodtweaks.Config;
import com.github.telvarost.fishinfoodtweaks.items.Fish;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FoodItem.class)
public abstract class FoodBaseMixin extends Item implements CustomTooltipProvider {

    @Shadow private int healthRestored;

    public FoodBaseMixin(int i, int j, boolean bl) {
        super(i);
    }

    @WrapOperation(
            method = "use",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;heal(I)V"
            )
    )
    public void fishinFoodTweaks_useFood(PlayerEntity instance, int amount, Operation<Void> original, ItemStack stack, World world, PlayerEntity user) {
        if (  (Config.config.enableRandomFishSizes)
           && (  (fishinFoodTweaks_isRawFish(stack.itemId))
              || (fishinFoodTweaks_isCookedFish(stack.itemId))
              )
        ) {
            int fishSize = (0 != stack.getDamage()) ? stack.getDamage() : 250;
            double healingDivisor = (fishinFoodTweaks_isRawFish(stack.itemId)) ? 100.0 : 50.0;
            int healingAmount = (int)Math.floor(fishSize / healingDivisor);
            original.call(instance, healingAmount);
        } else {
            original.call(instance, amount);
        }
    }

    @Override
    public String[] getTooltip(ItemStack itemInstance, String originalTooltip) {
        if (  (Config.config.enableRandomFishSizes)
           && (  (fishinFoodTweaks_isRawFish(itemInstance.itemId))
              || (fishinFoodTweaks_isCookedFish(itemInstance.itemId))
              )
        ) {
            int fishSize = (0 != itemInstance.getDamage()) ? itemInstance.getDamage() : 250;

            if (fishinFoodTweaks_isRawFish(itemInstance.itemId)) {
                if (990 <= fishSize) {
                    if (1090 <= fishSize) {
                        originalTooltip = "§bLegendary Fish";
                    } else {
                        originalTooltip = "§6Rare Fish";
                    }
                } else if (690 <= fishSize && fishSize <= 700) {
                    originalTooltip = "§eLucky Fish";
                }
            } else {
                if (990 <= fishSize) {
                    if (1090 <= fishSize) {
                        originalTooltip = "§bCooked Legendary Fish";
                    } else {
                        originalTooltip = "§6Cooked Rare Fish";
                    }
                } else if (690 <= fishSize && fishSize <= 700) {
                    originalTooltip = "§eCooked Lucky Fish";
                }
            }

            if (Config.config.enableFishHealingTooltip) {
                double healingDivisor = (fishinFoodTweaks_isRawFish(itemInstance.itemId)) ? 100.0 : 50.0;
                double healingAmount = (Math.floor(fishSize / healingDivisor) / 2.0);
                return new String[]{originalTooltip, "§4" + "Heals " + healingAmount, "§7" + (fishSize / 10.0) + " cm"};
            } else {
                return new String[]{originalTooltip, "§7" + (fishSize / 10.0) + " cm"};
            }
        } else {
            if (  (fishinFoodTweaks_isRawFish(itemInstance.itemId))
               || (fishinFoodTweaks_isCookedFish(itemInstance.itemId))
               )
            {
                if (Config.config.enableFishHealingTooltip) {
                    return new String[]{originalTooltip, "§4" + "Heals " + (this.healthRestored / 2.0)};
                } else {
                    return new String[]{originalTooltip};
                }
            } else {
                if (Config.config.enableFoodHealingTooltips) {
                    return new String[]{originalTooltip, "§4" + "Heals " + (this.healthRestored / 2.0)};
                } else {
                    return new String[]{originalTooltip};
                }
            }
        }
    }

    @Unique
    private boolean fishinFoodTweaks_isRawFish(int itemId) {
        return (  (Item.RAW_FISH.id     == itemId)
               || (Fish.raw_common_fish.id  == itemId)
               || (Fish.raw_river_fish.id == itemId)
               || (Fish.raw_sea_fish.id == itemId)
               || (Fish.raw_ocean_fish.id  == itemId)
               );
    }

    @Unique
    private boolean fishinFoodTweaks_isCookedFish(int itemId) {
        return (  (Item.COOKED_FISH.id     == itemId)
                || (Fish.cooked_common_fish.id  == itemId)
                || (Fish.cooked_river_fish.id == itemId)
                || (Fish.cooked_sea_fish.id == itemId)
                || (Fish.cooked_ocean_fish.id  == itemId)
        );
    }
}
