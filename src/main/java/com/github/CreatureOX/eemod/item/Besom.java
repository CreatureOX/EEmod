package com.github.CreatureOX.eemod.item;

import com.github.CreatureOX.eemod.Main;
import com.github.CreatureOX.eemod.entity.EntityBesom;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Besom extends Item{
    public Besom(){
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTransport);
    }
	public Besom(String unlocalizedName) {
	    this.setUnlocalizedName(unlocalizedName);
	    this.setTextureName(Main.MODID + ":" + unlocalizedName);
        this.maxStackSize = 1;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote){
	        // getEyeHeight方法是获取物体的"眼高",即头部到脚底的距离
        	EntityBesom entity = new EntityBesom(par2World, par3EntityPlayer.posX,par3EntityPlayer.posY + par3EntityPlayer.getEyeHeight(), par3EntityPlayer.posZ, par3EntityPlayer);
	        // 水平方向的角度
        	float angle = (par3EntityPlayer.rotationYaw / 180F) * 3.141593F;
	        // 垂直方向的仰角
            float angle2 = (-par3EntityPlayer.rotationPitch / 180F) * 3.141593F;
	        // 飞行速度
            final float speed = 2f;
	        // 算出三个方向上的速度,为了方便阅读我先计算的Y轴分速度
            entity.motionY = speed * MathHelper.sin(angle2);
	        // 根据仰角算出速度在XZ平面上的投影,再正交分解投影
            entity.motionX = speed * MathHelper.cos(angle2) * -MathHelper.sin(angle);
            entity.motionZ = speed * MathHelper.cos(angle2) * MathHelper.cos(angle);
	        // 放置实体
            par2World.spawnEntityInWorld(entity);
        }		
		return par1ItemStack;
	
	}			
}
