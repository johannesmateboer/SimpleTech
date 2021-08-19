package net.simpletech;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.simpletech.init.SieveBlocks;
import net.simpletech.util.Dropresults;

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
