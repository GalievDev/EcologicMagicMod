package com.eсologicmagic.setup;


import com.eсologicmagic.block.OreBlocks;
import com.eсologicmagic.block.custom.DenseHoneyBlock;
import com.eсologicmagic.item.custom.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.eсologicmagic.Ecologicmagic.ModId;
import static com.eсologicmagic.setup.ModSetup.ECOLOGICALL;


public class Registration {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModId);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModId);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<EcologyBook> ECOLOGY_BOOK = ITEMS.register("ecology_book", EcologyBook::new);
    public static final RegistryObject<PurityEssence> PURITY_ESSENCE = ITEMS.register("purity_essence", PurityEssence::new);
    public static final RegistryObject<ProsperityStone> PROSPERITY_STONE = ITEMS.register("prosperity_stone", ProsperityStone::new);
    public static final RegistryObject<EcologicHoe> ECOLOGIC_HOE = ITEMS.register("ecologic_hoe", EcologicHoe::new );
    public static final RegistryObject<EcologRing> ECOLOG_RING = ITEMS.register("ecolog_ring", EcologRing::new);

    public static final RegistryObject<OreBlocks> PURITY_ESSENCE_ORE = BLOCKS.register("purity_essence_ore", OreBlocks::new);
    public static final RegistryObject<Item> PURITY_ESSENCE_ORE_ITEM = ITEMS.register("purity_essence_ore", ()-> new BlockItem(PURITY_ESSENCE_ORE.get(), new Item.Properties().tab(ECOLOGICALL)));

    public static final RegistryObject<DenseHoneyBlock> DENSE_HONEY_BLOCK = BLOCKS.register("dense_honey_block", DenseHoneyBlock::new);
    public static final RegistryObject<Item> DENSE_HONEY_BLOCK_ITEM = ITEMS.register("dense_honey_block", ()-> new BlockItem(DENSE_HONEY_BLOCK.get(), new Item.Properties().tab(ECOLOGICALL)));

}

