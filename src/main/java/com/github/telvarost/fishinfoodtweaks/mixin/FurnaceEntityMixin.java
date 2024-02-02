package com.github.telvarost.fishinfoodtweaks.mixin;

import com.github.telvarost.fishinfoodtweaks.Config;
import com.github.telvarost.fishinfoodtweaks.ModHelper;
import net.minecraft.inventory.InventoryBase;
import net.minecraft.item.ItemBase;
import net.minecraft.tileentity.TileEntityBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.item.ItemInstance;

@Mixin(TileEntityFurnace.class)
public abstract class FurnaceEntityMixin extends TileEntityBase implements InventoryBase {

    @Shadow
    private ItemInstance[] inventory;

    @Shadow public int burnTime;

    @Shadow protected abstract boolean canAcceptRecipeOutput();

    @Inject(method = "craftRecipe", at = @At(value = "HEAD"), cancellable = true)
    public void fishinFoodTweaks_craftRecipe(CallbackInfo ci) {
        if (this.canAcceptRecipeOutput()) {
            if (Config.ConfigFields.enableRandomFishSizes) {
                if (this.inventory[0] != null && this.inventory[0].itemId == ItemBase.rawFish.id) {
                    ModHelper.ModHelperFields.COOKED_RAW_FISH_SIZE = this.inventory[0].getDamage();
                    ModHelper.ModHelperFields.IS_RAW_FISH_CONSUMED = true;
                }
            }
        }
    }

    @Inject(method = "tick", at = @At(value = "RETURN"))
    public void fishinFoodTweaks_tickConsumeLavaBucketReturnEmptyBucket(CallbackInfo ci) {
        if(ModHelper.ModHelperFields.IS_RAW_FISH_CONSUMED) {
            this.inventory[2] = new ItemInstance(ItemBase.cookedFish);
            this.inventory[2].setDamage(ModHelper.ModHelperFields.COOKED_RAW_FISH_SIZE);
            ModHelper.ModHelperFields.IS_RAW_FISH_CONSUMED = false;
        }
    }
}
