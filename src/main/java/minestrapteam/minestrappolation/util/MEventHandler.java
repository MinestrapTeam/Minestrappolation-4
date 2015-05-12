package minestrapteam.minestrappolation.util;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MEventHandler {
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayerJoin(EntityJoinWorldEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{
			if(event.world.isRemote == false)
			{
				VersionChecker.checkIfCurrent(MReference.VERSION, "https://raw.githubusercontent.com/MinestrapTeam/Minestrappolation-4/master/version.txt");
				event.entity.addChatMessage(VersionChecker.uptoDate);
				event.entity.addChatMessage(VersionChecker.motd);
			}
		}	
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event)
	{
		Random rand = new Random();
		if(event.state.getBlock() instanceof BlockNetherWart)
		{
			BlockNetherWart wart = (BlockNetherWart)event.state.getBlock();
			IBlockState ground = event.world.getBlockState(event.pos.add(0, -1, 0));
			
			ItemStack item = new ItemStack(MItems.soul_gem);
			EntityItem eitem = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), item);

			if(rand.nextInt(100) < 3 && (Integer)event.state.getValue(wart.AGE) == 3 && ground.getBlock() == MBlocks.soul_ore)
			{
				event.world.spawnEntityInWorld(eitem);
			}
			
		}	
	}
	

}
