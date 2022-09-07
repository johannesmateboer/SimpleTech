package net.simpletech.block;

import net.minecraft.item.Item;
import net.simpletech.util.Dropresults;

import java.util.ArrayList;
import java.util.Random;

public class SieveGold extends Sieve {

    public SieveGold(Settings settings) {
        super(settings);
    }

    @Override
    public ArrayList<Item> getDropitems() {
        return Dropresults.ITEMS_GOLD;
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
