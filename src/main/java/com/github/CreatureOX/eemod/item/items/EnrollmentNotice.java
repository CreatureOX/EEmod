package com.github.CreatureOX.eemod.item.items;

import com.github.CreatureOX.eemod.constant.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: enrollment notice
 * @Author: CreatureOX
 **/
public class EnrollmentNotice extends ItemEditableBook {

	private Integer collegeCode;
	private List<String> pages;
	private ItemStack book;

	public EnrollmentNotice(){
		this.collegeCode = null;
		this.pages = new ArrayList<String>();
		this.book = new ItemStack(Items.written_book);
	}

	public Integer getCollegeCode() {
		return collegeCode;
	}

	public void setPages(Integer collegeCode, List<String> pages){
		this.collegeCode = collegeCode;
		this.pages = new ArrayList<String>();
		this.pages.add(Constants.College.getLocalName(collegeCode) + "录取通知书");
		this.pages.addAll(pages);
		NBTTagList pagesTag = new NBTTagList();
		for(String page: this.pages){
			pagesTag.appendTag(new NBTTagString(page));
		}
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		nbtTagCompound.setInteger("collegeCode", collegeCode);
		nbtTagCompound.setTag("pages", pagesTag);
		this.book.setTagCompound(nbtTagCompound);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		player.displayGUIBook(this.book);
		return itemStack;
	}
}
