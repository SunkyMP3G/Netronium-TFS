package netro.content;

import arc.graphics.Color;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.weather.*;
import mindustry.world.meta.*;

public class NetroWeathers {
    public static Weather
    acidRain, snowy, blizzard, mist;

    public static void load(){
        acidRain = new RainWeather("acid-rain"){{
            attrs.set(Attribute.light, -0.3f);
            status = NetroStatuses.weakCorrosion;
            sound = Sounds.rain;
            soundVol = 0.33f;
            color = Color.valueOf("edf3a9ff");
        }};

        snowy = new ParticleWeather("snowy"){{
            particleRegion = "particle";
            sizeMax = 9f;
            sizeMin = 2.6f;
            density = 1600f;
            status = NetroStatuses.snowy;

            sound = Sounds.windhowl;
            soundVol = 0f;
            soundVolOscMag = 1.5f;
            soundVolOscScl = 1100f;
            soundVolMin = 0.02f;
        }};

        blizzard = new ParticleWeather("blizzard"){{
            color = noiseColor = Color.valueOf("ffffff");
            particleRegion = "particle";
            drawNoise = true;
            useWindVector = true;
            sizeMax = 200f;
            sizeMin = 140f;
            minAlpha = 0f;
            maxAlpha = 0.2f;
            density = 1600f;
            baseSpeed = 12f;
            status = NetroStatuses.blizzard;
            attrs.set(Attribute.light, -1f);
            opacityMultiplier = 0.3f;
            force = 2.1f;
            sound = Sounds.wind;
            soundVol = 1f;
        }};

        mist = new ParticleWeather("mist"){{
            noiseLayers = 4;
            noiseLayerAlphaM = 0.7f;
            noiseLayerSpeedM = 2f;
            noiseLayerSclM = 0.6f;
            baseSpeed = 0.04f;
            color = noiseColor = Color.valueOf("ffffff");
            noiseScale = 1100f;
            noisePath = "fog";
            drawParticles = false;
            drawNoise = true;
            useWindVector = false;
            xspeed = 1f;
            yspeed = 1f;
            attrs.set(Attribute.light, -0.3f);
            attrs.set(Attribute.water, 0.06f);
            opacityMultiplier = 1f;
        }};
    }
}