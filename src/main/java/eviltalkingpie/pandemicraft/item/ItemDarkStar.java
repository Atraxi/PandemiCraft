package eviltalkingpie.pandemicraft.item;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDarkStar extends ItemBase
{
    public ItemDarkStar(String name, String research)
    {
        super(name, research, null);
        maxStackSize = 64;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack itemStack)
    {
        return true;
    }
}
