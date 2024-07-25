package netro.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;

public class NetroLiquids {

    public static Liquid
    acid, lava, cleanWater;

    public static void load(){
        acid = new Liquid("acid", Color.valueOf("bef574")){{
            viscosity = 0.7f;
            heatCapacity = 0.3f;
            temperature = 0.5f;
            coolant = false;
            barColor = Color.valueOf("bef574");
            effect = NetroStatuses.corrosion;
            capPuddles = false;
        }};

        lava = new Liquid("lava", Color.valueOf("de9458")){{
            viscosity = 0.9f;
            heatCapacity = 0f;
            temperature = 2f;
            barColor = Color.valueOf("de9458");
            effect = NetroStatuses.lavaMelting;
            capPuddles = false;
        }};

        cleanWater = new Liquid("clean-water", Color.valueOf("7a8cdc")){{ //TODO recolor
            viscosity = 0.4f;
            temperature = 0.4f;
            heatCapacity = 0.4f;
            barColor = Color.valueOf("7a8cdc");
            effect = StatusEffects.wet; //TODO new status maybe?
            capPuddles = false;
        }};
    }
}