package com.github.CreatureOX.eemod.client.gui;

import com.github.CreatureOX.eemod.Main;
import com.github.CreatureOX.eemod.client.GUIHelper;
import com.github.CreatureOX.eemod.constant.Constants;
import com.github.CreatureOX.eemod.item.items.MagicWand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class EEmodCursesGui extends GuiScreen{

	private static final String TEXTURE = "textures/gui/71ecef976fca23b2b2b03671c31f2727.png";
	private static final String ITEM_PREFIX = "item.";

	private ResourceLocation texture = new ResourceLocation(Main.MODID.toLowerCase(),TEXTURE);

    private GuiScreen parentScreen;
	private GuiButton btnCurse1;
	private GuiButton btnCurse2;
	private GuiButton btnCurse3;
    private GuiButton btnClose;

    public EEmodCursesGui(GuiScreen parent){
            parentScreen = parent;
    }

    public void initGui(){
	    // 这里部署控件
    	buttonList.add(btnCurse1 = new GuiButton(Constants.GUI.BUTTON_CURSE1, width/2 - 40, 0, 80, 20, "咒语1"));
    	buttonList.add(btnCurse2 = new GuiButton(Constants.GUI.BUTTON_CURSE2, 0, height/2 - 10, 80, 20, "咒语2"));
    	buttonList.add(btnCurse3 = new GuiButton(Constants.GUI.BUTTON_CURSE3, width - 80, height/2 - 10, 80, 20, "咒语3"));
    	buttonList.add(btnClose = new GuiButton(Constants.GUI.BUTTON_CLOSE, width/2 - 40, height - 20, 80, 20, "关闭"));
    }

    public void drawScreen(int par1, int par2, float par3){
    	drawDefaultBackground();
	    // 绑定纹理-
	    mc.renderEngine.bindTexture(texture);
	    // func_146110_a(0, 0, 0, 0, width, height, 750, 600);
	    GUIHelper.drawScaledCustomSizeModalRect(width/4, 0, 0, 0, 2000, 2000, width/2, width/2, 2000, 2000);
	    super.drawScreen(par1,par2,par3);
    }

    @Override
    protected void actionPerformed(GuiButton button){
	    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
	    Item equippedItem = player.getCurrentEquippedItem().getItem();
	    if(equippedItem != null && equippedItem.getUnlocalizedName().equals(ITEM_PREFIX + Constants.Items.MAGIC_WAND)){
		    MagicWand magicWand = (MagicWand) equippedItem;
		    switch (button.id){
			    case Constants.GUI.BUTTON_CURSE1:
			    	magicWand.setCurse(Constants.Curse.ICE);
				    break;
			    case Constants.GUI.BUTTON_CURSE2:
			    	magicWand.setCurse(Constants.Curse.FIRE);
				    break;
			    case Constants.GUI.BUTTON_CURSE3:
			    	magicWand.setCurse(Constants.Curse.WIND);
				    break;
			    case Constants.GUI.BUTTON_CLOSE:
				    mc.displayGuiScreen(parentScreen);
				    break;
			    default:
				    super.actionPerformed(button);
				    return;
		    }
	    }

    }

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		System.out.println(String.format("You are pointing to: (%d, %d)", par1, par2));
		Double k1 = 1.0 * height/width;
		Double k2 = -1.0 * k1;
		Double line1 = (height/2.0 - par2) - k1*(-width/2.0 + par1);
		Double line2 = (height/2.0 - par2) - k2*(-width/2.0 + par1);
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		Item equippedItem = player.getCurrentEquippedItem().getItem();
		if(equippedItem != null && equippedItem.getUnlocalizedName().equals(ITEM_PREFIX + Constants.Items.MAGIC_WAND)){
			MagicWand magicWand = (MagicWand) equippedItem;
			if(line1>0 && line2>0){
				magicWand.setCurse(Constants.Curse.ICE);
			}
			if(line1<0 && line2>0){
				magicWand.setCurse(Constants.Curse.FIRE);
			}
			if(line1>0 && line2<0){
				magicWand.setCurse(Constants.Curse.WIND);
			}
			if(line1<0 && line2<0){
				mc.displayGuiScreen(parentScreen);
			}
		}
		super.mouseClicked(par1, par2, par3);
	}
 
}
