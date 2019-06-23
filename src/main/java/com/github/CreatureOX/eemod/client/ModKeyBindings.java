package com.github.CreatureOX.eemod.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class ModKeyBindings {

	public static KeyBinding showTime;
	
	public static void init(){
		ModKeyBindings.showTime = new KeyBinding("key.eemod.showTime",Keyboard.KEY_H,"key.categories.eemod");
		ClientRegistry.registerKeyBinding(ModKeyBindings.showTime);
	}
}
