package netro.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

import java.util.ArrayList;

public class NetroItems {
    public static Item
    // T1
        ironIngot, aluminium, zinc, ferroAluminium,
    // T2
        netroCopper, steelIngot,
    // T... (For later)
        neutroniumGem;

    public static void load(){
        ironIngot = new Item("iron-ingot", Color.valueOf("707070")){{
            hardness = 1; // Mineable by iron drill or better
            cost = 1f;
            buildable = true;
        }};

        zinc = new Item("zinc", Color.valueOf("858585")){{
            hardness = 2;
        }};

        aluminium = new Item("raw-aluminium", Color.valueOf("aaaaaa")){{ //TODO resprite
            hardness = 3;
            buildable = false;
        }};

        ferroAluminium = new Item("ferroaluminium", Color.valueOf("909090")){{ //TODO resprite
            cost = 2f;
            buildable = true;
        }};

        netroCopper = new Item("netrocopper", Color.valueOf("d99d73")){{
            hardness = 4; // Mineable by aluminium drill or better
            cost = 3f;
            buildable = true;
        }};

        steelIngot = new Item("steel-ingot", Color.valueOf("d99d73")){{
            cost = 5f;
            buildable = true;
        }};

        neutroniumGem = new Item("neutronium-gem", Color.valueOf("ffa8af")){{ //TODO rebalance
            cost = 20f;
            buildable = true;
            radioactivity = 3.33f;
            charge = 1f;
        }};
    }
}