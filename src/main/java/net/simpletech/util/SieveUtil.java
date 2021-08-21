package net.simpletech.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class SieveUtil {

    /**
     * Inserts into an attached inventory, or drops the item in the world
     * @param world The World
     * @param pos   The targetposition
     */
    public static void insertOrDrop(World world, BlockPos pos) {
        Item randomItem = Dropresults.getRandomItem();
        if (randomItem != null) {
            if (world.getBlockEntity(pos) instanceof Inventory targetInventory) {
                if (InventoryUtil.insertOrMerge(new ItemStack(randomItem, 1), targetInventory, Direction.UP)) {
                    return;
                }
            }
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(randomItem, 1));
        }
    }
}
