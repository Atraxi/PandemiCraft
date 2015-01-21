package eviltalkingpie.pandemicraft.utility;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Util
{
    public static ItemStack setNBTString(ItemStack item, String tagName, String tag)
    {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString(tagName, tag);
        item.setTagCompound(nbt);
        return item;
    }
    
    public static ItemStack setNBTInteger(ItemStack item, String tagName, int tag)
    {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger(tagName, tag);
        item.setTagCompound(nbt);
        return item;
    }
    
    public static ItemStack setNBTByte(ItemStack item, String tagName, byte tag)
    {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setByte(tagName, tag);
        item.setTagCompound(nbt);
        return item;
    }
    
    public static ItemStack setNBTCompound(ItemStack item, String tagName, NBTTagCompound tag)
    {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag(tagName, tag);
        item.setTagCompound(nbt);
        return item;
    }
}
