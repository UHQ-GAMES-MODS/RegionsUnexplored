package net.regions_unexplored.block;

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
import net.regions_unexplored.platform.Registrar;
import net.regions_unexplored.item.RUItemUtils;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class RUBlockUtils {
    // TODO: Consolidate unnecessary factory methods here
    public static Block block(BlockBehaviour.Properties properties, float destroyTime, float explosionResistance, MapColor colour, SoundType sound, boolean fireproof, BlockFactory factory) {
        applyProperties(properties, destroyTime, explosionResistance, sound, fireproof, colour);
        return factory.apply(properties);
    }

    public static Block log(BlockBehaviour.Properties properties, BlockFactory blockFactory, MapColor plankColour, MapColor logColour, SoundType sound, boolean fireproof) {
        applyProperties(properties, 2f, 2f, sound, fireproof, null).mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? plankColour : logColour);
        return blockFactory.apply(properties);
    }

    public static RotatedPillarBlock wood(BlockBehaviour.Properties properties, MapColor colour, SoundType sound, boolean fireproof) {
        applyProperties(properties, 2, 3, sound, fireproof, colour);
        return new RotatedPillarBlock(properties);
    }

    public static Block planks(BlockBehaviour.Properties properties, MapColor colour, SoundType sound, boolean fireproof) {
        applyProperties(properties, 2, 3, sound, fireproof, colour);
        return new Block(properties);
    }

    public static StairBlock stairs(BlockBehaviour.Properties properties, MapColor colour, SoundType sound, boolean fireproof) {
        applyProperties(properties, 2, 3, sound, fireproof, colour);
        return new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), properties);
    }

    public static SlabBlock slab(BlockBehaviour.Properties properties, MapColor colour, SoundType sound, boolean fireproof) {
        applyProperties(properties, 2, 3, sound, fireproof, colour);
        return new SlabBlock(properties);
    }

    public static DoorBlock door(BlockBehaviour.Properties properties, MapColor colour, SoundType sound, BlockSetType blockSetType, boolean fireproof) {
        applyProperties(properties, 3, 3, sound, fireproof, colour).noOcclusion();
        return new DoorBlock(blockSetType, properties);
    }

    public static TrapDoorBlock trapdoor(BlockBehaviour.Properties properties, MapColor colour, SoundType sound, BlockSetType blockSetType, boolean fireproof) {
        applyProperties(properties, 3, 3, sound, fireproof, colour).noOcclusion();
        return new TrapDoorBlock(blockSetType, properties);
    }

    public static FenceBlock fence(BlockBehaviour.Properties properties, MapColor colour, SoundType sound, boolean fireproof) {
        applyProperties(properties, 2, 3, sound, fireproof, colour);
        return new FenceBlock(properties);
    }

    public static FenceGateBlock fenceGate(BlockBehaviour.Properties properties, MapColor colour, WoodType type, SoundType sound, boolean fireproof) {
        applyProperties(properties, 2, 3, sound, fireproof, colour);
        return new FenceGateBlock(type, properties);
    }

    public static PressurePlateBlock pressurePlate(BlockBehaviour.Properties properties, MapColor colour, SoundType sound, BlockSetType blockSetType, boolean fireproof) {
        applyProperties(properties, 0.5f, 0.5f, sound, fireproof, colour).noCollission();
        return new PressurePlateBlock(blockSetType, properties);
    }

    public static ButtonBlock button(BlockBehaviour.Properties properties, SoundType sound, BlockSetType blockSetType) {
        applyProperties(properties, 0.5f, 0.5f, sound, true, null).noCollission();
        return new ButtonBlock(blockSetType, 30, properties);
    }

    public static StandingSignBlock sign(BlockBehaviour.Properties properties, SoundType sound, WoodType woodType, boolean fireproof) {
        applyProperties(properties, 1, 1, sound, fireproof, null).noCollission();
        return new StandingSignBlock(woodType, properties);
    }

    public static WallSignBlock wallSign(BlockBehaviour.Properties properties, SoundType sound, Block standingSign, WoodType woodType, boolean fireproof) {
        applyProperties(properties, 1, 1, sound, fireproof, null).noCollission().dropsLike(standingSign);
        return new WallSignBlock(woodType, properties);
    }

    public static CeilingHangingSignBlock hangingSign(BlockBehaviour.Properties properties, MapColor color, SoundType sound, WoodType woodType, boolean fireproof) {
        applyProperties(properties, 1, 1, sound, fireproof, color).noCollission().forceSolidOn();
        return new CeilingHangingSignBlock(woodType, properties);
    }

    public static WallHangingSignBlock wallHangingSign(BlockBehaviour.Properties properties, MapColor color, SoundType sound, Block hangingSign, WoodType woodType, boolean fireproof) {
        applyProperties(properties, 1, 1, sound, fireproof, color).noCollission().dropsLike(hangingSign).forceSolidOn();
        return new WallHangingSignBlock(woodType, properties);
    }

    private static BlockBehaviour.Properties applyProperties(BlockBehaviour.Properties properties, float destroyTime, float explosionResistance, SoundType sound, boolean fireproof, MapColor color) {
        properties.instrument(NoteBlockInstrument.BASS).strength(destroyTime, explosionResistance).sound(sound);
        if (!fireproof) properties.ignitedByLava();
        if (color != null) properties.mapColor(color);
        return properties;
    }

    public static Supplier<Block> register(String name, BlockFactory factory) {
        return register(name, factory, RUItemUtils::registerBlock, null);
    }

    public static Supplier<Block> register(String name, BlockFactory factory, Block copiedBlock) {
        return register(name, factory, RUItemUtils::registerBlock, () -> copiedBlock);
    }

    public static Supplier<Block> register(String name, BlockFactory factory, Supplier<Block> copiedBlock) {
        return register(name, factory, RUItemUtils::registerBlock, copiedBlock);
    }

    public static Supplier<Block> registerNoItem(String name, BlockFactory factory) {
        return register(name, factory, (a, b) -> {}, null);
    }

    public static Supplier<Block> registerNoItem(String name, BlockFactory factory, Block copiedBlock) {
        return register(name, factory, (a, b) -> {}, () -> copiedBlock);
    }

    public static Supplier<Block> registerNoItem(String name, BlockFactory factory, Supplier<Block> copiedBlock) {
        return register(name, factory, (a, b) -> {}, copiedBlock);
    }

    public static Supplier<Block> register(String name, BlockFactory factory, BiConsumer<String, Supplier<Block>> itemCreator, @Nullable Supplier<Block> copiedBlock) {
        Supplier<Block> block = Registrar.registerBlock(name, () -> factory.apply(createProperties(copiedBlock)));
        itemCreator.accept(name, block);
        return block;
    }

    private static BlockBehaviour.Properties createProperties(@Nullable Supplier<Block> copiedBlock) {
        return copiedBlock != null ? BlockBehaviour.Properties.ofFullCopy(copiedBlock.get()) : BlockBehaviour.Properties.of();
    }

    //Configure leaves blocks
    public static Block leaves(BlockBehaviour.Properties properties, MapColor colour) {
        return leaves(properties, colour, false, LeavesBlock::new);
    }

    public static Block leaves(BlockBehaviour.Properties properties, MapColor colour, boolean fireproof, BlockFactory factory) {
        properties.mapColor(colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(RUBlockUtils::ocelotOrParrot).isSuffocating(RUBlockUtils::never).isViewBlocking(RUBlockUtils::never).pushReaction(PushReaction.DESTROY).isRedstoneConductor(RUBlockUtils::never);
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
