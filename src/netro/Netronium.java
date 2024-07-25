package netro;

import arc.util.*;
import mindustry.mod.*;

import netro.content.*;

public class Netronium extends Mod{
    @Override
    public void loadContent(){
        NetroItems.load();
        NetroStatuses.load();
        NetroLiquids.load();
        NetroUnits.load();
        NetroBlocks.load();
        NetroWeathers.load();
        Log.info("Netronium mod (CU-1) is loaded successfully!");
    }
}