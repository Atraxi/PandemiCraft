package eviltalkingpie.pandemicraft.fluids;

import net.minecraftforge.fluids.Fluid;
import eviltalkingpie.pandemicraft.init.ModBlocks;
import eviltalkingpie.pandemicraft.init.ModItems;
import eviltalkingpie.pandemicraft.utility.Logger;

public class FluidRawMana extends Fluid
{

    public FluidRawMana()
    {
        super("fluidRawMana");
        this.setLuminosity(10);
        this.setDensity(1500);
        this.setTemperature(310);
        this.setViscosity(2500);
        this.setGaseous(true);
        
        //this.setParticleColor(0.2F, 0.0F, 0.4F);
        
        this.setBlock(ModBlocks.blockFluidRawMana);
    }
}
