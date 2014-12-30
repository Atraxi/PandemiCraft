package eviltalkingpie.pandemicraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import eviltalkingpie.pandemicraft.blocks.BlockFluidBase;
import eviltalkingpie.pandemicraft.blocks.BlockFluidRawMana;
import eviltalkingpie.pandemicraft.fluids.FluidRawMana;
import eviltalkingpie.pandemicraft.handler.BucketHandler;
import eviltalkingpie.pandemicraft.item.ItemBase;
import eviltalkingpie.pandemicraft.item.ItemRawManaBucket;
import eviltalkingpie.pandemicraft.reference.Reference;
import eviltalkingpie.pandemicraft.utility.Logger;

public class ModFluids
{
    public static Fluid fluidRawMana; 
    
    public static void preInit()
    {
        fluidRawMana = new Fluid("rawMana").setLuminosity(10).setDensity(1500).setTemperature(310).setViscosity(2500).setGaseous(true).setBlock(ModBlocks.blockFluidRawMana);
        FluidRegistry.registerFluid(fluidRawMana);
    }
    
    public static void init()
    {
        FluidContainerRegistry.registerFluidContainer(fluidRawMana, new ItemStack(ModItems.itemRawManaBucket), FluidContainerRegistry.EMPTY_BUCKET);
    }
}
