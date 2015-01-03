package eviltalkingpie.pandemicraft.tinkers;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import eviltalkingpie.pandemicraft.init.ModFluids;

public class Melting
{
    public static void postInit()
    {
        NBTTagCompound tag = new NBTTagCompound();
        // the item
        NBTTagCompound item = new NBTTagCompound();
        ItemStack ring = new ItemStack(GameRegistry.findItem("Botania", "manaRingGreater"));
        NBTTagCompound manaTag = new NBTTagCompound();
        manaTag.setInteger("mana", 2000000);
        ring.setTagCompound(manaTag);
        ring.setItemDamage(0);
        ring.writeToNBT(item); // greater band of mana
        tag.setTag("Item", item);
        // the block to render
        item = new NBTTagCompound();
        // The block to render while smelting
        (new ItemStack(TinkerSmeltery.smeltery, 1, 4)).writeToNBT(item);
        tag.setTag("Block", item);
        // liquid to produce. The amount DOES matter!
        (new FluidStack(ModFluids.fluidRawMana, 250)).writeToNBT(tag);
        // the temperature required
        tag.setInteger("Temperature", 1300);
        FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", tag);
    }
}
