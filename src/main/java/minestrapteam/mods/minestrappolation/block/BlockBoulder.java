package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.util.Chance;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockBoulder extends BlockFalling
{
	int damage;
	public BlockBoulder(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		ItemStack stack;
		if(this == MBlocks.stone_boulder)
		{
			stack = (ItemStack) Chance.getRandomFromTable("boulder_stone");
			damage = stack.getItemDamage();
			return stack.getItem();
		}
		else if(this == MBlocks.red_rock_boulder)
		{
			stack = (ItemStack) Chance.getRandomFromTable("boulder_red");
			damage = stack.getItemDamage();
			return stack.getItem();
		}
		else if(this == MBlocks.coldstone_boulder)
		{
			stack = (ItemStack) Chance.getRandomFromTable("boulder_cold");
			damage = stack.getItemDamage();
			return stack.getItem();
		}
		else if(this == MBlocks.icestone_boulder)
		{
			stack = (ItemStack) Chance.getRandomFromTable("boulder_ice");
			damage = stack.getItemDamage();
			return stack.getItem();
		}
		else if(this == MBlocks.oceanstone_boulder)
		{
			stack = (ItemStack) Chance.getRandomFromTable("boulder_ocean");
			damage = stack.getItemDamage();
			return stack.getItem();
		}
		else
			return Item.getItemFromBlock(Blocks.gravel);
	}
	
	@Override
	public int damageDropped(IBlockState state)
    {
        return damage;
    }
	
	@Override
	protected void onStartFalling(EntityFallingBlock fallingEntity)
	{
		fallingEntity.setHurtEntities(true);
	}
	
	@Override
	public void onEndFalling(World worldIn, BlockPos pos)
	{
		worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), "dig.stone", 2.0F, 0.1F);
	}
}
