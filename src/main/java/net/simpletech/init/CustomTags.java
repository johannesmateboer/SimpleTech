package net.simpletech.init;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.simpletech.SimpleTech;

public class CustomTags {
    public static final Tag<Item> TAGS_BIOS = TagRegistry.item(new Identifier(SimpleTech.MOD_ID, "bios"));
    public static final Tag<Item> TAGS_COAL = TagRegistry.item(new Identifier(SimpleTech.MOD_ID, "coal"));
    public static final Tag<Item> TAGS_DIAMONDS = TagRegistry.item(new Identifier(SimpleTech.MOD_ID, "diamonds"));
    public static final Tag<Item> TAGS_DIRT_REMAINS = TagRegistry.item(new Identifier(SimpleTech.MOD_ID, "dirt_remains"));
    public static final Tag<Item> TAGS_GOLD_INGOTS = TagRegistry.item(new Identifier(SimpleTech.MOD_ID, "gold_ingots"));
    public static final Tag<Item> TAGS_LAPIS = TagRegistry.item(new Identifier(SimpleTech.MOD_ID, "lapis_lazulis"));
    public static final Tag<Item> TAGS_REDSTONE = TagRegistry.item(new Identifier(SimpleTech.MOD_ID, "redstone_dusts"));

    public static void init() {

    }

}
