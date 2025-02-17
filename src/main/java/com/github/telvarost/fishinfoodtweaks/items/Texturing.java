package com.github.telvarost.fishinfoodtweaks.items;

import com.github.telvarost.fishinfoodtweaks.ModHelper;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;

public class Texturing {

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        Fish.raw_common_fish.setTexture(ModHelper.NAMESPACE.id("item/sepia_raw_fish"));
        Fish.cooked_common_fish.setTexture(ModHelper.NAMESPACE.id("item/sepia_cooked_fish"));
        Fish.raw_river_fish.setTexture(ModHelper.NAMESPACE.id("item/salmon_raw_fish"));
        Fish.cooked_river_fish.setTexture(ModHelper.NAMESPACE.id("item/salmon_cooked_fish"));
        Fish.raw_sea_fish.setTexture(ModHelper.NAMESPACE.id("item/violet_raw_fish"));
        Fish.cooked_sea_fish.setTexture(ModHelper.NAMESPACE.id("item/violet_cooked_fish"));
        Fish.raw_ocean_fish.setTexture(ModHelper.NAMESPACE.id("item/ocean_raw_fish"));
        Fish.cooked_ocean_fish.setTexture(ModHelper.NAMESPACE.id("item/ocean_cooked_fish"));
    }
}
