package eviltalkingpie.pandemicraft.thaumcraft;

import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import eviltalkingpie.pandemicraft.init.ModBlocks;
import eviltalkingpie.pandemicraft.init.ModItems;

public class Crucible
{
    public static void init()
    {
        ThaumcraftApi.addCrucibleRecipe(
                "OUTERREV",
                new ItemStack(ModItems.itemRealityCrack),
                new ItemStack(ModItems.itemPulsingIngot),
                new AspectList().add(Aspect.ELDRITCH/* Alienis */, 20).add(Aspect.MAGIC/* Praecantio */, 20)
                        .add(Aspect.ENTROPY/* Perditio */, 20).add(Aspect.VOID/* Vacuos */, 20)
                        .add(Aspect.ENERGY/* Potentia */, 20).add(Aspect.AURA/* Auram */, 20).add(Aspect.TAINT/* Vitium */, 20));
        ThaumcraftApi.addCrucibleRecipe("OUTERREV", new ItemStack(ModItems.itemDenseBlade), new ItemStack(
                ModBlocks.blockDecupleCompressed), new AspectList().add(Aspect.ELDRITCH/* Alienis */, 20).add(Aspect.WEAPON, 40)
                .add(Aspect.DARKNESS, 20).add(Aspect.DEATH, 40).add(Aspect.ENTROPY, 20).add(Aspect.ORDER, 20));
    }
}
