package eviltalkingpie.pandemicraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.item.ItemBase;
import eviltalkingpie.pandemicraft.item.ItemDarkStar;
import eviltalkingpie.pandemicraft.item.ItemPulsingIngot;
import eviltalkingpie.pandemicraft.item.ItemRawManaBucket;
import eviltalkingpie.pandemicraft.item.ItemRealityCrack;
import eviltalkingpie.pandemicraft.item.ItemStabilizedRealityCrack;

public class ModItems
{
    public static final ItemBase itemPulsingIngot           = new ItemPulsingIngot();
    public static final ItemBase itemDarkStar               = new ItemDarkStar();
    public static final ItemBase itemRawManaBucket          = new ItemRawManaBucket();
    public static final ItemBase itemRealityCrack           = new ItemRealityCrack();
    public static final ItemBase itemStabilizedRealityCrack = new ItemStabilizedRealityCrack();
    
    public static void preInit()
    {
        GameRegistry.registerItem(itemPulsingIngot, "pulsingIngot");
        GameRegistry.registerItem(itemDarkStar, "darkStar");
        GameRegistry.registerItem(itemRawManaBucket, "rawManaBucket");
        GameRegistry.registerItem(itemRealityCrack, "rsealityCrack");
        GameRegistry.registerItem(itemStabilizedRealityCrack, "stabilizedRealityCrack");
    }
}
