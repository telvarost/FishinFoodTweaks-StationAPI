package com.github.telvarost.fishinfoodtweaks.achievement;

import com.github.telvarost.fishinfoodtweaks.items.Fish;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.achievement.Achievement;
import net.minecraft.block.BlockBase;
import net.minecraft.item.ItemBase;
import net.minecraft.stat.RegisteringStat;
import net.minecraft.stat.Stat;

import java.util.ArrayList;
import java.util.List;

public class FishinFoodTweaksAchievements {
	public static final List<Achievement> ACHIEVEMENTS = new ArrayList<>();
	private static int achievementID = 11000;

	public static final Achievement WISHIN_I_WAS_FISHIN = make("wishin_i_was_fishin", ItemBase.fishingRod, 0, 0, null, false);
	public static final Achievement SPECIAL_FISH = make("special_fish", ItemBase.rawFish, 2, -2, WISHIN_I_WAS_FISHIN, true);
	public static final Achievement LITTLE_FISH = make("little_fish", Fish.raw_common_fish, -2, 0, WISHIN_I_WAS_FISHIN, false);
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

//	public static int readStat(Stat stat) {
//		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
//			return getStatClient(stat);
//		}
//		// No way to read from server, not handling
//		return 0;
//	}

//	@SuppressWarnings("unchecked")
//	private static int getStatClient(Stat stat) {
//		return (int) BNBClient.getMinecraft().statFileWriter.getHashMapOfStats().getOrDefault(stat, 0);
//	}
}
