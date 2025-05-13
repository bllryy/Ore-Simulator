package bllry.oresim.forks;

import bllry.oresim.bllryAddon;
import meteordevelopment.meteorclient.systems.modules.Module;

public class SilentDisconnect extends Module {
    public SilentDisconnect() {
        super(bllryAddon.CATEGORY, "silent-disconnect", "Won't show a disconnect screen when you disconnect.");
    }
}