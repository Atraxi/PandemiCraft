package eviltalkingpie.pandemicraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.item.ItemBase;
import eviltalkingpie.pandemicraft.item.ItemDarkStar;
import eviltalkingpie.pandemicraft.item.ItemPulsingIngot;
import eviltalkingpie.pandemicraft.item.ItemRawManaBucket;

public class ModItems
{
    public static final ItemBase itemPulsingIngot  = new ItemPulsingIngot();
    public static final ItemBase itemDarkStar      = new ItemDarkStar();
    public static final ItemBase itemRawManaBucket = new ItemRawManaBucket();
    
    public static void preInit()
    {
        GameRegistry.registerItem(itemPulsingIngot, "pulsingIngot");
        GameRegistry.registerItem(itemDarkStar, "darkStar");
        GameRegistry.registerItem(itemRawManaBucket, "rawManaBucket");
    }
}
