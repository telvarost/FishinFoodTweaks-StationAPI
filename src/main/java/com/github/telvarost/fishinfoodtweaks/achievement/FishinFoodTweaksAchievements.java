package com.github.telvarost.fishinfoodtweaks.achievement;

import com.github.telvarost.fishinfoodtweaks.items.Fish;
import net.minecraft.achievement.Achievement;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;

import java.util.ArrayList;
import java.util.List;

public class FishinFoodTweaksAchievements {
	public static final List<Achievement> ACHIEVEMENTS = new ArrayList<>();
	private static int achievementID = 11000;

	public static final Achievement FIRST_UNIQUE_FISH = make("first_unique_fish", ItemBase.fishingRod, 0, 0, null, false);
	public static final Achievement SPECIAL_FISH = make("special_fish", ItemBase.rawFish, 2, -2, FIRST_UNIQUE_FISH, true);
	public static final Achievement LITTLE_FISH = make("little_fish", Fish.raw_common_fish, -2, 0, FIRST_UNIQUE_FISH, false);
	public static final Achievement OCEAN_FISH = make("ocean_fish", Fish.raw_ocean_fish, 0, 2, LITTLE_FISH, false);

	private static Achievement make(String name, BlockBase icon, int x, int y, Achievement parent) {
		Achievement achievement = new Achievement(achievementID++, "fishinfoodtweaks:" + name, x, y, icon, parent);
		ACHIEVEMENTS.add(achievement);
		return achievement;
	}

	private static Achievement make(String name, ItemBase icon, int x, int y, Achievement parent, boolean isChallenge) {
		Achievement achievement = new Achievement(achievementID++, "fishinfoodtweaks:" + name, x, y, icon, parent);
		if (isChallenge) {
			achievement.setUnusual();
		}
		ACHIEVEMENTS.add(achievement);
		return achievement;
	}
}
