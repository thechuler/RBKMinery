package net.rbk.shinyandtiny.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rbk.shinyandtiny.Bloques.ModBlocks;
import net.rbk.shinyandtiny.ShinyAndTiny;

import java.util.concurrent.CompletableFuture;

public class DGBlockTagProvider extends BlockTagsProvider {

    public DGBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ShinyAndTiny.MODID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BANITE_ORE.get());
    }



}
