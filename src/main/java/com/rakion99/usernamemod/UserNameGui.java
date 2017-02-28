package com.rakion99.usernamemod;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;

public class UserNameGui extends GuiScreen
{
    private final GuiScreen parentScreen;
    private GuiTextField userNameField;
    String version = "v1.5";

    public UserNameGui(GuiScreen parentScreen)
    {
        this.parentScreen = parentScreen;
    }

    public void updateScreen()
    {
        this.userNameField.updateCursorCounter();
    }

    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50, this.height / 4 + 96 + 18, 100, 20, I18n.format("Change User name", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50, this.height / 4 + 120 + 18, 100, 20, I18n.format("Done", new Object[0])));
        this.userNameField = new GuiTextField(0, this.fontRendererObj, this.width / 2 - 100, 106, 190, 20);
        this.userNameField.setFocused(true);
        this.userNameField.setMaxStringLength(30);
        this.userNameField.setTextColor(0xFFFF00);
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void actionPerformed(GuiButton button) throws IOException
    {
            if (button.id == 1)
            {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            if (button.id == 0)
            {
            	this.mc.getSession().username = this.userNameField.getText();
            	this.parentScreen.confirmClicked(true, 0);
            	System.out.println("New UserName: "+this.userNameField.getText());
            }
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        this.userNameField.textboxKeyTyped(typedChar, keyCode);

        if (keyCode == 15)
        {
            this.userNameField.setFocused(!this.userNameField.isFocused());
        }

        if (keyCode == 28 || keyCode == 156)
        {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
        
        if (keyCode == 1)
        {
        	this.mc.displayGuiScreen(this.parentScreen);
        }

    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.userNameField.mouseClicked(mouseX, mouseY, mouseButton);
    }
    
    protected static final ResourceLocation bg_texture = new ResourceLocation("textures/blocks/red_nether_brick.png");

	
	public void drawBackg(int tint)
    {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        this.mc.getTextureManager().bindTexture(bg_texture);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32.0F;
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        vertexbuffer.pos(0.0D, (double)this.height, 0.0D).tex(0.0D, (double)((float)this.height / 32.0F + (float)tint)).color(64, 64, 64, 255).endVertex();
        vertexbuffer.pos((double)this.width, (double)this.height, 0.0D).tex((double)((float)this.width / 32.0F), (double)((float)this.height / 32.0F + (float)tint)).color(64, 64, 64, 255).endVertex();
        vertexbuffer.pos((double)this.width, 0.0D, 0.0D).tex((double)((float)this.width / 32.0F), (double)tint).color(64, 64, 64, 255).endVertex();
        vertexbuffer.pos(0.0D, 0.0D, 0.0D).tex(0.0D, (double)tint).color(64, 64, 64, 255).endVertex();
        tessellator.draw();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
    	this.drawBackg(0);
        this.drawCenteredString(this.fontRendererObj, I18n.format("Change User Name " + version, new Object[0]), this.width / 2, 17, 0xFF0000);
        this.drawString(this.fontRendererObj, I18n.format("Current User Name: " + this.mc.getSession().getUsername(), new Object[0]), this.width / 2 - 100, 53, 0x00FFFF);
        this.drawString(this.fontRendererObj, I18n.format("New Username(Max Lenght 30):", new Object[0]), this.width / 2 - 100, 93, 16777215);
        this.drawCenteredString(this.fontRendererObj, I18n.format("Mod by: rakion99", new Object[0]), this.width / 2, 150, 0x00FF00);
        this.userNameField.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
