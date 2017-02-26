package minestrapteam.mods.minestrappolation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.util.text.TextComponentString;

public class VersionChecker implements Runnable
{
	
	private String					versionToCheck;
	private String					urlToCheck;
	private  String					name;
	
	public static boolean			hasChecked	= false;
	
	public static TextComponentString	uptoDate;
	public static TextComponentString	motd;
	
	public VersionChecker(String versionToCheck, String url, String name)
	{
		this.versionToCheck = versionToCheck;
		this.urlToCheck = url;
		this.name = name;
	}
	
	private  boolean checkIfCurrent(String versiontocheck, String urlToCheck)
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
						uptoDate = new TextComponentString("�2"+ name + " is the current version");
					}
					else
					{
						upToDate = false;
						uptoDate = new TextComponentString("�cA newer version of " + name +" is available: " + version);
					}
				}
				if (str.contains("motd="))
				{
					motd = new TextComponentString(str.substring(6));
				}
			}
			in.close();
		}
		catch (IOException e)
		{
			System.err.println("Version file not found at: " + urlToCheck);
			uptoDate = new TextComponentString("�c"+ name +" cannont find the latest version.");
			motd = new TextComponentString("�cAre you connected to the internet?");
		}
		return upToDate;
	}
	
	@Override
	public void run()
	{
		checkIfCurrent(this.versionToCheck, this.urlToCheck);
	}
}
