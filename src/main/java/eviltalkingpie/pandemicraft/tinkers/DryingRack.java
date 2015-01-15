package eviltalkingpie.pandemicraft.tinkers;

import tconstruct.library.crafting.DryingRackRecipes;
import eviltalkingpie.pandemicraft.init.ModItems;

public class DryingRack
{
    public static void init()
    {
        DryingRackRecipes.addDryingRecipe(ModItems.itemManaPlasm, 400, ModItems.itemCrystalLifeform);
    }
}
