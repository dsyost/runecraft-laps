package yost.drew.rclaps;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class RunecraftLapsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(RunecraftLapsPlugin.class);
		RuneLite.main(args);
	}
}