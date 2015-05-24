/**
 * 
 */
package eviltalkingpie.pandemicraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * @author Atraxi
 *
 */
public class ItemRealityCrack extends ItemSimple
{
    
    /**
     * @param name
     * @param stackSize
     *            Research requirements for recipes and tooltips
     * @param research
     *            Any special formatting to be applied to the tooltip
     */
    public ItemRealityCrack(String name, int stackSize, String research)
    {
        super(name, stackSize, research);
    }
    
    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
    {
        if (entity instanceof EntityLivingBase)
        {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.hunger.getId(), 100, 1, true));
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(), 100, 1, true));
        }
    }
}
