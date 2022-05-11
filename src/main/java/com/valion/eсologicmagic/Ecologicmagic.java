package com.valion.eсologicmagic;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.valion.eсologicmagic.curio.CurioHandler;
import com.valion.eсologicmagic.setup.ModSetup;
import com.valion.eсologicmagic.setup.Registration;
import com.valion.eсologicmagic.util.ModSoundEvents;
import com.valion.eсologicmagic.world.gen.BiomeGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Ecologicmagic.ModId)
@Mod.EventBusSubscriber(modid = Ecologicmagic.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Ecologicmagic {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "ecologicmagic";
    public static final String NAME = "EcologicMagic";

    public Ecologicmagic() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Registration.init();

        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::client);
        if (ModList.get().isLoaded("curios"))eventBus.addListener(CurioHandler::loadCurio); 

        ModSoundEvents.register(eventBus);
    }

    

    private void client(final FMLClientSetupEvent event){
        event.enqueueWork(() -> {
           RenderTypeLookup.setRenderLayer(Block.byItem(Registration.ECOLOG_STUFF.get()), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(Registration.EMACIATED_SAPLING.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(Registration.EMACIATED_LEAVES.get(), RenderType.cutout());

        });
    }

   private void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
       BiomeGen.generateBiomes();
    });
   }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        Registration.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry()
                    .register(new BlockItem(block, new Item.Properties().tab(ModSetup.ECOLOGICALL))
                            .setRegistryName(block.getRegistryName()));
        });
    }
}
