package com.github.CreatureOX.eemod.creativetab;

import net.minecraft.creativetab.CreativeTabs;

public class ModCreativeTabs {
	
	    public static CreativeTabs tabEEmod;

	    public static final void init(){
	        tabEEmod = new CreativeTabsEEmod();
	    }
}
