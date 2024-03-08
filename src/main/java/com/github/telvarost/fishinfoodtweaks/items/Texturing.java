package com.github.telvarost.fishinfoodtweaks.items;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Texturing {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        Fish.raw_sepia_fish.setTexture(NAMESPACE.id("item/sepia_raw_fish"));
        Fish.cooked_sepia_fish.setTexture(NAMESPACE.id("item/sepia_cooked_fish"));
        Fish.raw_salmon_fish.setTexture(NAMESPACE.id("item/salmon_raw_fish"));
        Fish.cooked_salmon_fish.setTexture(NAMESPACE.id("item/salmon_cooked_fish"));
        Fish.raw_violet_fish.setTexture(NAMESPACE.id("item/violet_raw_fish"));
        Fish.cooked_violet_fish.setTexture(NAMESPACE.id("item/violet_cooked_fish"));
        Fish.raw_ocean_fish.setTexture(NAMESPACE.id("item/ocean_raw_fish"));
        Fish.cooked_ocean_fish.setTexture(NAMESPACE.id("item/ocean_cooked_fish"));
//        Fish.raw_big_fish.setTexture(NAMESPACE.id("item/vanilla_raw_fish"));
//        Fish.cooked_big_fish.setTexture(NAMESPACE.id("item/vanilla_cooked_fish"));
    }
}
