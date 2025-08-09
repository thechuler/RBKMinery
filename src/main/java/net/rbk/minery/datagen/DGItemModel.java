package net.rbk.minery.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rbk.minery.Minery;

public class DGItemModel extends ItemModelProvider {
    public DGItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Minery.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //aca se pueden registrar los modelos de los items
      //  basicItem(ModItems.RAW_FROG_MEAT.get());

    }
    }

