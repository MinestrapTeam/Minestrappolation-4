package minestrapteam.mods.chunkster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProtectionData implements Serializable
{
	public String owner;
	public List editors = new ArrayList<String>();
	public boolean redstoneUseable = false;
	
	public ProtectionData(String owner)
	{
		this.owner = owner;
		this.editors.add(owner);
	}
	
	public boolean canEdit(String playerName)
	{
		if(this.editors.contains(playerName))
		{
			return true;
		}
		return false;
	}
	
	public boolean addTrustedPlayer(String playerName)
	{
		if(!this.editors.contains(playerName))
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
