package net.simpletech.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.simpletech.block.SieveProperties;
import net.simpletech.init.SieveBlocks;
import net.simpletech.util.Dropresults;
import net.simpletech.util.SieveUtil;

import java.util.Objects;
import java.util.Random;

public class SieveAutoNetherEntity extends BlockEntity {

    private final Random rnd = new Random();

    public SieveAutoNetherEntity(BlockPos pos, BlockState state) {
        super(SieveBlocks.SIEVE_AUTO_NETHER_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SieveAutoNetherEntity blockEntity) {
        if (!world.isClient() && world.getTime() % 40L == 0L) {
            boolean isActive = false;
            Direction direction = blockEntity.getCachedState().get(Properties.HORIZONTAL_FACING);

            if (world.getBlockEntity(pos.offset(direction.rotateClockwise(Direction.Axis.Y))) instanceof Inventory targetInventory) {
                for (int i = 0; i < targetInventory.size(); i++) {
                    ItemStack targetStack = targetInventory.getStack(i);
                    if (Objects.equals(targetStack.getItem(), Blocks.NETHERRACK.asItem())) {
                        isActive = true;
                        targetStack.decrement(1);
                        BlockPos exitPos = pos.offset(direction.rotateCounterclockwise(Direction.Axis.Y));
                        if (blockEntity.shouldDrop()) {
                            SieveUtil.insertOrDrop(world, exitPos, Dropresults.ITEMS_NETHER);
                        }
                        break;
                    }
                }
            }
            world.setBlockState(pos, blockEntity.getCachedState().with(SieveProperties.ACTIVE, isActive));
        }
    }

    /**
     * Less change, it's a nether thing
     * @return
     */
    public boolean shouldDrop() {
        return rnd.nextInt(1,10) >= 7;
    }
}
