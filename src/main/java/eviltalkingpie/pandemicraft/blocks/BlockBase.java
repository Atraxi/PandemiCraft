package eviltalkingpie.pandemicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.utility.Reference;

public abstract class BlockBase extends Block
{
    protected BlockBase(Material material, String name)
    {
        super(material);
        setBlockName(name);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon =
                iconRegister.registerIcon(Reference.MOD_ID + ":"
                        + getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1));
    }
}
