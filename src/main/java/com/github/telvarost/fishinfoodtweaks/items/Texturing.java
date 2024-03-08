package com.github.telvarost.fishinfoodtweaks.items;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class Texturing {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        Fish.blocks_Disc.setTexture(NAMESPACE.id("item/blocks_disc"));
        Fish.chirp_Disc.setTexture(NAMESPACE.id("item/chirp_disc"));
        Fish.far_Disc.setTexture(NAMESPACE.id("item/far_disc"));
        Fish.mall_Disc.setTexture(NAMESPACE.id("item/mall_disc"));
        Fish.mellohi_Disc.setTexture(NAMESPACE.id("item/mellohi_disc"));
        Fish.stal_Disc.setTexture(NAMESPACE.id("item/stal_disc"));
        Fish.strad_Disc.setTexture(NAMESPACE.id("item/strad_disc"));
        Fish.ward_Disc.setTexture(NAMESPACE.id("item/ward_disc"));
        Fish.eleven_Disc.setTexture(NAMESPACE.id("item/11_disc"));
        Fish.wait_Disc.setTexture(NAMESPACE.id("item/wait_disc"));
        Fish.pigstep_Disc.setTexture(NAMESPACE.id("item/pigstep_disc"));
        Fish.otherside_Disc.setTexture(NAMESPACE.id("item/otherside_disc"));
        Fish.relic_Disc.setTexture(NAMESPACE.id("item/relic_disc"));
        Fish.five_Disc.setTexture(NAMESPACE.id("item/5_disc"));
    }
}
