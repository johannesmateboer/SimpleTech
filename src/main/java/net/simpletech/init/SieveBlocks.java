package net.simpletech.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.simpletech.SimpleTech;
import net.simpletech.block.Sieve;
import net.simpletech.block.SieveBio;
import net.simpletech.block.SieveGold;

public class SieveBlocks {

    public static final Block SIEVE;
    public static final BlockItem SIEVE_ITEM;
    public static final Identifier SIEVE_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve");

    public static final Block SIEVE_BIO;
    public static final BlockItem SIEVE_BIO_ITEM;
    public static final Identifier SIEVE_BIO_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve_bio");

    public static final Block SIEVE_GOLD;
    public static final BlockItem SIEVE_GOLD_ITEM;
    public static final Identifier SIEVE_GOLD_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve_gold");

    static {
        SIEVE = Registry.register(Registry.BLOCK, SIEVE_IDENTIFIER, new Sieve(getBlockSettings(SIEVE_IDENTIFIER)));
        SIEVE_ITEM = Registry.register(Registry.ITEM, SIEVE_IDENTIFIER, new BlockItem(SIEVE, new FabricItemSettings().group(SimpleTech.ITEM_GROUP)));

        SIEVE_BIO = Registry.register(Registry.BLOCK, SIEVE_BIO_IDENTIFIER, new SieveBio(getBlockSettings(SIEVE_BIO_IDENTIFIER)));
        SIEVE_BIO_ITEM = Registry.register(Registry.ITEM, SIEVE_BIO_IDENTIFIER, new BlockItem(SIEVE_BIO, new FabricItemSettings().group(SimpleTech.ITEM_GROUP)));

        SIEVE_GOLD = Registry.register(Registry.BLOCK, SIEVE_GOLD_IDENTIFIER, new SieveGold(getBlockSettings(SIEVE_GOLD_IDENTIFIER)));
        SIEVE_GOLD_ITEM = Registry.register(Registry.ITEM, SIEVE_GOLD_IDENTIFIER, new BlockItem(SIEVE_GOLD, new FabricItemSettings().group(SimpleTech.ITEM_GROUP)));
    }

    private static FabricBlockSettings getBlockSettings(Identifier identifier) {
        return FabricBlockSettings.of(Material.STONE).hardness(1.5f).drops(identifier).nonOpaque();
    }

    public static void init() {

    }

}
