package net.regions_unexplored.internal.config.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.regions_unexplored.RegionsUnexplored;
import net.regions_unexplored.internal.config.ConfigValue;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Scrollable list container for config entries.
 */
public class ConfigEntryList extends ContainerObjectSelectionList<ConfigEntryList.Entry> {
    private final int listWidth;

    public ConfigEntryList(Minecraft minecraft, ConfigScreen screen) {
        super(minecraft, screen.width, screen.layout.getContentHeight(), screen.layout.getHeaderHeight(), 25);
        this.listWidth = 400;
    }

    @Override
    public int getRowWidth() {
        return this.listWidth;
    }

    /**
     * Public wrapper for adding entries to the list.
     * @param entry The entry to add
     */
    public void addConfigEntry(Entry entry) {
        super.addEntry(entry);
    }

    private static Component text(String prefix, String value) {
        return Component.translatable(String.format("config.%s.%s.%s", RegionsUnexplored.MOD_ID, prefix, value));
    }

    /**
     * Base class for all config entries
     */
    public static abstract class Entry extends ContainerObjectSelectionList.Entry<Entry> {
        @Override
        public @NotNull List<? extends AbstractWidget> children() {
            return Collections.emptyList();
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return Collections.emptyList();
        }
    }

    /**
     * Category header entry
     */
    public static class CategoryEntry extends Entry {
        private final String category;

        public CategoryEntry(String category) {
            this.category = category;
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height,
                           int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            // Draw category name centered
            graphics.drawCenteredString(
                    Minecraft.getInstance().font,
                    text("category", category),
                    left + width / 2,
                    top + 5,
                    0xFFFFFF
            );
        }
    }

    /**
     * Simple text entry (fallback for unsupported types)
     */
    public static class TextEntry extends Entry {
        private final String text;

        public TextEntry(String text) {
            this.text = text;
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height,
                           int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            graphics.drawString(
                    Minecraft.getInstance().font,
                    text,
                    left + 5,
                    top + 5,
                    0xFFFFFF
            );
        }
    }

    public abstract static class ConfigEntry<T> extends Entry {
        protected final ConfigValue<T> configValue;
        protected final List<AbstractWidget> widgets;
        protected final String comment;

        public ConfigEntry(ConfigValue<T> configValue) {
            this.configValue = configValue;
            this.widgets = new ArrayList<>();
            this.comment = configValue.getComment();
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            String label = ConfigScreen.toDisplayName(configValue.getKey());
            if (configValue.requiresRestart()) {
                label += " *";
            }
            Font font = Minecraft.getInstance().font;
            graphics.drawString(
                font,
                label,
                left + 5,
                top + 5,
                0xFFFFFF
            );

            if (comment != null) {
                if (
                    mouseX > left + 5 &&
                    mouseX < left + width * 0.4 &&
                    mouseY > top &&
                    mouseY < top + 20
                ) {
                    graphics.renderTooltip(font, font.split(Component.literal(comment), 200), mouseX, mouseY);
                }
            }
        }

        @Override
        public @NotNull List<? extends AbstractWidget> children() {
            return widgets;
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return widgets;
        }
    }

    /**
     * Boolean toggle entry
     */
    public static class BooleanEntry extends ConfigEntry<Boolean> {
        private final CycleButton<Boolean> toggleButton;

        public BooleanEntry(ConfigScreen screen, ConfigValue<Boolean> configValue) {
            super(configValue);
            this.toggleButton = CycleButton.onOffBuilder(configValue.get()).displayOnlyValue().create(0, 0, 100, 20, Component.empty(), (button, bool) -> {
                boolean newValue = !this.configValue.get();
                this.configValue.setValue(newValue);
                if (this.configValue.requiresRestart()) {
                    screen.markUnsavedChanges();
                }
            });
            this.widgets.add(toggleButton);
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            super.render(graphics, index, top, left, width, height, mouseX, mouseY, isMouseOver, partialTick);
            // Position and render button
            toggleButton.setX(left + width - 110);
            toggleButton.setY(top);
            toggleButton.render(graphics, mouseX, mouseY, partialTick);
        }
    }

    /**
     * Integer slider/field entry
     */
    public static class IntegerEntry extends ConfigEntry<Integer> {
        private final EditBox textField;
        private final Button decrementButton;
        private final Button incrementButton;
        private final int min;
        private final int max;

        public IntegerEntry(ConfigScreen screen, ConfigValue<Integer> configValue) {
            super(configValue);
            this.min = configValue.getMinValue() != null ? configValue.getMinValue().intValue() : Integer.MIN_VALUE;
            this.max = configValue.getMaxValue() != null ? configValue.getMaxValue().intValue() : Integer.MAX_VALUE;

            // Text field
            this.textField = new EditBox(
                    Minecraft.getInstance().font,
                    0, 0, 100, 20,
                    Component.literal("")
            );
            this.textField.setValue(String.valueOf(this.configValue.get()));
            this.textField.setResponder(text -> {
                try {
                    int value = Integer.parseInt(text);
                    if (this.configValue.isValid(value)) {
                        this.configValue.setValue(value);
                        if (this.configValue.requiresRestart()) {
                            screen.markUnsavedChanges();
                        }
                    }
                } catch (NumberFormatException ignored) {
                }
            });

            // Decrement button
            this.decrementButton = Button.builder(Component.literal("-"), button -> {
                int current = this.configValue.get();
                int newValue = Math.max(min, current - 1);
                this.configValue.setValue(newValue);
                this.textField.setValue(String.valueOf(newValue));
                if (this.configValue.requiresRestart()) {
                    screen.markUnsavedChanges();
                }
            }).bounds(0, 0, 20, 20).build();

            // Increment button
            this.incrementButton = Button.builder(Component.literal("+"), button -> {
                int current = this.configValue.get();
                int newValue = Math.min(max, current + 1);
                this.configValue.setValue(newValue);
                this.textField.setValue(String.valueOf(newValue));
                if (this.configValue.requiresRestart()) {
                    screen.markUnsavedChanges();
                }
            }).bounds(0, 0, 20, 20).build();

            this.widgets.add(textField);
            this.widgets.add(decrementButton);
            this.widgets.add(incrementButton);
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            super.render(graphics, index, top, left, width, height, mouseX, mouseY, isMouseOver, partialTick);

            // Position widgets
            decrementButton.setX(left + width - 155);
            decrementButton.setY(top);

            textField.setX(left + width - 130);
            textField.setY(top);

            incrementButton.setX(left + width - 25);
            incrementButton.setY(top);

            // Render widgets
            decrementButton.render(graphics, mouseX, mouseY, partialTick);
            textField.render(graphics, mouseX, mouseY, partialTick);
            incrementButton.render(graphics, mouseX, mouseY, partialTick);
        }

        @Override
        public @NotNull List<? extends AbstractWidget> children() {
            return widgets;
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return widgets;
        }
    }

    /**
     * Long number field entry
     */
    public static class LongEntry extends ConfigEntry<Long> {
        private final EditBox textField;

        public LongEntry(ConfigScreen screen, ConfigValue<Long> configValue) {
            super(configValue);

            this.textField = new EditBox(
                    Minecraft.getInstance().font,
                    0, 0, 100, 20,
                    Component.literal("")
            );
            this.textField.setValue(String.valueOf(this.configValue.get()));
            this.textField.setResponder(text -> {
                try {
                    long value = Long.parseLong(text);
                    if (this.configValue.isValid(value)) {
                        this.configValue.setValue(value);
                        if (this.configValue.requiresRestart()) {
                            screen.markUnsavedChanges();
                        }
                    }
                } catch (NumberFormatException ignored) {
                }
            });

            this.widgets.add(textField);
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            super.render(graphics, index, top, left, width, height, mouseX, mouseY, isMouseOver, partialTick);

            textField.setX(left + width - 110);
            textField.setY(top);
            textField.render(graphics, mouseX, mouseY, partialTick);
        }

        @Override
        public @NotNull List<? extends AbstractWidget> children() {
            return widgets;
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return widgets;
        }
    }

    /**
     * Double number field entry
     */
    public static class DoubleEntry extends ConfigEntry<Double> {
        private final EditBox textField;

        public DoubleEntry(ConfigScreen screen, ConfigValue<Double> configValue) {
            super(configValue);

            this.textField = new EditBox(
                    Minecraft.getInstance().font,
                    0, 0, 100, 20,
                    Component.literal("")
            );
            this.textField.setValue(String.valueOf(this.configValue.get()));
            this.textField.setResponder(text -> {
                try {
                    double value = Double.parseDouble(text);
                    if (this.configValue.isValid(value)) {
                        this.configValue.setValue(value);
                        if (this.configValue.requiresRestart()) {
                            screen.markUnsavedChanges();
                        }
                    }
                } catch (NumberFormatException ignored) {
                }
            });

            this.widgets.add(textField);
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            super.render(graphics, index, top, left, width, height, mouseX, mouseY, isMouseOver, partialTick);

            textField.setX(left + width - 110);
            textField.setY(top);
            textField.render(graphics, mouseX, mouseY, partialTick);
        }

        @Override
        public @NotNull List<? extends AbstractWidget> children() {
            return widgets;
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return widgets;
        }
    }

    /**
     * Float number field entry
     */
    public static class FloatEntry extends ConfigEntry<Float> {
        private final EditBox textField;

        public FloatEntry(ConfigScreen screen, ConfigValue<Float> configValue) {
            super(configValue);

            this.textField = new EditBox(
                    Minecraft.getInstance().font,
                    0, 0, 100, 20,
                    Component.literal("")
            );
            this.textField.setValue(String.valueOf(this.configValue.get()));
            this.textField.setResponder(text -> {
                try {
                    float value = Float.parseFloat(text);
                    if (this.configValue.isValid(value)) {
                        this.configValue.setValue(value);
                        if (this.configValue.requiresRestart()) {
                            screen.markUnsavedChanges();
                        }
                    }
                } catch (NumberFormatException ignored) {
                }
            });

            this.widgets.add(textField);
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            super.render(graphics, index, top, left, width, height, mouseX, mouseY, isMouseOver, partialTick);

            textField.setX(left + width - 110);
            textField.setY(top);
            textField.render(graphics, mouseX, mouseY, partialTick);
        }

        @Override
        public @NotNull List<? extends AbstractWidget> children() {
            return widgets;
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return widgets;
        }
    }

    /**
     * String text field entry (with dropdown for allowed values)
     */
    public static class StringEntry extends ConfigEntry<String> {
        private final EditBox textField;
        private final Button cycleButton;

        @SuppressWarnings("unchecked")
        public StringEntry(ConfigScreen screen, ConfigValue<String> configValue) {
            super(configValue);

            // Check if it has allowed values
            boolean hasAllowedValues = this.configValue.getAllowedValues() != null
                    && !this.configValue.getAllowedValues().isEmpty();

            if (hasAllowedValues) {
                // Create cycle button
                this.cycleButton = Button.builder(
                        Component.literal(this.configValue.get()),
                        button -> {
                            List<String> allowed = this.configValue.getAllowedValues();
                            int currentIndex = allowed.indexOf(this.configValue.get());
                            int nextIndex = (currentIndex + 1) % allowed.size();
                            String newValue = allowed.get(nextIndex);
                            this.configValue.setValue(newValue);
                            button.setMessage(Component.literal(newValue));
                            if (this.configValue.requiresRestart()) {
                                screen.markUnsavedChanges();
                            }
                        }
                ).bounds(0, 0, 120, 20).build();
                this.textField = null;
            } else {
                // Create text field
                this.textField = new EditBox(
                        Minecraft.getInstance().font,
                        0, 0, 120, 20,
                        Component.literal("")
                );
                this.textField.setValue(this.configValue.get());
                this.textField.setMaxLength(256);
                this.textField.setResponder(text -> {
                    if (this.configValue.isValid(text)) {
                        this.configValue.setValue(text);
                        if (this.configValue.requiresRestart()) {
                            screen.markUnsavedChanges();
                        }
                    }
                });
                this.cycleButton = null;
            }

            if (textField != null) {
                this.widgets.add(textField);
            }
            if (cycleButton != null) {
                this.widgets.add(cycleButton);
            }
        }

        @Override
        public void render(GuiGraphics graphics, int index, int top, int left, int width, int height, int mouseX, int mouseY, boolean isMouseOver, float partialTick) {
            super.render(graphics, index, top, left, width, height, mouseX, mouseY, isMouseOver, partialTick);

            if (textField != null) {
                textField.setX(left + width - 130);
                textField.setY(top);
                textField.render(graphics, mouseX, mouseY, partialTick);
            }

            if (cycleButton != null) {
                cycleButton.setX(left + width - 130);
                cycleButton.setY(top);
                cycleButton.render(graphics, mouseX, mouseY, partialTick);
            }
        }

        @Override
        public @NotNull List<? extends AbstractWidget> children() {
            return widgets;
        }

        @Override
        public List<? extends NarratableEntry> narratables() {
            return widgets;
        }
    }
}
