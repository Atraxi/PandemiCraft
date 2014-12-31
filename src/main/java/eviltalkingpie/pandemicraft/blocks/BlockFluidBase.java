package eviltalkingpie.pandemicraft.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.reference.Reference;

public class BlockFluidBase extends BlockFluidClassic
{
    public BlockFluidBase(Fluid fluid, Material material, String name)
    {
        super(fluid, material);
        setBlockName(name);
        setBlockTextureName(name);
    }
    
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return ((side == 0) || (side == 1)) ? stillIcon : flowingIcon;
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":",
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
        stillIcon = iconRegister.registerIcon(String.format("%s",
                getUnwrappedUnlocalizedName(getUnlocalizedName())));
        flowingIcon = iconRegister
                .registerIcon(String.format("%s",
                        getUnwrappedUnlocalizedName(getUnlocalizedName()))
                        + "_flowing");
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
        {
            return false;
        }
        return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z).getMaterial().isLiquid())
        {
            return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }
}
