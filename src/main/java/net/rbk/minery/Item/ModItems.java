package net.rbk.minery.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rbk.minery.Minery;

/*Esta clase se encarga de registrar los items. Minecraft necesita que registremos los items para
"Saber que existen", Al registrarlos podemos agregar varias propiedades y definir que tipo de item estamos
creando.
 */


public class ModItems {

    //Este objeto es el que se encarga de registrar todos nuestros Items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Minery.MODID);

   /*---------------------------------------------------------------------
/*Un registro de item siempre va a ser una variable del tipo Deferred<t> siendo t la clase de item que estemos creando.
  Para este proyecto la notation que vamos a seguir en los registros es MAYUSCULA_ESPACIO. Luego de poner el nombre
  nuestro item va a recibir un id, los id seran el mismo nombre pero todo en minuscula.
  despues de eso ya podemos crear las propiedades como   .stacksTo(64) o   .rarity(Rarity.RARE).
  En caso de que el item necesite tener un funcionamiento mas complejo, creamos una clase custom y extendemos de ahi.
    */

    /*---------------------------------------------------------------------




     */
    /* Ejemplo de item tipo Comida---------------
    public static final DeferredItem<Item> RAW_FROG_MEAT = ITEMS.register("raw_frog_meat",
            () -> new Item(new Item.Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(5).saturationModifier(3).effect(new MobEffectInstance(MobEffects.POISON, 100), 1).build())));

    /*Ejemplo de item Basic---------------
    public static final DeferredItem<Item> HEAVY_HORN = ITEMS.register("heavy_horn",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

     /*ejemplo de item Custom------------
    public static final DeferredItem<ShamanStaff> SHAMAN_STAFF = ITEMS.register("shaman_staff",
            () -> new ShamanStaff(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).durability(100)));
*/






    //Esta funcion se encarga de realizar el registro como tal, la van a ver en muchas clases
    public static void registrar(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
