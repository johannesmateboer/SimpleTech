package net.simpletech.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;

public class InventoryUtil {

    /**
     * Tries to merge or insert to an Inventory
     * @param sourceStack       The stack that must be inserted or merged
     * @param targetInventory   The target-inventory
     * @param direction         The direction which the target should accept from
     * @return                  True when insert/merge is successful, false, if not.
     */
    public static Boolean insertOrMerge(ItemStack sourceStack, Inventory targetInventory, Direction direction) {
        for (int i = 0; i < targetInventory.size(); i++) {
            ItemStack targetStack = targetInventory.getStack(i);
            if (targetInventory instanceof SidedInventory && !((SidedInventory) targetInventory).canInsert(i, targetStack, direction)) {
                continue;
            }
            if (targetStack.getItem() == sourceStack.getItem()) {
                // Can we merge the items?
                int available = targetStack.getMaxCount() - targetStack.getCount();
                if (available >= sourceStack.getCount()) {
                    targetStack.setCount(targetStack.getCount() + sourceStack.getCount());
                    targetInventory.markDirty();
                    return true;
                }
            }else if (targetStack.isEmpty()) {
                targetInventory.setStack(i, sourceStack);
                targetInventory.markDirty();
                return true;
            }
        }
        return false;
    }
}

