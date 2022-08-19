package net.simpletech;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.simpletech.init.CustomTags;
import net.simpletech.init.SieveBlocks;
import net.simpletech.util.Dropresults;
import org.apache.logging.log4j.core.jmx.Server;

public class SimpleTech implements ModInitializer {

	public static final String MOD_ID = "simpletech";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
					new Identifier(MOD_ID, "general"))
			.icon(() -> new ItemStack(SieveBlocks.SIEVE))
			.build();

	@Override
	public void onInitialize() {
		Dropresults.init();
		SieveBlocks.init();
	}
}
