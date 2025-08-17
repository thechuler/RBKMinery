package net.rbk.shinyandtiny.Item.custom;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rbk.shinyandtiny.DataComponent.ModDataComponent;


public class BananiteBat extends Item {


    public BananiteBat(Properties properties) {
        super(properties);

    }


    @Override
    public  FoodProperties getFoodProperties(ItemStack stack,  LivingEntity entity) {
        if (stack.has(ModDataComponent.FLAVOR) && stack.has(ModDataComponent.PURITY)) {
            int flavor = stack.get(ModDataComponent.FLAVOR);
            return new FoodProperties.Builder()
                    .alwaysEdible()
                    .nutrition((int) (1 + (stack.get(ModDataComponent.PURITY).floatValue()) / 10))
                    .saturationModifier((int) (3 + (stack.get(ModDataComponent.PURITY).floatValue()) / 10)).build();

        }
        return super.getFoodProperties(stack, entity);
    }



    @Override
    public int getMaxDamage(ItemStack stack) {
        if (stack.has(ModDataComponent.PURITY)) {
            return (int) (10 + stack.get(ModDataComponent.PURITY));
        }
        return 10;
    }


    @Override
    public  InteractionResultHolder<ItemStack> use( Level level, Player player,  InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }


    @Override
    public  ItemStack finishUsingItem( ItemStack stack,  Level level,  LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            FoodProperties foodProps = stack.getFoodProperties(player);
            if (foodProps != null) {
                player.getFoodData().eat(foodProps.nutrition(), foodProps.saturation());
                switch (stack.get(ModDataComponent.FLAVOR)){
                    case 1:
                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, (int) (100 + stack.get(ModDataComponent.PURITY).floatValue())));
                        break;
                    case 2:
                        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) (100 + stack.get(ModDataComponent.PURITY).floatValue())));
                        break;
                    case 4:
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) (100 + stack.get(ModDataComponent.PURITY).floatValue())));
                        break;
                    case 5:
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int) (100 + stack.get(ModDataComponent.PURITY).floatValue())));
                        break;
                }
            }
            stack.hurtAndBreak(5, livingEntity, EquipmentSlot.MAINHAND);
        }
       return stack;
    }
}
