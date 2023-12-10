package net.simpletech.block;

import net.minecraft.item.Item;
import net.simpletech.util.Dropresults;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class SieveGold extends Sieve {

    public SieveGold(Settings settings) {
        super(settings);
    }

    @Override
    public Collection<Item> getDropresultsList() {
        return Dropresults.ITEMS_GOLD;
    }

    /**
     * Less chance, more result.
     *
     * @return bool
     */
    @Override
    public boolean shouldDrop() {
        return ThreadLocalRandom.current().nextInt(10) > 6;
    }
}
