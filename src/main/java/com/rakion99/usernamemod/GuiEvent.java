package com.rakion99.usernamemod;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiEvent 
{
	
	@SubscribeEvent
    public void guiEvent(GuiScreenEvent.InitGuiEvent.Post event){
    	GuiScreen gui = event.gui;
    	int j = gui.height / 4 + 48;
    	if(gui instanceof GuiMainMenu){
    		event.buttonList.add(new Guinick2(99, gui.width / 2 - 150, j + 72 + 12));
    	}
    }
	
	@SubscribeEvent
    public void onButtonClickPost(GuiScreenEvent.ActionPerformedEvent.Post event) {
    	GuiScreen gui = event.gui;
        if (gui instanceof GuiMainMenu) {
            if (event.button.id == 99) {
            	gui.mc.displayGuiScreen(new Guinick(gui));
            }
        }
    }
	
}
