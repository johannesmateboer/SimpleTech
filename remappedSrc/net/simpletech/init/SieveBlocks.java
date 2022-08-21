package net.simpletech.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.simpletech.SimpleTech;
import net.simpletech.block.*;
import net.simpletech.entity.SieveAutoEntity;
import net.simpletech.entity.SieveAutoGoldEntity;

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

    public static final Block SIEVE_AUTO;
    public static final BlockItem SIEVE_AUTO_ITEM;
    public static BlockEntityType<SieveAutoEntity> SIEVE_AUTO_ENTITY;
    public static final Identifier SIEVE_AUTO_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve_auto");

    public static final Block SIEVE_AUTO_GOLD;
    public static final BlockItem SIEVE_AUTO_GOLD_ITEM;
    public static BlockEntityType<SieveAutoGoldEntity> SIEVE_AUTO_GOLD_ENTITY;
    public static final Identifier SIEVE_AUTO_GOLD_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve_auto_gold");

    static {
        SIEVE = Registry.register(Registry.BLOCK, SIEVE_IDENTIFIER, new Sieve(getBlockSettings(SIEVE_IDENTIFIER)));
        SIEVE_ITEM = Registry.register(Registry.ITEM, SIEVE_IDENTIFIER, new BlockItem(SIEVE, new FabricItemSettings().group(SimpleTech.ITEM_GROUP)));

        SIEVE_BIO = Registry.register(Registry.BLOCK, SIEVE_BIO_IDENTIFIER, new SieveBio(getBlockSettings(SIEVE_BIO_IDENTIFIER)));
        SIEVE_BIO_ITEM = Registry.register(Registry.ITEM, SIEVE_BIO_IDENTIFIER, new BlockItem(SIEVE_BIO, new FabricItemSettings().group(SimpleTech.ITEM_GROUP)));

        SIEVE_GOLD = Registry.register(Registry.BLOCK, SIEVE_GOLD_IDENTIFIER, new SieveGold(getBlockSettings(SIEVE_GOLD_IDENTIFIER)));
        SIEVE_GOLD_ITEM = Registry.register(Registry.ITEM, SIEVE_GOLD_IDENTIFIER, new BlockItem(SIEVE_GOLD, new FabricItemSettings().group(SimpleTech.ITEM_GROUP)));

        SIEVE_AUTO = Registry.register(Registry.BLOCK, SIEVE_AUTO_IDENTIFIER, new SieveAuto(getBlockSettings(SIEVE_AUTO_IDENTIFIER)));
        SIEVE_AUTO_ITEM = Registry.register(Registry.ITEM, SIEVE_AUTO_IDENTIFIER, new BlockItem(SIEVE_AUTO, new FabricItemSettings().group(SimpleTech.ITEM_GROUP)));
        SIEVE_AUTO_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, SIEVE_AUTO_IDENTIFIER, FabricBlockEntityTypeBuilder.create(SieveAutoEntity::new, SIEVE_AUTO).build(null));

        SIEVE_AUTO_GOLD = Registry.register(Registry.BLOCK, SIEVE_AUTO_GOLD_IDENTIFIER, new SieveAutoGold(getBlockSettings(SIEVE_AUTO_IDENTIFIER)));
        SIEVE_AUTO_GOLD_ITEM = Registry.register(Registry.ITEM, SIEVE_AUTO_GOLD_IDENTIFIER, new BlockItem(SIEVE_AUTO_GOLD, new FabricItemSettings().group(SimpleTech.ITEM_GROUP)));
        SIEVE_AUTO_GOLD_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, SIEVE_AUTO_GOLD_IDENTIFIER, FabricBlockEntityTypeBuilder.create(SieveAutoGoldEntity::new, SIEVE_AUTO_GOLD).build(null));

    }

    private static FabricBlockSettings getBlockSettings(Identifier identifier) {
        return FabricBlockSettings.of(Material.STONE).hardness(1.5f).drops(identifier).nonOpaque();
    }

    public static void init() {
        // I'm here to be called!
    }

}
