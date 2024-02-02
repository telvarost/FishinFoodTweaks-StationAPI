package com.github.telvarost.fishinfoodtweaks.mixin;

import com.github.telvarost.fishinfoodtweaks.Config;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.FishHook;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;

@Mixin(FishHook.class)
public abstract class FishHookMixin extends EntityBase {

    public FishHookMixin(Level arg) {
        super(arg);
    }

    @Redirect(
            method = "method_956",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/level/Level;spawnEntity(Lnet/minecraft/entity/EntityBase;)Z"
            )
    )
    public boolean method_956(Level instance, EntityBase entityBase) {
        if (Config.ConfigFields.enableFishSizes) {
            // ItemInstance item =
            Random rand = new Random();
            GammaDistribution gammaDistribution = new GammaDistribution(2, 0.125);

            int fishSize = (int)Math.round(100.0f * gammaDistribution.sample());
            ((Item)entityBase).item.setDamage(fishSize);
            return instance.spawnEntity(entityBase);
        } else {
            return instance.spawnEntity(entityBase);
        }
    }
}
