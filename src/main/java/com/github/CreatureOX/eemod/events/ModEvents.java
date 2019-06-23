package com.github.CreatureOX.eemod.events;

import com.github.CreatureOX.eemod.achievement.ModAchievements;
import com.github.CreatureOX.eemod.client.ModKeyBindings;
import com.github.CreatureOX.eemod.client.gui.EEmodCursesGui;
import com.github.CreatureOX.eemod.client.gui.EEmodGui;
import com.github.CreatureOX.eemod.constant.Constants;
import com.github.CreatureOX.eemod.item.items.MagicWand;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import org.lwjgl.input.Keyboard;

public class ModEvents extends Gui{

	private static final String ITEM_PREFIX = "item.";
	private static final String TILE_PREFIX = "tile.";

	private static final String TIME_FORMATTED_STRING = "chat.eemod.time";

	@EventHandler
	public static final void init(){
		MinecraftForge.EVENT_BUS.register(new ModEvents());
		FMLCommonHandler.instance().bus().register(new ModEvents());
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void MagicWandEvent(PlayerInteractEvent event){
		if(event.entityLiving instanceof EntityPlayerMP){
			EntityPlayer entityPlayer = (EntityPlayer)event.entityLiving;
			if (event.action == Action.RIGHT_CLICK_BLOCK && entityPlayer.getCurrentEquippedItem() != null){
				Item magicWand = (MagicWand) entityPlayer.getCurrentEquippedItem().getItem();
				if(magicWand.getUnlocalizedName().equals(ITEM_PREFIX + Constants.Items.MAGIC_WAND)){
					switch (((MagicWand) magicWand).getCurse()){
						case ICE:
							event.world.setBlock(event.x, event.y, event.z, Blocks.ice);
							break;
						case FIRE:
							event.world.setBlock(event.x, event.y, event.z, Blocks.fire);
							break;
						case WIND:
							event.world.setBlock(event.x, event.y, event.z, Blocks.air);
							break;
						default:
							break;
					}
					entityPlayer.triggerAchievement(ModAchievements.firstUseMagic);
				}
			}
		}		
	}	
	
	@SubscribeEvent
	public void MagicWandCraftedEvent(PlayerEvent.ItemCraftedEvent event){
		if(event.player instanceof EntityPlayerMP){
        	EntityPlayer entityPlayer = event.player;
	        if (event.crafting.getItem()!=null){
	        	if(event.crafting.getItem().getUnlocalizedName().equals(ITEM_PREFIX + Constants.Items.MAGIC_WAND)){
	            entityPlayer.triggerAchievement(ModAchievements.beAWizard);
	            	}
	        	}
	       }
		}
	
	@SubscribeEvent
	public void MagicIngotSmeltedEvent( PlayerEvent.ItemSmeltedEvent event){
		if(event.player instanceof EntityPlayerMP){
        	EntityPlayer entityPlayer = event.player;
	        if (event.smelting.getItem()!=null){
	        	if(event.smelting.getItem().getUnlocalizedName().equals(TILE_PREFIX + Constants.Blocks.MAGIC_BLOCK.getName())){
	        		entityPlayer.triggerAchievement(ModAchievements.firstUseMagicSmelting);
	        	}
	        }
		}
	}
	
	
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
	    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if (ModKeyBindings.showTime.isPressed()) {
            World world = Minecraft.getMinecraft().theWorld;
            player.addChatMessage(new ChatComponentTranslation(TIME_FORMATTED_STRING, world.getTotalWorldTime()));
        }
        
		if (Keyboard.getEventKey() == Keyboard.KEY_K){
			Minecraft mc = Minecraft.getMinecraft();
			mc.displayGuiScreen(new EEmodGui(mc.currentScreen));
        }

		if (Keyboard.getEventKey() == Keyboard.KEY_LCONTROL){
			if(player.getCurrentEquippedItem().getItem().getUnlocalizedName().equals(ITEM_PREFIX + Constants.Items.MAGIC_WAND)){
				Minecraft mc = Minecraft.getMinecraft();
				mc.displayGuiScreen(new EEmodCursesGui(mc.currentScreen));
			}
		}
    } 
    
    @SubscribeEvent
    public void playerHealth(RenderGameOverlayEvent.Pre event) {
    	if(event.type == ElementType.HEALTH) {
    		int width = event.resolution.getScaledWidth();
    		int height = event.resolution.getScaledHeight();
    		Minecraft mc = Minecraft.getMinecraft();
    		//String hp = String.format("Magic: %d/%d",
    		//				MathHelper.ceiling_float_int(mc.thePlayer.getHealth()),
    		//				MathHelper.ceiling_double_int(mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue()));
    		//FontRenderer fontRenderer = mc.fontRenderer;
    		//fontRenderer.drawStringWithShadow(hp, width / 2 + 25, height - GuiIngameForge.left_height-10, 0xFFFFFF);
    		// 字体渲染器在渲染时会重新绑定到字型纹理上 HUD在下一步绘制时不会重新绑定纹理,因此需要我们在此手动绑定.
    		mc.renderEngine.bindTexture(Gui.icons);
    		drawTexturedModalRect(width / 2-182/2,height - GuiIngameForge.left_height-6,0,79,182,5);
    		// 参数分别为x,y,u,v,    x,y为绘制在屏幕上的左上角坐标  u，v为纹理的左上角坐标 w,h为纹理的宽、高
    	}
    }
}
	

