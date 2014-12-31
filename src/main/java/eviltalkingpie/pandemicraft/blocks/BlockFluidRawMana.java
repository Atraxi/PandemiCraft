package eviltalkingpie.pandemicraft.blocks;

import net.minecraft.block.material.Material;
import eviltalkingpie.pandemicraft.init.ModFluids;

public class BlockFluidRawMana extends BlockFluidBase
{
    public BlockFluidRawMana()
    {
        super(ModFluids.fluidRawMana, Material.water, "rawMana");
        setQuantaPerBlock(5);
    }
}
