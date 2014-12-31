package eviltalkingpie.pandemicraft.proxy;

import net.minecraftforge.client.event.TextureStitchEvent.Post;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ServerProxy extends CommonProxy
{
    @SideOnly(Side.CLIENT)
    @Override
    public void initializeIcons(Post event)
    {
        // TODO Auto-generated method stub
    }
}
