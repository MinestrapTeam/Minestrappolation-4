package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import scala.Int;
import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSheep extends BlockFlesh
{
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 5);
	public int dropMeta;
    
	public BlockSheep(Material materialIn, MapColor mapColorIn, int dropMeta)
	{
		super(materialIn, mapColorIn);
		this.dropMeta = dropMeta;
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		this.setTickRandomly(true);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        int j = ((Integer)state.getValue(AGE)).intValue();
        if(j < 5)
        {
        	int chance = rand.nextInt(Config.bushGrowChance);
        	if(chance == 1)
            {
        		worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 2);
            }
        }  
    }

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		if((Integer)state.getValue(AGE) == 5 && playerIn.getCurrentEquippedItem().getItem() == Items.shears)
		{
			if(playerIn.getCurrentEquippedItem().getItemDamage() < playerIn.getCurrentEquippedItem().getMaxDamage())
			{
				playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
			}
			else
			{
				playerIn.destroyCurrentEquippedItem();
			}
			worldIn.setBlockState(pos, this.getDefaultState(), 2);
			int quantity = worldIn.rand.nextInt(4);
			EntityItem ei = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(Blocks.wool, quantity, dropMeta));
			worldIn.spawnEntityInWorld(ei);
			if(playerIn instanceof FakePlayer)
				ei.onCollideWithPlayer(playerIn);
			return true;
		}
		else if(playerIn.getCurrentEquippedItem().getItem() == Items.dye)
		{
			if(playerIn.getCurrentEquippedItem().getItemDamage() == 0)
				worldIn.setBlockState(pos, MBlocks.block_sheep_black.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 1)
				worldIn.setBlockState(pos, MBlocks.block_sheep_red.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 2)
				worldIn.setBlockState(pos, MBlocks.block_sheep_green.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 3)
				worldIn.setBlockState(pos, MBlocks.block_sheep_brown.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 4)
				worldIn.setBlockState(pos, MBlocks.block_sheep_blue.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 5)
				worldIn.setBlockState(pos, MBlocks.block_sheep_purple.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 6)
				worldIn.setBlockState(pos, MBlocks.block_sheep_cyan.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 7)
				worldIn.setBlockState(pos, MBlocks.block_sheep_silver.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 8)
				worldIn.setBlockState(pos, MBlocks.block_sheep_grey.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 9)
				worldIn.setBlockState(pos, MBlocks.block_sheep_pink.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 10)
				worldIn.setBlockState(pos, MBlocks.block_sheep_lime.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 11)
				worldIn.setBlockState(pos, MBlocks.block_sheep_yellow.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 12)
				worldIn.setBlockState(pos, MBlocks.block_sheep_light_blue.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 13)
				worldIn.setBlockState(pos, MBlocks.block_sheep_magenta.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 14)
				worldIn.setBlockState(pos, MBlocks.block_sheep_orange.getStateFromMeta(this.getMetaFromState(state)), 2);
			else if(playerIn.getCurrentEquippedItem().getItemDamage() == 15)
				worldIn.setBlockState(pos, MBlocks.block_sheep_white.getStateFromMeta(this.getMetaFromState(state)), 2);
			
			if(playerIn.getCurrentEquippedItem().stackSize > 1)
			{
				--playerIn.getCurrentEquippedItem().stackSize;
			}
			else
			{
				playerIn.destroyCurrentEquippedItem();
			}
			
			return true;
		}
		return false;
	}
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {AGE});
    }
}
