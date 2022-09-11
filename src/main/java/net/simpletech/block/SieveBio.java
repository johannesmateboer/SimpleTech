package net.simpletech.block;

import net.minecraft.item.Item;
import net.simpletech.util.Dropresults;

import java.util.ArrayList;

public class SieveBio extends Sieve{

    public SieveBio(Settings settings) {
        super(settings);
    }

    @Override
    public ArrayList<Item> getDropresultsList() {
        return Dropresults.ITEMS_BIO;
    }

}
