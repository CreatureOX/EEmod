package com.github.CreatureOX.eemod.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class ModKeyBindings {

	private static final String SHOWTIME_DESCRIPTION = "key.eemod.showTime";
	private static final String SHOWTIME_CATEGORY = "key.categories.eemod";

	public static KeyBinding showTime;
	
	public static void init(){
		ModKeyBindings.showTime = new KeyBinding(SHOWTIME_DESCRIPTION, Keyboard.KEY_H, SHOWTIME_CATEGORY);
		ClientRegistry.registerKeyBinding(ModKeyBindings.showTime);
	}
}
