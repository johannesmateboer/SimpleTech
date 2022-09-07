package net.simpletech.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.simpletech.util.Dropresults;

public class SieveNether extends Sieve {

    public SieveNether(Settings settings) {
        super(settings);
    }

    @Override
    public void doDropResult(World world, BlockPos pos) {
        Item randomItem = Dropresults.getRandomItem(Dropresults.ITEMS_NETHER);
        if (randomItem != null) {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(randomItem, 1));
        }
    }

    @Override
    public Block getFilterBlock() {
        return Blocks.NETHERRACK;
    }
}
