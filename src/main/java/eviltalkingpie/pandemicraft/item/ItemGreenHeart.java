package eviltalkingpie.pandemicraft.item;

import net.minecraft.item.ItemStack;
import vazkii.botania.api.recipe.IElvenItem;

public class ItemGreenHeart extends ItemBase implements IElvenItem
{
    public ItemGreenHeart(String name)
    {
        super(name);
        setMaxStackSize(16);
    }
    
    @Override
    public boolean isElvenItem(ItemStack item)
    {
        return true;
    }
    
    // TODO when eaten fully heal player, and provide absorbtion effect
}
