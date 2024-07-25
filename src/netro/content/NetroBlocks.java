package netro.content;

import arc.graphics.Color;
import arc.struct.Seq;
import classes.NetroCoreBlock;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import static mindustry.type.ItemStack.with;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

public class NetroBlocks {
    public static Block

    // Environment floors
    grassFloor, stoneFloor,

    // Ores
    oreIron, oreAlum,

    // Environment liquids
    acidFloor, lavaFloor,

    // Environment walls
    grassWall, stoneOreWall,

    // Cores
    coreHusk,

    // Transport
    ironConveyor, ironRouter, ironUndConveyor,

    //Drills
    ironDrill,

    // Liquids
    alumPump, alumPipe, alumRouter, //TODO underground pipes

    // Factories
    ironSmelter, alloyFurnace, acidCleaner,

    // Energy
    ironNode,

    // Turrets
    origin, tesla,

    // Walls
    ironWall, largeIronWall,

    // Unit crafters
    ironassembler,

    // Editor only
    supersteelWall, largeSupersteelWall;

    public static void load(){
        // Environment floors
        grassFloor = new Floor("grass-floor"){{
            variants = 3;
        }};

        stoneFloor = new Floor("stone-floor"){{
            variants = 3;
        }};


        // Ores
        oreIron = new OreBlock("ore-iron", NetroItems.ironOre){{
            variants = 2;
        }};

        oreAlum = new OreBlock("ore-alum", NetroItems.aluminium){{
            variants = 2;
        }};


        // Environment liquids
        acidFloor = new Floor("acid-floor"){{
            speedMultiplier = 0.6f;
            variants = 0;
            liquidDrop = NetroLiquids.acid;
            isLiquid = true;
            status = NetroStatuses.corrosion;
            statusDuration = 300f;
            drownTime = 120f;
            cacheLayer = CacheLayer.water;
            albedo = 0.5f;
        }};

        lavaFloor = new Floor("lava-floor"){{
            speedMultiplier = 0.4f;
            variants = 0;
            liquidDrop = NetroLiquids.lava;
            isLiquid = true;
            status = NetroStatuses.lavaMelting;
            statusDuration = 600f;
            drownTime = 80f;
            cacheLayer = CacheLayer.slag;
            albedo = 0f;
            lightColor = Color.valueOf("f8c266");
            lightRadius = 40f;
        }};


        // Environment walls
        grassWall = new StaticWall("grass-wall"){{
            variants = 3;
        }};

        stoneOreWall = new StaticWall("stone-ore-wall"){{
            variants = 3;
        }};


        // Cores
        coreHusk = new NetroCoreBlock("core-husk"){{
            requirements(Category.effect, with(NetroItems.ironOre, 600, NetroItems.ironIngot, 300));

            isFirstTier = true;
            unitType = NetroUnits.unite;
            health = 1400;
            armor = 1f;
            itemCapacity = 800;
            size = 2;
            thrusterLength = 12/2f;
            alwaysUnlocked = true;
            requiresCoreZone = true;
            powerProduction = 25f;
            squareSprite = false;

            unitCapModifier = 10;
        }};


        // Transport
        ironConveyor = new Conveyor("iron-conveyor"){{
            requirements(Category.distribution, with(NetroItems.ironOre, 1));
            health = 10;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            underBullets = true;
        }};

        ironRouter = new Router("iron-router"){{
            requirements(Category.distribution, with(NetroItems.ironOre, 3));
            health = 20;
            underBullets = true;
        }};

        ironUndConveyor = new DuctBridge("iron-und-conveyor"){{
            requirements(Category.distribution, with(NetroItems.ironOre, 10));
            health = 30;
            range = 4;
            speed = 0.03f;
            underBullets = true;
        }};


        //Drills
        ironDrill = new Drill("iron-drill"){{
        requirements(Category.production, with(NetroItems.ironOre, 20));
        consumePower(0.1f);

        drillTime = 180f;
        tier = 2;
        health = 100;
        size = 2;
        squareSprite = false;
        hasLiquids = false;
        liquidBoostIntensity = 1f;
        }};


        //Liquids
        alumPump = new Pump("aluminium-pump"){{
            requirements(Category.liquid, with(NetroItems.ferroAluminium, 6));
            consumePower(0.1f);
            underBullets = true;
            pumpAmount = 5f / 60f;
            squareSprite = false;
        }};

        alumPipe = new Conduit("aluminium-pipe"){{
            requirements(Category.liquid, with(NetroItems.ferroAluminium, 1));
            underBullets = true;
            health = 10;
        }};

        alumRouter = new LiquidRouter("aluminium-router"){{
            requirements(Category.liquid, with(NetroItems.ferroAluminium, 3));
            health = 20;
            liquidCapacity = 18f;
            underBullets = true;
            solid = false;
        }};


        // Factories
        ironSmelter = new GenericCrafter("iron-smelter"){{
            requirements(Category.crafting, with(NetroItems.ironOre, 70));
            health = 150;
            craftEffect = Fx.none;
            outputItem = new ItemStack(NetroItems.ironIngot, 1);
            craftTime = 40f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 10;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.12f;
            squareSprite = false;

            consumeItems(with(NetroItems.ironOre, 2));
            consumePower(1f);
        }};

        alloyFurnace = new GenericCrafter("alloy-furnace"){{
            requirements(Category.crafting, with(NetroItems.ironIngot, 90));
            health = 200;
            craftEffect = Fx.none;
            outputItem = new ItemStack(NetroItems.ferroAluminium, 1);
            craftTime = 120f;
            size = 3;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 20;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawFlame(), new DrawDefault());
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.12f;
            squareSprite = false;

            consumeItems(with(NetroItems.ironOre, 2, NetroItems.aluminium, 2));
            consumePower(3f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
        }};

        acidCleaner = new GenericCrafter("acid-cleaner"){{
            requirements(Category.crafting, with(NetroItems.ferroAluminium, 50, NetroItems.ironIngot, 80));
            health = 100;
            size = 2;
            consumeLiquid(NetroLiquids.acid, 10f / 60f);
            consumePower(1f);
            liquidCapacity = 30f;
            outputLiquids = LiquidStack.with(NetroLiquids.cleanWater, 10f / 60f);
            squareSprite = false;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(NetroLiquids.acid){{padding = 3;}}, new DrawLiquidTile(NetroLiquids.cleanWater){{padding = 3;}}, new DrawDefault());
        }};


        // Energy
        ironNode = new BeamNode("iron-node"){{
            requirements(Category.power, with(NetroItems.ironOre, 6));
            consumesPower = outputsPower = true;
            health = 40;
            range = 5;
            consumePowerBuffered(100f);
        }};


        // Turrets
        origin = new ItemTurret("origin"){{
            requirements(Category.turret, with(NetroItems.ironOre, 75, NetroItems.ironIngot, 40));
            ammo(
                    NetroItems.ironOre, new BasicBulletType(6f, 15){{
                        width = 8f;
                        height = 10f;
                        lifetime = 19f;
                        buildingDamageMultiplier = 0.01f;
                    }});

            shootSound = Sounds.shoot;
            squareSprite = false;

            ammoPerShot = 1;
            drawer = new DrawTurret("netrobase-");
            outlineColor = Pal.darkOutline;
            size = 2;
            reload = 35f;
            recoil = 2f;
            range = 120;
            shootCone = 3f;
            health = 200;
            rotateSpeed = 2f;
            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 7.5f / 60f));
            coolantMultiplier = 5f;
        }};

        tesla = new PowerTurret("tesla"){{
            requirements(Category.turret, with(NetroItems.ironIngot, 80));
            shootType = new LightningBulletType(){{
                damage = 10;
                lightningLength = 20;
                collidesAir = false;
                ammoMultiplier = 1f;
                consumePower(2f);
                shootX = shootY = 0f;

                lightningType = new BulletType(0.0001f, 0f){{
                    lifetime = Fx.lightning.lifetime;
                    hitEffect = Fx.hitLancer;
                    despawnEffect = Fx.none;
                    status = NetroStatuses.shock;
                    statusDuration = 6f; //0.1 sec
                    hittable = false;
                    collidesAir = false;
                    lightColor = Color.white;
                    buildingDamageMultiplier = 0.01f;
                }};
            }};
            reload = 60f; //1 sec
            shootCone = 40f;
            rotateSpeed = Float.POSITIVE_INFINITY; //rotation isn't seen, so, the rotate speed is useless
            targetAir = false;
            drawer = new DrawTurret("tesla-");
            range = 125f;
            shootEffect = Fx.lightningShoot;
            recoil = 0f;
            size = 2;
            health = 110;
            shootSound = Sounds.spark;
            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 15f / 60f));
            coolantMultiplier = 2f;
        }};

        // Walls
        ironWall = new Wall("iron-wall"){{
            requirements(Category.defense, with(NetroItems.ironIngot, 6));
            health = 100;
            armor = 1f;
            size = 1;
        }};

        largeIronWall = new Wall("large-iron-wall"){{
            requirements(Category.defense, with(NetroItems.ironIngot, 24));
            health = 400;
            armor = 1f;
            size = 2;
        }};


        // Unit crafters
        ironassembler = new UnitFactory("iron-assembler"){{
            requirements(Category.units, with(NetroItems.ironOre, 90, NetroItems.ironIngot, 60));
            health = 200;
            plans = Seq.with(
                    new UnitPlan(NetroUnits.hope, 60f * 30, with(NetroItems.ironIngot, 40)),
                    new UnitPlan(NetroUnits.spark, 60f * 25, with(NetroItems.ironIngot, 30)),
                    new UnitPlan(NetroUnits.kamikaze, 60f * 15, with(NetroItems.ironIngot, 20)),
                    new UnitPlan(NetroUnits.plasma, 60f * 40, with(NetroItems.ironIngot, 60, NetroItems.ferroAluminium, 30))
            );
            size = 3;
            consumePower(2.5f);
        }};


        // Editor only
        supersteelWall = new Wall("supersteel-wall"){{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with());
            health = Integer.MAX_VALUE;
            armor = Float.POSITIVE_INFINITY;
            size = 1;
            absorbLasers = true;
            drawTeamOverlay = false;
            targetable = false;
        }};

        largeSupersteelWall = new Wall("large-supersteel-wall"){{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with());
            health = Integer.MAX_VALUE;
            armor = Float.POSITIVE_INFINITY;
            size = 2;
            absorbLasers = true;
            drawTeamOverlay = false;
            targetable = false;
        }};
    }
}