package com.github.telvarost.fishinfoodtweaks.mixin;

import com.github.telvarost.fishinfoodtweaks.Config;
import com.github.telvarost.fishinfoodtweaks.achievement.FishinFoodTweaksAchievements;
import com.github.telvarost.fishinfoodtweaks.items.Fish;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.entity.player.PlayerHelper;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(FishingBobberEntity.class)
public abstract class FishHookMixin extends Entity {

    @Unique
    private int _amountOfWaterBlocks = 0;
    @Unique
    private int _calcX = 0;
    @Unique
    private int _calcY = 0;
    @Unique
    private int _calcZ = 0;
    @Unique
    private int _blockY = 0;
    @Unique
    private boolean _specialFish = false;

    public FishHookMixin(World arg) {
        super(arg);
    }

    @WrapOperation(
            method = "use",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;spawnEntity(Lnet/minecraft/entity/Entity;)Z"
            )
    )
    public boolean fishinFoodTweaks_use(World instance, Entity entity, Operation<Boolean> original) {
        if (Config.config.enableRandomFishSizes) {
            PlayerEntity player = PlayerHelper.getPlayerFromGame();
            fishinFoodTweaks_calculateWaterSurfaceSize(instance);

            /** - Set up for fish size calculations */
            double surfaceWaterAdjustment = (_amountOfWaterBlocks / 10000.0);
            int fishSize = 20;
            _specialFish = false;
            Random rand = new Random();
            GammaDistribution gammaDistribution = new GammaDistribution(2, 0.125 + surfaceWaterAdjustment);

            /** - Calculate size of fish */
            if (Config.config.enableBiggerFish && 250 <= _amountOfWaterBlocks) {
                fishSize = (int)Math.round(1000.0 * gammaDistribution.sample());

                if (990 <= fishSize) {
                    _specialFish = true;
                }

                if (1000 <= fishSize) {
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

            if (Config.config.enableNonVanillaFish) {
                if (false == _specialFish) {
                    int fishType;

                    if (Config.config.enableBiggerFish && 250 <= _amountOfWaterBlocks) {
                        fishType = rand.nextInt(4);
                        if (Config.config.calculateWaterSurfaceSize && 1 == fishType) {
                            fishType = rand.nextInt(4);
                        }
                    } else if (150 <= _amountOfWaterBlocks) {
                        fishType = rand.nextInt(3);
                    } else if (50 <= _amountOfWaterBlocks) {
                        fishType = rand.nextInt(2);
                    } else {
                        fishType = 0;
                    }

                    switch (fishType)
                    {
                        default:
                        case 0:
                            ((ItemEntity)entity).stack = new ItemStack(Fish.raw_common_fish, 1);

                            if (400 <= fishSize) {
                                fishSize = (int)(fishSize * 0.50);
                            } else if (300 <= fishSize) {
                                fishSize = (int)(fishSize * 0.75);
                            }
                            break;

                        case 1:
                            ((ItemEntity)entity).stack = new ItemStack(Fish.raw_river_fish, 1);

                            if (350 <= fishSize) {
                                fishSize = (int)(fishSize * 0.8);
                            } else {
                                fishSize = fishSize + 10;
                                fishSize = (int)(fishSize * 1.1);
                            }
                            break;

                        case 2:
                            ((ItemEntity)entity).stack = new ItemStack(Fish.raw_sea_fish, 1);

                            if (450 <= fishSize) {
                                fishSize = (int)(fishSize * 0.9);
                            } else {
                                fishSize = fishSize + 50;
                                fishSize = (int)(fishSize * 1.1);
                            }
                            break;

                        case 3:
                            ((ItemEntity)entity).stack = new ItemStack(Fish.raw_ocean_fish, 1);

                            if (null != player) {
                                player.incrementStat(FishinFoodTweaksAchievements.OCEAN_FISH);
                            }

                            if (500 <= fishSize) {
                                if (600 <= fishSize) {
                                    /** - Do nothing */
                                } else {
                                    fishSize = (int)(fishSize * 1.1);
                                }
                            } else {
                                fishSize = fishSize + 125;
                                fishSize = (int)(fishSize * 1.1);
                            }
                            break;
                    }
                }
            } else {
                if (700 < fishSize) {
                    if (null != player) {
                        player.incrementStat(FishinFoodTweaksAchievements.OCEAN_FISH);
                    }
                }
            }

            if (null != player) {
                player.incrementStat(FishinFoodTweaksAchievements.FIRST_UNIQUE_FISH);
                if (_specialFish) {
                    player.incrementStat(FishinFoodTweaksAchievements.SPECIAL_FISH);
                }
                if (150 > fishSize) {
                    player.incrementStat(FishinFoodTweaksAchievements.LITTLE_FISH);
                }
            }
            ((ItemEntity)entity).stack.setDamage(fishSize);
        } else if (Config.config.enableNonVanillaFish) {
            int fishType;
            fishinFoodTweaks_calculateWaterSurfaceSize(instance);

            if (250 <= _amountOfWaterBlocks) {
                fishType = random.nextInt(5);
                if (Config.config.calculateWaterSurfaceSize && 1 == fishType) {
                    fishType = random.nextInt(5);
                }
            } else if (150 <= _amountOfWaterBlocks) {
                fishType = random.nextInt(4);
            } else if (50 <= _amountOfWaterBlocks) {
                fishType = random.nextInt(3);
            } else {
                fishType = random.nextInt(2);
            }

            fishType = fishType - 1;

            switch (fishType) {
                default:
                case -1:
                    /** - Do nothing */
                    break;

                case 0:
                    ((ItemEntity) entity).stack = new ItemStack(Fish.raw_common_fish, 1);
                    break;

                case 1:
                    ((ItemEntity) entity).stack = new ItemStack(Fish.raw_river_fish, 1);
                    break;

                case 2:
                    ((ItemEntity) entity).stack = new ItemStack(Fish.raw_sea_fish, 1);
                    break;

                case 3:
                    ((ItemEntity) entity).stack = new ItemStack(Fish.raw_ocean_fish, 1);
                    break;
            }
        }

        return original.call(instance, entity);
    }

    @Unique
    private int fishinFoodTweaks_computeNormalFishSize(GammaDistribution gammaDistribution)
    {
        int fishSize = (int)Math.round(600.0 * gammaDistribution.sample());

        if (550 <= fishSize) {
            int ones = random.nextInt(10) * 10;
            int tenths = random.nextInt(10);

            fishSize = 600 + ones + tenths;

            if (fishSize == 699) {
                fishSize = fishSize + random.nextInt(2);
            }

            if (690 <= fishSize && fishSize <= 700) {
                _specialFish = true;
            }
        } else {
            fishSize = fishSize + 100;
        }

        return fishSize;
    }

    @Unique void fishinFoodTweaks_calculateWaterSurfaceSize(World instance) {
        if (Config.config.calculateWaterSurfaceSize) {
            /** - Set up water block search */
            _amountOfWaterBlocks = 0;
            _blockY = 0;
            _calcX = (int) Math.floor(this.x);
            _calcY = (int) Math.floor(this.y);
            _calcZ = (int) Math.floor(this.z);

            /** - Search for starting water block */
            int blockId = instance.getBlockId(_calcX, _calcY, _calcZ);
            if ((Block.WATER.id == blockId)
                    || (Block.FLOWING_WATER.id == blockId)
            ) {
                _amountOfWaterBlocks++;
            } else {
                _blockY--;
                blockId = instance.getBlockId(_calcX, _calcY + _blockY, _calcZ);
                if ((Block.WATER.id == blockId)
                        || (Block.FLOWING_WATER.id == blockId)
                ) {
                    _amountOfWaterBlocks++;
                }
            }

            /** - Search for surface water blocks in eight directions from starting water block */
            if (0 < _amountOfWaterBlocks) {
                fishinFoodTweaks_findWaterInDirection(instance, 1, 1);   // North East
                fishinFoodTweaks_findWaterInDirection(instance, 1, 0);   // North
                fishinFoodTweaks_findWaterInDirection(instance, 1, -1);  // North West
                fishinFoodTweaks_findWaterInDirection(instance, -1, 1);  // South East
                fishinFoodTweaks_findWaterInDirection(instance, -1, 0);  // South
                fishinFoodTweaks_findWaterInDirection(instance, -1, -1); // South West
                fishinFoodTweaks_findWaterInDirection(instance, 0, 1);   // East
                fishinFoodTweaks_findWaterInDirection(instance, 0, -1);  // West
            }
        } else {
            _amountOfWaterBlocks = 250;
        }
    }

    @Unique
    private void fishinFoodTweaks_findWaterInDirection(World instance, int dirX, int dirZ) {
        int searchX = _calcX;
        int searchY = _calcY + _blockY;
        int searchZ = _calcZ;

        while (350 > _amountOfWaterBlocks) {
            searchX = searchX + dirX;
            searchZ = searchZ + dirZ;

            int blockId = instance.getBlockId(searchX, searchY, searchZ);
            if (  (Block.WATER.id == blockId)
               || (Block.FLOWING_WATER.id == blockId)
            ) {
                _amountOfWaterBlocks++;
            } else {
                break;
            }
        }
    }
}
