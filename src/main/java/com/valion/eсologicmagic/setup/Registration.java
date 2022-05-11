package com.valion.eсologicmagic.setup;


import static com.valion.eсologicmagic.Ecologicmagic.ModId;

import com.valion.eсologicmagic.block.DenseHoneyBlock;
import com.valion.eсologicmagic.block.OreBlocks;
import com.valion.eсologicmagic.block.trees.EmaciatedTree;
import com.valion.eсologicmagic.item.*;
import com.valion.eсologicmagic.world.biome.*;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModId);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModId);
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, ModId);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        BIOMES.register(bus);
    }

    public static final RegistryObject<EcologyBook> ECOLOGY_BOOK = ITEMS.register("ecology_book", EcologyBook::new);
    public static final RegistryObject<PurityEssence> PURITY_ESSENCE = ITEMS.register("purity_essence", PurityEssence::new);
    public static final RegistryObject<ProsperityStone> PROSPERITY_STONE = ITEMS.register("prosperity_stone", ProsperityStone::new);
    public static final RegistryObject<EcologicHoe> ECOLOGIC_HOE = ITEMS.register("ecologic_hoe", EcologicHoe::new);
    public static final RegistryObject<EcologRing> ECOLOG_RING = ITEMS.register("ecolog_ring", EcologRing::new);

    public static final RegistryObject<OreBlocks> PURITY_ESSENCE_ORE = BLOCKS.register("purity_essence_ore", OreBlocks::new);
    public static final RegistryObject<DenseHoneyBlock> DENSE_HONEY_BLOCK = BLOCKS.register("dense_honey_block", DenseHoneyBlock::new);


    public static final RegistryObject<Block> EMACIATED_LOG = BLOCKS.register("emaciated_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).strength(1f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EMACIATED_WOOD = BLOCKS.register("emaciated_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EMACIATED_PLANKS = BLOCKS.register("emaciated_planks",
            () -> new Block(AbstractBlock.Properties.of(Material.WOOD).strength(1f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> EMACIATED_LEAVES = BLOCKS.register("emaciated_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.of(Material.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> EMACIATED_DIRT = BLOCKS.register("emaciated_dirt",
            () -> new Block(AbstractBlock.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<SaplingBlock> EMACIATED_SAPLING = BLOCKS.register("emaciated_sapling",
            () -> new SaplingBlock(new EmaciatedTree(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<EcologStaff> ECOLOG_STUFF = ITEMS.register("ecolog_staff", EcologStaff::new);

    public static final RegistryObject<Biome> EMACIATED_BIOME = BIOMES.register("emaciated_biome",
            () -> EmaciatedBiome.makeEmaciatedBiome(() -> ConfigureBuilder.EMACIATED_SURFACE, 0.125f, 0.05f));

}

