package com.github.telvarost.fishinfoodtweaks.items;

import com.github.telvarost.fishinfoodtweaks.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.item.TemplateFoodItem;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class NewFish extends TemplateFoodItem implements CustomTooltipProvider {

    public NewFish(Identifier identifier, int healAmount, boolean isWolfFood) {
        super(identifier, healAmount, isWolfFood);
    }

    @Override
    public String[] getTooltip(ItemInstance itemInstance, String originalTooltip) {
        int fishSize = itemInstance.getDamage();
        if (Config.ConfigFields.enableFishHealingTooltip) {
            double healingDivisor = (ItemBase.rawFish.id == itemInstance.itemId) ? 100.0 : 50.0;
            double healingAmount = (Math.floor(fishSize / healingDivisor) / 2.0);
            return new String[]{originalTooltip, "§4" + "Heals " + healingAmount, "§7" + (fishSize / 10.0) + " cm"};
        } else {
            return new String[]{originalTooltip, "§7" + (fishSize / 10.0) + " cm"};
        }
    }
}
