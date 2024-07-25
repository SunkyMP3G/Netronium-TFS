package classes;

import mindustry.graphics.*;
import mindustry.type.UnitType;

public class NetroBossUnit extends UnitType {
    public NetroBossUnit(String name) {
        super(name);
        outlineColor = Pal.neoplasmMid;
        crashDamageMultiplier = 100f; // Are bosses heavy? Yes, of course

        //Would be too stupid for a boss to drown :D
        canDrown = false;
        hovering = true;

        targetPriority = 3f;
        hidden = false; //Temporarily false
        itemCapacity = 0;
    }
}