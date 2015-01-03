package eviltalkingpie.pandemicraft.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import eviltalkingpie.pandemicraft.utility.Reference;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean       isPandemiCraft = true;
    
    public static void init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }
    
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }
    
    private static void loadConfiguration()
    {
        isPandemiCraft =
                configuration.getBoolean("isPandemiCraft", Configuration.CATEGORY_GENERAL, true,
                        "Is this on the PandemiCraft server? (changes whether the PandemiCrafters heads are use for crafting, or mob heads)");
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
