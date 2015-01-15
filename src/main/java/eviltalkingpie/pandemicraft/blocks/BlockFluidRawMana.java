package eviltalkingpie.pandemicraft.blocks;

import net.minecraft.block.material.Material;
import eviltalkingpie.pandemicraft.init.ModFluids;

public class BlockFluidRawMana extends BlockFluidBase
{
    public BlockFluidRawMana(String name)
    {
        super(ModFluids.fluidRawMana, Material.water, name);
        setQuantaPerBlock(5);
    }
}
