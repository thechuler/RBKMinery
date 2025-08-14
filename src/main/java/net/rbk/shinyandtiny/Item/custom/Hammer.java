package net.rbk.shinyandtiny.Item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rbk.shinyandtiny.Item.ModItems;
import net.rbk.shinyandtiny.Otros.Utilidades;


public class Hammer extends Item {
    public Hammer(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
       if(!level.isClientSide){
           ItemStack item1 = player.getItemInHand(InteractionHand.MAIN_HAND);
           ItemStack item2 = player.getItemInHand(InteractionHand.OFF_HAND);

           if((item1.is(ModItems.HAMMER) && item2.getItem() instanceof AbstractGeode)){
             tryOpenGeode(item2,player,level);
             item1.hurtAndBreak(1,player, EquipmentSlot.MAINHAND);
           }
           if((item2.is(ModItems.HAMMER) && item1.getItem() instanceof AbstractGeode)){
               tryOpenGeode(item1,player,level);
               item2.hurtAndBreak(1,player, EquipmentSlot.OFFHAND);
           }

       }
        return super.use(level, player, usedHand);
    }



    private void tryOpenGeode(ItemStack geode, Player player, Level level){
        if(geode.getItem() instanceof AbstractGeode ag){
            int chance = Utilidades.GenerarNumeroAleatorio(0,ag.getBreakDifficulty());
          if(chance == 0){
              ItemStack stack = new ItemStack(ag.getDrop());
              if(ag.getDrop() instanceof AbstractOre ore){
                  ore.applyStats(stack,ore.getAllowedStats());
              }
              if(!player.addItem(stack)){
                  net.minecraft.world.entity.item.ItemEntity itemEntity = new net.minecraft.world.entity.item.ItemEntity(
                          level,
                          player.getX(),
                          player.getY() + 0.5,
                          player.getZ(),
                          stack
                  );
                  level.addFreshEntity(itemEntity);
              }

              geode.shrink(1);
              player.level().playSound(null, player.getOnPos(), SoundEvents.STONE_BREAK, SoundSource.HOSTILE, 1.0F, 2.0F); // Sonido

              return;
          }
            player.level().playSound(null, player.getOnPos(), SoundEvents.ITEM_BREAK, SoundSource.HOSTILE, 1.0F, 2.0F); // Sonido

        }
    }



}
