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
    private static final ArrayList<String> DROPTAGS_BIO = new ArrayList<>();
    private static final ArrayList<String> DROPTAGS_GOLD = new ArrayList<>();

    // Holds the retrieved items
    public static final ArrayList<Item> ITEMS = new ArrayList<>();
    public static final ArrayList<Item> ITEMS_BIO = new ArrayList<>();
    public static final ArrayList<Item> ITEMS_GOLD = new ArrayList<>();

    public static void init() {
        initNuggetlist();
        initBioList();
        initGoldList();
    }

    /**
     * Returns a random item from the loaded list
     * @return  Item    The provided item
     */
    public static Item getRandomItem(ArrayList<Item> selectionGroup) {
        loadGenericDropResults(ITEMS, DROPTAGS);
        loadGenericDropResults(ITEMS_BIO, DROPTAGS_BIO);
        loadGenericDropResults(ITEMS_GOLD, DROPTAGS_GOLD);

        if (selectionGroup.size() > 0) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(selectionGroup.size());
            return selectionGroup.get(randomIndex);
        }else{
            return null;
        }
    }

    /**
     * Loads the provided tagslist into an Item-array
     * @param targetList    An empty item-list.
     * @param sourceList    A string-list with tags: c:tag
     */
    private static void loadGenericDropResults(ArrayList<Item> targetList, ArrayList<String> sourceList) {
        if (targetList.size() > 0) {
            return;
        }
        for (String dropTag : sourceList) {
            String[] dropTagParts = dropTag.split(Pattern.quote(":"));
            Identifier tagIdentifier = new Identifier(dropTagParts[0], dropTagParts[1]);
            Tag<Item> itemTag = ItemTags.getTagGroup().getTagOrEmpty(tagIdentifier);

            if (itemTag != null) {
                for (Item checkItem : itemTag.values()) {
                    if (!targetList.contains(checkItem)) {
                        targetList.add(checkItem);
                    }
                }
            }
        }
    }

    private static void initNuggetlist() {
        DROPTAGS.add("simpletech:dirt_remains");
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
        DROPTAGS.add("c:coal_dusts");
    }

    private static void initBioList() {
        DROPTAGS_BIO.add("minecraft:bee_growables");
        DROPTAGS_BIO.add("minecraft:crops");
        DROPTAGS_BIO.add("c:seeds");
        DROPTAGS_BIO.add("c:vegetables");
        DROPTAGS_BIO.add("simpletech:bios");
    }

    private static void initGoldList() {
        DROPTAGS_GOLD.add("simpletech:redstone_dusts");
        DROPTAGS_GOLD.add("simpletech:lapis_ores");
        DROPTAGS_GOLD.add("simpletech:diamonds");
        DROPTAGS_GOLD.add("simpletech:tin_dusts");
        DROPTAGS_GOLD.add("simpletech:coal");
    }
}
