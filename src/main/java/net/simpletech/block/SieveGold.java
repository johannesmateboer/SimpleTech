package net.simpletech.block;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.simpletech.util.Dropresults;

import java.util.Random;

public class SieveGold extends Sieve {

    public SieveGold(Settings settings) {
        super(settings);
    }

    @Override
    public void doDropResult(World world, BlockPos pos) {
        Item randomItem = Dropresults.getRandomGoldItem();
        if (randomItem != null) {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(randomItem, 1));
        }
    }

    /**
     * Less chance, more result.
     *
     * @return bool
     */
    @Override
    public boolean shouldDrop() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        return n > 6;
    }
}
