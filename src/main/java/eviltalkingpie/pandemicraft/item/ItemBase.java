package eviltalkingpie.pandemicraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.utility.Reference;

public abstract class ItemBase extends Item
{
    public ItemBase(String name)
    {
        super();
        setUnlocalizedName(name);
        setMaxStackSize(1);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon =
                iconRegister.registerIcon(Reference.MOD_ID + ":"
                        + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        list.add(StatCollector.translateToLocal(this.getUnlocalizedName() + ".flavorText"));
    }
}
