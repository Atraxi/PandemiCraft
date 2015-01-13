package eviltalkingpie.pandemicraft.blocks;

import net.minecraft.block.material.Material;

public class BlockSimple extends BlockBase
{
    public BlockSimple(String name, Material material, float blockHardness, float blockResistance)
    {
        super(material, name);
        setHardness(blockHardness);
        setResistance(blockResistance);
    }
}
