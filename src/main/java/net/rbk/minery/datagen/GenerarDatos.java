package net.rbk.minery.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.rbk.minery.Minery;
import java.util.concurrent.CompletableFuture;


/* Esta clase es muy importante ya que se dedica a crear varios datos de manera automatica
para que no tengamos que crear jsons a mano. Esta en especifico se encarga de obtener datos
de los proveedores (Marcados como DGNombre) y generar los archivos json correspondientes.
 */

@EventBusSubscriber(modid = Minery.MODID)
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
    }
}
