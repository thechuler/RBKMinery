package net.rbk.shinyandtiny.Efectos;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rbk.shinyandtiny.ShinyAndTiny;


public class ModEffects {

    public static final DeferredRegister<MobEffect> EFECTOS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, ShinyAndTiny.MODID);

    public static final DeferredHolder<MobEffect, GeoTouch> GEOTOUCH = EFECTOS.register("geotouch",
                    () -> new GeoTouch(MobEffectCategory.HARMFUL, 12));

    public static void registrar(IEventBus eventBus) {
        EFECTOS.register(eventBus);
    }
}
