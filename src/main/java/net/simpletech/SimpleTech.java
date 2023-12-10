package net.simpletech;

import net.fabricmc.api.ModInitializer;
import net.simpletech.init.SimpleTechItemGroup;
import net.simpletech.init.SieveBlocks;
import net.simpletech.util.Dropresults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTech implements ModInitializer {
	public static final String MOD_ID = "simpletech";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Dropresults.init();
		SieveBlocks.init();
		SimpleTechItemGroup.init();
	}
}
