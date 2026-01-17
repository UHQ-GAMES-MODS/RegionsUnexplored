package net.regions_unexplored.internal.config.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigManager;
import net.regions_unexplored.internal.config.ConfigValue;
import org.jetbrains.annotations.NotNull;

import java.util.*;


public class ConfigScreen extends Screen {
    private final Screen parent;
    private final ConfigManager configManager;
    private ConfigEntryList entryList;
    private Button doneButton;
    private Button cancelButton;
    private boolean hasUnsavedChanges = false;

    public ConfigScreen(Screen parent, ConfigManager configManager) {
        super(Component.literal(configManager.getDisplayName()));
        this.parent = parent;
        this.configManager = configManager;
    }

    @Override
    protected void init() {
        // Create the scrollable list of config entries
        this.entryList = new ConfigEntryList(
                this.minecraft,
                this.width,
                this.height,
                32,
                25
        );

        this.addWidget(this.entryList);

        // Populate entries from config
        populateEntries();

        // Add done button
        this.doneButton = Button.builder(Component.literal("Done"), button -> {
            saveAndClose();
        }).bounds(this.width / 2 - 154, this.height - 28, 150, 20).build();

        // Add cancel button
        this.cancelButton = Button.builder(Component.literal("Cancel"), button -> {
            this.minecraft.setScreen(parent);
        }).bounds(this.width / 2 + 4, this.height - 28, 150, 20).build();

        this.addRenderableWidget(this.doneButton);
        this.addRenderableWidget(this.cancelButton);
    }

    private void populateEntries() {
        Config config = configManager.getConfig();

        // Group by category
        Map<String, List<ConfigValue<?>>> categorizedValues = new LinkedHashMap<>();
        for (ConfigValue<?> configValue : config.getConfigValues()) {
            String category = configValue.getCategory();
            if (category.isEmpty()) {
                category = "General";
            }
            categorizedValues
                    .computeIfAbsent(category, k -> new ArrayList<>())
                    .add(configValue);
        }

        // Add entries by category
        for (Map.Entry<String, List<ConfigValue<?>>> entry : categorizedValues.entrySet()) {
            String categoryName = entry.getKey();
            List<ConfigValue<?>> values = entry.getValue();

            // Add category header
            entryList.addConfigEntry(new ConfigEntryList.CategoryEntry(categoryName));

            // Add config entries
            for (ConfigValue<?> configValue : values) {
                entryList.addConfigEntry(createEntryForValue(configValue));
            }
        }
    }

    private ConfigEntryList.Entry createEntryForValue(ConfigValue<?> configValue) {
        Object value = configValue.get();

        if (value instanceof Boolean) {
            return new ConfigEntryList.BooleanEntry(this, configValue);
        } else if (value instanceof Integer) {
            return new ConfigEntryList.IntegerEntry(this, configValue);
        } else if (value instanceof Long) {
            return new ConfigEntryList.LongEntry(this, configValue);
        } else if (value instanceof Double) {
            return new ConfigEntryList.DoubleEntry(this, configValue);
        } else if (value instanceof Float) {
            return new ConfigEntryList.FloatEntry(this, configValue);
        } else if (value instanceof String) {
            return new ConfigEntryList.StringEntry(this, configValue);
        }

        // Fallback for unknown types
        return new ConfigEntryList.TextEntry(configValue.getKey() + ": " + value);
    }

    private void saveAndClose() {
        configManager.save();
        this.minecraft.setScreen(parent);
    }

    @Override
    protected void renderBlurredBackground(float $$0) {}

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);
        this.entryList.render(graphics, mouseX, mouseY, partialTick);

        // Draw title
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 8, 0xFFFFFF);

        // Draw warning if changes require restart
        if (hasUnsavedChanges) {
            graphics.drawCenteredString(
                    this.font,
                    Component.literal("Some changes require a restart"),
                    this.width / 2,
                    20,
                    0xFFFF55
            );
        }

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose() {
        assert this.minecraft != null;
        this.minecraft.setScreen(parent);
    }

    public void markUnsavedChanges() {
        this.hasUnsavedChanges = true;
    }

    /**
     * Converts snake_case or camelCase to Display Name format
     */
    public static String toDisplayName(String key) {
        return Arrays.stream(key.split("_"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .reduce((a, b) -> a + " " + b)
                .orElse(key);
    }
}