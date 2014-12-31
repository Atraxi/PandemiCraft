package eviltalkingpie.pandemicraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids
{
    public static Fluid fluidRawMana;
    
    public static void preInit()
    {
        fluidRawMana = new Fluid("rawMana").setLuminosity(10).setDensity(1500)
                .setTemperature(310).setViscosity(2500).setGaseous(true)
                .setBlock(ModBlocks.blockFluidRawMana);
        FluidRegistry.registerFluid(fluidRawMana);
    }
    
    public static void init()
    {
        FluidContainerRegistry.registerFluidContainer(fluidRawMana,
                new ItemStack(ModItems.itemRawManaBucket),
                FluidContainerRegistry.EMPTY_BUCKET);
    }
}
