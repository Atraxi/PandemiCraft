package eviltalkingpie.pandemicraft.pneumaticcraft;

import net.minecraft.item.ItemStack;
import pneumaticCraft.api.recipe.AssemblyRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModItems;

public class LaserAssembly
{
    public static void init()
    {
        AssemblyRecipe.drillLaserRecipes.add(new AssemblyRecipe(new ItemStack(GameRegistry.findItem("ThermalFoundation",
                "material"), 1, 74), new ItemStack(ModItems.itemSuperiorComponents)));
    }
}
