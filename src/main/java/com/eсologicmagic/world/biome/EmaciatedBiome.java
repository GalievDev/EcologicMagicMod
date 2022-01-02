package com.eсologicmagic.world.biome;


import com.eсologicmagic.world.gen.feature.ModTreeGeneration;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.eсologicmagic.Ecologicmagic.ModId;

public class EmaciatedBiome {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, ModId);

    public static final RegistryObject<Biome> EMACIATED_BIOME = BIOMES.register("emaciated_biome",
            () -> makeEmaciatedBiome(() -> ConfigureBuilder.EMACIATED_SURFACE, 0.125f, 0.05f));

    private static Biome makeEmaciatedBiome(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, float depth, float scale) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER,
                new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 7, 10));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder =
                (new BiomeGenerationSettings.Builder()).surfaceBuilder(surfaceBuilder);

        biomegenerationsettings$builder.addStructureStart(StructureFeatures.MINESHAFT);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_SWAMP);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.BURIED_TREASURE);

        DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
        ModTreeGeneration.addEmaciatedTrees(biomegenerationsettings$builder);

        DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDesertVegetation(biomegenerationsettings$builder);

        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);
        DefaultBiomeFeatures.addSurfaceFreezing(biomegenerationsettings$builder);
        return (new Biome.Builder()).precipitation(Biome.RainType.NONE).biomeCategory(Biome.Category.DESERT).depth(depth).scale(scale)
                .temperature(0.8F).downfall(0.9F).specialEffects((new BiomeAmbience.Builder()).waterColor(4804443).waterFogColor(2763314)
                        .fogColor(6513507).skyColor(3026478).foliageColorOverride(2171169).grassColorOverride(1842204)
                        .ambientParticle(new ParticleEffectAmbience(ParticleTypes.LARGE_SMOKE, 0.003f)).skyColor(3026478)
                        .ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                        .ambientMoodSound(new MoodSoundAmbience(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                        .ambientAdditionsSound(new SoundAdditionsAmbience(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                        .backgroundMusic(BackgroundMusicTracks.createGameMusic(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS))
                        .build())
                .mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }


    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}

