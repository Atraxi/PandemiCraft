package eviltalkingpie.pandemicraft.bloodmagic;

import net.minecraft.item.ItemStack;
import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import eviltalkingpie.pandemicraft.init.ModItems;

public class BindingRitual
{
    public static void init()
    {
        BindingRegistry.registerRecipe(new ItemStack(ModItems.itemRealityCrack), new ItemStack(ModItems.itemPulsingIngot));
    }
}
