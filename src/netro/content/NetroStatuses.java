package netro.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;


public class NetroStatuses {
    public static StatusEffect
    corrosion, weakCorrosion, lavaMelting, shock, corrupted, snowy, blizzard;

    public static void load(){
        corrosion = new StatusEffect("corrosion"){{ // When you step on the acid floor
            color = Pal.plastanium;
            damage = 0.2f;
            speedMultiplier = 0.7f;
            healthMultiplier = 0.8f;
        }};

        weakCorrosion = new StatusEffect("weak-corrosion"){{ // Acid rain internal status
            color = Pal.plastanium;
            speedMultiplier = 0.9f;
            healthMultiplier = 0.9f;
        }};

        lavaMelting = new StatusEffect("lava-melting"){{ // When you step on the lava floor
            color = Color.valueOf("f8c266");
            speedMultiplier = 0.5f;
            damage = 0.6f;
        }};

        shock = new StatusEffect("shock"){{ // Tesla hit status
            speedMultiplier = 0.1f;
        }};

        corrupted = new StatusEffect("corrupted"){{
            speedMultiplier = 0.66f;
            healthMultiplier = 0.5f;
        }};

        snowy = new StatusEffect("snowy"){{ // Snowy weather status
            speedMultiplier = 0.9f;
            reloadMultiplier = 0.9f;
        }};

        blizzard = new StatusEffect("blizzard-status"){{ // Blizzard weather status
            speedMultiplier = 0.8f;
            reloadMultiplier = 0.8f;
        }};

        // Since the campaign will have its own unique bosses, the buff is useless
        StatusEffects.boss.healthMultiplier = 1;
        StatusEffects.boss.damageMultiplier = 1;
    }
}