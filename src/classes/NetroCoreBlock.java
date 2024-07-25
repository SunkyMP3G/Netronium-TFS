package classes;

import arc.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.meta.*;
@SuppressWarnings("unused")

public class NetroCoreBlock extends CoreBlock {
    public float powerProduction;
    public Stat generationType = Stat.basePowerGeneration;
    public NetroCoreBlock(String name) {
        super(name);
        squareSprite = false;
        hasPower = true;
        outputsPower = true;
        consumesPower = false;
        sync = true;
        priority = 10f;
        flags = EnumSet.of(BlockFlag.generator);
    }


    @Override
    public void setStats(){
        super.setStats();
        stats.add(generationType, powerProduction * 60.0f, StatUnit.powerSecond);
    }

    @Override
    public void setBars(){
        super.setBars();

        this.addBar("poweroutput", entity -> new Bar(
                () -> Core.bundle.format("bar.poweroutput", powerProduction * 60),
                () -> Pal.powerBar,
                () -> 1
	    ));
    }

    public class NetroCoreBuild extends CoreBuild{
        @Override
        public float getPowerProduction(){
            return powerProduction;
        }
    }

    @Override
    protected TextureRegion[] icons() {
        return teamRegion.found() ? new TextureRegion[]{region, teamRegions[Team.sharded.id]} : new TextureRegion[]{region};
    }
}