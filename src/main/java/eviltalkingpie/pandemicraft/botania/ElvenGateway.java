package eviltalkingpie.pandemicraft.botania;

import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;
import eviltalkingpie.pandemicraft.init.ModItems;

public class ElvenGateway
{
    public static void init()
    {
        BotaniaAPI.registerElvenTradeRecipe(new ItemStack(ModItems.itemGreenHeart), new ItemStack(ModItems.itemInfusedHeart));
    }
}
