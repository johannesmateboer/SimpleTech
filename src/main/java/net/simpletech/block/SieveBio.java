package net.simpletech.block;

import net.minecraft.item.Item;
import net.simpletech.util.Dropresults;

import java.util.Collection;

public class SieveBio extends Sieve {

    public SieveBio(Settings settings) {
        super(settings);
    }

    @Override
    public Collection<Item> getDropresultsList() {
        return Dropresults.ITEMS_BIO;
    }
}
