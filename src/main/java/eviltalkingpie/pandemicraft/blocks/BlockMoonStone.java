package eviltalkingpie.pandemicraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import eviltalkingpie.pandemicraft.init.ModItems;

public class BlockMoonStone extends BlockBase
{
    public BlockMoonStone(String name)
    {
        super(Material.rock, name);
        setHardness(5f);
        setResistance(500);
        setLightLevel(0.5f);
    }
    
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ModItems.itemLunarSlime;
    }
}
