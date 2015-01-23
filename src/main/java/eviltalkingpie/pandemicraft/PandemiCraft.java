package eviltalkingpie.pandemicraft;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import eviltalkingpie.pandemicraft.bloodmagic.Alchemy;
import eviltalkingpie.pandemicraft.bloodmagic.Altar;
import eviltalkingpie.pandemicraft.bloodmagic.BindingRitual;
import eviltalkingpie.pandemicraft.botania.ElvenGateway;
import eviltalkingpie.pandemicraft.botania.Orechid;
import eviltalkingpie.pandemicraft.enderio.SliceAndSplice;
import eviltalkingpie.pandemicraft.enderio.Vat;
import eviltalkingpie.pandemicraft.handler.BucketHandler;
import eviltalkingpie.pandemicraft.handler.CommandHeldItem;
import eviltalkingpie.pandemicraft.handler.ConfigurationHandler;
import eviltalkingpie.pandemicraft.init.ModBlocks;
import eviltalkingpie.pandemicraft.init.ModFluids;
import eviltalkingpie.pandemicraft.init.ModItems;
import eviltalkingpie.pandemicraft.init.Tweaks;
import eviltalkingpie.pandemicraft.init.VanillaRecipes;
import eviltalkingpie.pandemicraft.pneumaticcraft.LaserAssembly;
import eviltalkingpie.pandemicraft.pneumaticcraft.PressureChamber;
import eviltalkingpie.pandemicraft.proxy.CommonProxy;
import eviltalkingpie.pandemicraft.railcraft.CokeOven;
import eviltalkingpie.pandemicraft.thaumcraft.ArcaneWorktable;
import eviltalkingpie.pandemicraft.thaumcraft.Crucible;
import eviltalkingpie.pandemicraft.thaumcraft.Infusion;
import eviltalkingpie.pandemicraft.tinkers.Alloys;
import eviltalkingpie.pandemicraft.tinkers.Casting;
import eviltalkingpie.pandemicraft.tinkers.DryingRack;
import eviltalkingpie.pandemicraft.utility.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS,
        dependencies = Reference.DEPENDENCIES)
public class PandemiCraft
{
    @Mod.Instance(Reference.MOD_ID)
    public static PandemiCraft instance;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy  proxy;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        /* register items/blocks network handling mod configuration */
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(instance);
        ModItems.preInit();
        ModFluids.preInit();
        ModBlocks.preInit();
        BucketHandler.buckets.put(ModBlocks.blockFluidRawMana, ModItems.itemRawManaBucket);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        MinecraftForge.EVENT_BUS.register(proxy);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModFluids.init();
        // Tinkers Construct recipes
        Alloys.init();
        Casting.init();
        DryingRack.init();
        // Thaumcraft recipes
        ArcaneWorktable.init();
        Crucible.init();
        Infusion.init();
        // Blood Magic recipes
        Altar.init();
        BindingRitual.init();
        Alchemy.init();
        // PneumaticCraft recipes
        PressureChamber.init();
        LaserAssembly.init();
        // Botania recipes
        ElvenGateway.init();
        Orechid.init();
        // Railcraft recipes
        CokeOven.init();
        // EnderIO recipes
        Vat.init();
        SliceAndSplice.init();
        
        VanillaRecipes.init();
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        Tweaks.postInit();
    }
    
    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandHeldItem());
    }
}
