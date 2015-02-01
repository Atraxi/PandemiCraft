package eviltalkingpie.pandemicraft.item;

import net.minecraft.util.EnumChatFormatting;

public class ItemSimple extends ItemBase
{
    public ItemSimple(String name, int maxStackSize, String research, EnumChatFormatting format)
    {
        super(name, research, format);
        setMaxStackSize(maxStackSize);
    }
    
    public ItemSimple(String name, int maxStackSize, String research)
    {
        this(name, maxStackSize, research, null);
    }
    
    public ItemSimple(String name, int maxStackSize)
    {
        this(name, maxStackSize, "");
    }
    
    public ItemSimple(String name, int maxStackSize, EnumChatFormatting format)
    {
        this(name, maxStackSize, "", format);
    }
}
