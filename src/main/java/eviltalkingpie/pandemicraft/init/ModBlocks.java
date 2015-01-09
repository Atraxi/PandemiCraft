package eviltalkingpie.pandemicraft.init;

import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.blocks.BlockBase;
import eviltalkingpie.pandemicraft.blocks.BlockFluidBase;
import eviltalkingpie.pandemicraft.blocks.BlockFluidRawMana;
import eviltalkingpie.pandemicraft.blocks.BlockSimple;
import eviltalkingpie.pandemicraft.utility.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static BlockFluidBase  blockFluidRawMana;
    public static final BlockBase blockNonupleCompressed = new BlockSimple("nonupleCompressed", Material.rock);
    public static final BlockBase blockDecupleCompressed = new BlockSimple("decupleCompressed", Material.rock);
    
    public static void preInit()
    {
        blockFluidRawMana = new BlockFluidRawMana();
        GameRegistry.registerBlock(blockFluidRawMana, "RawMana");
        registerBlock(blockNonupleCompressed);
        registerBlock(blockDecupleCompressed);
    }
    
    private static void registerBlock(BlockBase block)
    {
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }
}
