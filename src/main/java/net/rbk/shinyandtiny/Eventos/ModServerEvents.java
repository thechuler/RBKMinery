package net.rbk.shinyandtiny.Eventos;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.rbk.shinyandtiny.DataComponent.ModDataComponent;
import net.rbk.shinyandtiny.Efectos.GeoTouch;
import net.rbk.shinyandtiny.Efectos.ModEffects;
import net.rbk.shinyandtiny.ShinyAndTiny;

import java.util.List;


@EventBusSubscriber(modid = ShinyAndTiny.MODID)
public class ModServerEvents {


    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        purityToolTip(event);
        flavorToolTip(event);
    }



    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        GeoTouch(event);
    }



private static void GeoTouch(BlockEvent.BreakEvent event){
    BlockState bloque = event.getState();
    if (event.getPlayer().hasEffect(ModEffects.GEOTOUCH)) {
        if (bloque.is(Tags.Blocks.ORES)) {
            LootParams.Builder lootBuilder = new LootParams.Builder((ServerLevel) event.getLevel())
                    .withParameter(LootContextParams.ORIGIN, event.getPos().getCenter())
                    .withParameter(LootContextParams.TOOL, event.getPlayer().getMainHandItem())
                    .withOptionalParameter(LootContextParams.THIS_ENTITY, event.getPlayer());

            List<ItemStack> drops = bloque.getDrops(lootBuilder);


            event.setCanceled(true);
            event.getLevel().destroyBlock(event.getPos(), false);
            for (ItemStack drop : drops) {
                ItemStack extra = drop.copy();
                extra.grow(drop.getCount());
                Block.popResource((Level) event.getLevel(), event.getPos(), extra);
            }
        }
    }
}




    private static void purityToolTip(ItemTooltipEvent event){
        ItemStack stack = event.getItemStack();
        if (stack.has(ModDataComponent.PURITY.get())) {
            float purity = stack.get(ModDataComponent.PURITY.get());
            int color = setColorFromPurity(purity);
            MutableComponent line = Component.translatable("tooltip.shinyandtiny.purity");
            line.append(Component.literal(String.format("%.2f%%", purity))
                    .withStyle(style -> style.withColor(color)));

            event.getToolTip().add(line);
        }
    }


    private static void flavorToolTip(ItemTooltipEvent event){
        ItemStack stack = event.getItemStack();
        if (stack.has(ModDataComponent.FLAVOR.get())) {
            int flavor = stack.get(ModDataComponent.FLAVOR.get());
            int color = setColorFromFlavor(flavor);
            MutableComponent line = Component.translatable("tooltip.shinyandtiny.flavor",
                    Component.translatable(setFlavorText(flavor)).withStyle(style -> style.withColor(color)));


            event.getToolTip().add(line);
        }
    }


    public static String setFlavorText(int flavor) {
        switch (flavor){
            case 1: return "tooltip.shinyandtiny.flavor.repulsive";
            case 2: return "tooltip.shinyandtiny.flavor.disgusting";
            case 3: return "tooltip.shinyandtiny.flavor.okay";
            case 4: return "tooltip.shinyandtiny.flavor.good";
            case 5: return "tooltip.shinyandtiny.flavor.exquisite";
            default: return "tooltip.shinyandtiny.flavor.unknown";
        }
    }

    public static int setColorFromFlavor(int flavor) {
      switch (flavor){
          case 1:
              return 0x523603;
          case 2:
              return 0x304713;
          case 3:
              return 0x1b51cc;
          case 4:
              return 0xffb63e;
          case 5:
              return 0xe27af5;
          default:
              return 0xFFFFFF;
      }
    }

    public static int setColorFromPurity(float purity) {
        if (purity <= 30) {
            return 0x858585; // gris
        } else if (purity > 30 && purity < 50) {
            return 0x57c22c; // verde
        } else if (purity >= 50 && purity < 70) {
            return 0x1352f5; // azul
        } else if (purity >= 70 && purity < 90) {
            return 0x9f19ff; // violeta
        } else if (purity >= 90 && purity < 95) {
            return 0xd60909; // rojo
        } else if (purity >= 95 && purity <= 100) {
            return 0xffe64f; // amarillo
        }
        return 0xFFFFFF; // blanco por defecto
    }

}
