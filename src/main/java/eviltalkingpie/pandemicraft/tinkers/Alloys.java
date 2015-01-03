package eviltalkingpie.pandemicraft.tinkers;

import cpw.mods.fml.common.event.FMLInterModComms;
import eviltalkingpie.pandemicraft.init.ModFluids;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.crafting.Smeltery;
import tconstruct.smeltery.TinkerSmeltery;
import tconstruct.tools.TinkerTools;

public class Alloys
{
    public static void postInit()
    {
        Smeltery.addAlloyMixing(new FluidStack(FluidRegistry.getFluid("mana"), 20), new FluidStack(ModFluids.fluidRawMana, 10), new FluidStack(FluidRegistry.getFluid("xpjuice"), 10), new FluidStack(FluidRegistry.getFluid("ender"), 10));
    }
}
