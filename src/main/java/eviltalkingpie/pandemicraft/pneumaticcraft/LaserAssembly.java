package eviltalkingpie.pandemicraft.pneumaticcraft;

import net.minecraft.item.ItemStack;
import pneumaticCraft.api.recipe.AssemblyRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModItems;

public class LaserAssembly
{
    public static void init()
    {
        AssemblyRecipe.addDrillRecipe(new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 74),
                ModItems.itemIntermediateComponents);
        AssemblyRecipe.addLaserRecipe(new ItemStack(ModItems.itemIntermediateComponents), new ItemStack(
                ModItems.itemSuperiorComponents));
    }
}
