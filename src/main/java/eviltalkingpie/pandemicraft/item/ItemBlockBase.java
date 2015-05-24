/**
 * 
 */
package eviltalkingpie.pandemicraft.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Atraxi
 *
 */
public class ItemBlockBase extends ItemBlock
{
    public ItemBlockBase(Block p_i45328_1_)
    {
        super(p_i45328_1_);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        list.add(StatCollector.translateToLocal(this.getUnlocalizedName() + ".flavorText"));
    }
}
