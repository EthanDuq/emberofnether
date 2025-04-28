package com.emberofnether;

import com.emberofnether.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmberOfNether implements ModInitializer {
	public static final String MOD_ID = "emberofnether";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing EmberOfNether");
		setup();
	}

	private void setup(){
		ModItems.registerItems();
	}
}