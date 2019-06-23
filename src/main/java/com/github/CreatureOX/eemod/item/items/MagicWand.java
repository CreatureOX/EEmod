package com.github.CreatureOX.eemod.item.items;

import com.github.CreatureOX.eemod.constant.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicWand extends Item{

	private Constants.Curse curse;

	public MagicWand(){
		// default curse
		this.curse = Constants.Curse.ICE;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
		return par1ItemStack;
	}


	public void setCurse(Constants.Curse curse){
		this.curse = curse;
	}

	public Constants.Curse getCurse(){
		return curse;
	}


}
