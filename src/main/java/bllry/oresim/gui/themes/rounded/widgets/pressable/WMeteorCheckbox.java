/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package bllry.oresim.gui.themes.rounded.widgets.pressable;

import bllry.oresim.utils.gui.GuiUtils;
import bllry.oresim.gui.themes.rounded.MeteorRoundedGuiTheme;
import meteordevelopment.meteorclient.gui.renderer.GuiRenderer;
import bllry.oresim.gui.themes.rounded.MeteorWidget;
import meteordevelopment.meteorclient.gui.widgets.pressable.WCheckbox;
import net.minecraft.util.math.MathHelper;

public class WMeteorCheckbox extends WCheckbox implements MeteorWidget {
    private double animProgress;

    public WMeteorCheckbox(boolean checked) {
        super(checked);
        animProgress = checked ? 1 : 0;
    }

    @Override
    protected void onRender(GuiRenderer renderer, double mouseX, double mouseY, double delta) {
        MeteorRoundedGuiTheme theme = theme();

        animProgress += (checked ? 1 : -1) * delta * 14;
        animProgress = MathHelper.clamp(animProgress, 0, 1);

        renderBackground(renderer, this, pressed, mouseOver);

        if (animProgress > 0) {
            double cs = (width - theme.scale(2)) / 1.75 * animProgress;
            GuiUtils.quadRounded(renderer, x + (width - cs) / 2, y + (height - cs) / 2, cs, cs, theme.checkboxColor.get(), theme.roundAmount());
        }
    }
}
