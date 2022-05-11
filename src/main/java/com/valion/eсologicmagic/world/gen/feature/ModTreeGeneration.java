package com.valion.eсologicmagic.world.gen.feature;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import com.valion.eсologicmagic.setup.Registration;

@SuppressWarnings("all")
public class ModTreeGeneration {
    public static void generateTrees(final BiomeLoadingEvent event) {
        RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
        Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

        if(types.contains(Registration.EMACIATED_BIOME.get())) {
            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);

            base.add(() -> TreeFeature.EMACIATED
                    .decorated(Features.Placements.HEIGHTMAP)
                    .decorated(Placement.COUNT_EXTRA.configured(
                            new AtSurfaceWithExtraConfig(20, 1f, 100))));
        }
    }

    public static void addEmaciatedTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, TreeFeature.EMACIATED);
    }
}
