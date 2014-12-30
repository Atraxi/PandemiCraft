package eviltalkingpie.pandemicraft.init;

import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.blocks.BlockFluidBase;
import eviltalkingpie.pandemicraft.blocks.BlockFluidRawMana;
import eviltalkingpie.pandemicraft.reference.Reference;
import eviltalkingpie.pandemicraft.handler.BucketHandler;

public class ModBlocks
{
    public static BlockFluidBase blockFluidRawMana;
    
    public static void preInit()
    {
        blockFluidRawMana= new BlockFluidRawMana();
        GameRegistry.registerBlock(blockFluidRawMana, "RawMana");
    }
}
