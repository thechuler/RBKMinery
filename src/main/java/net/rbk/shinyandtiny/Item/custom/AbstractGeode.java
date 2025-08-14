package net.rbk.shinyandtiny.Item.custom;

import net.minecraft.world.item.Item;




public abstract class AbstractGeode extends AbstractOre{
    private int breakDifficulty;  //--Que tan dificil sera para el hammer abrir la geoda, entre mas grande mas dificil
    private Item drop; // Lo que soltara la geoda cuando se abra

    public AbstractGeode(Properties properties,int breakDifficulty,Item drop) {
        super(properties);
        this.breakDifficulty = breakDifficulty;
        this.drop = drop;
    }



    public Item getDrop() {
        return drop;
    }

    public int getBreakDifficulty() {
        return breakDifficulty;
    }








    }



