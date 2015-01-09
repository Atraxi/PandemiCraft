package eviltalkingpie.pandemicraft.item;

import net.minecraft.item.ItemStack;
import vazkii.botania.api.recipe.IElvenItem;

public class ItemGreenHeart extends ItemBase implements IElvenItem
{
    public ItemGreenHeart()
    {
        super("greenHeart");
        setMaxStackSize(16);
    }
    
    @Override
    public boolean isElvenItem(ItemStack item)
    {
        return true;
    }
}
