package com.github.CreatureOX.eemod.creativetab.creativetabs;

import com.github.CreatureOX.eemod.Main;
import com.github.CreatureOX.eemod.item.ModItemsRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsEEmod extends CreativeTabs {

    private static final String LABEL = Main.MODID.toLowerCase();
    private static final String SUFFIX = ".png";

    public CreativeTabsEEmod() {
        super(LABEL);
        this.setBackgroundImageName(LABEL + SUFFIX);
    }

    @Override
    public Item getTabIconItem()
    {
        return ModItemsRegistry.hammerItem;
    }
    
    @Override
    public boolean hasSearchBar(){
    	return true;
    }
}