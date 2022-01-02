package com.eсologicmagic.world.gen;

import com.eсologicmagic.world.gen.feature.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.eсologicmagic.Ecologicmagic.ModId;

@Mod.EventBusSubscriber(modid = ModId)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModTreeGeneration.generateTrees(event);
    }
}
