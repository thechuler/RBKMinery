package net.rbk.shinyandtiny;

import net.rbk.shinyandtiny.Bloques.ModBlocks;
import net.rbk.shinyandtiny.DataComponent.ModDataComponent;
import net.rbk.shinyandtiny.Efectos.ModEffects;
import net.rbk.shinyandtiny.Item.CreativeTab;
import net.rbk.shinyandtiny.Item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


@Mod(ShinyAndTiny.MODID)
public class ShinyAndTiny {

    public static final String MODID = "shinyandtiny";

    public static final Logger LOGGER = LogUtils.getLogger();


    public ShinyAndTiny(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModEffects.registrar(modEventBus);
        ModItems.registrar(modEventBus);
        ModDataComponent.registrar(modEventBus);
        CreativeTab.registrar(modEventBus);
        ModBlocks.register(modEventBus);


       modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}


    private void addCreative(BuildCreativeModeTabContentsEvent event) {}


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
