package net.rbk.shinyandtiny.Bloques;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rbk.shinyandtiny.Item.ModItems;
import net.rbk.shinyandtiny.ShinyAndTiny;
import java.util.function.Supplier;

//Esta clase es muy parecida a la de los items en cuanto a registro solo que con algunas salvedades.

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOQUES =
            DeferredRegister.createBlocks(ShinyAndTiny.MODID);




    public static final DeferredBlock<Block> BANITE_ORE = registerBlock("bananite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.STONE)));





    //Este metodo se encarga de crear un Item asociado a cada uno de nuestros bloques para que sea colocado
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }





    //sinceramente no me acuerdo bien para que se usaba este metodo, si lo sacas explota todo asi que imagino que es
    //importante
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOQUES.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }



    //Registrar Bloques.
    public static void register(IEventBus eventBus) {
        BLOQUES.register(eventBus);
    }
}
