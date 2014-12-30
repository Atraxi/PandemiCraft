package eviltalkingpie.pandemicraft.blocks;

import eviltalkingpie.pandemicraft.init.ModFluids;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidRawMana extends BlockFluidBase
{
    public BlockFluidRawMana()
    {
        super(ModFluids.fluidRawMana, Material.water, "rawMana");
    }
}
