package com.eсologicmagic;



import com.eсologicmagic.setup.ModSetup;
import com.eсologicmagic.setup.Registration;
import com.eсologicmagic.util.ModSoundEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod(Ecologicmagic.ModId)
public class Ecologicmagic {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "ecologicmagic";
    public static final String NAME = "EcologicMagic";

    public Ecologicmagic() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.init();

        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);

        ModSoundEvents.register(eventBus);
    }

    private void enqueueIMC(final InterModEnqueueEvent event){
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                () -> SlotTypePreset.RING.getMessageBuilder().build());
    }

    private void doClientStuff(final FMLClientSetupEvent event){
        event.enqueueWork(() -> {
           //RenderTypeLookup.setRenderLayer(Registration.FLOWER_PEDESTAL.get(), RenderType.cutout());
        });
    }
}
