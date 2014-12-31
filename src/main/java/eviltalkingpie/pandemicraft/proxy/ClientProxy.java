package eviltalkingpie.pandemicraft.proxy;

import net.minecraftforge.client.event.TextureStitchEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.init.ModFluids;

public class ClientProxy extends CommonProxy
{
    @Override
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void initializeIcons(TextureStitchEvent.Post event)
    {
        ModFluids.fluidRawMana
        .setIcons(ModFluids.fluidRawMana.getBlock().getIcon(0, 0),
                ModFluids.fluidRawMana.getBlock().getIcon(3, 0));
    }
}
