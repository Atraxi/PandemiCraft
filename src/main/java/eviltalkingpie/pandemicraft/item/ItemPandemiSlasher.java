package eviltalkingpie.pandemicraft.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import thaumcraft.api.IRepairableExtended;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import eviltalkingpie.pandemicraft.PandemiCraft;
import eviltalkingpie.pandemicraft.utility.Logger;
import eviltalkingpie.pandemicraft.utility.Reference;

public class ItemPandemiSlasher extends ItemSword implements IRepairableExtended
{
    private static IIcon broken;
    
    public ItemPandemiSlasher(String name)
    {
        super(PandemiCraft.denseTool);
        this.setUnlocalizedName(name);
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
                    stack.addEnchantment(Enchantment.knockback, 5);
                }
                entity.attackEntityFrom(DamageSource.outOfWorld, ((EntityLiving) entity).getMaxHealth() / 2);
            }
            else if (stack.getItemDamage() == 25)
            {
                entity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player), 5);
            }
        }
        return false;
    }
    
    @Override
    public void onUpdate(ItemStack stack, World world, Entity player, int p_77663_4_, boolean p_77663_5_)
    {
        if (player instanceof EntityPlayer && stack.getItemDamage() == 25)
        {
            ((EntityPlayer) player).addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 2));
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
                stack.addEnchantment(Enchantment.knockback, 5);
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
}
