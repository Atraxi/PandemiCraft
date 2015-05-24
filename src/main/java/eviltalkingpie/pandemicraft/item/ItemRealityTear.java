/**
 * 
 */
package eviltalkingpie.pandemicraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * @author Atraxi
 *
 */
public class ItemRealityTear extends ItemSimple
{
    
    /**
     * @param string
     * @param i
     * @param string2
     */
    public ItemRealityTear(String name, int maxStackSize, String research)
    {
        super(name, maxStackSize, research);
    }
    
    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
    {
        if (entity instanceof EntityLivingBase)
        {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.blindness.getId(), 100, 3, true));
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.wither.getId(), 100, 0, true));
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(), 100, 1, true));
            if (Item.itemRand.nextInt(300) == 1)
            {
                world.spawnEntityInWorld(new EntityLightningBolt(world, entity.lastTickPosX, entity.lastTickPosY,
                        entity.lastTickPosZ));
            }
        }
    }
}
