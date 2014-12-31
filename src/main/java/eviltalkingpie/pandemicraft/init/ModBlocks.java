package eviltalkingpie.pandemicraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.blocks.BlockFluidBase;
import eviltalkingpie.pandemicraft.blocks.BlockFluidRawMana;

public class ModBlocks
{
    public static BlockFluidBase blockFluidRawMana;
    
    public static void preInit()
    {
        blockFluidRawMana = new BlockFluidRawMana();
        GameRegistry.registerBlock(blockFluidRawMana, "RawMana");
    }
}
