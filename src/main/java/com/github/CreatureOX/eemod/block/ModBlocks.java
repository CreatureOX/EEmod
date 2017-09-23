package com.github.CreatureOX.eemod.block;

import com.github.CreatureOX.eemod.Main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static Block experimentBlock;
	
	public static final void init(){
		GameRegistry.registerBlock(experimentBlock=new BasicBlock("blackboard",Material.iron), "blackboard");
	}

}
