package eviltalkingpie.pandemicraft.tinkers;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.crafting.Smeltery;
import eviltalkingpie.pandemicraft.init.ModFluids;

public class Alloys
{
    public static void init()
    {
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("mana"), 500), new FluidStack(ModFluids.fluidRawMana, 250),
                new FluidStack(FluidRegistry.getFluid("xpjuice"), 250), new FluidStack(FluidRegistry.getFluid("ender"), 250));
    }
}
