package net.regions_unexplored.internal.config.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.HeaderAndFooterLayout;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.regions_unexplored.internal.config.Config;
import net.regions_unexplored.internal.config.ConfigManager;
import net.regions_unexplored.internal.config.ConfigValue;
import org.jetbrains.annotations.NotNull;

import java.util.*;


public class ConfigScreen extends Screen {
    private final Screen parent;
    private final ConfigManager configManager;
    final HeaderAndFooterLayout layout = new HeaderAndFooterLayout(this);
    private ConfigEntryList configList;
    private boolean hasUnsavedChanges = false;

    public ConfigScreen(Screen parent, ConfigManager configManager) {
        super(Component.literal(configManager.getDisplayName()));
        this.parent = parent;
        this.configManager = configManager;
    }

    @Override
    protected void init() {
        // Header
        this.layout.addTitleHeader(this.title, this.font);
        // Content
        this.configList = new ConfigEntryList(this.minecraft, this);
        this.layout.addToContents(this.configList);
        // Footer
        LinearLayout linearLayout = this.layout.addToFooter(LinearLayout.horizontal().spacing(8));
        linearLayout.addChild(Button.builder(CommonComponents.GUI_DONE, button -> saveAndClose()).size(150, 20).build());
        linearLayout.addChild(Button.builder(CommonComponents.GUI_CANCEL, button -> this.minecraft.setScreen(parent)).size(150, 20).build());

        this.layout.visitWidgets(this::addRenderableWidget);
        this.repositionElements();

        populateEntries();
    }

    protected void repositionElements() {
        this.layout.arrangeElements();
        if (this.configList != null) {
            this.configList.updateSize(this.width, this.layout);
        }
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
            configList.addConfigEntry(new ConfigEntryList.CategoryEntry(categoryName));

            // Add config entries
            for (ConfigValue<?> configValue : values) {
                configList.addConfigEntry(createEntryForValue(configValue));
            }
        }
    }

    private ConfigEntryList.Entry createEntryForValue(ConfigValue<?> configValue) {
        Object value = configValue.get();

        if (value instanceof Boolean) {
            return new ConfigEntryList.BooleanEntry(this, (ConfigValue<Boolean>) configValue);
        } else if (value instanceof Integer) {
            return new ConfigEntryList.IntegerEntry(this, (ConfigValue<Integer>) configValue);
        } else if (value instanceof Long) {
            return new ConfigEntryList.LongEntry(this, (ConfigValue<Long>) configValue);
        } else if (value instanceof Double) {
            return new ConfigEntryList.DoubleEntry(this, (ConfigValue<Double>) configValue);
        } else if (value instanceof Float) {
            return new ConfigEntryList.FloatEntry(this, (ConfigValue<Float>) configValue);
        } else if (value instanceof String) {
            return new ConfigEntryList.StringEntry(this, (ConfigValue<String>) configValue);
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
        super.render(graphics, mouseX, mouseY, partialTick);
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