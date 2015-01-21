package eviltalkingpie.pandemicraft.enderio;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.registry.GameRegistry;
import crazypants.enderio.machine.recipe.Recipe;
import crazypants.enderio.machine.recipe.RecipeBonusType;
import crazypants.enderio.machine.recipe.RecipeInput;
import crazypants.enderio.machine.recipe.RecipeOutput;
import crazypants.enderio.machine.vat.VatRecipeManager;
import eviltalkingpie.pandemicraft.init.ModBlocks;

public class Vat
{
    public static void init()
    {
        VatRecipeManager.getInstance().addRecipe(
                new Recipe(new RecipeInput[] { new RecipeInput(new FluidStack(FluidRegistry.getFluid("mana"), 1000)),
                        new RecipeInput(new ItemStack(Blocks.redstone_block), false, 3, 0),
                        new RecipeInput(new ItemStack(Items.redstone), false, 1, 0),
                        new RecipeInput(new ItemStack(Items.ender_pearl), false, 1, 1),
                        new RecipeInput(new ItemStack(Items.ender_eye), false, 1.5f, 1) }, new RecipeOutput[] { new RecipeOutput(
                        new FluidStack(FluidRegistry.getFluid("redstone"), 500)) }, 50000, RecipeBonusType.MULTIPLY_OUTPUT));
        VatRecipeManager.getInstance().addRecipe(
                new Recipe(new RecipeInput[] {
                        new RecipeInput(new FluidStack(FluidRegistry.getFluid("slime.blue"), 500)),
                        new RecipeInput(new ItemStack(ModBlocks.blockPermafrost), false, 1, 0),
                        new RecipeInput(new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 513), false, 1,
                                1) }, new RecipeOutput[] { new RecipeOutput(new FluidStack(FluidRegistry.getFluid("cryotheum"),
                        500)) }, 50000, RecipeBonusType.MULTIPLY_OUTPUT));
    }
}