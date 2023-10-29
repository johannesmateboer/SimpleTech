package net.simpletech.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.simpletech.util.Dropresults;

import java.util.Collection;

public class SieveEnd extends Sieve {

    public SieveEnd(Settings settings) {
        super(settings);
    }

    @Override
    public Collection<Item> getDropresultsList() {
        return Dropresults.ITEMS_END;
    }

    @Override
    public Block getFilterBlock() {
        return Blocks.END_STONE;
    }
}
