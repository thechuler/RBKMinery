package net.rbk.shinyandtiny.DataComponent;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rbk.shinyandtiny.ShinyAndTiny;

import java.util.function.Supplier;


//Esta clase se encarga de realizar el registro de datos adicionales que pueden aplicarse a items,bloques,entidades,etc
public class ModDataComponent {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, ShinyAndTiny.MODID);


    public static final Supplier<DataComponentType<Float>> PURITY = DATA_COMPONENTS.register(
            "purity", () -> DataComponentType.<Float>builder()
                    .persistent(Codec.FLOAT)
                    .build()
    );


    public static final Supplier<DataComponentType<Integer>> FLAVOR = DATA_COMPONENTS.register(
            "flavor", () -> DataComponentType.<Integer>builder()
                    .persistent(Codec.INT)
                    .build()
    );





    public static void registrar(IEventBus bus) {
        DATA_COMPONENTS.register(bus);
    }

}
