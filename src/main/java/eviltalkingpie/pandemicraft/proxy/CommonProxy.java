package eviltalkingpie.pandemicraft.proxy;

import net.minecraftforge.client.event.TextureStitchEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class CommonProxy
{
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public abstract void initializeIcons(TextureStitchEvent.Post event);
}
