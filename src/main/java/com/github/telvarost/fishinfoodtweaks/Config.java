package com.github.telvarost.fishinfoodtweaks;

import blue.endless.jankson.Comment;
import net.glasslauncher.mods.api.gcapi.api.ConfigName;
import net.glasslauncher.mods.api.gcapi.api.GConfig;
import net.glasslauncher.mods.api.gcapi.api.MaxLength;

public class Config {

    @GConfig(value = "config", visibleName = "FishinFoodTweaks Config")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigName("Enable Raw Fish Size")
        @Comment("Raw fish size tooltip displays if enabled")
        public static Boolean enableFishSizes = true;
    }
}
