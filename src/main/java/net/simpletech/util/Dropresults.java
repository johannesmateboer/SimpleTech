package net.simpletech.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.simpletech.SimpleTech;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Dropresults {
    // Holds all tags which should be loaded
    private static final ArrayList<TagKey<Item>> DROPTAGS = new ArrayList<>();
    private static final ArrayList<TagKey<Item>> DROPTAGS_BIO = new ArrayList<>();
    private static final ArrayList<TagKey<Item>> DROPTAGS_GOLD = new ArrayList<>();
    private static final ArrayList<TagKey<Item>> DROPTAGS_NETHER = new ArrayList<>();
    private static final ArrayList<TagKey<Item>> DROPTAGS_END = new ArrayList<>();

    // Holds the retrieved items
    public static final HashSet<Item> ITEMS = new HashSet<>();
    public static final HashSet<Item> ITEMS_BIO = new HashSet<>();
    public static final HashSet<Item> ITEMS_GOLD = new HashSet<>();
    public static final HashSet<Item> ITEMS_NETHER = new HashSet<>();
    public static final HashSet<Item> ITEMS_END = new HashSet<>();

    public static void init() {
        initNuggetlist();
        initBioList();
        initGoldList();
        initNetherList();
        initEndList();

        ServerLifecycleEvents.SERVER_STARTING.register(listener -> {
            loadGenericDropResults(ITEMS, DROPTAGS, "Sieve");
            loadGenericDropResults(ITEMS_BIO, DROPTAGS_BIO, "Bio Sieve");
            loadGenericDropResults(ITEMS_GOLD, DROPTAGS_GOLD, "Gold Sieve");
            loadGenericDropResults(ITEMS_NETHER, DROPTAGS_NETHER, "Nether Sieve");
            loadGenericDropResults(ITEMS_END, DROPTAGS_END, "End Sieve");
        });
    }

    /**
     * Returns a random item from the loaded list
     * @return  Item    The provided item
     */
    public static @Nullable Item getRandomItem(Collection<Item> selectionGroup) {
        int size = selectionGroup.size();
        if (size <= 0) {
            return null;
        }

        return selectionGroup
                .stream()
                .skip(ThreadLocalRandom.current().nextInt(size))
                .findAny()
                .orElse(null);
    }

    /**
     * Loads the provided tagslist into an Item-array
     * @param targetList    An empty item-list.
     * @param sourceList    A string-list with tags: c:tag
     */
    private static void loadGenericDropResults(Collection<Item> targetList, ArrayList<TagKey<Item>> sourceList, String name) {
        int oldSize = targetList.size();
        int newSize = 0;

        if (oldSize > 0) {
            targetList.clear();
        }

        // Iterate over the droptags
        for (TagKey<Item> dropTagKey : sourceList) {
            for (RegistryEntry<Item> entry : Registries.ITEM.getOrCreateEntryList(dropTagKey)) {
                Optional<RegistryKey<Item>> itemKey = entry.getKey();
                if (itemKey.isPresent()) {
                    targetList.add(Registries.ITEM.get(itemKey.get().getValue()));
                    ++newSize;
                }
            }
        }
        SimpleTech.LOGGER.info("Updated {} droplist from size {} to size {}", name, oldSize, newSize);
    }

    private static TagKey<Item> register(String id, String path) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id, path));
    }

    private static void initNuggetlist() {
        DROPTAGS.add(register("simpletech","dirt_remains"));

        DROPTAGS.add(register("c", "aluminum_nuggets"));
        DROPTAGS.add(register("c", "aluminum_tiny_dusts"));
        DROPTAGS.add(register("c", "antimony_nuggets"));
        DROPTAGS.add(register("c", "antimony_tiny_dusts"));
        DROPTAGS.add(register("c", "battery_alloy_tiny_dusts"));
        DROPTAGS.add(register("c", "bauxite_tiny_dusts"));
        DROPTAGS.add(register("c", "bronze_tiny_dusts"));
        DROPTAGS.add(register("c", "coal_dusts"));
        DROPTAGS.add(register("c", "gold_dusts"));
        DROPTAGS.add(register("c", "iron_nuggets"));
        DROPTAGS.add(register("c", "iron_dusts"));
        DROPTAGS.add(register("c", "invar_nuggets"));
        DROPTAGS.add(register("c", "iridium_nuggets"));
        DROPTAGS.add(register("c", "lead_nuggets"));
        DROPTAGS.add(register("c", "manganese_nuggets"));
        DROPTAGS.add(register("c", "nickel_nuggets"));
        DROPTAGS.add(register("c", "platinum_nuggets"));
        DROPTAGS.add(register("c", "refined_iron_nuggets"));
        DROPTAGS.add(register("c", "silicon_nuggets"));
        DROPTAGS.add(register("c", "silver_nuggets"));
        DROPTAGS.add(register("c", "sodium_nuggets"));
        DROPTAGS.add(register("c", "steel_nuggets"));
        DROPTAGS.add(register("c", "stones"));
        DROPTAGS.add(register("c", "tin_nuggets"));
        DROPTAGS.add(register("c", "titanium_nuggets"));
        DROPTAGS.add(register("c", "tungsten_nuggets"));
        DROPTAGS.add(register("c", "tungstensteel_nuggets"));
        DROPTAGS.add(register("c", "tin_tiny_dusts"));
        DROPTAGS.add(register("c", "titanium_tiny_dusts"));
        DROPTAGS.add(register("c", "zinc_nuggets"));

        DROPTAGS.add(register("c", "common_loot"));
    }

    private static void initBioList() {
        DROPTAGS_BIO.add(register("simpletech", "bios"));

        DROPTAGS_BIO.add(register("minecraft","crops"));
        DROPTAGS_BIO.add(register("minecraft","fox_food"));
        DROPTAGS_BIO.add(register("minecraft","saplings"));
        DROPTAGS_BIO.add(register("minecraft","small_flowers"));
        DROPTAGS_BIO.add(register("minecraft","tall_flowers"));
        DROPTAGS_BIO.add(register("minecraft","villager_plantable_seeds"));

        DROPTAGS_BIO.add(register("c", "seeds"));
        DROPTAGS_BIO.add(register("c", "vegetables"));
    }

    private static void initGoldList() {
        DROPTAGS_GOLD.add(register("simpletech","redstone_dusts"));
        DROPTAGS_GOLD.add(register("simpletech","lapis_ores"));
        DROPTAGS_GOLD.add(register("simpletech","diamonds"));
        DROPTAGS_GOLD.add(register("simpletech","tin_dusts"));
        DROPTAGS_GOLD.add(register("simpletech","coal"));

        DROPTAGS_GOLD.add(register("c","rare_loot"));

    }

    private static void initNetherList() {
        DROPTAGS_NETHER.add(register("simpletech","nether_remains"));

        DROPTAGS_NETHER.add(register("c", "gold_nuggets"));
        DROPTAGS_NETHER.add(register("c", "netherrack"));
        DROPTAGS_NETHER.add(register("c", "quartz"));
        DROPTAGS_NETHER.add(register("c", "sulfurs"));

        DROPTAGS_NETHER.add(register("c", "uncommon_loot"));
    }

    private static void initEndList() {
        DROPTAGS_END.add(register("simpletech","end_remains"));

        DROPTAGS_END.add(register("c", "very_rare_loot"));
        DROPTAGS_END.add(register("c", "common_loot"));
    }
}
