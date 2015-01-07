package eviltalkingpie.pandemicraft.tinkers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.LiquidCasting;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModItems;
import eviltalkingpie.pandemicraft.utility.Logger;

public class Casting
{
    private static LiquidCasting tableCasting = TConstructRegistry.instance.getTableCasting();
    
    public static void init()
    {
        ItemStack stableIngot = new ItemStack(GameRegistry.findItem("ExtraUtilities", "unstableingot"));
        NBTTagCompound stable = new NBTTagCompound();
        stable.setByte("stable", (byte) 1);
        stable.setByte("superstable", (byte) 1);
        stableIngot.setTagCompound(stable);
        Logger.debug(stableIngot);
        tableCasting.addCastingRecipe(new ItemStack(ModItems.itemPulsingIngot), new FluidStack(FluidRegistry.getFluid("mana"),
                1000), stableIngot, true, 200);
    }
}
