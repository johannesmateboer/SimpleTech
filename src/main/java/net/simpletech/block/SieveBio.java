package net.simpletech.block;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.simpletech.util.Dropresults;

public class SieveBio extends Sieve{

    public SieveBio(Settings settings) {
        super(settings);
    }

    @Override
    public void doDropResult(World world, BlockPos pos) {
        Item randomItem = Dropresults.getRandomBioItem();
        if (randomItem != null) {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(randomItem, 1));
        }
    }
}
