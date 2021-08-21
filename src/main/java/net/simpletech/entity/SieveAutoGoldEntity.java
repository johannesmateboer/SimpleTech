package net.simpletech.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.simpletech.block.SieveProperties;
import net.simpletech.init.SieveBlocks;
import net.simpletech.util.Dropresults;
import net.simpletech.util.SieveUtil;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class SieveAutoGoldEntity extends BlockEntity {

    private static int ticker = 0;
    private final ArrayList<Item> dropResults = Dropresults.ITEMS_GOLD;

    public SieveAutoGoldEntity(BlockPos pos, BlockState state) {
        super(SieveBlocks.SIEVE_AUTO_GOLD_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SieveAutoGoldEntity blockEntity) {
        if (!world.isClient() && ticker++ % 40 == 0) {
            boolean isActive = false;

            Direction direction = blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING);
            if (world.getBlockEntity(pos.offset(direction.rotateClockwise(Direction.Axis.Y))) instanceof Inventory) {
                Inventory targetInventory = (Inventory) world.getBlockEntity(pos.offset(direction.rotateClockwise(Direction.Axis.Y)));
                for (int i = 0; i < targetInventory.size(); i++) {
                    ItemStack targetStack = targetInventory.getStack(i);
                    if (Objects.equals(targetStack.getItem(), Blocks.DIRT.asItem())) {
                        isActive = true;
                        targetStack.decrement(1);
                        BlockPos exitPos = pos.offset(direction.rotateCounterclockwise(Direction.Axis.Y));
                        if (blockEntity.shouldDrop()) {
                            SieveUtil.insertOrDrop(world, exitPos, blockEntity.getDroplist());
                        }
                        break;
                    }
                }
            }
            world.setBlockState(pos, blockEntity.getCachedState().with(SieveProperties.ACTIVE, isActive));
        }
    }

    private boolean shouldDrop() {
        Random rnd = new Random();
        return rnd.nextBoolean();
    }

    private ArrayList<Item> getDroplist() {
        return this.dropResults;
    }

}
