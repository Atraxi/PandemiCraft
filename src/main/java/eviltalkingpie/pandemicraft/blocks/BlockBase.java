package eviltalkingpie.pandemicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block
{
    protected BlockBase(Material material, String name)
    {
        super(material);
        setBlockName(name);
    }
}
