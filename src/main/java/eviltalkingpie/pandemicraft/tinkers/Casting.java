package eviltalkingpie.pandemicraft.tinkers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.LiquidCasting;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModItems;

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
        // Logger.debug(stableIngot);
        // Util.setNBTByte(stableIngot, "stable", (byte) 1);
        // Util.setNBTByte(stableIngot, "superstable", (byte) 1);
        tableCasting.addCastingRecipe(new ItemStack(ModItems.itemPulsingIngot), new FluidStack(FluidRegistry.getFluid("mana"),
                1000), stableIngot, true, 200);
        tableCasting.addCastingRecipe(new ItemStack(ModItems.itemPulsingHeart), new FluidStack(FluidRegistry.getFluid("mana"),
                500), new ItemStack(ModItems.itemBloodHeart), true, 250);
    }
}
