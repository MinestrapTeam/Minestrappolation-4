package minestrapteam.mods.chunkster;

import java.io.Serializable;

public class Key implements Serializable
{
	private final int x;
	private final int y;

	public Key(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof Key))
		{
			return false;
		}

		Key key = (Key) o;

		return this.x == key.x && this.y == key.y;
	}

	@Override
	public int hashCode()
	{
		int result = this.x;
		result = 31 * result + this.y;
		return result;
	}
}
