package net.rbk.shinyandtiny.GeneracionDeMundo;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.neoforge.common.world.BiomeModifier;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.rbk.shinyandtiny.ShinyAndTiny;


public class ModBiomeModifiers {


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        //aca se pueden registrar modificadores de biomas
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ShinyAndTiny.MODID, name));
    }
}