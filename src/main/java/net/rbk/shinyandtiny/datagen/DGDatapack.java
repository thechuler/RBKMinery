package net.rbk.shinyandtiny.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.rbk.shinyandtiny.GeneracionDeMundo.ModBiomeModifiers;
import net.rbk.shinyandtiny.ShinyAndTiny;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DGDatapack extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);
    public DGDatapack(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ShinyAndTiny.MODID));
    }
}
