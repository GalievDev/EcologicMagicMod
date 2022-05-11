package com.valion.eсologicmagic.world.gen;

import static com.valion.eсologicmagic.Ecologicmagic.ModId;

import com.valion.eсologicmagic.world.gen.feature.ModTreeGeneration;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModId)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModTreeGeneration.generateTrees(event);
    }
}
