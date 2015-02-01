package eviltalkingpie.pandemicraft.proxy;

import java.lang.reflect.Field;

import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.PandemiCraft;
import eviltalkingpie.pandemicraft.handler.ConfigurationHandler;
import eviltalkingpie.pandemicraft.utility.Reference;

public class ClientProxy extends CommonProxy
{
    @Override
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void initializeIcons(Pre event)
    {
        if (ConfigurationHandler.prankJarren)
        {
            IIcon itemIcon = event.map.registerIcon(Reference.MOD_ID + ":" + "jarrenPick");
            try
            {
                Field icon;
                if (PandemiCraft.deobf)
                {
                    icon = Items.wooden_pickaxe.getClass().getSuperclass().getSuperclass().getDeclaredField("itemIcon");
                }
                else
                {
                    icon = Items.wooden_pickaxe.getClass().getSuperclass().getSuperclass().getDeclaredField("field_77791_bV");
                }
                icon.setAccessible(true);
                icon.set(Items.wooden_pickaxe, itemIcon);
            }
            catch (NoSuchFieldException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (SecurityException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalArgumentException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
