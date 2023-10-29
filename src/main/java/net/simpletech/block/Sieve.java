package net.simpletech.block;

import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.simpletech.util.Dropresults;
import net.simpletech.util.VoxelUtil;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("deprecation")
public class Sieve extends Block {

    public Sieve(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(SieveProperties.PROGRESS, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        // Set the available properties
        stateManager.add(SieveProperties.PROGRESS);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    /**
     * Which block triggers the sieve?
     * @return
     */
    public Block getFilterBlock() {
        return Blocks.DIRT;
    }

    /**
     * Returns the droplist for this specific sieve
     * @return
     */
    public Collection<Item> getDropresultsList() {
        return Dropresults.ITEMS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState, BlockView blockView, BlockPos blockPos, ShapeContext entityContext) {
        // Set the bounding-box
        return VoxelUtil.createCuboid(0, 0, 0, 16, 16, 16);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int currentState = state.get(SieveProperties.PROGRESS);
        int targetProgress;

        // Check if the player is holding dirt and the sieve is empty
        if (currentState == 0) {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.isEmpty() || !Objects.equals(stack.getItem(), getFilterBlock().asItem())) {
                return ActionResult.PASS;
            } else {
                // Take a dirt-block from the non-Creative player
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                    player.setStackInHand(hand, stack);
                }
            }
        }
        currentState = currentState + 1;
        if (currentState > 3) {
            // Do the drop of items
            if (shouldDrop()) {
                doDropResult(world, pos);
            }
            targetProgress = 0;
        } else {
            targetProgress = currentState;
        }
        world.setBlockState(pos, state.with(SieveProperties.PROGRESS, targetProgress));
        return ActionResult.success(world.isClient);
    }

    public boolean shouldDrop() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    /**
     * Returns the dropresults as tags
     * @param world
     * @param pos
     */
    public void doDropResult(World world, BlockPos pos) {
        Item randomItem = Dropresults.getRandomItem(getDropresultsList());
        if (randomItem != null) {
            // This is how vanilla spawns composter outputs; it avoids spawning beneath the sieve.
            Vec3d spawnPos = Vec3d.add(pos, 0.5, 1.01, 0.5).addRandom(world.random, 0.6f);
            ItemEntity itemEntity = new ItemEntity(world, spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), new ItemStack(randomItem));
            itemEntity.setToDefaultPickupDelay();
            world.spawnEntity(itemEntity);
        }
    }
}
