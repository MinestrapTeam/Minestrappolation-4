package minestrapteam.mods.minestrappolation.lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MAchievements {
	public static Achievement minestrapp = new Achievement("achievement.minestrap", "minestrap",  0, 0, MBlocks.copper_ore, (Achievement)null).setSpecial();
	public static Achievement heart = new Achievement("achievement.heart", "heart", 1, -3, MItems.heart_container, (Achievement)minestrapp).setSpecial();
	public static Achievement stonecutter = new Achievement("achievement.stonecutter", "stonecutter",  -1, 2, MBlocks.stonecutter, (Achievement)minestrapp);
	public static Achievement sawmill = new Achievement("achievement.sawmill", "sawmill",  -3, 1, MBlocks.sawmill, (Achievement)minestrapp);
	public static Achievement alloy = new Achievement("achievement.alloy", "alloy",  -1, 4, MBlocks.alloy, (Achievement)stonecutter);
	public static Achievement melter = new Achievement("achievement.melter", "melter",  -1, 6, MBlocks.melter, (Achievement)alloy);
	public static Achievement titanium = new Achievement("achievement.titanium", "titanium",  -1, 8, MItems.titanium_ingot, (Achievement)melter);
	public static Achievement frost = new Achievement("achievement.frost", "frost",  2, -1, MBlocks.dirt_permafrost, (Achievement)minestrapp);
	public static Achievement glacieric_ice = new Achievement("achievement.glacieric_ice", "glacieric_ice", 4, -1, MItems.glacieric_ice_shard, (Achievement)frost);
	public static Achievement frost_gen = new Achievement("achievemnt.frost_gen", "frost_gen", 4, -3, MBlocks.frost_generator, (Achievement)glacieric_ice);
	public static Achievement bedrock = new Achievement("achievement.bedrock", "bedrock", -3, 6, Blocks.bedrock, (Achievement)melter).setSpecial();
	public static Achievement sifter = new Achievement("achievement.sifter", "sifter", 1, 4, MItems.sifter, (Achievement)alloy);
	public static Achievement god = new Achievement("achievement.god", "god",  -2, -1, MBlocks.godstone, (Achievement)minestrapp).setSpecial();
	public static Achievement jam = new Achievement("achievement.jam", "jam", 2, 1, MItems.jam_bottle, (Achievement)minestrapp);
	public static Achievement crusher = new Achievement("achievement.crusher", "crusher",  1, 6, MBlocks.crusher, (Achievement)melter).setSpecial();
	public static Achievement icecream = new Achievement("achievement.icecream", "icecream", 3, 6, MItems.ice_cream, (Achievement)crusher);
	
	public static void load()
	{
		AchievementPage.registerAchievementPage( new AchievementPage("Minestrappolation", new Achievement[] {heart, stonecutter, sawmill, alloy, melter, titanium, frost, glacieric_ice, frost_gen, bedrock, minestrapp, sifter, god, jam, crusher, icecream}));
		preInit();
	}
	
	public static void preInit()
	{
		heart.registerStat();
		stonecutter.registerStat();
		sawmill.registerStat();
		crusher.registerStat();
		alloy.registerStat();
		melter.registerStat();
		titanium.registerStat();
		frost.registerStat();
		glacieric_ice.registerStat();
		frost_gen.registerStat();
		bedrock.registerStat();
		minestrapp.registerStat();
		sifter.registerStat();
		god.registerStat();
		jam.registerStat();
		icecream.registerStat();
	}
	
	public static void addAchievement(EntityPlayer player, Achievement ach)
	{
		player.addStat(ach, 1);
	}

}
