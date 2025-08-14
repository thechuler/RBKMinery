package net.rbk.shinyandtiny.Item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rbk.shinyandtiny.ShinyAndTiny;

import java.util.function.Supplier;



// Esta clase se encarga de agregar una pestaña en el inventario creativo para nuestro mod, y ya de paso
//agregar automaticamente todos los items que creemos

public class CreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,ShinyAndTiny.MODID);





    //Toma los registros de la clase ModItems y los agrega automaticamente a la pestaña principal del mod
    public static final Supplier<CreativeModeTab> MAIN_TAB = CREATIVE_TABS.register("main_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.DIAMOND))
                    .title(Component.translatable("creativetab.minerymod"))
                    .displayItems((pParameters, pOutput) -> {
                        for (int i = 0; i < ModItems.ITEMS.getEntries().size(); i++) {
                            pOutput.accept(ModItems.ITEMS.getEntries().stream().toList().get(i).get().asItem());
                        }
                    }).build());



    //Esta funcion se encarga de realizar el registro como tal, la van a ver en muchas clases
    public static void registrar(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }

}
