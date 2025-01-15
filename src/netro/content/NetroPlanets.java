package netro.content;

import arc.graphics.*;

import mindustry.content.*;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.*;

public class NetroPlanets {
    public static Planet
        netroniumPlanet;

    public static void load(){
        netroniumPlanet = new Planet("netronium", Planets.sun, 1f, 2){{
            generator = new SerpuloPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 1, 0f, 0.15f, 2, Color.white.cpy().lerp(Color.valueOf("30d5c8"), 0.55f).a(0.65f), 0, 1f, 2f, 0.1f)
            );

            defaultCore = NetroBlocks.coreHusk;
            clearSectorOnLose = true;
            allowLaunchToNumbered = false;
            orbitRadius = 35;

            sectorSeed = 0;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.coreDestroyClear = true;
                r.lighting = true;
            };

            iconColor = Color.valueOf("30d5c8");
            atmosphereColor = Color.valueOf("cc4e5c");
            atmosphereRadIn = 0f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            alwaysUnlocked = true;
            landCloudColor = Pal.spore.cpy().a(0.5f);
        }};
    }
}