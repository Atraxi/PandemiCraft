package eviltalkingpie.pandemicraft.thaumcraft;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModItems;

public class ArcaneWorktable
{
    public static void init()
    {
        //@formatter:off
        ThaumcraftApi.addArcaneCraftingRecipe("OUTERREV", new ItemStack(ModItems.itemStabilizedRealityCrack),
                new AspectList().add(Aspect.ORDER, 150).add(Aspect.EARTH, 20),
                "pip",
                "ici",
                "pip",
                'c', new ItemStack(ModItems.itemRealityCrack),
                'i', new ItemStack(GameRegistry.findItem("ThaumicTinkerer", "kamiResource"), 1, 1),//ichor cloth
                'p', new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 8));//pixie dust
        ThaumcraftApi.addArcaneCraftingRecipe("OUTERREV", new ItemStack(ModItems.itemDarkStar),
                new AspectList().add(Aspect.ENTROPY, 150).add(Aspect.EARTH, 20),
                "gdg",
                "dnd",
                "gdg",
                'n', new ItemStack(Items.nether_star),
                'd', new ItemStack(GameRegistry.findItem("MagicBees", "miscResources"), 1, 6),//draconic chunk
                'g', new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 5));//gaia spirit
        //@formatter:on
    }
}
