package net.rbk.shinyandtiny.Item;


import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rbk.shinyandtiny.Item.custom.*;
import net.rbk.shinyandtiny.ShinyAndTiny;

/*Esta clase se encarga de registrar los items. Minecraft necesita que registremos los items para
"Saber que existen", Al registrarlos podemos agregar varias propiedades y definir que tipo de item estamos
creando.
 */


public class ModItems {

    //Este objeto es el que se encarga de registrar todos nuestros Items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ShinyAndTiny.MODID);


    public static final DeferredItem<Bananite> BANANITE = ITEMS.register("bananite",
            () -> new Bananite(
                    new Item.Properties()
                            .stacksTo(64)
                            .food(new FoodProperties.Builder().nutrition(5).saturationModifier(3).alwaysEdible().build()),
                    ORE_STATS.PURITY,   ORE_STATS.FLAVOR
            )
    );


    public static final DeferredItem<BananiteBat> BANANITE_BAT = ITEMS.register("bananite_bat",
            () -> new BananiteBat(new Item.Properties().durability(10).stacksTo(1).food(new FoodProperties.Builder().nutrition(5).saturationModifier(3).alwaysEdible().build())));


    public static final DeferredItem<BananiteGeode> BANANITE_GEODE = ITEMS.register("bananite_geode",
            () -> new BananiteGeode(new Item.Properties().stacksTo(64),
                    1,ModItems.BANANITE.get()));




    public static final DeferredItem<Hammer> HAMMER = ITEMS.register("hammer",
            () -> new Hammer(new Item.Properties().stacksTo(1).durability(100)));







    //Esta funcion se encarga de realizar el registro como tal, la van a ver en muchas clases
    public static void registrar(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
