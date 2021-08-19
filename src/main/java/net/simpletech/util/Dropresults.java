package net.simpletech.util;

import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class Dropresults {

    // Holds all tags which should be loaded
    private static final ArrayList<String> DROPTAGS = new ArrayList<>();
    private static final ArrayList<String> BIO_DROPTAGS = new ArrayList<>();
    private static final ArrayList<String> GOLD_DROPTAGS = new ArrayList<>();

    // Holds the retrieved items
    private static final ArrayList<Item> ITEMS = new ArrayList<>();
    private static final ArrayList<Item> ITEMS_BIO = new ArrayList<>();
    private static final ArrayList<Item> ITEMS_GOLD = new ArrayList<>();

    private static boolean isNuggetLoaded = false;
    private static boolean isBioLoaded = false;
    private static boolean isGoldLoaded = false;

    public static void init() {
        initNuggetlist();
        initBioList();
        initGoldList();
    }

    /**
     * Returns a random item from the loaded list
     * @return  Item    The provided item
     */
    public static Item getRandomItem() {
        loadDropresults();
        if (ITEMS.size() > 0) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(ITEMS.size());
            return ITEMS.get(randomIndex);
        }else{
            return null;
        }
    }

    /**
     * Returns a random bio-item from the loaded list
     * @return  Item    The provided item
     */
    public static Item getRandomBioItem() {
        loadBioresults();
        if (ITEMS_BIO.size() > 0) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(ITEMS_BIO.size());
            return ITEMS_BIO.get(randomIndex);
        }else{
            return null;
        }
    }

    /**
     * Returns a random bio-item from the loaded list
     * @return  Item    The provided item
     */
    public static Item getRandomGoldItem() {
        loadGoldresults();
        if (ITEMS_GOLD.size() > 0) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(ITEMS_GOLD.size());
            return ITEMS_GOLD.get(randomIndex);
        }else{
            return null;
        }
    }

    /**
     * Load dropresults for nuggets
     */
    private static void loadDropresults() {
        if (isNuggetLoaded) {
            return;
        }
        for (String dropTag : DROPTAGS) {
            String[] dropTagParts = dropTag.split(Pattern.quote(":"));
            Identifier tagIdentifier = new Identifier(dropTagParts[0], dropTagParts[1]);
            Tag<Item> itemTag = ItemTags.getTagGroup().getTagOrEmpty(tagIdentifier);

            if (itemTag != null) {
                for (Item checkItem : itemTag.values()) {
                    if (!ITEMS.contains(checkItem)) {
                        ITEMS.add(checkItem);
                    }
                }
            }
        }
        isNuggetLoaded = true;
    }

    /**
     * Load dropresults for BIO
     */
    private static void loadBioresults() {
        if (isBioLoaded) {
            return;
        }
        for (String dropTag : BIO_DROPTAGS) {
            String[] dropTagParts = dropTag.split(Pattern.quote(":"));
            Identifier tagIdentifier = new Identifier(dropTagParts[0], dropTagParts[1]);
            Tag<Item> itemTag = ItemTags.getTagGroup().getTagOrEmpty(tagIdentifier);

            if (itemTag != null) {
                for (Item checkItem : itemTag.values()) {
                    if (!ITEMS_BIO.contains(checkItem)) {
                        ITEMS_BIO.add(checkItem);
                    }
                }
            }
        }
        isBioLoaded = true;
    }

    /**
     * Load dropresults for Gold Sieve
     */
    private static void loadGoldresults() {
        if (isGoldLoaded) {
            return;
        }
        for (String dropTag : GOLD_DROPTAGS) {
            String[] dropTagParts = dropTag.split(Pattern.quote(":"));
            Identifier tagIdentifier = new Identifier(dropTagParts[0], dropTagParts[1]);
            Tag<Item> itemTag = ItemTags.getTagGroup().getTagOrEmpty(tagIdentifier);

            if (itemTag != null) {
                for (Item checkItem : itemTag.values()) {
                    if (!ITEMS_GOLD.contains(checkItem)) {
                        ITEMS_GOLD.add(checkItem);
                    }
                }
            }
        }
        isGoldLoaded = true;
    }

    private static void initNuggetlist() {
        DROPTAGS.add("c:iron_nuggets");
        DROPTAGS.add("c:invar_nuggets");
        DROPTAGS.add("c:iridium_nuggets");
        DROPTAGS.add("c:lead_nuggets");
        DROPTAGS.add("c:manganese_nuggets");
        DROPTAGS.add("c:nickel_nuggets");
        DROPTAGS.add("c:platinum_nuggets");
        DROPTAGS.add("c:refined_iron_nuggets");
        DROPTAGS.add("c:iron_dusts");
        DROPTAGS.add("c:silicon_nuggets");
        DROPTAGS.add("c:silver_nuggets");
        DROPTAGS.add("c:sodium_nuggets");
        DROPTAGS.add("c:steel_nuggets");
        DROPTAGS.add("c:tin_nuggets");
        DROPTAGS.add("c:titanium_nuggets");
        DROPTAGS.add("c:tungsten_nuggets");
        DROPTAGS.add("c:tungstensteel_nuggets");
        DROPTAGS.add("c:zinc_nuggets");
        DROPTAGS.add("c:gold_dusts");
        DROPTAGS.add("c:tin_tiny_dusts");
        DROPTAGS.add("c:titanium_tiny_dusts");
        DROPTAGS.add("c:aluminum_tiny_dusts");
        DROPTAGS.add("c:antimony_tiny_dusts");
        DROPTAGS.add("c:battery_alloy_tiny_dusts");
        DROPTAGS.add("c:bauxite_tiny_dusts");
        DROPTAGS.add("c:bronze_tiny_dusts");
        DROPTAGS.add("c:stones");
    }

    private static void initBioList() {
        BIO_DROPTAGS.add("minecraft:bee_growables");
        BIO_DROPTAGS.add("minecraft:crops");
        BIO_DROPTAGS.add("c:seeds");
        BIO_DROPTAGS.add("c:vegetables");
    }

    private static void initGoldList() {
        GOLD_DROPTAGS.add("c:redstone_dusts");
        GOLD_DROPTAGS.add("c:lapis_ores");
        GOLD_DROPTAGS.add("c:diamonds");
        GOLD_DROPTAGS.add("c:tin_dusts");

    }
}
