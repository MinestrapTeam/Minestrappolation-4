package minestrapteam.minestrappolation.lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MAchievements {
	public static Achievement minestrapp = new Achievement("achievement.minestrap", "minestrap",  0, 0, MBlocks.copper_ore, (Achievement)null).setSpecial();
	public static Achievement stonecutter = new Achievement("achievement.stonecutter", "stonecutter",  0, 2, MBlocks.stonecutter, (Achievement)minestrapp);
	public static Achievement sawmill = new Achievement("achievement.sawmill", "sawmill",  0, 4, MBlocks.sawmill, (Achievement)minestrapp);
	public static Achievement crusher = new Achievement("achievement.crusher", "crusher",  0, 6, MBlocks.crusher, (Achievement)minestrapp);	
	public static Achievement alloy = new Achievement("achievement.alloy", "alloy",  0, 8, MBlocks.alloy, (Achievement)minestrapp);
	public static Achievement melter = new Achievement("achievement.melter", "melter",  0, 10, MBlocks.melter, (Achievement)minestrapp);
	public static Achievement frost = new Achievement("achievement.frost", "frost",  2, 0, MBlocks.dirt_permafrost, (Achievement)minestrapp);
	public static Achievement bedrock = new Achievement("achievement.bedrock", "bedrock", 0, -2, Blocks.bedrock, (Achievement)minestrapp);
	public static Achievement sifter = new Achievement("achievement.sifter", "sifter", -2, 0, MItems.sifter, (Achievement)minestrapp);
	public static Achievement god = new Achievement("achievement.god", "god",  0, -4, MBlocks.godstone, (Achievement)minestrapp);
	
	public static void load()
	{
		AchievementPage.registerAchievementPage( new AchievementPage("Minestrappolation", new Achievement[] {stonecutter, sawmill, alloy, melter, frost, bedrock, minestrapp, sifter, god, crusher}));
	}
	
	public static void preInit()
	{
		stonecutter.registerStat();
		sawmill.registerStat();
		crusher.registerStat();
		alloy.registerStat();
		melter.registerStat();
		frost.registerStat();
		bedrock.registerStat();
		minestrapp.registerStat();
		sifter.registerStat();
		god.registerStat();
	}
	
	public static void addAchievement(EntityPlayer player, Achievement ach)
	{
		player.addStat(ach, 1);
	}

}
