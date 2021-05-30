package com.rakion99.usernamemod;

import java.io.IOException;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class UserNameGui extends Screen
{
    private final Screen parentScreen;
    private final Minecraft mc;
    private TextFieldWidget userNameField;
    String version = "v1.7";

    public class ChangeUserName implements Button.IPressable{
        @Override
        public void onPress(Button p_onPress_1_) {
            changeUserName();
        }
    }

    public class Cancel implements Button.IPressable{
        @Override
        public void onPress(Button p_onPress_1_) {
            cancel();
        }
    }

    public void changeUserName(){
        this.mc.getSession().username = this.userNameField.getText();
    	System.out.println("New UserName: "+this.userNameField.getText());
        this.mc.displayGuiScreen(this.parentScreen);
    }

    public void cancel(){
        this.mc.displayGuiScreen(this.parentScreen);
    }

    public UserNameGui(Screen parentScreen)
    {
        super(new TranslationTextComponent("rakion99.usernamemod.usernamegui"));
        this.parentScreen = parentScreen;
        this.mc=Minecraft.getInstance();
    }

    @Override
    public void init()
    {
        this.addButton(new Button(this.width / 2 - 100, 140, 200, 20, DialogTexts.GUI_DONE,new ChangeUserName()));
        this.addButton(new Button(this.width / 2 - 100, 160, 200, 20, DialogTexts.GUI_CANCEL, new Cancel()));
        this.userNameField = new TextFieldWidget(this.font, this.width / 2 - 95, 106, 190, 20, new StringTextComponent("rakion99.usernamemod.username"));
        this.userNameField.setFocused2(true);
        this.userNameField.setMaxStringLength(16);
        this.userNameField.setTextColor(0xFFFF00);
    }

    // protected void actionPerformed(Button button) throws IOException
    // {
    //         if (button.id == 1)
    //         {
    //             this.mc.displayGuiScreen(this.parentScreen);
    //         }
    //         if (button.id == 0)
    //         {
    //         	this.mc.getSession().username = this.userNameField.getText();
    //         	this.parentScreen.confirmClicked(true, 0);
    //         	System.out.println("New UserName: "+this.userNameField.getText());
    //         }
    // }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers){
        return userNameField.keyReleased(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char codePoint, int modifiers){
        return userNameField.charTyped(codePoint, modifiers);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers)
    {
        return userNameField.keyPressed(keyCode, scanCode, modifiers);
        // this.userNameField.keyPressed(keyCode, scanCode, modifiers);

        // if (scanCode == 15)
        // {
        //     this.userNameField.setFocused2(!this.userNameField.isFocused());
        // }

        // if (scanCode == 28 || scanCode == 156)
        // {
        //     this.changeUserName();
        // }
        
        // if (scanCode == 1)
        // {
        // 	this.mc.displayGuiScreen(this.parentScreen);
        // }
        // return true;
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.userNameField.mouseClicked(mouseX, mouseY, mouseButton);
    }
    
    // protected static final ResourceLocation bg_texture = new ResourceLocation("textures/blocks/red_nether_brick.png");

	
	// public void drawBackg(int tint)
    // {
    //     Tessellator tessellator = Tessellator.getInstance();
    //     BufferBuilder vertexbuffer = tessellator.getBuffer();
    //     this.mc.getTextureManager().bindTexture(bg_texture);
    //     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    //     float f = 32.0F;
    //     vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
    //     vertexbuffer.pos(0.0D, (double)this.height, 0.0D).tex(0.0D, (double)((float)this.height / 32.0F + (float)tint)).color(64, 64, 64, 255).endVertex();
    //     vertexbuffer.pos((double)this.width, (double)this.height, 0.0D).tex((double)((float)this.width / 32.0F), (double)((float)this.height / 32.0F + (float)tint)).color(64, 64, 64, 255).endVertex();
    //     vertexbuffer.pos((double)this.width, 0.0D, 0.0D).tex((double)((float)this.width / 32.0F), (double)tint).color(64, 64, 64, 255).endVertex();
    //     vertexbuffer.pos(0.0D, 0.0D, 0.0D).tex(0.0D, (double)tint).color(64, 64, 64, 255).endVertex();
    //     tessellator.draw();
    // }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
    	// this.drawBackg(0);
        this.renderBackground(matrixStack);
        Screen.drawCenteredString(matrixStack, this.font, I18n.format("UserNameMod " + version, new Object[0]), this.width / 2, 17, 0xFF0000);
        Screen.drawString(matrixStack ,this.font, I18n.format("Current User Name: " + this.mc.getSession().getUsername(), new Object[0]), this.width / 2 - 100, 53, 0x00FFFF);
        Screen.drawString(matrixStack, this.font, I18n.format("New Username(Max Lenght 16):", new Object[0]), this.width / 2 - 100, 93, 16777215);
        Screen.drawCenteredString(matrixStack, this.font, I18n.format("Mod by: rakion99", new Object[0]), this.width / 2, this.height - 50, 0x00FF00);
        this.userNameField.render(matrixStack, mouseX, mouseY, partialTicks);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}
