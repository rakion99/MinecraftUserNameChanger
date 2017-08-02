package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class UserNameBtn extends GuiButton
{
	protected static final ResourceLocation btn1_texture = new ResourceLocation("rakion99/usernamemod/btn_1.png");

	public UserNameBtn(int buttonID, int xPos, int yPos)
    {
        super(buttonID, xPos, yPos, 20, 20, "");
    }

    public void func_191745_a(Minecraft mc, int mouseX, int mouseY, float p_191745_4_)
    {
        if (this.visible)
        {
            mc.getTextureManager().bindTexture(this.btn1_texture);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int txy = 146;

            if (flag)
            {
                txy += this.height;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, txy, this.width, this.height);
        }
    }
}