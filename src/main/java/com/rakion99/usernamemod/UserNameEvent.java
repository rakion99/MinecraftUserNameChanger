package com.rakion99.usernamemod;

import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class UserNameEvent 
{
	
	@SubscribeEvent
    public void GuiEvent(GuiScreenEvent.InitGuiEvent.Post event){
    	GuiScreen gui = event.getGui();
    	//int j = gui.height / 4 + 48;
    	if(gui instanceof GuiMultiplayer){
    		event.getButtonList().add(new UserNameBtn(99, gui.width / 2 - 185, gui.height - 52));
    	}
    }
	
	@SubscribeEvent
    public void onButtonClickPost(GuiScreenEvent.ActionPerformedEvent.Post event) {
    	GuiScreen gui = event.getGui();
        if (gui instanceof GuiMultiplayer) {
            if (event.getButton().id == 99) {
            	gui.mc.displayGuiScreen(new UserNameGui(gui));
            }
        }
    }
	
}
