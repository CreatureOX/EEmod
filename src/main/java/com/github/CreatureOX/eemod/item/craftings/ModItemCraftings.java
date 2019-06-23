package com.github.CreatureOX.eemod.item.craftings;

import com.github.CreatureOX.eemod.block.ModBlocks;

import com.github.CreatureOX.eemod.item.ModItemsRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItemCraftings {

	public static final void init(){
		registerModItemRecipce();
		registerModItemSmelting();
		registerModItemFuel();
	}
	
    private static void registerModItemRecipce(){
		GameRegistry.addRecipe(new ItemStack(ModItemsRegistry.PoisonedApple, 1, 0), new Object[] {"###", "#*#","###",'#', Items.ender_eye, '*', Items.apple});
		GameRegistry.addRecipe(new ItemStack(ModItemsRegistry.MagicWand, 2, 0), new Object[] {"#", "#", '#', Blocks.log});
    }

    private static void registerModItemSmelting(){
		GameRegistry.addSmelting(Items.coal, new ItemStack(ModBlocks.magicBlock), 0.5F);
		GameRegistry.addSmelting(ModBlocks.magicBlock, new ItemStack(ModItemsRegistry.PurpleIngot), 0.5F);
    }

    private static void registerModItemFuel(){
    	GameRegistry.registerFuelHandler(new IFuelHandler(){
            @Override
            public int getBurnTime(ItemStack fuel){
                return Items.diamond != fuel.getItem() ? 0 : 12800;
            }
        });
    }
}
