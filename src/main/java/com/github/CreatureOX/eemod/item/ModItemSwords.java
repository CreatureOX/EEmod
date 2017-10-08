package com.github.CreatureOX.eemod.item;

import com.github.CreatureOX.eemod.Main;

import net.minecraft.item.ItemSword;

public class ModItemSwords extends ItemSword{

	public ModItemSwords(ToolMaterial material) {
		super(material);
		// TODO 
	}
	public ModItemSwords(String unlocalizedName, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Main.MODID + ":" + unlocalizedName);
}

}
