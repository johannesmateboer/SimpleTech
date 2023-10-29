package net.simpletech.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.simpletech.SimpleTech;
import net.simpletech.block.*;
import net.simpletech.entity.SieveAutoEntity;
import net.simpletech.entity.SieveAutoGoldEntity;
import net.simpletech.entity.SieveAutoNetherEntity;

public class SieveBlocks {
    public static final Block SIEVE;
    public static final BlockItem SIEVE_ITEM;
    public static final Identifier SIEVE_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve");

    public static final Block SIEVE_NETHER;
    public static final BlockItem SIEVE_NETHER_ITEM;
    public static final Identifier SIEVE_NETHER_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve_nether");

    public static final Block SIEVE_END;
    public static final BlockItem SIEVE_END_ITEM;
    public static final Identifier SIEVE_END_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve_end");

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

    public static final Block SIEVE_AUTO_NETHER;
    public static final BlockItem SIEVE_AUTO_NETHER_ITEM;
    public static BlockEntityType<SieveAutoNetherEntity> SIEVE_AUTO_NETHER_ENTITY;
    public static final Identifier SIEVE_AUTO_NETHER_IDENTIFIER = new Identifier(SimpleTech.MOD_ID, "sieve_auto_nether");

    static {
        SIEVE = Registry.register(Registries.BLOCK, SIEVE_IDENTIFIER, new Sieve(getBlockSettings(SIEVE_IDENTIFIER)));
        SIEVE_ITEM = Registry.register(Registries.ITEM, SIEVE_IDENTIFIER, new BlockItem(SIEVE, new FabricItemSettings()));

        SIEVE_BIO = Registry.register(Registries.BLOCK, SIEVE_BIO_IDENTIFIER, new SieveBio(getBlockSettings(SIEVE_BIO_IDENTIFIER)));
        SIEVE_BIO_ITEM = Registry.register(Registries.ITEM, SIEVE_BIO_IDENTIFIER, new BlockItem(SIEVE_BIO, new FabricItemSettings()));

        SIEVE_NETHER = Registry.register(Registries.BLOCK, SIEVE_NETHER_IDENTIFIER, new SieveNether(getBlockSettings(SIEVE_NETHER_IDENTIFIER)));
        SIEVE_NETHER_ITEM = Registry.register(Registries.ITEM, SIEVE_NETHER_IDENTIFIER, new BlockItem(SIEVE_NETHER, new FabricItemSettings()));

        SIEVE_END = Registry.register(Registries.BLOCK, SIEVE_END_IDENTIFIER, new SieveEnd(getBlockSettings(SIEVE_END_IDENTIFIER)));
        SIEVE_END_ITEM = Registry.register(Registries.ITEM, SIEVE_END_IDENTIFIER, new BlockItem(SIEVE_END, new FabricItemSettings()));

        SIEVE_GOLD = Registry.register(Registries.BLOCK, SIEVE_GOLD_IDENTIFIER, new SieveGold(getBlockSettings(SIEVE_GOLD_IDENTIFIER)));
        SIEVE_GOLD_ITEM = Registry.register(Registries.ITEM, SIEVE_GOLD_IDENTIFIER, new BlockItem(SIEVE_GOLD, new FabricItemSettings()));

        SIEVE_AUTO = Registry.register(Registries.BLOCK, SIEVE_AUTO_IDENTIFIER, new SieveAuto(getBlockSettings(SIEVE_AUTO_IDENTIFIER)));
        SIEVE_AUTO_ITEM = Registry.register(Registries.ITEM, SIEVE_AUTO_IDENTIFIER, new BlockItem(SIEVE_AUTO, new FabricItemSettings()));
        SIEVE_AUTO_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, SIEVE_AUTO_IDENTIFIER, FabricBlockEntityTypeBuilder.create(SieveAutoEntity::new, SIEVE_AUTO).build(null));

        SIEVE_AUTO_GOLD = Registry.register(Registries.BLOCK, SIEVE_AUTO_GOLD_IDENTIFIER, new SieveAutoGold(getBlockSettings(SIEVE_AUTO_GOLD_IDENTIFIER)));
        SIEVE_AUTO_GOLD_ITEM = Registry.register(Registries.ITEM, SIEVE_AUTO_GOLD_IDENTIFIER, new BlockItem(SIEVE_AUTO_GOLD, new FabricItemSettings()));
        SIEVE_AUTO_GOLD_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, SIEVE_AUTO_GOLD_IDENTIFIER, FabricBlockEntityTypeBuilder.create(SieveAutoGoldEntity::new, SIEVE_AUTO_GOLD).build(null));

        SIEVE_AUTO_NETHER = Registry.register(Registries.BLOCK, SIEVE_AUTO_NETHER_IDENTIFIER, new SieveAutoNether(getBlockSettings(SIEVE_AUTO_NETHER_IDENTIFIER)));
        SIEVE_AUTO_NETHER_ITEM = Registry.register(Registries.ITEM, SIEVE_AUTO_NETHER_IDENTIFIER, new BlockItem(SIEVE_AUTO_NETHER, new FabricItemSettings()));
        SIEVE_AUTO_NETHER_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, SIEVE_AUTO_NETHER_IDENTIFIER, FabricBlockEntityTypeBuilder.create(SieveAutoNetherEntity::new, SIEVE_AUTO_NETHER).build(null));
    }

    private static FabricBlockSettings getBlockSettings(Identifier identifier) {
        return FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).hardness(1.2f).drops(identifier).nonOpaque();
    }

    public static void init() {
        // Add items to our item group.
        SimpleTechItemGroup.registerItem(SIEVE_ITEM);
        SimpleTechItemGroup.registerItem(SIEVE_BIO_ITEM);
        SimpleTechItemGroup.registerItem(SIEVE_NETHER_ITEM);
        SimpleTechItemGroup.registerItem(SIEVE_END_ITEM);
        SimpleTechItemGroup.registerItem(SIEVE_GOLD_ITEM);
        SimpleTechItemGroup.registerItem(SIEVE_AUTO_ITEM);
        SimpleTechItemGroup.registerItem(SIEVE_AUTO_GOLD_ITEM);
        SimpleTechItemGroup.registerItem(SIEVE_AUTO_NETHER_ITEM);
    }
}
