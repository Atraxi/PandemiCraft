/**
 * Copyright (c) SpaceToad, 2011 http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License
 * 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package eviltalkingpie.pandemicraft.handler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BucketHandler
{
    public static BucketHandler      INSTANCE = new BucketHandler();
    public static BiMap<Block, Item> buckets  = HashBiMap.create();
    
    private BucketHandler()
    {
    }
    
    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event)
    {
        ItemStack result = fillCustomBucket(event.world, event.target);
        if (result == null)
        {
            return;
        }
        event.result = result;
        event.setResult(Event.Result.ALLOW);
    }
    
    private ItemStack fillCustomBucket(World world, MovingObjectPosition pos)
    {
        Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
        Item bucket = buckets.get(block);
        if ((bucket != null)
                && (world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0))
        {
            world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
            return new ItemStack(bucket);
        }
        else
        {
            return null;
        }
    }
    
    public static boolean emptyBucket(World world, int x, int y, int z,
            ItemStack bucket)
    {
        boolean r = false;
        if (!buckets.inverse().containsKey(bucket.getItem()))
        {
            if (bucket.getItem() instanceof ItemBucket)
            {
                r = ((ItemBucket) bucket.getItem()).tryPlaceContainedLiquid(
                        world, x, y, z);
                world.markBlockForUpdate(x, y, z);
            }
            return r;
        }
        Block result = buckets.inverse().get(bucket.getItem());
        Material material = world.getBlock(x, y, z).getMaterial();
        boolean solid = !material.isSolid();
        if (world.isAirBlock(x, y, z) || solid)
        {
            if (!world.isRemote && solid && !material.isLiquid())
            {
                world.func_147480_a(x, y, z, true);
            }
            r = world.setBlock(x, y, z, result); // this can fail
            world.markBlockForUpdate(x, y, z);
        }
        return r;
    }
}