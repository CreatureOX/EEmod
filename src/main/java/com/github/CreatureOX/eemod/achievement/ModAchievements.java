package com.github.CreatureOX.eemod.achievement;

import com.github.CreatureOX.eemod.Main;
import com.github.CreatureOX.eemod.block.ModBlocks;
import com.github.CreatureOX.eemod.constant.Constants;
import com.github.CreatureOX.eemod.item.ModItemsRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

/**
 * @description: achievements
 * @Author: CreatureOX
 **/
public class ModAchievements {

	public static Achievement beAWizard = new Achievement(Constants.Achievements.BE_A_WIZARD.getName(),
			Constants.Achievements.BE_A_WIZARD.getUnlocalizedName(),5,-4, ModItemsRegistry.MagicWand,null);

	public static Achievement firstUseMagic = new Achievement(Constants.Achievements.FIRST_USE_MAGIC.getName(),
			Constants.Achievements.FIRST_USE_MAGIC.getUnlocalizedName(),0,0,Blocks.ice,null);

	public static Achievement firstUseMagicSmelting = new Achievement(Constants.Achievements.FIRST_USE_MAGIC_SMELTING.getName(),
			Constants.Achievements.FIRST_USE_MAGIC_SMELTING.getUnlocalizedName(),1,1,ModBlocks.magicBlock,null);
	
	public static AchievementPage pageEEmod = new AchievementPage(Main.MODID.toLowerCase(),beAWizard,firstUseMagic,firstUseMagicSmelting);
	
	public static final void init() {
		beAWizard.setSpecial().registerStat().initIndependentStat();
		firstUseMagic.setSpecial().registerStat().initIndependentStat();
		firstUseMagicSmelting.setSpecial().registerStat().initIndependentStat();
		
        AchievementPage.registerAchievementPage(pageEEmod);
	}
}
