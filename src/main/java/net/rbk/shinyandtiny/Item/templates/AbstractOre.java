package net.rbk.shinyandtiny.Item.templates;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.rbk.shinyandtiny.DataComponent.ModDataComponent;

import java.util.Random;

//Base para crear nuevos ores
public abstract class  AbstractOre extends Item {
    private final ORE_STATS[] allowedStats;


    //Cuando vayan a crear un ore,este va a aceptar propiedades basicas de un item pero tambien ORE_STATS
    public AbstractOre(Properties properties, ORE_STATS... allowedStats) {
        super(properties);
        this.allowedStats = allowedStats;
    }




    public ORE_STATS[] getAllowedStats() {
        return allowedStats;
    }



    //Genera Pureza del 0 al 100
    protected static float generatePurity() {
        return (float) Math.random()*100;
    }

    //Genera Sabor 1 al 5
    protected static int generateFlavor() {
        Random rand = new Random();
        return rand.nextInt(5) + 1;
    }





    //Metodo que aplica las stats en un momento indicado, como cuando el hammer rompe una geoda
    public  void applyStats(ItemStack stack,ORE_STATS ... stats){
        for (ORE_STATS stat : stats) {
            switch (stat) {
                case PURITY -> setPurity(stack);
                case FLAVOR -> setFlavor(stack);
                //Si se agregan mas van aca B)
            }
        }
    }




    //Setea el DataComponent
    public static void setPurity(ItemStack stack){
        float purity = generatePurity();
        if(getPurity(stack) == -1){
            stack.set(ModDataComponent.PURITY,purity);
        }
    }

    //Setea el DataComponent
    public static float getPurity(ItemStack stack) {
        if (stack.has(ModDataComponent.PURITY)) {
            return stack.get(ModDataComponent.PURITY).floatValue();
        }
        return -1f;
    }



    //Getter, se usa para poder obtener el valor en otras clases
    public static int getFlavor(ItemStack stack) {
        if (stack.has(ModDataComponent.FLAVOR)) {
            return stack.get(ModDataComponent.FLAVOR).intValue();
        }
        return -1;
    }


    //Getter, se usa para poder obtener el valor en otras clases
    public static void setFlavor(ItemStack stack){
        int flavor = generateFlavor();
        if(getFlavor(stack) == -1){
            stack.set(ModDataComponent.FLAVOR,flavor);
        }
    }







}
