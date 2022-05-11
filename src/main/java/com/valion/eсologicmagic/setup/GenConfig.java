package com.valion.eсologicmagic.setup;

import net.minecraftforge.common.ForgeConfigSpec;

public class GenConfig {
    public static ForgeConfigSpec.BooleanValue GENERATE_PURITY_ESSENCE;

    public static ForgeConfigSpec.IntValue PURITY_ESSENCE_PER_CHUNK;

    public static ForgeConfigSpec.IntValue purity_essence_min_height;

    public static ForgeConfigSpec.IntValue purity_essence_max_height;

    public static ForgeConfigSpec.IntValue purity_essence_vein_size;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {
        server.comment("Gen Config");

        GENERATE_PURITY_ESSENCE = server.comment("Should Purity essence ore Spawn").define("OreGen.GENERATE_PURITY_ESSENCE", true);

        PURITY_ESSENCE_PER_CHUNK = server.comment("Maximum number of Purity essence ore veins in one chunk").defineInRange("OreGen.PURITY_ESSENCE_PER_CHUNK", 22, 1, 9);

        purity_essence_min_height = server.comment("What Y-Level Purity essence ore starts spawning").defineInRange("OreGen.purity_essence_min_height", 0, 0, 255);

        purity_essence_max_height = server.comment("What Y-Level Purity essence ore stops spawning").defineInRange("OreGen.purity_essence_max_height", 90, 0, 255);

        purity_essence_vein_size = server.comment("Maximum number of Purity essence ore in one vein").defineInRange("purity_essence_vein_size", 14, 1, 3);
    }
}
