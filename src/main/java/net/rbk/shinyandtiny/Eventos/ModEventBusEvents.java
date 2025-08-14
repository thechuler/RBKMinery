package net.rbk.shinyandtiny.Eventos;


import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.rbk.shinyandtiny.DataComponent.ModDataComponent;
import net.rbk.shinyandtiny.Item.ModItems;
import net.rbk.shinyandtiny.ShinyAndTiny;
import net.rbk.shinyandtiny.ShinyAndTiny;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EventBusSubscriber(modid = ShinyAndTiny.MODID)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        applyStatsBananiteBat(event);
    }






    private static void applyStatsBananiteBat(PlayerEvent.ItemCraftedEvent event){
        ItemStack crafted = event.getCrafting();
        if (crafted.getItem() == ModItems.BANANITE_BAT.get()) {
            float finalPurity = 0;
            List<Integer> flavors = new ArrayList<>();
            if (event.getInventory() instanceof CraftingContainer craftingContainer) {
                for (int i = 0; i < craftingContainer.getContainerSize(); i++) {
                    ItemStack ingredient = craftingContainer.getItem(i);
                    if (!ingredient.isEmpty() && ingredient.has(ModDataComponent.PURITY) &&ingredient.has(ModDataComponent.FLAVOR) ) {
                        flavors.add(ingredient.get(ModDataComponent.FLAVOR));
                        finalPurity += ingredient.get(ModDataComponent.PURITY);
                    }
                }
                finalPurity = finalPurity/2; //el hardcodeo del papu B)
                int finalFlavor = flavors.get(ThreadLocalRandom.current().nextInt(flavors.size()));
                crafted.set(ModDataComponent.PURITY, finalPurity);
                crafted.set(ModDataComponent.FLAVOR,finalFlavor);

            }
        }
    }
}
