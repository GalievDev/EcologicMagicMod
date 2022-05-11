package com.valion.eсologicmagic.curio;

import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

public class CurioHandler {
    public static void loadCurio(final InterModEnqueueEvent event){
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
               () -> SlotTypePreset.RING.getMessageBuilder().build());
    }
}
