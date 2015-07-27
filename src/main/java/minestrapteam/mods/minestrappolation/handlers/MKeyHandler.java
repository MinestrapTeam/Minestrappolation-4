package minestrapteam.mods.minestrappolation.handlers;

/** OLD key handler stuff. It used to open a custom inventory. Saved incase we need keybindings.
public class MKeyHandler
{	 
	//Key index for easy handling

	public static final int CUSTOM_INV = 0;

	// Key descriptions; use a language file to localize the description later

	private static final String[] desc = { "key.tut_inventory.desc" };

	//Default key values – these can be changed using the in-game menu

	private static final int[] keyValues = { Keyboard.KEY_P };

	private final KeyBinding[] keys;

	public MKeyHandler()
	{
		keys = new KeyBinding[desc.length];

		for (int i = 0; i < desc.length; ++i)
		{
			keys[i] = new KeyBinding(desc[i], keyValues[i], "key.tutorial.category");

			ClientRegistry.registerKeyBinding(keys[i]);
		}

	}


	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event)
	{
		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class))
		{
			int kb = Keyboard.getEventKey();

			boolean isDown = Keyboard.getEventKeyState();

			if (kb == keys[CUSTOM_INV].getKeyCode())
			{
				EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;

				if (player.openContainer instanceof ContainerInventoryMinestrap)
				{
					// TODO close screen? Not sure how to do this yet.

				} else
				{
					Minestrappolation.network.sendToServer(new OpenGuiPacket(MGuiHandler.GUI_CUSTOM_INV));
				}

			}

		}

	}

}
*/