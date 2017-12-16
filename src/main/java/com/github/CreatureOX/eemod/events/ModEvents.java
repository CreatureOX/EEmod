package com.github.CreatureOX.eemod.events;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.github.CreatureOX.eemod.Main;
import com.github.CreatureOX.eemod.achievement.ModAchievements;
import com.github.CreatureOX.eemod.client.ModKeyBindings;
import com.github.CreatureOX.eemod.client.gui.EEmodCursesGui;
import com.github.CreatureOX.eemod.client.gui.EEmodGui;
import com.github.CreatureOX.eemod.item.MagicWand;
import com.github.CreatureOX.eemod.item.ModItems;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import org.lwjgl.opengl.GL11;

public class ModEvents extends Gui{

	@EventHandler
	public static final void init(){
		MinecraftForge.EVENT_BUS.register(new ModEvents());
		FMLCommonHandler.instance().bus().register(new ModEvents());
	}
	
//	@SubscribeEvent
//	public void test(LivingFallEvent event){
//		if(event.entityLiving instanceof EntityPlayerMP){
//            EntityPlayer entityPlayer = (EntityPlayer)event.entityLiving;
//            entityPlayer.addChatMessage(new ChatComponentText("Falling Star! You fell "+event.distance+ " meters.That's cool, man!"));
//		}
//	}
	
	@SubscribeEvent
	public void MagicWandEvent(PlayerInteractEvent event){
		if(event.entityLiving instanceof EntityPlayerMP){
			EntityPlayer entityPlayer = (EntityPlayer)event.entityLiving;
			if (event.action == Action.RIGHT_CLICK_BLOCK && Keyboard.getEventKey() != Keyboard.KEY_LCONTROL && entityPlayer.getCurrentEquippedItem() !=null){
					if(entityPlayer.getCurrentEquippedItem().getItem().getUnlocalizedName().equals("item.magicwandItem")){
							event.world.setBlock(event.x, event.y, event.z, Blocks.ice);
							entityPlayer.triggerAchievement(ModAchievements.firstUseMagic);
				}
			}
			if (event.action == Action.RIGHT_CLICK_AIR && Keyboard.getEventKey() == Keyboard.KEY_LCONTROL && entityPlayer.getCurrentEquippedItem() !=null){
				if(entityPlayer.getCurrentEquippedItem().getItem().getUnlocalizedName().equals("item.magicwandItem")){
					Minecraft mc = Minecraft.getMinecraft();
					mc.displayGuiScreen(new EEmodCursesGui(mc.currentScreen));
			}
		}
			
		}		
	}	
	
	@SubscribeEvent
	public void MagicWandCraftedEvent(PlayerEvent.ItemCraftedEvent event){
		if(event.player instanceof EntityPlayerMP){
        	EntityPlayer entityPlayer = ((EntityPlayer)event.player);
	        if (event.crafting.getItem()!=null){
	        	if(event.crafting.getItem().getUnlocalizedName().equals("item.magicwandItem")){
	            entityPlayer.triggerAchievement(ModAchievements.beAWizard);
	            	}
	        	}
	       }
		}
	
	@SubscribeEvent
	public void MagicIngotSmeltedEvent( PlayerEvent.ItemSmeltedEvent event){
		if(event.player instanceof EntityPlayerMP){
        	EntityPlayer entityPlayer = ((EntityPlayer)event.player);
	        if (event.smelting.getItem()!=null){
	        	if(event.smelting.getItem().getUnlocalizedName().equals("tile.magicblock")){
	            entityPlayer.triggerAchievement(ModAchievements.firstUseMagicSmelting);
	            	}
	        	}
	       }
		}	
	
	
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        if (ModKeyBindings.showTime.isPressed())
        {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            World world = Minecraft.getMinecraft().theWorld;
            player.addChatMessage(new ChatComponentTranslation("chat.eemod.time", world.getTotalWorldTime()));
        }
        
		if (Keyboard.getEventKey() == Keyboard.KEY_K) //��ȡ���µİ������ж�
        {
		Minecraft mc = Minecraft.getMinecraft();
		mc.displayGuiScreen(new EEmodGui(mc.currentScreen));
        }
    } 
    
    @SubscribeEvent
    public void playerHealth(RenderGameOverlayEvent.Pre event) {
    	if(event.type == ElementType.HEALTH)
    	{
    		int width = event.resolution.getScaledWidth();
    		int height = event.resolution.getScaledHeight();
    		Minecraft mc = Minecraft.getMinecraft();
    		//String hp = String.format("Magic: %d/%d",
    		//				MathHelper.ceiling_float_int(mc.thePlayer.getHealth()),
    		//				MathHelper.ceiling_double_int(mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue()));
    		//FontRenderer fontRenderer = mc.fontRenderer;
    		//fontRenderer.drawStringWithShadow(hp, width / 2 + 25, height - GuiIngameForge.left_height-10, 0xFFFFFF);
    		//字体渲染器在渲染时会重新绑定到字型纹理上 HUD在下一步绘制时不会重新绑定纹理,因此需要我们在此手动绑定.
    		mc.renderEngine.bindTexture(Gui.icons);
    		drawTexturedModalRect(width / 2-182/2,height - GuiIngameForge.left_height-6,0,79,182,5);
    		//参数分别为x,y,u,v,    x,y为绘制在屏幕上的左上角坐标  u，v为纹理的左上角坐标 w,h为纹理的宽、高
    	}
    }
}
	

