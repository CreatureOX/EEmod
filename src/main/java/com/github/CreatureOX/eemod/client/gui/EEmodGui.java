package com.github.CreatureOX.eemod.client.gui;

import org.lwjgl.input.Keyboard;

import com.github.CreatureOX.eemod.Main;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;

public class EEmodGui extends GuiScreen{

    private GuiScreen parentScreen;
    private GuiButton btnClose;
    private GuiTextField tfInput;
    private ResourceLocation texture = new ResourceLocation("eemod","textures/gui/texture.jpg"); //绗竴涓弬鏁版槸modid
    
    public EEmodGui(GuiScreen parent)
    {
            parentScreen = parent; //璁颁笅鏄摢涓晫闈㈡墦寮�浜嗗畠,浠ヤ究浠ュ悗杩斿洖閭ｄ釜鐣岄潰
            //鍦ㄨ繖閲屽垵濮嬪寲涓庣晫闈㈡棤鍏崇殑鏁版嵁,鎴栬�呮槸鍙渶鍒濆鍖栦竴娆＄殑鏁版嵁.
    }

    public void initGui()
    {
    	buttonList.add(btnClose = new GuiButton(0, (int)(width*0.75), (int)(height*0.85), 80, 20, "鍏抽棴"));
    	Keyboard.enableRepeatEvents(true); //鎵撳紑閿洏杩炵画杈撳叆
    	tfInput = new GuiTextField(fontRendererObj, (int)(width*0.5)-150, (int)(height*0.85), 300, 20);
    	tfInput.setMaxStringLength(64); //璁剧疆鏈�澶ч暱搴�,鍙渷鐣�
    	tfInput.setFocused(false); //璁剧疆鏄惁涓虹劍鐐�
    	tfInput.setCanLoseFocus(true); //璁剧疆涓哄彲浠ヨ鍙栨秷鐒︾偣
    	//杩欓噷閮ㄧ讲鎺т欢
    }

    public void drawScreen(int par1, int par2, float par3)
    {
            drawDefaultBackground();
            //鍦ㄨ繖閲岀粯鍒舵枃鏈垨绾圭悊绛夐潪鎺т欢鍐呭,杩欓噷缁樺埗鐨勪笢瑗夸細琚帶浠�(鍗虫寜閿�)鐩栦綇.
            mc.renderEngine.bindTexture(texture); //缁戝畾绾圭悊
            //drawTexturedModalRect((int)(width*0.5)-128, 0,0,0,256,256); //缁樺埗涓�涓�256x256鐨勭汗鐞�
            func_146110_a(0, 0, 0, 0, width, height, 750, 600); //涓棿鐨�0,300鏄疷V鍋忕Щ,鏍规嵁浣犵殑绾圭悊闅忔剰瀹氬惂.1440,900鍚岀悊.
            drawRect((int)(width*0.1), (int)(height*0.1), (int)(width*0.9), (int)(height*0.7), 0x80FFFFFF);//鍗婇�忔槑鐨勭煩褰�
            super.drawScreen(par1,par2,par3);
            //鍦ㄨ繖閲岀粯鍒舵枃鏈垨绾圭悊绛夐潪鎺т欢鍐呭,杩欓噷缁樺埗鐨勪笢瑗夸細鐩栧湪鎺т欢(鍗虫寜閿�)涔嬩笂.
            drawCenteredString(fontRendererObj, "Your 搂f搂nHogwarts搂r screen", width/2, (int)(height*0.2), 0xFFFF00);
            drawString(fontRendererObj, String.format("You are pointing to: (搂o%d搂r,搂o%d搂r)", par1, par2),
            			(int)(width*0.05), (int)(height*0.9), 0xFFFFFF);
            //tfInput.drawTextBox();
    }
    
    @Override
    protected void actionPerformed(GuiButton par1GuiButton){
             if(par1GuiButton.id == 0){  //鐢ㄦ埛鎸変笅浜唅d涓�1鐨勬寜閽�          
                    mc.displayGuiScreen(parentScreen);
             }
    }
    
    @Override
    protected void keyTyped(char par1, int par2) {
    	if(tfInput.textboxKeyTyped(par1, par2)) //鍚戞枃鏈浼犲叆杈撳叆鐨勫唴瀹�
    		return;
    	super.keyTyped(par1, par2);
    }

    @Override
    protected void mouseClicked(int par1, int par2, int par3) {
    	tfInput.mouseClicked(par1, par2, par3); //璋冪敤鏂囨湰妗嗙殑榧犳爣鐐瑰嚮妫�鏌�
    	super.mouseClicked(par1, par2, par3);
    }

    @Override
    public void onGuiClosed() {
    	Keyboard.enableRepeatEvents(false); //鍏抽棴閿洏杩炵画杈撳叆
    }
}
