package net.simpletech.util;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.impl.tag.convention.TagRegistration;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.data.server.LootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.resource.Resource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.IndexedIterable;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;

public class Dropresults {

    // Holds all tags which should be loaded
    private static final ArrayList<TagKey> DROPTAGS = new ArrayList<>();
    private static final ArrayList<TagKey> DROPTAGS_BIO = new ArrayList<>();
    private static final ArrayList<TagKey> DROPTAGS_GOLD = new ArrayList<>();

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
    private static void loadGenericDropResults(ArrayList<Item> targetList, ArrayList<TagKey> sourceList) {
        if (targetList.size() > 0) {
            return;
        }
        Integer counter = 0;

        // Iterate over the droptags
        for (TagKey<Item> dropTagKey : sourceList) {
            for (RegistryEntry<Item> entry : Registry.ITEM.getOrCreateEntryList(dropTagKey)) {
                Optional<RegistryKey<Item>> itm = entry.getKey();
                RegistryKey<Item> i = itm.get();
                Identifier itemId = i.getValue();
                Item mainItem = Registry.ITEM.get(itemId);
                targetList.add(mainItem);
                counter++;
            }
        }
        System.out.println("Added " + counter + " to the droplist");
    }

    private static TagKey<Item> register(String id, String path) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(id, path));
    }

    private static void initNuggetlist() {
        DROPTAGS.add(register("simpletech","dirt_remains"));

        DROPTAGS.add(register("c", "aluminum_tiny_dusts"));
        DROPTAGS.add(register("c", "aluminum_nuggets"));
        DROPTAGS.add(register("c", "antimony_tiny_dusts"));
        DROPTAGS.add(register("c", "antimony_nuggets"));

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
    }

    private static void initBioList() {
        DROPTAGS_BIO.add(register("minecraft","bee_growables"));
        DROPTAGS_BIO.add(register("minecraft","crops"));
        DROPTAGS_BIO.add(register("c", "seeds"));
        DROPTAGS_BIO.add(register("c", "vegetables"));
        DROPTAGS_BIO.add(register("simpletech", "bios"));
    }

    private static void initGoldList() {
        DROPTAGS_GOLD.add(register("simpletech","redstone_dusts"));
        DROPTAGS_GOLD.add(register("simpletech","lapis_ores"));
        DROPTAGS_GOLD.add(register("simpletech","diamonds"));
        DROPTAGS_GOLD.add(register("simpletech","tin_dusts"));
        DROPTAGS_GOLD.add(register("simpletech","coal"));
    }
}
