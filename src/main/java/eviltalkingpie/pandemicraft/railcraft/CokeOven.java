package eviltalkingpie.pandemicraft.railcraft;

import mods.railcraft.api.crafting.RailcraftCraftingManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModFluids;
import eviltalkingpie.pandemicraft.utility.Util;

public class CokeOven
{
    public static void init()
    {
        ItemStack ring = new ItemStack(GameRegistry.findItem("Botania", "manaRingGreater"));
        // NBTTagCompound manaTag = new NBTTagCompound();
        // manaTag.setInteger("mana", 2000000);
        // ring.setTagCompound(manaTag);
        Util.setNBTInteger(ring, "mana", 2000000);
        ring.setItemDamage(0);
        RailcraftCraftingManager.cokeOven.addRecipe(ring, true, true,
                new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 4),
                new FluidStack(ModFluids.fluidRawMana, 500), 600);
    }
}
