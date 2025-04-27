package com.emberofnether;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class EmberOfNetherClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Enregistrez ici les renderers, keybinds, etc.
    }
}
