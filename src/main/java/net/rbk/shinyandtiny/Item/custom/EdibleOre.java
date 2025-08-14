package net.rbk.shinyandtiny.Item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.rbk.shinyandtiny.DataComponent.ModDataComponent;
import org.jetbrains.annotations.Nullable;

public abstract class EdibleOre extends AbstractOre {

    public EdibleOre(Properties properties, ORE_STATS... allowedStats) {
        super(properties, allowedStats);
    }


    /**
     *
     * Devuelve el efecto correspondiente a cada "flavor".
     */
    protected abstract Holder<MobEffect> getEffectForFlavor(int flavor);

    @Override
    public @Nullable FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity) {
        if (stack.has(ModDataComponent.FLAVOR) && stack.has(ModDataComponent.PURITY)) {
            int flavor = stack.get(ModDataComponent.FLAVOR);
            float purity = stack.get(ModDataComponent.PURITY).floatValue();

            Holder<MobEffect> effect = getEffectForFlavor(flavor);

            if (effect != null) {
                return new FoodProperties.Builder()
                        .alwaysEdible()
                        .nutrition((int) (1 + purity / 10))
                        .saturationModifier((int) (3 + purity / 10))
                        .effect(new MobEffectInstance(effect, (int) (100 + purity)), 1)
                        .build();
            }else{
                return new FoodProperties.Builder()
                        .alwaysEdible()
                        .nutrition((int) (1 + purity / 10))
                        .saturationModifier((int) (3 + purity / 10))
                        .build();
            }
        }
        return super.getFoodProperties(stack, entity);
    }
}
