package com.github.CreatureOX.eemod.creativetab;

import com.github.CreatureOX.eemod.creativetab.creativetabs.CreativeTabsEEmod;
import net.minecraft.creativetab.CreativeTabs;

public class ModCreativeTabs {
	
	    public static CreativeTabs tabEEmod;

	    public static final void init(){
	        tabEEmod = new CreativeTabsEEmod();
	    }
}
