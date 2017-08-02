package com.rakion99.usernamemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class UserNameBtn extends GuiButton
{

	protected static final ResourceLocation btn1_texture = new ResourceLocation("rakion99/usernamemod/btn_1.png");
	
    public UserNameBtn(int buttonID, int xPos, int yPos)
    {
        super(buttonID, xPos, yPos, 20, 20, "");
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
    	if (this.visible)
        {
            mc.getTextureManager().bindTexture(this.btn1_texture);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int txy = 146;

            if (flag)
            {
                txy += this.height;
            }

            this.drawTexturedModalRect(this.x, this.y, 0, txy, this.width, this.height);
        }
    }
}
