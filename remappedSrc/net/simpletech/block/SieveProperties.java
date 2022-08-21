package net.simpletech.block;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;

public class SieveProperties {
    // Manual Sieves, progress of sifting
    public static final IntProperty PROGRESS = IntProperty.of("progress", 0, 3);

    // Auto sieve, is doing something?
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");
}
