package netro.content;

import mindustry.type.*;
@SuppressWarnings("unused")

public class NetroSectors {
    public static SectorPreset
        firstSteps;

    public static void load(){
        firstSteps = new SectorPreset("first-steps", NetroPlanets.netroniumPlanet, 15){{
            difficulty = 0;
            isLastSector = true;
        }};
    }
}