package com.dhj.ingameime;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = IngameIME_Forge.MOD_ID,
        name = IngameIME_Forge.MOD_NAME,
        clientSideOnly = true,
        acceptedMinecraftVersions = "[1.8.9]",
        acceptableRemoteVersions = "*",
        guiFactory = "com.dhj.ingameime.ConfigGuiFactory"
)
public class IngameIME_Forge {
    public static final String MOD_ID = "ingameime";
    public static final String MOD_NAME = "In game IME";
    public static final Logger LOG = LogManager.getLogger(MOD_NAME);
    @SidedProxy(clientSide = "com.dhj.ingameime.ClientProxy", serverSide = "com.ingameime.CommonProxy")
    public static CommonProxy proxy;

    /**
     * For some logs which are not important most time.
     */
    public static void logDebugInfo(String message, Object... params) {
        if (Config.DebugLog) LOG.info(message, params);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
}
