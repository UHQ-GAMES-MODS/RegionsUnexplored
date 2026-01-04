package net.regions_unexplored.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.regions_unexplored.platform.Services;
import net.regions_unexplored.world.level.block.leaves.*;
import net.regions_unexplored.world.level.block.wood.*;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockRegistry {
    // TODO: Consolidate unnecessary factory methods here
    public static Block block(float destroyTime, float explosionResistance, MapColor colour, SoundType sound, boolean fireproof, Function<BlockBehaviour.Properties, Block> factory) {
        return factory.apply(properties(destroyTime, explosionResistance, sound, fireproof, colour));
    }

    public static RotatedPillarBlock log(MapColor yColour, MapColor xzColour, SoundType sound, boolean fireproof) {
        var properties = properties(2f, 2f, sound, fireproof).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? yColour : xzColour);
        return new RotatedPillarBlock(properties);
    }

    public static RotatedPillarBlock wood(MapColor colour, SoundType sound, boolean fireproof) {
        var properties = properties(2, 3, sound, fireproof, colour);
        return new RotatedPillarBlock(properties);
    }

    public static Block planks(MapColor colour, SoundType sound, boolean fireproof) {
        var properties = properties(2, 3, sound, fireproof, colour);
        return new Block(properties);
    }

    public static StairBlock stairs(MapColor colour, SoundType sound, boolean fireproof) {
        var properties = properties(2, 3, sound, fireproof, colour);
        return new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), properties);
    }

    public static SlabBlock slab(MapColor colour, SoundType sound, boolean fireproof) {
        var properties = properties(2, 3, sound, fireproof, colour);
        return new SlabBlock(properties);
    }

    public static DoorBlock door(MapColor colour, SoundType sound, BlockSetType blockSetType, boolean fireproof) {
        var properties = properties(3, 3, sound, fireproof, colour).noOcclusion();
        return new DoorBlock(blockSetType, properties);
    }

    public static TrapDoorBlock trapdoor(MapColor colour, SoundType sound, BlockSetType blockSetType, boolean fireproof) {
        var properties = properties(3, 3, sound, fireproof, colour).noOcclusion();
        return new TrapDoorBlock(blockSetType, properties);
    }

    public static FenceBlock fence(MapColor colour, SoundType sound, boolean fireproof) {
        var properties = properties(2, 3, sound, fireproof, colour);
        return new FenceBlock(properties);
    }

    public static FenceGateBlock fenceGate(MapColor colour, WoodType type, SoundType sound, boolean fireproof) {
        var properties = properties(2, 3, sound, fireproof, colour);
        return new FenceGateBlock(type, properties);
    }

    public static PressurePlateBlock pressurePlate(MapColor colour, SoundType sound, BlockSetType blockSetType, boolean fireproof) {
        var properties = properties(0.5f, 0.5f, sound, fireproof, colour).noCollission();
        return new PressurePlateBlock(blockSetType, properties);
    }

    public static ButtonBlock button(SoundType sound, BlockSetType blockSetType) {
        var properties = properties(0.5f, 0.5f, sound, true).noCollission();
        return new ButtonBlock(blockSetType, 30, properties);
    }

    public static StandingSignBlock sign(SoundType sound, WoodType woodType, boolean fireproof) {
        var properties = properties(1, 1, sound, fireproof).noCollission();
        return new StandingSignBlock(woodType, properties);
    }

    public static WallSignBlock wallSign(SoundType sound, Block standingSign, WoodType woodType, boolean fireproof) {
        var properties = properties(1, 1, sound, fireproof).noCollission().dropsLike(standingSign);
        return new WallSignBlock(woodType, properties);
    }

    public static CeilingHangingSignBlock hangingSign(MapColor color, SoundType sound, WoodType woodType, boolean fireproof) {
        var properties = properties(1, 1, sound, fireproof, color).noCollission().forceSolidOn();
        return new CeilingHangingSignBlock(woodType, properties);
    }

    public static WallHangingSignBlock wallHangingSign(MapColor color, SoundType sound, Block hangingSign, WoodType woodType, boolean fireproof) {
        var properties = properties(1, 1, sound, fireproof, color).noCollission().dropsLike(hangingSign).forceSolidOn();
        return new WallHangingSignBlock(woodType, properties);
    }

    private static BlockBehaviour.Properties properties(float destroyTime, float explosionResistance, SoundType sound, boolean fireproof) {
        return properties(destroyTime, explosionResistance, sound, fireproof, null);
    }

    private static BlockBehaviour.Properties properties(float destroyTime, float explosionResistance, SoundType sound, boolean fireproof, MapColor color) {
        var properties = BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).strength(destroyTime, explosionResistance).sound(sound);
        if (!fireproof) properties.ignitedByLava();
        if (color != null) properties.mapColor(color);
        return properties;
    }

    //Register default blocks and items
    public static Supplier<Block> registerDefaultBlock(String name, Supplier<Block> block) {
        Supplier<Block> toReturn = Services.REGISTAR.registerBlock(name, block);
        ItemRegistry.registerDefaultBlockItem(name, toReturn);
        return toReturn;
    }

    //Register default block without item
    public static Supplier<Block> registerDefaultBlockNoItem(String name, Supplier<Block> block) {
        return Services.REGISTAR.registerBlock(name, block);
    }

    //Register Duckweed block and item
    public static Supplier<Block> registerPlaceOnWaterBlock(String name, Supplier<Block> block) {
        Supplier<Block> toReturn = Services.REGISTAR.registerBlock(name, block);
        ItemRegistry.registerPlaceOnWaterItem(name, toReturn);
        return toReturn;
    }

    public static PineLogBlock pineLog(MapColor colour, MapColor colour2, SoundType sound) {
        return new PineLogBlock(BlockBehaviour.Properties.of().mapColor((p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? colour : colour2;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(sound).ignitedByLava());
    }
    public static AspenLogBlock aspenLogBlock(MapColor colour, MapColor colour2, SoundType sound) {
        return new AspenLogBlock(BlockBehaviour.Properties.of().mapColor((p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? colour : colour2;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(sound).ignitedByLava());
    }

    //Configure leaves blocks
    public static Block leaves(MapColor colour) {
        return leaves(colour, false, LeavesBlock::new);
    }

    public static Block leaves(MapColor colour, boolean fireproof, Function<BlockBehaviour.Properties, Block> factory) {
        var properties = BlockBehaviour.Properties.of().mapColor(colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never).pushReaction(PushReaction.DESTROY).isRedstoneConductor(BlockRegistry::never);
        if (!fireproof) properties.ignitedByLava();
        return factory.apply(properties);
    }


    //Boolean states
    public static Boolean always(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return true;
    }
    public static boolean always(BlockState state, BlockGetter getter, BlockPos pos) {
        return true;
    }
    public static Boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return false;
    }
    public static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }
    public static Boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return (type == EntityType.OCELOT || type == EntityType.PARROT);
    }
}
