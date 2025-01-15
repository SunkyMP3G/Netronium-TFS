package netro.content;

import arc.struct.*;
import static mindustry.Vars.*;
import static mindustry.content.TechTree.*;
import mindustry.type.*;
@SuppressWarnings("all")

public class NetroTechTree {
    public static void load(){
        var costMultipliers = new ObjectFloatMap<Item>();
        for(var item : content.items()) costMultipliers.put(item, 0f);

        costMultipliers.put(NetroItems.ironIngot, 0f);
        costMultipliers.put(NetroItems.ferroAluminium, 0f);
        costMultipliers.put(NetroItems.steelIngot, 0f);
        costMultipliers.put(NetroItems.netroCopper, 0f);

        NetroPlanets.netroniumPlanet.techTree = nodeRoot("netronium-tt", NetroBlocks.coreHusk, true, () -> {
            node(NetroBlocks.ironDrill, () -> {
                node(NetroBlocks.steelDrill, () -> {
                });
            });

            node(NetroBlocks.ironNode, () -> {
            });

            node(NetroBlocks.ironConveyor, () -> {
                node(NetroBlocks.ironRouter, () -> {
                    node(NetroBlocks.ironUndConveyor, () -> {
                    });
                });
            });

            node(NetroBlocks.alumPump, () -> {
                node(NetroBlocks.alumPipe, () -> {
                    node(NetroBlocks.alumRouter, () -> {
                    });
                });
            });

            node(NetroBlocks.alloyFurnace, () -> {
                node(NetroBlocks.acidCleaner, () -> {
                });
                node(NetroBlocks.steelFurnace, () -> {
                });
                node(NetroBlocks.netroProcessor, () -> {
                    node(NetroBlocks.netroSwitch, () -> {
                    });
                    node(NetroBlocks.netroMessage, () -> {
                    });
                    node(NetroBlocks.netroCell, () -> {
                    });
                });
            });

            node(NetroBlocks.origin, () -> {
                node(NetroBlocks.tesla, () -> {
                });
                node(NetroBlocks.ironWall, () -> {
                    node(NetroBlocks.largeIronWall, () -> {
                    });
                    node(NetroBlocks.steelWall, () -> {
                        node(NetroBlocks.largeSteelWall, () -> {
                        });
                    });
                });
            });

            node(NetroBlocks.ironassembler, () -> {
                node(NetroUnits.spark);
                node(NetroUnits.hope);
                node(NetroUnits.kamikaze);
                node(NetroUnits.plasma);
            });

            nodeProduce(NetroItems.ironIngot, () -> {
                nodeProduce(NetroItems.aluminium, () -> {
                    nodeProduce(NetroItems.ferroAluminium, () -> {
                    });
                });
                nodeProduce(NetroItems.zinc, () -> {
                });
                nodeProduce(NetroItems.netroCopper, () -> {
                    nodeProduce(NetroItems.steelIngot, () -> {
                    });
                });
                nodeProduce(NetroLiquids.acid, () -> {
                    nodeProduce(NetroLiquids.cleanWater, () -> {
                    });
                    nodeProduce(NetroLiquids.lava, () -> {
                    });
                });
            });
        });
    }
}