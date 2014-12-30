package eviltalkingpie.pandemicraft;

import eviltalkingpie.pandemicraft.reference.Reference;
import eviltalkingpie.pandemicraft.configuration.ConfigurationHandler;
import eviltalkingpie.pandemicraft.proxy.IProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class PandemiCraft
{
    @Mod.Instance(Reference.MOD_ID)
    public static PandemiCraft instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        /*
         *  register items/blocks
         *  network handling
         *  mod configuration
         */
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(instance);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}
