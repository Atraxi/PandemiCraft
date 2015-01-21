package eviltalkingpie.pandemicraft.init;

import net.minecraft.item.ItemStack;
import appeng.api.AEApi;
import cpw.mods.fml.common.registry.GameRegistry;

public class VanillaRecipes
{
    public static void init()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("TConstruct", "heartCanister"), 1, 6), new ItemStack(
                ModItems.itemGreenHeart), new ItemStack(GameRegistry.findItem("TConstruct", "heartCanister"), 1, 4),
                new ItemStack(GameRegistry.findItem("Botania", "storage"), 1, 1),
                new ItemStack(GameRegistry.findItem("EnderIO", "blockIngotStorage"), 1, 2),
                new ItemStack(GameRegistry.findItem("ThermalFoundation", "Storage"), 1, 12),
                new ItemStack(GameRegistry.findItem("Thaumcraft", "blockCosmeticSolid"), 1, 4));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemPandemiSlasher), "b", "t", "h", 'b', new ItemStack(
                ModItems.itemDenseBlade), 't', new ItemStack(ModItems.itemRealityTear), 'h',
                new ItemStack(GameRegistry.findItem("Thaumcraft", "WandRod"), 1, 100));
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemSuperiorCircuit), "olc", "cgc", " p ", 'o', new ItemStack(
                GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 2), 'l', new ItemStack(
                AEApi.instance().materials().materialLogicProcessor.item(), 1, 22), 'c', new ItemStack(
                ModItems.itemSuperiorComponents), 'g', new ItemStack(GameRegistry.findItem("ThermalFoundation", "bucket"), 1, 4),
                'p', new ItemStack(GameRegistry.findItem("PneumaticCraft", "printedCircuitBoard")));
    }
}
