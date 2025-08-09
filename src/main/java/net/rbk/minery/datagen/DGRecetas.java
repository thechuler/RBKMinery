package net.rbk.minery.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import java.util.concurrent.CompletableFuture;


//este data provider se encarga de generar recetas como mesa de crafteo, horno, etc.

public class DGRecetas extends RecipeProvider implements IConditionBuilder {
    public DGRecetas(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        //Aca se pueden registrar las recetas de crafteo
    }




}
