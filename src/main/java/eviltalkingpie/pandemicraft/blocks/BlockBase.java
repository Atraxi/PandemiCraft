package eviltalkingpie.pandemicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.utility.Reference;

public class BlockBase extends Block
{
    protected BlockBase(Material material, String name)
    {
        super(material);
        setBlockName(name);
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
                getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        stillIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(getUnlocalizedName())));
        flowingIcon =
                iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(getUnlocalizedName())) + "_flowing");
    }
}
