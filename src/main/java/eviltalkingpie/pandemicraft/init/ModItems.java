package eviltalkingpie.pandemicraft.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.item.ItemBase;
import eviltalkingpie.pandemicraft.item.ItemDarkStar;
import eviltalkingpie.pandemicraft.item.ItemGreenHeart;
import eviltalkingpie.pandemicraft.item.ItemPandemiSlasher;
import eviltalkingpie.pandemicraft.item.ItemRawManaBucket;
import eviltalkingpie.pandemicraft.item.ItemSimple;
import eviltalkingpie.pandemicraft.utility.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemBase  itemRawManaBucket          = new ItemRawManaBucket("rawManaBucket");
    public static final ItemBase  itemDarkStar               = new ItemDarkStar("darkStar");
    public static final ItemBase  itemPulsingIngot           = new ItemSimple("pulsingIngot", 1);
    public static final ItemBase  itemRealityCrack           = new ItemSimple("realityCrack", 1);
    public static final ItemBase  itemStabilizedRealityCrack = new ItemSimple("stabilizedRealityCrack", 1);
    public static final ItemBase  itemRealityTear            = new ItemSimple("realityTear", 1);
    public static final ItemBase  itemBloodHeart             = new ItemSimple("bloodHeart", 16);
    public static final ItemBase  itemPulsingHeart           = new ItemSimple("pulsingHeart", 16);
    public static final ItemBase  itemInfusedHeart           = new ItemSimple("infusedHeart", 16);
    public static final ItemBase  itemDenseBlade             = new ItemSimple("denseBlade", 4);
    public static final ItemSword itemPandemiSlasher         = new ItemPandemiSlasher("pandemiSlasher");
    public static final ItemBase  itemGreenHeart             = new ItemGreenHeart("greenHeart");
    public static final ItemBase  itemLunarSlime             = new ItemSimple("lunarSlime", 64);
    public static final ItemBase  itemManaPlasm              = new ItemSimple("manaPlasm", 64);
    public static final ItemBase  itemCrystalLifeform        = new ItemSimple("crystalLifeform", 64);
    public static final ItemBase  itemSusan                  = new ItemSimple("susan", 1);
    public static final ItemBase  itemSuperiorComponents     = new ItemSimple("superiorComponents", 64);
    public static final ItemBase  itemSuperiorCircuit        = new ItemSimple("superiorCircuit", 64);
    
    public static void preInit()
    {
        registerItem(itemRawManaBucket);
        registerItem(itemDarkStar);
        registerItem(itemPulsingIngot);
        registerItem(itemRealityCrack);
        registerItem(itemStabilizedRealityCrack);
        registerItem(itemRealityTear);
        registerItem(itemBloodHeart);
        registerItem(itemPulsingHeart);
        registerItem(itemInfusedHeart);
        registerItem(itemGreenHeart);
        registerItem(itemDenseBlade);
        registerItem(itemPandemiSlasher);
        registerItem(itemLunarSlime);
        registerItem(itemManaPlasm);
        registerItem(itemCrystalLifeform);
        registerItem(itemSusan);
        registerItem(itemSuperiorComponents);
        registerItem(itemSuperiorCircuit);
    }
    
    private static void registerItem(Item item)
    {
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
}
