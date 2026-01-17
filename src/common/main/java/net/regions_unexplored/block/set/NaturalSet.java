package net.regions_unexplored.block.set;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.sapling.RuTreeGrowers;
import net.regions_unexplored.registry.BlockRegistry;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock;
import net.regions_unexplored.world.level.block.plant.sapling.RuNetherSaplingBlock;
import net.regions_unexplored.world.level.block.plant.tall.AshenShrubBlock;
import net.regions_unexplored.world.level.block.plant.tall.ShrubBlock;

import java.util.function.Function;
import java.util.function.Supplier;

public class NaturalSet {
    private static final BlockBehaviour.Properties BRANCH_PROPERTIES = BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.MANGROVE_ROOTS).strength(1.0F, 1.5F).dynamicShape();
    private static final BlockBehaviour.Properties SHRUB_PROPERTIES = BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.AZALEA).offsetType(BlockBehaviour.OffsetType.XZ);
    public final boolean fireproof;
    protected Supplier<Block> branch;
    protected Supplier<Block> shrub;
    protected Supplier<Block> leaves;
    protected Supplier<Block> sapling;
    protected Supplier<Block> pottedSapling;

    public NaturalSet(boolean fireproof) {
        this.fireproof = fireproof;
    }

    public static NaturalSet vanilla(String name) {
        NaturalSet set = new NaturalSet(false);
        set.branch = BlockRegistry.registerDefaultBlock(name + "_branch", () -> new BranchBlock(BRANCH_PROPERTIES, BranchBlock.BranchType.BRANCH));
        set.shrub = BlockRegistry.registerDefaultBlock(name + "_shrub", () -> new ShrubBlock(SHRUB_PROPERTIES));
        RuBlocks.NATURAL_SETS.add(set);
        return set;
    }

    public static NaturalSet full(String name, TreeGrower grower) {
        return full(name, MapColor.PLANT, BranchBlock.BranchType.BRANCH, false, properties -> new SaplingBlock(grower, properties));
    }

    public static NaturalSet full(String name, MapColor leavesColour, BranchBlock.BranchType branchType, boolean fireproof, TreeGrower grower) {
        return full(name, leavesColour, branchType, fireproof, properties -> new SaplingBlock(grower, properties));
    }

    public static NaturalSet full(String name, MapColor leavesColour, BranchBlock.BranchType branchType, boolean fireproof, Function<BlockBehaviour.Properties, Block> saplingFactory) {
        return full(name, branchType, fireproof, () -> BlockRegistry.leaves(leavesColour, fireproof, LeavesBlock::new), saplingFactory);
    }

    public static <T extends LeavesBlock> NaturalSet full(String name, BranchBlock.BranchType branchType, boolean fireproof, Supplier<Block> leavesFactory, Function<BlockBehaviour.Properties, Block> saplingFactory) {
        NaturalSet set = new NaturalSet(fireproof);
        set.branch = BlockRegistry.registerDefaultBlock(name + "_" + branchType.getSerializedName(), () -> new BranchBlock(BRANCH_PROPERTIES, branchType));
        set.shrub = BlockRegistry.registerDefaultBlock(name + "_shrub", () -> new ShrubBlock(SHRUB_PROPERTIES));
        set.leaves = BlockRegistry.registerDefaultBlock(name + "_leaves", leavesFactory);
        set.sapling = BlockRegistry.registerDefaultBlock(name + "_sapling", () -> saplingFactory.apply(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
        set.pottedSapling = BlockRegistry.registerDefaultBlockNoItem("potted_" + name + "_sapling", () -> new FlowerPotBlock(set.sapling.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
        RuBlocks.NATURAL_SETS.add(set);
        return set;
    }

    public static NaturalSet fullWithoutBranch(String name, MapColor leavesColour, boolean fireproof, TreeGrower grower) {
        return fullWithoutBranch(name, leavesColour, fireproof, properties -> new SaplingBlock(grower, properties));
    }

    public static NaturalSet fullWithoutBranch(String name, MapColor leavesColour, boolean fireproof, Function<BlockBehaviour.Properties, Block> saplingFactory) {
        return fullWithoutBranch(name, fireproof, () -> BlockRegistry.leaves(leavesColour, fireproof, LeavesBlock::new), saplingFactory);
    }

    public static NaturalSet fullWithoutBranch(String name, boolean fireproof, Supplier<Block> leavesFactory, Function<BlockBehaviour.Properties, Block> saplingFactory) {
        NaturalSet set = new NaturalSet(fireproof);
        set.shrub = BlockRegistry.registerDefaultBlock(name + "_shrub", () -> new ShrubBlock(SHRUB_PROPERTIES));
        set.leaves = BlockRegistry.registerDefaultBlock(name + "_leaves", leavesFactory);
        set.sapling = BlockRegistry.registerDefaultBlock(name + "_sapling", () -> saplingFactory.apply(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
        set.pottedSapling = BlockRegistry.registerDefaultBlockNoItem("potted_" + name + "_sapling", () -> new FlowerPotBlock(set.sapling.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
        RuBlocks.NATURAL_SETS.add(set);
        return set;
    }

    public static NaturalSet leavesAndSaplings(String name, Function<BlockBehaviour.Properties, Block> leavesFactory, TreeGrower grower) {
        NaturalSet set = new NaturalSet(false);
        set.leaves = BlockRegistry.registerDefaultBlock(name + "_leaves", () -> BlockRegistry.leaves(MapColor.PLANT, false, leavesFactory));
        set.sapling = BlockRegistry.registerDefaultBlock(name + "_sapling", () -> new SaplingBlock(grower, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
        set.pottedSapling = BlockRegistry.registerDefaultBlockNoItem("potted_" + name + "_sapling", () -> new FlowerPotBlock(set.sapling.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
        RuBlocks.NATURAL_SETS.add(set);
        return set;
    }

    public static NaturalSet onlySapling(String name, Supplier<Block> saplingFactory) {
        NaturalSet set = new NaturalSet(false);
        set.sapling = BlockRegistry.registerDefaultBlock(name, saplingFactory);
        set.pottedSapling = BlockRegistry.registerDefaultBlockNoItem("potted_" + name, () -> new FlowerPotBlock(set.sapling.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
        RuBlocks.NATURAL_SETS.add(set);
        return set;
    }

    public static NaturalSet ashen() {
        NaturalSet set = new NaturalSet(false);
        set.shrub = BlockRegistry.registerDefaultBlock("ashen_shrub", () -> new AshenShrubBlock(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().sound(SoundType.ROOTED_DIRT).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)));
        set.leaves = BlockRegistry.registerDefaultBlock("ashen_leaves", () -> BlockRegistry.leaves(MapColor.COLOR_LIGHT_GRAY));
        set.sapling = BlockRegistry.registerDefaultBlock("ashen_sapling", () -> new SaplingBlock(RuTreeGrowers.ASHEN, BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS).randomTicks()));
        set.pottedSapling = BlockRegistry.registerDefaultBlockNoItem("potted_ashen_sapling", () -> new FlowerPotBlock(set.sapling.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
        RuBlocks.NATURAL_SETS.add(set);
        return set;
    }

    public static NaturalSet cobalt() {
        NaturalSet set = new NaturalSet(false);
        set.sapling = BlockRegistry.registerDefaultBlock("cobalt_sapling", () -> new RuNetherSaplingBlock(RuTreeGrowers.COBALT, BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.NETHER_SPROUTS).randomTicks()));
        set.leaves = BlockRegistry.registerDefaultBlock("cobalt_webbing", () -> BlockRegistry.leaves(MapColor.COLOR_BLUE, true, LeavesBlock::new));
        set.pottedSapling = BlockRegistry.registerDefaultBlockNoItem("potted_cobalt_sapling", () -> new FlowerPotBlock(set.sapling.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));

        RuBlocks.NATURAL_SETS.add(set);
        return set;
    }

    public Block getBranch() {
        return branch != null ? branch.get() : null;
    }

    public Block getShrub() {
        return shrub != null ? shrub.get() : null;
    }

    public Block getLeaves() {
        return leaves != null ? leaves.get() : null;
    }

    public Block getSapling() {
        return sapling != null ? sapling.get() : null;
    }

    public Block getPottedSapling() {
        return pottedSapling != null ? pottedSapling.get() : null;
    }
}
