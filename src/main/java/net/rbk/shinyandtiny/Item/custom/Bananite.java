package net.rbk.shinyandtiny.Item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

public class Bananite extends EdibleOre{
    public Bananite(Properties properties, ORE_STATS... allowedStats) {
        super(properties, allowedStats);
    }

    @Override
    protected Holder<MobEffect> getEffectForFlavor(int flavor) {
        switch (flavor) {
            case 1: return MobEffects.BLINDNESS;
            case 2: return MobEffects.CONFUSION;
            case 4: return MobEffects.REGENERATION;
            case 5: return MobEffects.DAMAGE_RESISTANCE;
            default: return null;
        }
    }
}
