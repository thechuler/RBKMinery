package net.rbk.shinyandtiny.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.rbk.shinyandtiny.Item.ModItems;

import java.util.concurrent.CompletableFuture;


//este data provider se encarga de generar recetas como mesa de crafteo, horno, etc.

public class DGRecetas extends RecipeProvider implements IConditionBuilder {
    public DGRecetas(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BANANITE_BAT.get())
                .pattern("  B")
                .pattern(" B ")
                .pattern("S  ")
                .define('B', ModItems.BANANITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_banite", has(ModItems.BANANITE.get()))
                .save(recipeOutput);

    }




}
