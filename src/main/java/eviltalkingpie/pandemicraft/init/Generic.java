package eviltalkingpie.pandemicraft.init;

import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.util.EnumHelper;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.handler.ConfigurationHandler;
import eviltalkingpie.pandemicraft.utility.Logger;
import eviltalkingpie.pandemicraft.utility.Util;

public class Generic
{
    public static ToolMaterial denseTool = EnumHelper.addToolMaterial("denseTool", 5, 25, 50, 10, 30);
    
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
                Logger.info(itemStack);
            }
        }
        
        List thaumcraftRecipes = ThaumcraftApi.getCraftingRecipes();
        for (Iterator iterator = thaumcraftRecipes.iterator(); iterator.hasNext();)
        {
            Object recipe = iterator.next();
            if (recipe instanceof InfusionRecipe && ((InfusionRecipe) recipe).getRecipeOutput() instanceof ItemStack)
            {
                Logger.info((((InfusionRecipe) recipe).getRecipeOutput()));
                Logger.info(new ItemStack(GameRegistry.findItem("Thaumcraft", "HoverHarness")));
                
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
                Logger.info(((InfusionRecipe) recipe).getRecipeOutput());
            }
        }
        Logger.info("Registered Thaumcraft research:");
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
        mirrorComponents[3] = new ItemStack(ModItems.itemRealityTear);
        ThaumcraftApi.addInfusionCraftingRecipe(recipe.getResearch(), recipe.getRecipeOutput(), recipe.getInstability(),
                recipe.getAspects(), recipe.getRecipeInput(), mirrorComponents);
        
        if (ConfigurationHandler.prankJarren)
        {
            GameRegistry.addShapedRecipe(new ItemStack(Items.wooden_pickaxe), "www", "hs ", " s ", 's', Items.stick, 'w',
                    Blocks.planks, 'h', Util.setNBTString(new ItemStack(Items.skull, 1, 3), "SkullOwner", "Jarrenitis"));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "heartCanister"), 1, 6), new ItemStack(
                ModItems.itemGreenHeart), new ItemStack(GameRegistry.findItem("TConstruct", "heartCanister"), 1, 4),
                new ItemStack(GameRegistry.findItem("Botania", "storage"), 1, 1),
                new ItemStack(GameRegistry.findItem("EnderIO", "blockIngotStorage"), 1, 2),
                new ItemStack(GameRegistry.findItem("ThermalFoundation", "Storage"), 1, 12),
                new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCosmeticSolid"), 1, 4));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemPandemiSlasher), "b", "t", "h", 'b', new ItemStack(
                ModItems.itemDenseBlade), 't', new ItemStack(ModItems.itemRealityTear), 'h',
                new ItemStack(GameRegistry.findItem("Thaumcraft", "WandRod"), 1, 100));
        GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem("ExtraUtilities", "endConstructor"), 1, 0), "ete",
                "cdc", "ooo", 'e', new ItemStack(Items.ender_eye), 't', new ItemStack(Blocks.crafting_table), 'c', new ItemStack(
                        ModItems.itemSuperiorCircuit), 'd',
                new ItemStack(GameRegistry.findBlock("ExtraUtilities", "decorativeBlock1"), 1, 12), 'o', new ItemStack(
                        GameRegistry.findBlock("ExtraUtilities", "decorativeBlock1"), 1, 1));
    }
}
