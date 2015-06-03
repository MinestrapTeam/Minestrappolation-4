package minestrapteam.minestrappolation.lib;

import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MAchievements {
	public static Achievement minestrapp = new Achievement("achievement.minestrap", "minestrap",  0, 2, MBlocks.copper_ore, (Achievement)null).setSpecial();
	public static Achievement stonecutter = new Achievement("achievement.stonecutter", "stonecutter",  0, 0, MBlocks.stonecutter, (Achievement)minestrapp);
	public static Achievement sawmill = new Achievement("achievement.sawmill", "sawmill",  2, 1, MBlocks.sawmill, (Achievement)minestrapp);
	public static Achievement alloy = new Achievement("achievement.alloy", "alloy",  4, 1, MBlocks.alloy, (Achievement)minestrapp);
	public static Achievement melter = new Achievement("achievement.melter", "melter",  6, 1, MBlocks.melter, (Achievement)minestrapp);
	public static Achievement frost = new Achievement("achievement.frost", "frost",  8, 1, MBlocks.dirt_permafrost, (Achievement)minestrapp);
	public static Achievement bedrock = new Achievement("achievement.bedrock", "bedrock", 2, 3, Blocks.bedrock, (Achievement)minestrapp);
	public static Achievement sifter = new Achievement("achievement.sifter", "sifter", 5, 3, MItems.sifter, (Achievement)minestrapp);
	
	public static void load()
	{
		AchievementPage.registerAchievementPage( new AchievementPage("Minestrappolation", new Achievement[] {stonecutter, sawmill, alloy, melter, frost, bedrock, minestrapp, sifter}));
	}
	
	public static void preInit()
	{
		stonecutter.registerStat();
		sawmill.registerStat();
		alloy.registerStat();
		melter.registerStat();
		frost.registerStat();
		bedrock.registerStat();
		minestrapp.registerStat();
		sifter.registerStat();
	}

}
