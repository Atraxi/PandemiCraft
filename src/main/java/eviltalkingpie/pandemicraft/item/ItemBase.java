package eviltalkingpie.pandemicraft.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import thaumcraft.api.ThaumcraftApiHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.utility.Reference;

public abstract class ItemBase extends Item
{
    private final String             researchKey;
    private final EnumChatFormatting tooltipFormat;
    
    public ItemBase(String name, String research, EnumChatFormatting format)
    {
        super();
        setUnlocalizedName(name);
        setMaxStackSize(1);
        researchKey = research;
        tooltipFormat = format;
    }
    
    public String getResearch()
    {
        return researchKey;
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
        if (researchKey.equals("")
                || ((!researchKey.equals("")) && ThaumcraftApiHelper.isResearchComplete(player.getDisplayName(), researchKey)))
        {
            String flavorText = StatCollector.translateToLocal(this.getUnlocalizedName() + ".flavorText");
            
            if (!flavorText.equals(this.getUnlocalizedName() + ".flavorText") && !flavorText.equals(""))
            {
                list.add(tooltipFormat != null ? tooltipFormat + flavorText : flavorText);
                flavorText = StatCollector.translateToLocal(this.getUnlocalizedName() + ".flavorText2");
                if (!flavorText.equals(this.getUnlocalizedName() + ".flavorText2") && !flavorText.equals(""))
                {
                    list.add(flavorText);
                }
            }
        }
        else
        {
            list.add(StatCollector.translateToLocal("flavorText.research." + researchKey));
        }
    }
}
