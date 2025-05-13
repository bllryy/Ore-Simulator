package bllry.oresim;

import bllry.oresim.commands.*;
import bllry.oresim.forks.Rendering;
import bllry.oresim.gui.hud.RadarHud;
import bllry.oresim.gui.themes.rounded.MeteorRoundedGuiTheme;
import bllry.oresim.modules.*;
import bllry.oresim.modules.OreSim;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.gui.GuiThemes;
import meteordevelopment.meteorclient.systems.Systems;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class bllryAddon extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("Oresim");
    public static final Category CATEGORY = new Category("Oresim", Items.BARRIER.getDefaultStack());
    public static final HudGroup HUD_GROUP = new HudGroup("Oresim");

    @Override
    public void onInitialize() {
        LOG.info("Initializing...");

        // Modules
        Modules modules = Modules.get();
        modules.add(new OreSim());
        // modules.add((new Rendering()));


        // Commands
        Commands.add(new CenterCommand());
        Commands.add(new ClearChatCommand());
        Commands.add(new GhostCommand());
        Commands.add(new GiveCommand());
        Commands.add(new HeadsCommand());
        Commands.add(new KickCommand());
        Commands.add(new LocateCommand());
        Commands.add(new PanicCommand());
        Commands.add(new ReconnectCommand());
        Commands.add(new ServerCommand());
        Commands.add(new SaveSkinCommand());
        Commands.add(new SeedCommand());
        Commands.add(new SetBlockCommand());
        Commands.add(new SetVelocityCommand());
        Commands.add(new TeleportCommand());
        Commands.add(new TerrainExport());

        // HUD
        Hud hud = Systems.get(Hud.class);
        hud.register(RadarHud.INFO);

        // Themes
        GuiThemes.add(new MeteorRoundedGuiTheme());
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getWebsite() {
        return "https://github.com/bllryy/Ore-Simulator";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("bllry", "Ore-Simulator");
    }

    @Override
    public String getCommit() {
        String commit = FabricLoader
                .getInstance()
                .getModContainer("Ore-Simulator")
                .get().getMetadata()
                .getCustomValue("github:sha")
                .getAsString();
        LOG.info("Rejects version: {}", commit);
        return commit.isEmpty() ? null : commit.trim();
    }

    public String getPackage() {
        return "bllry.oresim";
    }
}
