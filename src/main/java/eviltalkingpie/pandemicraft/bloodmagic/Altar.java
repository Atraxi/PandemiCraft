package eviltalkingpie.pandemicraft.bloodmagic;

import net.minecraft.item.ItemStack;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModItems;

public class Altar
{
    public static void init()
    {
        AltarRecipeRegistry.registerAltarRecipe(new ItemStack(ModItems.itemBloodHeart),
                new ItemStack(GameRegistry.findItem("TConstruct", "heartCanister"), 1, 3), 6, 100000, 1000, 5000, false);
    }
}
