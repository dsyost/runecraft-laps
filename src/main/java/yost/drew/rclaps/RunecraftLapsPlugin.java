package yost.drew.rclaps;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Runecraft Laps"
)
public class RunecraftLapsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private RunecraftLapsConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Runecraft Laps started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Runecraft Laps stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Runecraft Laps says " + config.greeting(), null);
		}
	}

	@Provides
	RunecraftLapsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(RunecraftLapsConfig.class);
	}
}
