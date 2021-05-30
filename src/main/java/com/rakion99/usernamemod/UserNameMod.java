package com.rakion99.usernamemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(UserNameMod.MODID)
public class UserNameMod
{
    public static final String MODID = "usernamemod";
    public static final String VERSION = "1.7";
    public static final Logger LOGGER = LogManager.getLogger();
    
    public UserNameMod()
    {
        System.out.println("<< UserNameMod 1.7 Loaded >> ");
    	MinecraftForge.EVENT_BUS.register(new UserNameEvent());
		
	}
    
}
