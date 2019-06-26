package com.github.CreatureOX.eemod;

import com.github.CreatureOX.eemod.Proxy.CommonProxy;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {

    public static final String MODID = "EEmod";
    public static final String VERSION = "0.1";
    public static final String LANGUAGE_TYPE = FMLClientHandler.instance().getClient().gameSettings.language;

    private static final String CLIENT_SIDE = "com.github.CreatureOX.eemod.Proxy.ClientProxy";
    private static final String SERVER_SIDE = "com.github.CreatureOX.eemod.Proxy.ServerProxy";

    @Instance
    public static Main instance = new Main();

    @SidedProxy(clientSide = CLIENT_SIDE, serverSide = SERVER_SIDE)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		// some example code
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		// some example code
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
		// some example code
    	proxy.postInit(event);
    }
    
}
