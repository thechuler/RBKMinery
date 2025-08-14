package net.rbk.shinyandtiny.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.rbk.shinyandtiny.ShinyAndTiny;
import net.rbk.shinyandtiny.ShinyAndTiny;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;


/* Esta clase es muy importante ya que se dedica a crear varios datos de manera automatica
para que no tengamos que crear jsons a mano. Esta en especifico se encarga de obtener datos
de los proveedores (Marcados como DGNombre) y generar los archivos json correspondientes.
 */

@EventBusSubscriber(modid = ShinyAndTiny.MODID)
public class GenerarDatos {


    @SubscribeEvent
    public static void ObtenerDatos(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeClient(), new DGItemModel(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new DGDatapack(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new DGRecetas(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new DGBlockState(packOutput,existingFileHelper ));
        generator.addProvider(event.includeServer(), new DGBlockTagProvider(packOutput,lookupProvider,existingFileHelper ));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(DGBlockLootTable::new, LootContextParamSets.BLOCK)), lookupProvider));

    }
}
