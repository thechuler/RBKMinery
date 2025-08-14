package net.rbk.shinyandtiny.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.rbk.shinyandtiny.Bloques.ModBlocks;
import net.rbk.shinyandtiny.Item.ModItems;

import java.util.Set;

public class DGBlockLootTable extends BlockLootSubProvider {
    protected DGBlockLootTable(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }


@Override
    protected void generate() {
add(ModBlocks.BANITE_ORE.get(),
        block -> createOreDrop(ModBlocks.BANITE_ORE.get(), ModItems.BANANITE_GEODE.get()));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOQUES.getEntries().stream().map(Holder::value)::iterator;
    }
}
