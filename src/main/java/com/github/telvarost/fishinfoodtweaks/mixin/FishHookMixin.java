package com.github.telvarost.fishinfoodtweaks.mixin;

import com.github.telvarost.fishinfoodtweaks.Config;
import com.github.telvarost.fishinfoodtweaks.items.Fish;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.EntityBase;
import net.minecraft.entity.FishHook;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mixin(FishHook.class)
public abstract class FishHookMixin extends EntityBase {

    public FishHookMixin(Level arg) {
        super(arg);
    }

    @Unique
    private int fishinFoodTweaks_computeNormalFishSize(GammaDistribution gammaDistribution)
    {
        int fishSize = (int)Math.round(600.0 * gammaDistribution.sample());

        if (550 < fishSize) {
            int ones = rand.nextInt(10) * 10;
            int tenths = rand.nextInt(10);

            fishSize = 600 + ones + tenths;

            if (fishSize == 699) {
                fishSize = fishSize + rand.nextInt(2);
            }
        } else {
            fishSize = fishSize + 100;
        }

        return fishSize;
    }

    @Redirect(
            method = "method_956",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/level/Level;spawnEntity(Lnet/minecraft/entity/EntityBase;)Z"
            )
    )
    public boolean fishinFoodTweaks_method_956(Level instance, EntityBase entityBase) {
        if (Config.ConfigFields.enableRandomFishSizes) {
            int fishSize = 100;
            Random rand = new Random();
            GammaDistribution gammaDistribution = new GammaDistribution(2, 0.15);

            if (Config.ConfigFields.enableBiggerFish) {

                fishSize = (int)Math.round(1000.0 * gammaDistribution.sample());

                if (1000 < fishSize) {
                    int ones = rand.nextInt(10) * 10;
                    int tenths = rand.nextInt(10);

                    fishSize = 1000 + ones + tenths;

                    if (fishSize == 1099) {
                        fishSize = fishSize + rand.nextInt(2);
                    }
                } else if (100 > fishSize) {
                    fishSize = fishinFoodTweaks_computeNormalFishSize(gammaDistribution);
                }
            } else {
                fishSize = fishinFoodTweaks_computeNormalFishSize(gammaDistribution);
            }

            int amountOfWaterBlocks = 0;
            int searchX = (int)this.x;
            int searchY = (int)this.y;
            int searchZ = (int)this.z;
            int[] currentBlockIds = new int[9];

            currentBlockIds[0] = instance.getTileId(searchX, searchY, searchZ);
            if (fishinFoodTweaks_isWaterBlock(currentBlockIds[0])) {
                amountOfWaterBlocks++;
            }

            /** - Search North */
            while (50 > amountOfWaterBlocks) {
                searchX++;
                currentBlockIds[1] = instance.getTileId(searchX, searchY, searchZ);
                if (fishinFoodTweaks_isWaterBlock(currentBlockIds[1])) {
                    amountOfWaterBlocks++;
                } else {
                    break;
                }
            }
            searchX = (int)this.x;
            searchY = (int)this.y;
            searchZ = (int)this.z;

            /** - Search South */
            while (50 > amountOfWaterBlocks) {
                searchX--;
                currentBlockIds[1] = instance.getTileId(searchX, searchY, searchZ);
                if (fishinFoodTweaks_isWaterBlock(currentBlockIds[1])) {
                    amountOfWaterBlocks++;
                } else {
                    break;
                }
            }
            searchX = (int)this.x;
            searchY = (int)this.y;
            searchZ = (int)this.z;

            /** - Search NorthEast */
            while (50 > amountOfWaterBlocks) {
                searchX++;
                searchZ++;
                currentBlockIds[1] = instance.getTileId(searchX, searchY, searchZ);
                if (fishinFoodTweaks_isWaterBlock(currentBlockIds[1])) {
                    amountOfWaterBlocks++;
                } else {
                    break;
                }
            }
            searchX = (int)this.x;
            searchY = (int)this.y;
            searchZ = (int)this.z;

            ((Item)entityBase).item = new ItemInstance(Fish.raw_sepia_fish, 1);
            ((Item)entityBase).item.setDamage(fishSize);
            return instance.spawnEntity(entityBase);
        } else {
            return instance.spawnEntity(entityBase);
        }
    }

    @Unique
    private boolean fishinFoodTweaks_isWaterBlock(int blockId) {
        return (  (BlockBase.STILL_WATER.id == blockId)
               || (BlockBase.FLOWING_WATER.id == blockId)
               );
    }
}
