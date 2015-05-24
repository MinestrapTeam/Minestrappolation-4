package minestrapteam.minestrappolation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.util.ChatComponentText;

public class VersionChecker implements Runnable
{
	
	private String					versionToCheck;
	private String					urlToCheck;
	
	public static boolean			hasChecked	= false;
	
	public static ChatComponentText	uptoDate;
	public static ChatComponentText	motd;
	
	public VersionChecker(String versionToCheck, String url)
	{
		this.versionToCheck = versionToCheck;
		this.urlToCheck = url;
	}
	
	private static boolean checkIfCurrent(String versiontocheck, String urlToCheck)
	{
		boolean upToDate = false;
		try
		{
			URL url = new URL(urlToCheck);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			String version = "";
			
			while ((str = in.readLine()) != null)
			{
				if (str.contains("version="))
				{
					version = str.substring(8);
					if (version.equals(versiontocheck))
					{
						upToDate = true;
						uptoDate = new ChatComponentText("�aMinestrappolation is the current version");
					}
					else
					{
						upToDate = false;
						uptoDate = new ChatComponentText("�cA newer version of Minestrappolation is available: " + version);
					}
				}
				if (str.contains("motd="))
				{
					motd = new ChatComponentText(str.substring(6));
				}
			}
			in.close();
		}
		catch (IOException e)
		{
			System.err.println("Version file not found at: " + urlToCheck);
			uptoDate = new ChatComponentText("�4Minestrappolation cannont find the latest version.");
			motd = new ChatComponentText("�4Are you connected to the internet?");
		}
		return upToDate;
	}
	
	@Override
	public void run()
	{
		VersionChecker.checkIfCurrent(this.versionToCheck, this.urlToCheck);
	}
}
