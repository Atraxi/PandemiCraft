package eviltalkingpie.pandemicraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.utility.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModFluids
{
    public static Fluid fluidRawMana = new Fluid("rawMana").setLuminosity(10).setDensity(1500).setTemperature(310)
                                             .setViscosity(2500).setGaseous(true);
    
    public static void preInit()
    {
        FluidRegistry.registerFluid(fluidRawMana);
    }
    
    public static void init()
    {
        fluidRawMana.setBlock(ModBlocks.blockFluidRawMana);
        FluidContainerRegistry.registerFluidContainer(fluidRawMana, new ItemStack(ModItems.itemRawManaBucket),
                FluidContainerRegistry.EMPTY_BUCKET);
    }
}
