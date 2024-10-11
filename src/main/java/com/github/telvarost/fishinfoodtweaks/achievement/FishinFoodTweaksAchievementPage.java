package com.github.telvarost.fishinfoodtweaks.achievement;

import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.client.gui.screen.achievement.AchievementPage;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class FishinFoodTweaksAchievementPage extends AchievementPage {
	private static FishinFoodTweaksAchievementPage instance;
	
	public FishinFoodTweaksAchievementPage(Identifier id) {
		super(id);
		instance = this;
	}
	
	@Override
	public int getBackgroundTexture(Random random, int column, int row, int randomizedRow, int currentTexture) {
		int k = Block.SANDSTONE.textureId;
		int l = random.nextInt(1 + row) + row / 2;
		if (l <= 37 && row != 35) {
			if (l == 22) {
				k = Block.WATER.textureId;
			} else if (l == 10) {
				k = Block.WATER.textureId;
			} else if (l == 8) {
				k = Block.WATER.textureId;
			} else if (l > 4) {
				k = Block.WATER.textureId;
			} else if (l > 0) {
				k = Block.SAND.textureId;
			}
		} else {
			k = Block.SAND.textureId;
		}

		return k;
	}
	
	public static FishinFoodTweaksAchievementPage getInstance() {
		return instance;
	}
}
