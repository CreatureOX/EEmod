package com.github.CreatureOX.eemod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicWand extends Item{
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote){
			//Minecraft mc = Minecraft.getMinecraft();
			//mc.displayGuiScreen(new EEmodCursesGui(mc.currentScreen));
            //par2World.spawnEntityInWorld(new EntityGoldenEgg(par2World, par3EntityPlayer));
        }		
		return par1ItemStack;
	
	}			
}
