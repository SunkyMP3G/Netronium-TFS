package netro.content;

import arc.graphics.*;
import classes.NetroUnitType;
import mindustry.content.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ai.types.*;
import mindustry.type.weapons.*;
//@SuppressWarnings("all")

public class NetroUnits {
    public static UnitType

    // Core units
    unite,

    //T1
    hope, spark, kamikaze, plasma;

    public static void load() {

        //Core units
        unite = new NetroUnitType("unite"){{
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500);
            isEnemy = false;
            this.constructor = UnitEntity::create;

            range = 60f;
            faceTarget = true;
            targetPriority = -2;
            lowAltitude = false;
            mineWalls = true;
            mineFloor = true;
            mineHardnessScaling = false;
            flying = true;
            mineSpeed = 4f;
            mineTier = 1;
            buildSpeed = 1f;
            drag = 0.08f;
            speed = 3.8f;
            rotateSpeed = 5f;
            accel = 0.08f;
            itemCapacity = 50;
            health = 100f;
            armor = 1f;
            hitSize = 9f;

            fogRadius = 0f;
            targetable = false;
            hittable = false;

            setEnginesMirror(
                    new UnitEngine(18 / 4f, -17 / 4f, 2f, 315f)
            );

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 0f;
                y = 5f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                repairSpeed = 2f;
                fractionRepairSpeed = 0.02f;
                aimDst = 0f;
                shootCone = 15f;
                mirror = false;

                targetUnits = false;
                targetBuildings = true;
                controllable = true;
                laserColor = Pal.heal;
                healColor = Pal.heal;

                bullet = new BulletType(){{
                    maxRange = 60f;
                }};
            }});
        }};

        //T1
        hope = new NetroUnitType("hope"){{
            hitSize = 9f;
            health = 130f;
            armor = 2f;
            speed = 0.6f;
            flying = false;
            this.constructor = MechUnit::create;
            itemCapacity = 0;

            weapons.add(new Weapon() {{
                reload = 80f;
                mirror = false;
                top = false;
                x = y = 0;
                shootSound = Sounds.laser;
                bullet = new LaserBulletType(){{
                    damage = 35f;
                    recoil = 2f;
                    sideAngle = 20f;
                    sideWidth = 1f;
                    sideLength = 20f;
                    length = 40f;
                    pierce = false;
                    colors = new Color[]{Pal.neoplasm1.cpy().a(0.4f), Pal.neoplasm1, Color.white};
                }};
            }});
        }};

        spark = new NetroUnitType("spark"){{
            hitSize = 8f;
            health = 90f;
            armor = 0f;
            speed = 2.5f;
            drag = accel = 0.07f;
            flying = true;
            this.constructor = UnitEntity::create;
            itemCapacity = 0;

            weapons.add(new Weapon("netroniummod-spark-weapon") {{
                reload = 20f;
                mirror = true;
                top = false;
                x = y = 2.75f;
                alternate = true;
                shootSound = Sounds.shoot;
                ejectEffect = Fx.casing1;
                recoil = 0.7f;
                bullet = new BasicBulletType() {{
                    damage = 15f;
                    speed = 2f;
                    width = height = 8;
                }};
            }});
        }};

        kamikaze = new NetroUnitType("kamikaze"){{
            hitSize = 8f;
            health = 25f;
            armor = 0f;
            speed = 2.2f;
            range = 40f;
            drag = accel = 0.08f;
            flying = true;
            this.constructor = UnitEntity::create;
            itemCapacity = 0;

            weapons.add(new Weapon() {{
                shootOnDeath = true;
                reload = 24f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                x = shootY = 0f;
                mirror = false;
                bullet = new BulletType() {{
                    collidesTiles = false;
                    collides = false;
                    hitSound = Sounds.explosion;

                    rangeOverride = 30f;
                    hitEffect = Fx.pulverize;
                    speed = 0f;
                    splashDamageRadius = 40f;
                    instantDisappear = true;
                    splashDamage = 30f;
                    killShooter = true;
                    hittable = false;
                    collidesAir = collidesGround = true;
                }};
            }});
        }};

        plasma = new NetroUnitType("plasma"){{
            hitSize = 9f;
            health = 200;
            armor = 3f;
            speed = 0.68f;
            flying = false;
            this.constructor = MechUnit::create;
            itemCapacity = 0;

            abilities.add(new ShieldArcAbility(){{
                region = "netroniummod-plasma-shield";
                radius = 20f;
                angle = 80f;
                regen = 15f / 60;
                cooldown = 60f * 10f;
                max = 250f;
                y = -12f;
                width = 4f;
                whenShooting = false;
            }});
        }};
    }}