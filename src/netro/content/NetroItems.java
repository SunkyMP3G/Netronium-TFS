package netro.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class NetroItems {
    public static Item
    // T1 ores
        ironOre, aluminium,
    // T1 items
        ironIngot, ferroAluminium;

    public static void load(){
        ironOre = new Item("iron-ore", Color.valueOf("808080")){{
            hardness = 1;
            cost = 0.5f;
            buildable = true;
        }};

        aluminium = new Item("raw-aluminium", Color.valueOf("aaaaaa")){{ //TODO resprite
            hardness = 2;
            buildable = false;
        }};

        ironIngot = new Item("iron-ingot", Color.valueOf("707070")){{
            cost = 1f;
            buildable = true;
        }};

        ferroAluminium = new Item("ferroaluminium", Color.valueOf("909090")){{ //TODO resprite
            cost = 2f;
            buildable = true;
        }};
    }
}