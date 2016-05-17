package minestrapteam.mods.chunkster;

import net.minecraft.entity.player.EntityPlayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProtectionData implements Serializable
{
	public String owner;
	public List<String> editors = new ArrayList<>();
	public boolean redstoneUseable;

	public ProtectionData(String owner)
	{
		this.owner = owner;
		this.editors.add(owner);
	}

	public boolean canEdit(EntityPlayer player)
	{
		return player.worldObj.getMinecraftServer().getPlayerList().getOppedPlayers().getEntry(player.getGameProfile())
			       != null // player is OP
			       || this.canEdit(player.getGameProfile().getId().toString());
	}

	public boolean canEdit(String playerName)
	{
		return this.editors.contains(playerName);
	}

	public boolean addTrustedPlayer(String playerName)
	{
		if (!this.editors.contains(playerName))
		{
			this.editors.add(playerName);
			return true;
		}
		return false;
	}

	public void setUseRedstoneObjects(boolean b)
	{
		this.redstoneUseable = b;
	}
}
