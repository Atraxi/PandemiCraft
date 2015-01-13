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
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.handler.ConfigurationHandler;
import eviltalkingpie.pandemicraft.utility.Util;

public class Generic
{
    public static ToolMaterial denseTool = EnumHelper.addToolMaterial("denseTool", 5, 25, 50, 10, 30);
    
    public static void postInit()
    {
        if (ConfigurationHandler.prankJarren)
        {
            List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
            Iterator<IRecipe> Leash = recipes.iterator();
            while (Leash.hasNext())
            {
                ItemStack is = Leash.next().getRecipeOutput();
                if (is != null && is.getItem() == Items.wooden_pickaxe)
                    Leash.remove();
            }
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
    }
}
