package eviltalkingpie.pandemicraft.proxy;

import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ServerProxy extends CommonProxy
{
    @Override
    @SideOnly(Side.CLIENT)
    public void initializeIcons(Pre event)
    {
    }
}
