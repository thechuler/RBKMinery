package net.rbk.minery.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.rbk.minery.Minery;

public class DGBlockState extends BlockStateProvider {
    public DGBlockState(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Minery.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
   //Aca se registran los modelos de los items
    }






    //Este metodo genera un bloque con la misma textura en todas sus caras excepto adelante y atras
    private void bloqueConCarasFrontales(DeferredBlock<?> deferredBlock,String bloque) {
        Block block = (Block) deferredBlock.get();
        simpleBlockWithItem(block, models().cube(
                BuiltInRegistries.BLOCK.getKey(block).getPath(), // nombre del modelo
                modLoc("block/" + bloque),   // cara inferior
                modLoc("block/" + bloque),     // cara superior
                modLoc("block/" + bloque + "_face"),  // frente
                modLoc("block/" + bloque + "_face"),  // parte trasera
                modLoc("block/" + bloque),    // derecha
                modLoc("block/" + bloque)  // izquierda
        ));
    }



    //Este metodo genera un bloque con la misma textura en todas sus caras
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
