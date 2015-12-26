package minestrapteam.mods.minestrappolation.tileentity;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityEnderPorter extends TileEntity
{
	public int x, y, z;
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("x", x);
        compound.setInteger("y", y);
        compound.setInteger("z", z);
    }

	@Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
    }

	@Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.pos, 5, nbttagcompound);
    }
	
	public void setLinkPos(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
