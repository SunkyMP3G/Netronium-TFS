package netro.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import arc.struct.Seq;
import classes.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import static mindustry.type.ItemStack.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.LogicBlock;
import mindustry.world.blocks.logic.MemoryBlock;
import mindustry.world.blocks.logic.MessageBlock;
import mindustry.world.blocks.logic.SwitchBlock;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

public class NetroBlocks {
    public static Block

    // Environment floors
    grassFloor, stoneFloor, iceFloor,

    // Ores
    oreIron, oreAlum,

    // Environment liquids
    acidFloor, lavaFloor,

    // Environment walls
    grassWall, stoneOreWall,

    // Lab and SSS environment
    techFloor1, techFloor2, techFloor3,

    // Ocean base environment
    oceanGridAcid, oceanGridAcidStairsH, oceanGridAcidStairsV,

    // Cores
    coreHusk,

    // Transport
    ironConveyor, ironRouter, ironUndConveyor,

    //Drills
    ironDrill, steelDrill,

    // Liquids
    alumPump, alumPipe, alumRouter, //TODO underground pipes

    // Factories
    alloyFurnace, steelFurnace, acidCleaner,

    // Energy
    ironNode,

    // Turrets
    origin, tesla, volcano, //Volcano is a turret. Change my mind

    // Walls
    ironWall, largeIronWall, steelWall, largeSteelWall,

    // Unit crafters
    ironassembler,

    // Logic
    netroProcessor, netroMessage, netroCell, netroSwitch,

    // Corrupted blocks... soon

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

        iceFloor = new Floor("ice-floor"){{
            variants = 3;
            speedMultiplier = 0.9f;
            dragMultiplier = 0.01f;
        }};


        // Ores
        oreIron = new OreBlock("ore-iron", NetroItems.ironIngot){{
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


        // Lab and SSS environment
        techFloor1 = new Floor("tech-floor-1"){{
            variants = 0;
        }};

        techFloor2 = new Floor("tech-floor-2"){{
            variants = 0;
        }};

        techFloor3 = new Floor("tech-floor-3"){{
            variants = 0;
        }};


        // Ocean environment
        oceanGridAcid = new Floor("ocean-grid-acid"){{
            variants = 0;
        }};

        oceanGridAcidStairsH = new Floor("ocean-grid-stairs-H-acid"){{
            variants = 0;
            blendGroup = oceanGridAcid;
            speedMultiplier = 0.9f;
        }};

        oceanGridAcidStairsV = new Floor("ocean-grid-stairs-V-acid"){{
            variants = 0;
            blendGroup = oceanGridAcid;
            speedMultiplier = 0.9f;
        }};


        // Cores
        coreHusk = new NetroCoreBlock("core-husk"){{
            requirements(Category.effect, with(NetroItems.ironIngot, 700));

            isFirstTier = true;
            unitType = NetroUnits.unite;
            health = 1400;
            armor = 1f;
            itemCapacity = 800;
            size = 2;
            thrusterLength = 12/2f;
            alwaysUnlocked = true;
            requiresCoreZone = true;
            powerProduction = 50 / 60f;
            squareSprite = false;

            unitCapModifier = 10;
        }};


        // Transport
        ironConveyor = new Conveyor("iron-conveyor"){{
            requirements(Category.distribution, with(NetroItems.ironIngot, 1));
            health = 10;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            underBullets = true;
        }};

        ironRouter = new Router("iron-router"){{
            requirements(Category.distribution, with(NetroItems.ironIngot, 3));
            health = 20;
            underBullets = true;
        }};

        ironUndConveyor = new DuctBridge("iron-und-conveyor"){{
            requirements(Category.distribution, with(NetroItems.ironIngot, 20));
            health = 30;
            range = 4;
            speed = 0.03f;
            underBullets = true;
        }};


        //Drills
        ironDrill = new Drill("iron-drill"){{
            requirements(Category.production, with(NetroItems.ironIngot, 40));
            drillTime = 200f;
            tier = 2;
            health = 100;
            size = 2;
            squareSprite = false;
            hasLiquids = false;
            liquidBoostIntensity = 1f;
        }};

        steelDrill = new Drill("steel-drill"){{
            requirements(Category.production, with(NetroItems.steelIngot, 30));
            consumePower(1 / 60f);
            drillTime = 140f;
            tier = 4;
            health = 200;
            size = 2;
            squareSprite = false;
            hasLiquids = false;
            liquidBoostIntensity = 1f;
        }};


        //Liquids
        alumPump = new Pump("aluminium-pump"){{
            requirements(Category.liquid, with(NetroItems.ferroAluminium, 10));
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

            consumeItems(with(NetroItems.ironIngot, 6, NetroItems.aluminium, 2));
            consumePower(1 / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
        }};

        steelFurnace = new GenericCrafter("steel-furnace"){{
            requirements(Category.crafting, with(NetroItems.ironIngot, 180, NetroItems.ferroAluminium, 60, NetroItems.netroCopper, 50));
            health = 400;
            craftEffect = Fx.none;
            outputItem = new ItemStack(NetroItems.steelIngot, 1);
            craftTime = 300f;
            size = 3;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 40;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawFlame(), new DrawDefault());
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.12f;
            squareSprite = false;

            consumeItems(with(NetroItems.ironIngot, 20, NetroItems.aluminium, 10, NetroItems.netroCopper, 10));
            consumePower(3 / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
        }};

        acidCleaner = new GenericCrafter("acid-cleaner"){{
            requirements(Category.crafting, with(NetroItems.ferroAluminium, 50, NetroItems.ironIngot, 80));
            health = 100;
            size = 2;
            consumeLiquid(NetroLiquids.acid, 10f / 60f);
            consumePower(2 / 60f);
            liquidCapacity = 30f;
            outputLiquids = LiquidStack.with(NetroLiquids.cleanWater, 10f / 60f);
            squareSprite = false;
            hasLiquids = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(NetroLiquids.acid){{padding = 3;}}, new DrawLiquidTile(NetroLiquids.cleanWater){{padding = 3;}}, new DrawDefault());
        }};


        // Energy
        ironNode = new BeamNode("iron-node"){{
            requirements(Category.power, with(NetroItems.ironIngot, 10));
            consumesPower = outputsPower = true;
            health = 40;
            range = 5;
            consumePowerBuffered(0f);
        }};


        // Turrets
        origin = new ItemTurret("origin"){{
            requirements(Category.turret, with(NetroItems.ironIngot, 70));
            ammo(
                    NetroItems.ironIngot, new BasicBulletType(6f, 15){{
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
            requirements(Category.turret, with(NetroItems.ironIngot, 150));
            shootType = new LightningBulletType(){{
                damage = 10;
                lightningLength = 20;
                collidesAir = false;
                ammoMultiplier = 1f;
                consumePower(4 / 60f);
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
            rotateSpeed = Float.POSITIVE_INFINITY;
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

        volcano = new PowerTurret("volcano"){{
            requirements(Category.turret, with());
            size = 4;
            health = 9999;
            armor = 9999f;
            targetable = destructible = false;
            range = 2000f;
            recoil = 0f;
            reload = 60f; // It will be controlled by world processor
            shootX = shootY = 0f;
            buildVisibility = BuildVisibility.sandboxOnly;
            rotateSpeed = Float.POSITIVE_INFINITY;
            drawer = new DrawTurret("volcanomouth-");
            ammoPerShot = 0;
            consumesPower = false;
            shootType = new BasicBulletType(0f, 0){{
                lifetime = 1f;
                ammoMultiplier = 0f;
                Draw.color(Color.black);
                Draw.z(121);
                shootEffect = new MultiEffect(Fx.titanExplosion, Fx.titanSmoke);
                shootSound = Sounds.titanExplosion;
                    reloadMultiplier = 1f;
                    despawnEffect = hitEffect = Fx.none;
                    width = 0f;
                    height = 0f;
                    fragBullets = 12;
                    fragBullet = new BasicBulletType(3f, 400f){{
                        health = 200;
                        hittable = true;
                        width = 24f;
                        height = 24f;
                        lifetime = 150f;
                        splashDamage = 110f;
                        splashDamageRadius = 64f;
                        pierce = true;
                        pierceCap = 4;
                        pierceBuilding = false;
                        pierceDamageFactor = 0.9f;
                        backColor = hitColor = trailColor = Color.valueOf("ea8878").lerp(Pal.redLight, 0.5f);
                        frontColor = Color.white;
                        trailLength = 32;
                        trailWidth = 3.35f;
                        trailSinScl = 2.5f;
                        trailSinMag = 0.5f;
                        trailEffect = Fx.none;
                        despawnShake = 7f;
                        Draw.color(Color.orange);
                        despawnEffect = hitEffect = new MultiEffect(Fx.titanExplosion, Fx.titanSmoke);
                        despawnSound = hitSound = Sounds.shootBig;
                        trailInterp = v -> Math.max(Mathf.slope(v), 0.8f);
                        shrinkY = 0.45f;
                        collidesGround = true;
                        collidesAir = true;
                    }};
                }};
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

        steelWall = new Wall("steel-wall"){{
            requirements(Category.defense, with(NetroItems.steelIngot, 3));
            health = 200;
            armor = 1f;
            size = 1;
        }};

        largeSteelWall = new Wall("large-steel-wall"){{
            requirements(Category.defense, with(NetroItems.steelIngot, 12));
            health = 800;
            armor = 1f;
            size = 2;
        }};


        // Unit crafters
        ironassembler = new UnitFactory("iron-assembler"){{
            requirements(Category.units, with(NetroItems.ironIngot, 130));
            health = 200;
            plans = Seq.with(
                    new UnitPlan(NetroUnits.hope, 60f * 50, with(NetroItems.ironIngot, 50)),
                    new UnitPlan(NetroUnits.spark, 60f * 30, with(NetroItems.ironIngot, 30)),
                    new UnitPlan(NetroUnits.kamikaze, 60f * 20, with(NetroItems.ironIngot, 20)),
                    new UnitPlan(NetroUnits.plasma, 60f * 75, with(NetroItems.ironIngot, 75, NetroItems.ferroAluminium, 40))
            );
            size = 3;
            consumePower(3 / 60f);
        }};

        // Logic
        netroProcessor = new LogicBlock("netro-processor"){{
            requirements(Category.logic, with(NetroItems.netroCopper, 90, NetroItems.ironIngot, 140, NetroItems.ferroAluminium, 60));
            health = 80;

            instructionsPerTick = 2;
            range = 8 * 8;
        }};

        netroMessage = new MessageBlock("netro-message"){{
            requirements(Category.logic, with(NetroItems.netroCopper, 30, NetroItems.ironIngot, 50));
            health = 40;
        }};

        netroSwitch = new SwitchBlock("netro-switch"){{
            requirements(Category.logic, with(NetroItems.netroCopper, 15, NetroItems.ironIngot, 30));
            health = 40;
        }};

        netroCell = new MemoryBlock("netro-cell"){{
            requirements(Category.logic, with(NetroItems.netroCopper, 25, NetroItems.ironIngot, 50));
            health = 100;

            memoryCapacity = 8;
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