package net.rbk.shinyandtiny;


import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.rbk.shinyandtiny.DataComponent.ModDataComponent;
import net.rbk.shinyandtiny.Item.ModItems;
import net.rbk.shinyandtiny.Item.Properties.ModItemProperties;




@EventBusSubscriber(modid = ShinyAndTiny.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MineryClient {
    public MineryClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
      //  ModItemProperties.registerItemProperties();
    }
}
