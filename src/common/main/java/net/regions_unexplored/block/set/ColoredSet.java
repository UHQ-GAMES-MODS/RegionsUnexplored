package net.regions_unexplored.block.set;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ColoredSet {
    private final Supplier<Block> white;
    private final Supplier<Block> lightGray;
    private final Supplier<Block> gray;
    private final Supplier<Block> black;
    private final Supplier<Block> brown;
    private final Supplier<Block> red;
    private final Supplier<Block> orange;
    private final Supplier<Block> yellow;
    private final Supplier<Block> lime;
    private final Supplier<Block> green;
    private final Supplier<Block> lightBlue;
    private final Supplier<Block> cyan;
    private final Supplier<Block> blue;
    private final Supplier<Block> purple;
    private final Supplier<Block> magenta;
    private final Supplier<Block> pink;

    public ColoredSet(Function<DyeColor, Supplier<Block>> factory) {
        this.white = factory.apply(DyeColor.WHITE);
        this.lightGray = factory.apply(DyeColor.LIGHT_GRAY);
        this.gray = factory.apply(DyeColor.GRAY);
        this.black = factory.apply(DyeColor.BLACK);
        this.brown = factory.apply(DyeColor.BROWN);
        this.red = factory.apply(DyeColor.RED);
        this.orange = factory.apply(DyeColor.ORANGE);
        this.yellow = factory.apply(DyeColor.YELLOW);
        this.lime = factory.apply(DyeColor.LIME);
        this.green = factory.apply(DyeColor.GREEN);
        this.lightBlue = factory.apply(DyeColor.LIGHT_BLUE);
        this.cyan = factory.apply(DyeColor.CYAN);
        this.blue = factory.apply(DyeColor.BLUE);
        this.purple = factory.apply(DyeColor.PURPLE);
        this.magenta = factory.apply(DyeColor.MAGENTA);
        this.pink = factory.apply(DyeColor.PINK);
    }

    public ArrayList<Block> getAll() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(white.get());
        blocks.add(lightGray.get());
        blocks.add(gray.get());
        blocks.add(black.get());
        blocks.add(brown.get());
        blocks.add(red.get());
        blocks.add(orange.get());
        blocks.add(yellow.get());
        blocks.add(lime.get());
        blocks.add(green.get());
        blocks.add(lightBlue.get());
        blocks.add(cyan.get());
        blocks.add(blue.get());
        blocks.add(purple.get());
        blocks.add(magenta.get());
        blocks.add(pink.get());
        return blocks;
    }

    public Map<DyeColor, Block> getMap() {
        Map<DyeColor, Block> map = new EnumMap<>(DyeColor.class);
        map.put(DyeColor.WHITE, white.get());
        map.put(DyeColor.LIGHT_GRAY, lightGray.get());
        map.put(DyeColor.GRAY, gray.get());
        map.put(DyeColor.BLACK, black.get());
        map.put(DyeColor.BROWN, brown.get());
        map.put(DyeColor.RED, red.get());
        map.put(DyeColor.ORANGE, orange.get());
        map.put(DyeColor.YELLOW, yellow.get());
        map.put(DyeColor.LIME, lime.get());
        map.put(DyeColor.GREEN, green.get());
        map.put(DyeColor.LIGHT_BLUE, lightBlue.get());
        map.put(DyeColor.CYAN, cyan.get());
        map.put(DyeColor.BLUE, blue.get());
        map.put(DyeColor.PURPLE, purple.get());
        map.put(DyeColor.MAGENTA, magenta.get());
        map.put(DyeColor.PINK, pink.get());
        return map;
    }

    public Supplier<Block> getWhite() {
        return white;
    }

    public Supplier<Block> getLightGray() {
        return lightGray;
    }

    public Supplier<Block> getGray() {
        return gray;
    }

    public Supplier<Block> getBlack() {
        return black;
    }

    public Supplier<Block> getBrown() {
        return brown;
    }

    public Supplier<Block> getRed() {
        return red;
    }

    public Supplier<Block> getOrange() {
        return orange;
    }

    public Supplier<Block> getYellow() {
        return yellow;
    }

    public Supplier<Block> getLime() {
        return lime;
    }

    public Supplier<Block> getGreen() {
        return green;
    }

    public Supplier<Block> getLightBlue() {
        return lightBlue;
    }

    public Supplier<Block> getCyan() {
        return cyan;
    }

    public Supplier<Block> getBlue() {
        return blue;
    }

    public Supplier<Block> getPurple() {
        return purple;
    }

    public Supplier<Block> getMagenta() {
        return magenta;
    }

    public Supplier<Block> getPink() {
        return pink;
    }
}
