package eviltalkingpie.pandemicraft.item;

import java.lang.reflect.Field;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import thaumcraft.api.IRepairableExtended;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.PandemiCraft;
import eviltalkingpie.pandemicraft.utility.Logger;
import eviltalkingpie.pandemicraft.utility.Reference;

public class ItemPandemiSlasher extends ItemSword implements IRepairableExtended
{
    private static IIcon       broken;
    Field                      damage;
    
    public static ToolMaterial denseTool = EnumHelper.addToolMaterial("denseTool", 5, 25, 50, 0, 50);
    
    public ItemPandemiSlasher(String name)
    {
        super(denseTool);
        this.setUnlocalizedName(name);
        setDamage(0f);
    }
    
    private void setDamage(float f)
    {
        
        try
        {
            if (damage == null)
            {
                damage = this.getClass().getSuperclass().getDeclaredField("field_150934_a");
                damage.setAccessible(true);
            }
            damage.setFloat(this, f);
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
    
    /**
     * Set the weapon properties for the 'broken' state (when stack damage==25)
     * 
     * @param stack
     */
    private void setBroken(ItemStack stack)
    {
        stack.addEnchantment(Enchantment.knockback, 5);
        setDamage(5);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon =
                iconRegister.registerIcon(Reference.MOD_ID + ":"
                        + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
        broken = iconRegister.registerIcon(Reference.MOD_ID + ":" + "brokenPandemiSlasher");
    }
    
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase player)
    {
        if (entity instanceof EntityLiving && !(entity instanceof EntityPlayer))
        {
            if (stack.getItemDamage() < 25)
            {
                stack.damageItem(1, player);
                if (stack.getItemDamage() == 25)
                {
                    setBroken(stack);
                }
                
                entity.attackEntityFrom(DamageSource.outOfWorld, ((EntityLiving) entity).getMaxHealth() / 2);
                
            }
            else if (stack.getItemDamage() == 25)
            {
                entity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player), 5);
            }
        }
        return true;
    }
    
    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
    {
        if (entity instanceof EntityLivingBase && stack.getItemDamage() == 25)
        {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 0, 1));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
        if (damage < 25)
        {
            return itemIcon;
        }
        else
        {
            return broken;
        }
    }
    
    @Override
    public boolean doRepair(ItemStack stack, EntityPlayer player, int enchantlevel)
    {
        if (stack.getItemDamage() < 25)
        {
            stack.setItemDamage(Math.max(stack.getItemDamage(), 0));
            return true;
        }
        else
        {
            NBTTagList enchants = stack.getEnchantmentTagList();
            for (int i = 0; i < enchants.tagCount(); i++)
            {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setShort("lvl", (short) 5);
                tag.setShort("id", (short) 19);
                Logger.info(tag);
                if (enchants.getCompoundTagAt(i).equals(tag))
                {
                    enchants.removeTag(i);
                }
            }
            Logger.info(enchants);
            stack.setItemDamage(24);
            setDamage(0);
            return true;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean showDurabilityBar(ItemStack stack)
    {
        if (stack.getItemDamage() == 25)
        {
            return false;
        }
        else
        {
            return stack.isItemDamaged();
        }
    }
    
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_,
            int p_150894_6_, EntityLivingBase p_150894_7_)
    {
        if (p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
        {
            if (stack.getItemDamage() < 24)
            {
                stack.damageItem(2, p_150894_7_);
            }
            else if (stack.getItemDamage() < 25)
            {
                stack.damageItem(1, p_150894_7_);
            }
            if (stack.getItemDamage() == 25)
            {
                setBroken(stack);
            }
        }
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_)
    {
        if (stack.getItemDamage() == 25)
        {
            list.add(StatCollector.translateToLocal(this.getUnlocalizedName() + "Broken.flavorText"));
        }
        else
        {
            list.add(StatCollector.translateToLocal(this.getUnlocalizedName() + ".flavorText"));
        }
    }
    
    //@formatter:off
    @Override
    public Multimap getAttributeModifiers(ItemStack stack)
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        boolean isTooltip;
        if(PandemiCraft.deobf)
        {
            isTooltip = stackTraceElements[3].getMethodName().equals("getTooltip");
        }
        else
        {
            isTooltip = stackTraceElements[3].getMethodName().equals("func_82840_a");
        }
        
//        Logger.info("Stacktrace:");
//        for (StackTraceElement element : stackTraceElements)
//        {
//            Logger.info(element);
//        }
        
        if(stackTraceElements.length>0 && isTooltip)
        {
            Multimap multimap = super.getAttributeModifiers(stack);
            if (stack.getItemDamage() < 25)
            {
                multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(
                        field_111210_e, "Weapon modifier", Item.itemRand.nextInt(90) + 10, 0));
            }
            else
            {
                multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(
                        field_111210_e, "Weapon modifier", 5, 0));
            }
            return multimap;
        }
        else
        {
            return HashMultimap.create();
        }
    }
    
    @Override
    public Multimap getItemAttributeModifiers()
    {
        return HashMultimap.create();
    }
    //@formatter:on
}
