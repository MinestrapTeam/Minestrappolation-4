package minestrapteam.mods.minestrappolation.tileentity;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityHourglass extends TileEntity
{
	private int hourglassLevel;
	
	public TileEntityHourglass() {}
	
	public TileEntityHourglass(int hourglassLevel)
	{
		this.hourglassLevel = hourglassLevel;
	}
	
	public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("Level", this.hourglassLevel);
    }
	
	public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.hourglassLevel = compound.getInteger("Level");
    }
	
	public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.pos, 5, nbttagcompound);
    }

    public void setHourglassData(int level)
    {
        this.hourglassLevel = level;
    }

    public int getHourglassData()
    {
        return this.hourglassLevel;
    }
}
