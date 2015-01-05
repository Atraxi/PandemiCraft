package eviltalkingpie.pandemicraft.thaumcraft;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import eviltalkingpie.pandemicraft.init.ModItems;
import eviltalkingpie.pandemicraft.utility.Util;

public class Infusion
{
    public static void postInit()
    {
        //@formatter:off
        Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "eviltalkingpie");
        
        ThaumcraftApi.addInfusionCraftingRecipe("",
                ModItems.itemRealityTear, 1000,
                new AspectList().add(Aspect.ELDRITCH/* Alienis */, 64).add(Aspect.MAGIC/* Praecantio */, 64)
                        .add(Aspect.ENTROPY/* Perditio */, 64).add(Aspect.VOID/* Vacuos */, 64)
                        .add(Aspect.ENERGY/* Potentia */, 64).add(Aspect.AURA/* Auram */, 64)
                        .add(Aspect.TAINT/* Vitium */, 64),
                new ItemStack(ModItems.itemStabilizedRealityCrack),
                new ItemStack[] {new ItemStack(ModItems.itemDarkStar, 2),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "eviltalkingpie"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Donmyster"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "_MaxRebo_"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Buzzsaw2913"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "XxsumsumxX"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "DasRenchen"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Jarrenitis"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Ric124"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Rain2006"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "IndigoWhite"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "IdioticMage"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Atticus_Taylor"),
                Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Elroygaffen"),
                });
        //@formatter:on
    }
}
