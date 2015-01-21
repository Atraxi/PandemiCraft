package eviltalkingpie.pandemicraft.enderio;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import crazypants.enderio.machine.recipe.BasicManyToOneRecipe;
import crazypants.enderio.machine.recipe.Recipe;
import crazypants.enderio.machine.recipe.RecipeBonusType;
import crazypants.enderio.machine.recipe.RecipeInput;
import crazypants.enderio.machine.recipe.RecipeOutput;
import crazypants.enderio.machine.slicensplice.SliceAndSpliceRecipeManager;
import eviltalkingpie.pandemicraft.init.ModItems;

public class SliceAndSplice
{
    public static void init()
    {
        for (ItemStack aluminiumStack : OreDictionary.getOres("ingotAluminium"))
        {
            SliceAndSpliceRecipeManager.getInstance().addRecipe(
                    new BasicManyToOneRecipe(new Recipe(new RecipeOutput(new ItemStack(ModItems.itemSusan)), 25000,
                            RecipeBonusType.NONE, new RecipeInput(
                                    new ItemStack(GameRegistry.findItem("Botania", "manaResource")), true, 1, 0),
                            new RecipeInput(new ItemStack(ModItems.itemCrystalLifeform), true, 1, 1), new RecipeInput(
                                    new ItemStack(GameRegistry.findItem("Botania", "manaResource")), true, 1, 2),
                            new RecipeInput(aluminiumStack, true, 1, 3), new RecipeInput(new ItemStack(ModItems.itemDarkStar),
                                    true, 1, 4), new RecipeInput(aluminiumStack.copy(), true, 1, 5))));
        }
    }
}
