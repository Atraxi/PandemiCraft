package eviltalkingpie.pandemicraft.init;

import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.blocks.BlockBase;
import eviltalkingpie.pandemicraft.blocks.BlockFluidBase;
import eviltalkingpie.pandemicraft.blocks.BlockFluidRawMana;
import eviltalkingpie.pandemicraft.blocks.BlockMoonStone;
import eviltalkingpie.pandemicraft.blocks.BlockSimple;

public class ModBlocks
{
    public static BlockFluidBase  blockFluidRawMana;
    public static final BlockBase blockNonupleCompressed = new BlockSimple("nonupleCompressed", Material.rock, 60f, 6000000);
    public static final BlockBase blockDecupleCompressed = new BlockSimple("decupleCompressed", Material.rock, 70f, 6000000);
    public static final BlockBase blockMoonStone         = new BlockMoonStone("moonStone");
    public static final BlockBase blockPermafrost        = new BlockSimple("permaFrost", Material.ice, 5f, 500);
    
    public static void preInit()
    {
        blockFluidRawMana = new BlockFluidRawMana("rawMana");
        GameRegistry.registerBlock(blockFluidRawMana, "rawMana");
        registerBlock(blockNonupleCompressed);
        registerBlock(blockDecupleCompressed);
        registerBlock(blockMoonStone);
        registerBlock(blockPermafrost);
        OreDictionary.registerOre("oreMoonStone", ModBlocks.blockMoonStone);
        OreDictionary.registerOre("oreIce", ModBlocks.blockPermafrost);
    }
    
    private static void registerBlock(BlockBase block)
    {
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }
}
