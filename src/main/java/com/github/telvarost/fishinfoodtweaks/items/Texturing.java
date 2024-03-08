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
        Fish.raw_big_fish.setTexture(NAMESPACE.id("item/raw_big_fish"));
        Fish.cooked_big_fish.setTexture(NAMESPACE.id("item/cooked_big_fish"));
        Fish.raw_indigo_fish.setTexture(NAMESPACE.id("item/raw_indigo_fish"));
        Fish.cooked_indigo_fish.setTexture(NAMESPACE.id("item/cooked_indigo_fish"));
        Fish.raw_purple_fish.setTexture(NAMESPACE.id("item/raw_purple_fish"));
        Fish.cooked_purple_fish.setTexture(NAMESPACE.id("item/cooked_purple_fish"));
        Fish.raw_rainbow_fish.setTexture(NAMESPACE.id("item/raw_rainbow_fish"));
        Fish.cooked_rainbow_fish.setTexture(NAMESPACE.id("item/cooked_rainbow_fish"));
        Fish.raw_red_fish.setTexture(NAMESPACE.id("item/raw_red_fish"));
        Fish.cooked_red_fish.setTexture(NAMESPACE.id("item/cooked_red_fish"));
    }
}
