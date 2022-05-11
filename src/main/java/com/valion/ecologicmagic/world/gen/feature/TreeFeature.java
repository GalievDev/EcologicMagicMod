package com.valion.ecologicmagic.world.gen.feature;

import com.valion.ecologicmagic.setup.Registration;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class TreeFeature {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> EMACIATED = register("emaciated",
            Feature.TREE.configured((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(Registration.EMACIATED_LOG.get().defaultBlockState()),
                            new SimpleBlockStateProvider(Registration.EMACIATED_LEAVES.get().defaultBlockState()),
                            new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3),
                            new StraightTrunkPlacer(7, 2, 10),
                            new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));


    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String string, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, string, configuredFeature);
    }
}
