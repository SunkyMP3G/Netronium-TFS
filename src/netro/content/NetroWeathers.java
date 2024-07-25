package netro.content;

import arc.graphics.Color;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.weather.*;
import mindustry.world.meta.*;

public class NetroWeathers {
    public static Weather
    acidRain, eruption;

    public static void load(){
        acidRain = new RainWeather("acid-rain"){{
            attrs.set(Attribute.light, -0.75f);
            status = NetroStatuses.weakCorrosion;
            sound = Sounds.rain;
            soundVol = 0.33f;
            color = Color.valueOf("edf3a9ff");
        }};

        eruption = new RainWeather("eruption"){{
            attrs.set(Attribute.light, -1f);
            sound = Sounds.rain;
            soundVol = 1f;
            color = Color.valueOf("f8c266ff");
            density = 1000f;
            status = NetroStatuses.lavaEruption;
        }};
    }
}