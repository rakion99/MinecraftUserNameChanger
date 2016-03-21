package com.rakion99.usernamemod;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = UserNameMod.MODID, version = UserNameMod.VERSION)
public class UserNameMod
{
    public static final String MODID = "UserNameMod";
    public static final String VERSION = "1.4";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("<< UserNameMod Loaded >> ");
    }
    
    @EventHandler
	public void preInit(FMLPreInitializationEvent event)  
    {
		
    	MinecraftForge.EVENT_BUS.register(new GuiEvent());
		
	}
    
}
