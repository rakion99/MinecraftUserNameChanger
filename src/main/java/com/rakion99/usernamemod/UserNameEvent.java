package com.rakion99.usernamemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MultiplayerScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class UserNameEvent 
{
	
	@SubscribeEvent
    public void GuiEvent(GuiScreenEvent.InitGuiEvent.Post event){
    	Screen gui = event.getGui();
    	//int j = gui.height / 4 + 48;
    	if(gui instanceof MultiplayerScreen){
    		event.addWidget(new ImageButton(gui.width / 2 - 154 - 20 - 5, gui.height - 52, 20, 20, 0, 146, 20, new ResourceLocation("minecraft", "rakion99/usernamemod/btn_1.png"),
				new Button.IPressable(){
					public void onPress(Button button){
						Minecraft.getInstance().displayGuiScreen(new UserNameGui(Minecraft.getInstance().currentScreen));
					}
				}
			));
    	}
    }
}
