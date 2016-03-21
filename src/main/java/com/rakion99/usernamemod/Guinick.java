package com.rakion99.usernamemod;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

public class Guinick extends GuiScreen
{
    private final GuiScreen parentScreen;
    private GuiTextField userNameField;
    String version = "v1.4";

    public Guinick(GuiScreen parentScreen)
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
        this.userNameField.setTextColor(255);
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

    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.userNameField.mouseClicked(mouseX, mouseY, mouseButton);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("Change User Name " + version, new Object[0]), this.width / 2, 17, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("Current User Name: " + this.mc.getSession().getUsername(), new Object[0]), this.width / 2 - 100, 53, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("New Username(Max Lenght 30):", new Object[0]), this.width / 2 - 100, 93, 16777215);
        this.drawCenteredString(this.fontRendererObj, I18n.format("Mod by: rakion99", new Object[0]), this.width / 2, 150, 65407);
        this.userNameField.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
