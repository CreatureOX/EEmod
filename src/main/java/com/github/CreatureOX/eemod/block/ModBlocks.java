package com.github.CreatureOX.eemod.block;

import com.github.CreatureOX.eemod.constant.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class ModBlocks {
	
	public static Block experimentBlock;
	public static Block magicBlock;
	
	public static final void init(){
		GameRegistry.registerBlock(experimentBlock=new BasicBlock(Constants.Blocks.EXPERIMENT_BLOCK.getUnlocalizedName(),Material.iron), Constants.Blocks.EXPERIMENT_BLOCK.getName());
		GameRegistry.registerBlock(magicBlock=new MagicBlock(Constants.Blocks.MAGIC_BLOCK.getUnlocalizedName(),Material.iron),Constants.Blocks.MAGIC_BLOCK.getName());
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.experimentBlock, 1, 0),
				new Object[] {"###", '#', new ItemStack(ModBlocks.magicBlock, 2, 0)});
	}

}
