package eviltalkingpie.pandemicraft.bloodmagic;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import WayofTime.alchemicalWizardry.api.alchemy.AlchemyRecipeRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Alchemy
{
    public static void init()
    {
        // alchemy is not nbt sensitive :(
        // ItemStack crystalAspectStack = new
        // ItemStack(GameRegistry.findItem("Thaumcraft", "ItemCrystalEssence"));
        // IEssentiaContainerItem item = ((IEssentiaContainerItem)
        // crystalAspectStack.getItem());
        // item.setAspects(crystalAspectStack, new AspectList().add(Aspect.COLD,
        // 1));
        // Logger.info("TEST:" + crystalAspectStack.toString() + "--" +
        // crystalAspectStack.stackTagCompound.toString());
        AlchemyRecipeRegistry.registerRecipe(new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 1024), 200,
                new ItemStack[] { new ItemStack(Items.blaze_rod), new ItemStack(Blocks.snow), new ItemStack(Blocks.ice),
                        new ItemStack(GameRegistry.findItem("ThermalFoundation", "bucket"), 1, 5), new ItemStack(Blocks.snow) },
                4);
    }
}
