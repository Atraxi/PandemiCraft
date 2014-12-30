package eviltalkingpie.pandemicraft;

import net.minecraftforge.common.MinecraftForge;
import eviltalkingpie.pandemicraft.reference.Reference;
import eviltalkingpie.pandemicraft.handler.BucketHandler;
import eviltalkingpie.pandemicraft.handler.ConfigurationHandler;
import eviltalkingpie.pandemicraft.init.ModBlocks;
import eviltalkingpie.pandemicraft.init.ModFluids;
import eviltalkingpie.pandemicraft.init.ModItems;
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
        
        ModItems.preInit();
        
        ModFluids.preInit();
        
        ModBlocks.preInit();
        
        BucketHandler.INSTANCE.buckets.put(ModBlocks.blockFluidRawMana, ModItems.itemRawManaBucket);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModFluids.init();
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }
}
