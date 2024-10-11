package com.github.telvarost.fishinfoodtweaks.events.init;

import com.github.telvarost.fishinfoodtweaks.achievement.FishinFoodTweaksAchievementPage;
import com.github.telvarost.fishinfoodtweaks.achievement.FishinFoodTweaksAchievements;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.achievement.Achievement;
import net.minecraft.stat.Stat;
import net.modificationstation.stationapi.api.client.gui.screen.achievement.AchievementPage;
import net.modificationstation.stationapi.api.event.achievement.AchievementRegisterEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

public class AchievementListener {

    @Entrypoint.Namespace
    private Namespace namespace;

    @EventListener
    public void registerAchievements(AchievementRegisterEvent event) {
        AchievementPage achievementPage = new FishinFoodTweaksAchievementPage(namespace.id("fishinAchievements"));
        event.achievements.addAll(FishinFoodTweaksAchievements.ACHIEVEMENTS);
        achievementPage.addAchievements(FishinFoodTweaksAchievements.ACHIEVEMENTS.toArray(Achievement[]::new));
        FishinFoodTweaksAchievements.ACHIEVEMENTS.forEach(Stat::addStat);
    }
}
