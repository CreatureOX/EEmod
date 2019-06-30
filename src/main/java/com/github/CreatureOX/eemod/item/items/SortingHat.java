package com.github.CreatureOX.eemod.item.items;

import com.github.CreatureOX.eemod.Main;
import com.github.CreatureOX.eemod.constant.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.Arrays;

/**
 * @description: sorting hat
 * @Author: CreatureOX
 **/
public class SortingHat extends Item {

	private static final String SORTING_FORMATTED_STRING = "chat.eemod.sorting";
	private static final String SORTED_FORMATTED_STRING = "chat.eemod.sorted";

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world, EntityPlayer player) {
		Boolean hasEnrollmentNotice = false;
		String collegeName;
		EnrollmentNotice enrollmentNotice = (EnrollmentNotice) GameRegistry.findItem(Main.MODID, Constants.Items.ENROLLMENT_NOTICE);
		for(ItemStack itemStack: player.inventory.mainInventory){
			if(itemStack!=null && itemStack.getUnlocalizedName().endsWith(Constants.Items.ENROLLMENT_NOTICE)){
				hasEnrollmentNotice = true;
				enrollmentNotice = (EnrollmentNotice) itemStack.getItem();
				break;
			}
		}
		if(hasEnrollmentNotice){
			player.addChatMessage(new ChatComponentTranslation(SORTED_FORMATTED_STRING, Constants.College.getLocalName(enrollmentNotice.getCollegeCode())));
		}else{
			int choice = -1;
			if(!world.isRemote){
				choice = (int)world.getTotalWorldTime()%4;
				collegeName = Constants.College.getLocalName(choice);
				player.addChatMessage(new ChatComponentTranslation(SORTING_FORMATTED_STRING, collegeName));
			}
			enrollmentNotice.setPages(choice, Arrays.asList("Lesson 1", "Lesson 2"));
			ItemStack itemStack = new ItemStack(enrollmentNotice);
			player.inventory.addItemStackToInventory(itemStack);
		}
		return par1ItemStack;
	}
}
