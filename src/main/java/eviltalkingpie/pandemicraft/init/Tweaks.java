package eviltalkingpie.pandemicraft.init;

import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.api.items.ShapedBloodOrbRecipe;
import appeng.api.AEApi;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.handler.ConfigurationHandler;
import eviltalkingpie.pandemicraft.utility.Logger;
import eviltalkingpie.pandemicraft.utility.Util;

public class Tweaks
{
    public static void postInit()
    {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> Leash = recipes.iterator();
        while (Leash.hasNext())
        {
            ItemStack itemStack = Leash.next().getRecipeOutput();
            if (itemStack != null)
            {
                if (itemStack.getItem() == Items.wooden_pickaxe && ConfigurationHandler.prankJarren)
                {
                    Logger.info("Preparing secret tweak");
                    Leash.remove();
                }
                else if (ItemStack.areItemStacksEqual(itemStack,
                        new ItemStack(GameRegistry.findItem("ExtraUtilities", "endConstructor"), 1, 0)))
                {
                    Logger.info("Removed QED recipe");
                    Leash.remove();
                }
                else if (itemStack.getItem() == GameRegistry.findItem("ExtraUtilities", "angelRing"))
                {
                    Logger.info("Removed Angel Ring recipe");
                    Leash.remove();
                }
                else if (ItemStack.areItemStacksEqual(new ItemStack(AEApi.instance().materials().materialCell64kPart.item(), 1,
                        38), itemStack))
                {
                    Logger.info("Removed 64k Storage Component recipe");
                    Leash.remove();
                }
                else if (ItemStack.areItemStacksEqual(itemStack,
                        new ItemStack(GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 2)))
                {
                    Logger.info("Removed Octadic Capacitor recipe");
                    Leash.remove();
                }
                else if (ItemStack.areItemStacksEqual(itemStack, new ItemStack(ModBlocks.blockTeleposer)))
                {
                    Logger.info("Removed Teleposer recipe");
                    Leash.remove();
                }
                else if (ItemStack.areItemStacksEqual(itemStack, new ItemStack(GameRegistry.findItem("AWWayofTime", "airSigil"),
                        1, 0)))
                {
                    Logger.info("Removed Air Sigil recipe");
                    Leash.remove();
                }
                else if (ItemStack.areItemStacksEqual(itemStack,
                        new ItemStack(GameRegistry.findItem("AWWayofTime", "sigilOfTheBridge"), 1, 0)))
                {
                    Logger.info("Removed Phantom Bridge recipe");
                    Leash.remove();
                }
                else if (ItemStack.areItemStacksEqual(itemStack, new ItemStack(GameRegistry.findItem("Botania", "flightTiara"),
                        1, 0)))
                {
                    Logger.info("Removed base Flugel Tiara recipe");
                    Leash.remove();
                }
            }
        }
        
        List thaumcraftRecipes = ThaumcraftApi.getCraftingRecipes();
        for (Iterator iterator = thaumcraftRecipes.iterator(); iterator.hasNext();)
        {
            Object recipe = iterator.next();
            if (recipe instanceof InfusionRecipe && ((InfusionRecipe) recipe).getRecipeOutput() instanceof ItemStack)
            {
                if (ItemStack.areItemStacksEqual(((ItemStack) ((InfusionRecipe) recipe).getRecipeOutput()), new ItemStack(
                        GameRegistry.findItem("Thaumcraft", "HoverHarness"))))
                {
                    Logger.info("Removed Thaumostatic Harness recipe");
                    iterator.remove();
                }
                else if (ItemStack.areItemStacksEqual((ItemStack) ((InfusionRecipe) recipe).getRecipeOutput(), new ItemStack(
                        GameRegistry.findItem("Thaumcraft", "blockMirror"))))
                {
                    Logger.info("Removed Magic Mirror recipe");
                    iterator.remove();
                }
                else if (ItemStack.areItemStacksEqual((ItemStack) ((InfusionRecipe) recipe).getRecipeOutput(), new ItemStack(
                        GameRegistry.findItem("ThaumicTinkerer", "focusFlight"))))
                {
                    Logger.info("Removed Wand Focus: Uprising recipe");
                    iterator.remove();
                }
            }
        }
        Logger.info("Currently registered Thaumcraft research:");
        for (String key : ResearchCategories.researchCategories.keySet())
        {
            Logger.info(key);
            for (String subKey : ResearchCategories.getResearchList(key).research.keySet())
            {
                Logger.info("-" + subKey);
            }
        }
        InfusionRecipe recipe = (InfusionRecipe) ResearchCategories.getResearch("HOVERHARNESS").getPages()[1].recipe;
        ItemStack[] harnessComponents = recipe.getComponents();
        harnessComponents[0] = new ItemStack(ModItems.itemSusan);
        harnessComponents[8] = harnessComponents[1].copy();
        ThaumcraftApi.addInfusionCraftingRecipe(recipe.getResearch(), recipe.getRecipeOutput(), recipe.getInstability(),
                recipe.getAspects(), recipe.getRecipeInput(), harnessComponents);
        
        recipe = (InfusionRecipe) ResearchCategories.getResearch("MIRROR").getPages()[2].recipe;
        ItemStack[] mirrorComponents = recipe.getComponents();
        mirrorComponents[3] = new ItemStack(ModItems.itemSusan);
        ThaumcraftApi.addInfusionCraftingRecipe(recipe.getResearch(), recipe.getRecipeOutput(), recipe.getInstability(),
                recipe.getAspects(), recipe.getRecipeInput(), mirrorComponents);
        
        recipe = (InfusionRecipe) ResearchCategories.getResearch("FOCUS_FLIGHT").getPages()[1].recipe;
        ItemStack[] flightFocusComponents = recipe.getComponents();
        flightFocusComponents[0] = new ItemStack(ModItems.itemSusan);
        ThaumcraftApi.addInfusionCraftingRecipe(recipe.getResearch(), recipe.getRecipeOutput(), recipe.getInstability(),
                recipe.getAspects(), recipe.getRecipeInput(), flightFocusComponents);
        
        if (ConfigurationHandler.prankJarren)
        {
            GameRegistry.addShapedRecipe(new ItemStack(Items.wooden_pickaxe), "www", "hs ", " s ", 's', Items.stick, 'w',
                    Blocks.planks, 'h', Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Jarrenitis"));
        }
        // QED
        GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("ExtraUtilities", "endConstructor"), 1, 0), "ete",
                "cdc", "ooo", 'e', new ItemStack(Items.ender_eye), 't', new ItemStack(Blocks.crafting_table), 'c', new ItemStack(
                        ModItems.itemSuperiorCircuit), 'd',
                new ItemStack(GameRegistry.findBlock("ExtraUtilities", "decorativeBlock1"), 1, 12), 'o', new ItemStack(
                        GameRegistry.findBlock("ExtraUtilities", "decorativeBlock1"), 1, 1));
        // Octadic Capacitor
        GameRegistry
                .addShapedRecipe(new ItemStack(GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 2), " c ", "dgd",
                        " c ", 'c', new ItemStack(ModItems.itemSuperiorComponents), 'd',
                        new ItemStack(GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 1), 'g', new ItemStack(
                                Blocks.glowstone));
        // 64k Storage Component
        GameRegistry.addShapedRecipe(new ItemStack(AEApi.instance().materials().materialCell64kPart.item(), 1, 38), "gpg", "cqc",
                "gsg", 'g', new ItemStack(Items.glowstone_dust), 'p', new ItemStack(
                        AEApi.instance().materials().materialEngProcessor.item(), 1, 24), 'c', new ItemStack(AEApi.instance()
                        .materials().materialCell16kPart.item(), 1, 37), 'q', new ItemStack(
                        AEApi.instance().blocks().blockQuartzGlass.block()), 's', new ItemStack(ModItems.itemSuperiorCircuit));
        // Teleposer
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockTeleposer), new Object[] { "ggg", "ese", "ggg", 'g',
                new ItemStack(Items.gold_ingot), 's', new ItemStack(ModItems.itemRealityTear), 'e',
                new ItemStack(Items.ender_pearl) });
        // Air Sigil
        GameRegistry.addRecipe(new ShapedBloodOrbRecipe(new ItemStack(WayofTime.alchemicalWizardry.ModItems.airSigil),
                new Object[] { "faf", "gsg", "fof", 'f', new ItemStack(Items.feather), 'a', new ItemStack(ModItems.itemSusan),
                        'g', new ItemStack(Items.ghast_tear), 's',
                        new ItemStack(WayofTime.alchemicalWizardry.ModItems.reinforcedSlate), 'o',
                        new ItemStack(WayofTime.alchemicalWizardry.ModItems.apprenticeBloodOrb) }));
        // Phantom Bridge
        GameRegistry.addRecipe(new ShapedBloodOrbRecipe(new ItemStack(WayofTime.alchemicalWizardry.ModItems.sigilOfTheBridge),
                new Object[] { "nan", "nsn", "ror", 'n', new ItemStack(Blocks.stone), 'r', new ItemStack(Blocks.soul_sand), 's',
                        new ItemStack(WayofTime.alchemicalWizardry.ModItems.imbuedSlate), 'o',
                        new ItemStack(WayofTime.alchemicalWizardry.ModItems.magicianBloodOrb), 'a',
                        new ItemStack(ModItems.itemSusan) }));
        // Flugel Tiara
        ShapedRecipes recipeTiara =
                new ShapedRecipes(3, 3, new ItemStack[] { new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 5),
                        new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 5),
                        new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 5),
                        new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 7), new ItemStack(ModItems.itemSusan),
                        new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 7), new ItemStack(Items.feather),
                        new ItemStack(GameRegistry.findItem("Botania", "manaResource"), 1, 7), new ItemStack(Items.feather) },
                        new ItemStack(GameRegistry.findItem("Botania", "flightTiara"), 1, 0));
        GameRegistry.addRecipe(recipeTiara);
        // Ender Marker
        GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("ExtraUtilities", "endMarker"), 1, 0), "d", "o", "o",
                'd', new ItemStack(Items.diamond), 'o', new ItemStack(
                        GameRegistry.findItem("ExtraUtilities", "decorativeBlock1"), 1, 1));
        // Diamond-Etched Computaional Matrix
        GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("ExtraUtilities", "enderQuarryUpgrade"), 1, 0), " o ",
                "odo", " o ", 'd', new ItemStack(GameRegistry.findItem("ExtraUtilities", "decorativeBlock1"), 1, 12), 'o',
                new ItemStack(GameRegistry.findItem("ExtraUtilities", "decorativeBlock1"), 1, 1));
        
        // Lexica Botania Editing
        Logger.info("Lexicon Entries:");
        int i = 0;
        for (Iterator iterator = BotaniaAPI.getAllEntries().iterator(); iterator.hasNext(); i++)
        {
            LexiconEntry lexiconEntry = (LexiconEntry) iterator.next();
            Logger.info(i + "-" + lexiconEntry.getUnlocalizedName());
            if (lexiconEntry.getUnlocalizedName().equals("botania.entry.flightTiara"))
            {
                Logger.info("Flugel Tiara Lexicon page modified");
                lexiconEntry.pages.remove(1);
                lexiconEntry.pages.add(1, new PageCraftingRecipe("botania.entry.flightTiara", recipeTiara));
            }
        }
    }
}
