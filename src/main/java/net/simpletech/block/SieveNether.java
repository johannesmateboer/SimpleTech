package net.simpletech.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.simpletech.util.Dropresults;

import java.util.ArrayList;

public class SieveNether extends Sieve {

    public SieveNether(Settings settings) {
        super(settings);
    }

    @Override
    public ArrayList<Item> getDropresultsList() {
        return Dropresults.ITEMS_NETHER;
    }

    @Override
    public Block getFilterBlock() {
        return Blocks.NETHERRACK;
    }
}
