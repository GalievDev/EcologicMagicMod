package com.eсologicmagic.world.biome;

import com.eсologicmagic.setup.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import static com.eсologicmagic.Ecologicmagic.ModId;

public class ConfigureBuilder {
    public static ConfiguredSurfaceBuilder<?> EMACIATED_SURFACE = register("emaciated_surface",
            SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
                    Registration.EMACIATED_DIRT.get().defaultBlockState(),
                    Registration.EMACIATED_DIRT.get().defaultBlockState(),
                    Blocks.STONE.defaultBlockState()
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                                                                                           ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(ModId, name), csb);
    }
}
