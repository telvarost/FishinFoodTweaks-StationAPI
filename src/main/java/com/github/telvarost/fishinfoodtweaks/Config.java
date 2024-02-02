package com.github.telvarost.fishinfoodtweaks;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.ConfigName;
import net.glasslauncher.mods.api.gcapi.api.GConfig;
import net.glasslauncher.mods.api.gcapi.api.MaxLength;

public class Config {

    @GConfig(value = "config", visibleName = "FishinFoodTweaks Config")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigName("Allow Catching Random Fish Sizes")
        public static Boolean enableRandomFishSizes = true;

        @ConfigName("Display Fish Healing Tooltip")
        public static Boolean enableFishHealingTooltips = false;

        @ConfigName("Enable Oceanic Fish")
        @Comment("Increases the max fish size from 70 to 110")
        public static Boolean enableBiggerFish = false;
    }
}
