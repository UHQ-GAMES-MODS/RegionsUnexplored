package net.regions_unexplored.internal.config.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.regions_unexplored.internal.config.ConfigManager;

import java.util.Map;

public class ConfigSelectionScreen extends Screen {
    private final Screen parent;

    public ConfigSelectionScreen(Screen parent) {
        super(Component.literal("Select Configuration"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int buttonWidth = 200;
        int buttonHeight = 20;
        int spacing = 25;

        // Get all registered configs
        Map<String, ConfigManager> configs = ConfigScreenRegistry.getAllConfigs();

        // Calculate starting Y position to center buttons
        int totalHeight = configs.size() * spacing;
        int startY = (this.height - totalHeight) / 2;

        int currentY = startY;

        // Create a button for each registered config
        for (Map.Entry<String, ConfigManager> entry : configs.entrySet()) {
            String configName = entry.getKey();
            ConfigManager manager = entry.getValue();

            // Use the manager's display name
            String displayName = manager.getDisplayName();

            this.addRenderableWidget(Button.builder(
                    Component.literal(displayName),
                    button -> ConfigScreenRegistry.openConfigScreen(manager, this)
            ).bounds(this.width / 2 - buttonWidth / 2, currentY, buttonWidth, buttonHeight).build());

            currentY += spacing;
        }

        // Done button at the bottom
        this.addRenderableWidget(Button.builder(
                Component.literal("Done"),
                button -> this.minecraft.setScreen(parent)
        ).bounds(this.width / 2 - buttonWidth / 2, this.height - 30, buttonWidth, buttonHeight).build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 15, 0xFFFFFF);

        // Show count
        int configCount = ConfigScreenRegistry.getConfigCount();
        graphics.drawCenteredString(
                this.font,
                Component.literal(configCount + " configuration" + (configCount != 1 ? "s" : "") + " available"),
                this.width / 2,
                30,
                0xAAAAAA
        );

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    protected void renderBlurredBackground(float $$0) {}

    @Override
    public void onClose() {
        this.minecraft.setScreen(parent);
    }
}