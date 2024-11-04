package com.github.telvarost.fishinfoodtweaks;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "FishinFoodTweaks")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigEntry(
                name = "Allow Catching Random Fish Sizes",
                multiplayerSynced = true
        )
        public Boolean enableRandomFishSizes = true;

        @ConfigEntry(
                name = "Calculate Water Surface Size",
                description = "Adjusts fish size/type based on area",
                multiplayerSynced = true
        )
        public Boolean calculateWaterSurfaceSize = true;

        @ConfigEntry(name = "Display Fish Healing Tooltip")
        public Boolean enableFishHealingTooltip = false;

        @ConfigEntry(name = "Display Food Healing Tooltips")
        public Boolean enableFoodHealingTooltips = false;

        @ConfigEntry(
                name = "Enable Non-vanilla Fish",
                multiplayerSynced = true
        )
        public Boolean enableNonVanillaFish = false;

        @ConfigEntry(
                name = "Enable Oceanic Fish",
                description = "Increases the max fish size from 70 to 110",
                multiplayerSynced = true
        )
        public Boolean enableBiggerFish = false;
    }
}
