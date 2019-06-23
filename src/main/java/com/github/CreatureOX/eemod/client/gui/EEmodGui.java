package com.github.CreatureOX.eemod.client.gui;

import com.github.CreatureOX.eemod.Main;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

public class EEmodGui extends GuiScreen{

	private static final String TEXTURE = "textures/gui/texture.jpg";

	private GuiScreen parentScreen;
	private GuiButton btnClose;
	private GuiTextField tfInput;
	private ResourceLocation texture = new ResourceLocation(Main.MODID.toLowerCase(),TEXTURE);

	public EEmodGui(GuiScreen parent) {
		// 记录父页面
		parentScreen = parent;
		// 在这里初始化与界面无关的数据,或是只需初始化一次的数据.
	}

	public void initGui() {
		buttonList.add(btnClose = new GuiButton(0, (int)(width*0.75), (int)(height*0.85), 80, 20, "关闭"));
		// 打开键盘连续输入
		Keyboard.enableRepeatEvents(true);
		tfInput = new GuiTextField(fontRendererObj, (int)(width*0.5)-150, (int)(height*0.85), 300, 20);
		tfInput.setMaxStringLength(64);
		// 设置是否为焦点
		tfInput.setFocused(false);
		tfInput.setCanLoseFocus(true);
		// 这里部署控件
	}

	public void drawScreen(int par1, int par2, float par3) {
		drawDefaultBackground();
		// 绑定纹理
		mc.renderEngine.bindTexture(texture);
		//drawTexturedModalRect((int)(width*0.5)-128, 0,0,0,256,256); //绘制256x256的纹理
		func_146110_a(0, 0, 0, 0, width, height, 750, 600);
		// 半透明的矩形
		drawRect((int)(width*0.1), (int)(height*0.1), (int)(width*0.9), (int)(height*0.7), 0x80FFFFFF);
		super.drawScreen(par1,par2,par3);
		//在这里绘制文本或纹理等非控件内容,这里绘制的东西会盖在控件之上.
		drawCenteredString(fontRendererObj, "Your §f§nHogwarts§r screen", width/2, (int)(height*0.2), 0xFFFF00);
		drawString(fontRendererObj, String.format("You are pointing to: (§o%d§r,§o%d§r)", par1, par2),
				(int)(width*0.05), (int)(height*0.9), 0xFFFFFF);
		//tfInput.drawTextBox();
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton){
		//用户按下了id=1的按键
		if(par1GuiButton.id == 0){
			mc.displayGuiScreen(parentScreen);
		}
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		// 向文本框传入输入的内容
		if(tfInput.textboxKeyTyped(par1, par2))
			return;
		super.keyTyped(par1, par2);
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		// 调用文本框的鼠标点击
		tfInput.mouseClicked(par1, par2, par3);
		super.mouseClicked(par1, par2, par3);
	}

	@Override
	public void onGuiClosed() {
		// 关闭键盘连续输入
		Keyboard.enableRepeatEvents(false);
	}
}
