package com.valion.ecologicmagic.integrated;

import com.valion.ecologicmagic.integrated.curio.CurioCapabilityHandler;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

public class IntegrationHandler {
    public static void loadCurio(final InterModEnqueueEvent event){
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().build());
    }

    public static ICapabilityProvider loadCurioCapability() {
        return new CurioCapabilityHandler();
    }
}
