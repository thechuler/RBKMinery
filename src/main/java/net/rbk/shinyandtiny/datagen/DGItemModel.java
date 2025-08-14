package net.rbk.shinyandtiny.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import net.rbk.shinyandtiny.Item.ModItems;
import net.rbk.shinyandtiny.ShinyAndTiny;
import net.rbk.shinyandtiny.ShinyAndTiny;

public class DGItemModel extends ItemModelProvider {
    public DGItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ShinyAndTiny.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BANANITE_GEODE.get());
        basicItem(ModItems.BANANITE.get());
        handheldItem(ModItems.BANANITE_BAT.get());
        handheldItem(ModItems.HAMMER.get());
    }


    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ShinyAndTiny.MODID,"item/" + item.getId().getPath()));
    }



}

