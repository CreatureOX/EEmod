package com.github.CreatureOX.eemod.client.gui;

import com.github.CreatureOX.eemod.Main;
import com.github.CreatureOX.eemod.constant.Constants;
import com.github.CreatureOX.eemod.item.items.MagicWand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class EEmodCursesGui extends GuiScreen{

	private static final String TEXTURE = "textures/gui/texture.jpg";
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
    	buttonList.add(btnCurse1 = new GuiButton(Constants.GUI.BUTTON_CURSE1, (int)(width*0.75), (int)(height*0.85)-20, 80, 20, "咒语1"));
    	buttonList.add(btnCurse2 = new GuiButton(Constants.GUI.BUTTON_CURSE2, (int)(width*0.75), (int)(height*0.85)-40, 80, 20, "咒语2"));
    	buttonList.add(btnCurse3 = new GuiButton(Constants.GUI.BUTTON_CURSE3, (int)(width*0.75), (int)(height*0.85)-60, 80, 20, "咒语3"));
    	buttonList.add(btnClose = new GuiButton(Constants.GUI.BUTTON_CLOSE, (int)(width*0.75), (int)(height*0.85), 80, 20, "关闭"));
    }

    public void drawScreen(int par1, int par2, float par3){
    	drawDefaultBackground();
	    // 绑定纹理
	    mc.renderEngine.bindTexture(texture);
	    func_146110_a(0, 0, 0, 0, width, height, 750, 600);
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
 
}
