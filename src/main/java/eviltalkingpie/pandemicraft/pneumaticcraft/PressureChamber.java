package eviltalkingpie.pandemicraft.pneumaticcraft;

import net.minecraft.item.ItemStack;
import pneumaticCraft.api.recipe.PressureChamberRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModBlocks;

public class PressureChamber
{
    public static void init()
    {
        PressureChamberRecipe.chamberRecipes.add(new PressureChamberRecipe(new ItemStack[] { new ItemStack(GameRegistry
                .findBlock("ExtraUtilities", "cobblestone_compressed"), 9, 7) }, 4.8f, new ItemStack[] { new ItemStack(
                ModBlocks.blockNonupleCompressed) }, false));
        PressureChamberRecipe.chamberRecipes.add(new PressureChamberRecipe(new ItemStack[] { new ItemStack(
                ModBlocks.blockNonupleCompressed, 9) }, 4.8f,
                new ItemStack[] { new ItemStack(ModBlocks.blockDecupleCompressed) }, false));
    }
}
