package net.regions_unexplored.block.set;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.regions_unexplored.block.BlockFactory;
import net.regions_unexplored.registry.RUBlocks;
import net.regions_unexplored.block.sapling.RuTreeGrowers;
import net.regions_unexplored.block.RUBlockUtils;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock;
import net.regions_unexplored.world.level.block.plant.sapling.RuCactusSaplingBlock;
import net.regions_unexplored.world.level.block.plant.sapling.RuNetherSaplingBlock;
import net.regions_unexplored.world.level.block.plant.tall.ShrubBlock;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class NaturalSet {
    private static final UnaryOperator<BlockBehaviour.Properties> BRANCH_PROPERTIES = p -> p.noOcclusion().sound(SoundType.MANGROVE_ROOTS).strength(1.0F, 1.5F).dynamicShape();
    private static final UnaryOperator<BlockBehaviour.Properties> SHRUB_PROPERTIES = p -> p.pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.AZALEA).offsetType(BlockBehaviour.OffsetType.XZ);
    public final String name;
    public final boolean fireproof;
    protected Supplier<Block> branch;
    protected Supplier<Block> shrub;
    protected Supplier<Block> leaves;
    protected Supplier<Block> sapling;
    protected Supplier<Block> pottedSapling;

    public NaturalSet(String name, boolean fireproof) {
        this.name = name;
        this.fireproof = fireproof;
        RUBlocks.NATURAL_SETS.add(this);
    }

    public static NaturalSet vanilla(String name) {
        NaturalSet set = new NaturalSet(name, false);
        set.branch = RUBlockUtils.register(name + "_branch", p -> new BranchBlock(BRANCH_PROPERTIES.apply(p), BranchBlock.BranchType.BRANCH));
        set.shrub = RUBlockUtils.register(name + "_shrub", p -> new ShrubBlock(SHRUB_PROPERTIES.apply(p)));
        return set;
    }

    public static NaturalSet full(String name, TreeGrower grower) {
        return full(name, MapColor.PLANT, BranchBlock.BranchType.BRANCH, false, properties -> new SaplingBlock(grower, properties));
    }

    public static NaturalSet full(String name, MapColor leavesColour, BranchBlock.BranchType branchType, boolean fireproof, TreeGrower grower) {
        return full(name, leavesColour, branchType, fireproof, properties -> new SaplingBlock(grower, properties));
    }

    public static NaturalSet full(String name, MapColor leavesColour, BranchBlock.BranchType branchType, boolean fireproof, BlockFactory saplingFactory) {
        return full(name, branchType, fireproof, p -> RUBlockUtils.leaves(p, leavesColour, fireproof, LeavesBlock::new), saplingFactory);
    }

    public static NaturalSet full(String name, BranchBlock.BranchType branchType, boolean fireproof, BlockFactory leavesFactory, BlockFactory saplingFactory) {
        NaturalSet set = new NaturalSet(name, fireproof);
        set.branch = RUBlockUtils.register(name + "_" + branchType.getSerializedName(), p -> new BranchBlock(BRANCH_PROPERTIES.apply(p), branchType));
        set.shrub = RUBlockUtils.register(name + "_shrub", p -> new ShrubBlock(SHRUB_PROPERTIES.apply(p)));
        set.leaves = RUBlockUtils.register(name + "_leaves", leavesFactory);
        set.sapling = RUBlockUtils.register(name + "_sapling", saplingFactory, Blocks.OAK_SAPLING);
        set.pottedSapling = RUBlockUtils.registerNoItem("potted_" + name + "_sapling", p -> new FlowerPotBlock(set.sapling.get(), p), Blocks.POTTED_OAK_SAPLING);
        return set;
    }

    public static NaturalSet fullWithoutBranch(String name, MapColor leavesColour, boolean fireproof, TreeGrower grower) {
        return fullWithoutBranch(name, leavesColour, fireproof, properties -> new SaplingBlock(grower, properties));
    }

    public static NaturalSet fullWithoutBranch(String name, MapColor leavesColour, boolean fireproof, BlockFactory saplingFactory) {
        return fullWithoutBranch(name, fireproof, p -> RUBlockUtils.leaves(p, leavesColour, fireproof, LeavesBlock::new), saplingFactory);
    }

    public static NaturalSet fullWithoutBranch(String name, boolean fireproof, BlockFactory leavesFactory, BlockFactory saplingFactory) {
        NaturalSet set = new NaturalSet(name, fireproof);
        set.shrub = RUBlockUtils.register(name + "_shrub", p -> new ShrubBlock(SHRUB_PROPERTIES.apply(p)));
        set.leaves = RUBlockUtils.register(name + "_leaves", leavesFactory);
        set.sapling = RUBlockUtils.register(name + "_sapling", saplingFactory, Blocks.OAK_SAPLING);
        set.pottedSapling = RUBlockUtils.registerNoItem("potted_" + name + "_sapling", p -> new FlowerPotBlock(set.sapling.get(), p), Blocks.POTTED_OAK_SAPLING);
        return set;
    }

    public static NaturalSet leavesAndSaplings(String name, BlockFactory leavesFactory, TreeGrower grower) {
        NaturalSet set = new NaturalSet(name, false);
        set.leaves = RUBlockUtils.register(name + "_leaves", p -> RUBlockUtils.leaves(p, MapColor.PLANT, false, leavesFactory));
        set.sapling = RUBlockUtils.register(name + "_sapling", p -> new SaplingBlock(grower, p), Blocks.OAK_SAPLING);
        set.pottedSapling = RUBlockUtils.registerNoItem("potted_" + name + "_sapling", p -> new FlowerPotBlock(set.sapling.get(), p), Blocks.POTTED_OAK_SAPLING);
        return set;
    }

    public static NaturalSet saguaroCactus() {
        NaturalSet set = new NaturalSet("saguaro_cactus", false);
        set.sapling = RUBlockUtils.register("saguaro_cactus_flower", p -> new RuCactusSaplingBlock(RuTreeGrowers.SAGUARO_CACTUS, p), Blocks.OAK_SAPLING);
        set.pottedSapling = RUBlockUtils.registerNoItem("potted_saguaro_cactus_flower", p -> new FlowerPotBlock(set.sapling.get(), p), Blocks.POTTED_OAK_SAPLING);
        return set;
    }

    public static NaturalSet ashen() {
        NaturalSet set = new NaturalSet("ashen", false);
        set.shrub = RUBlockUtils.register("ashen_shrub", p -> new ShrubBlock(SHRUB_PROPERTIES.apply(p).sound(SoundType.ROOTED_DIRT).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)));
        set.leaves = RUBlockUtils.register("ashen_leaves", p -> RUBlockUtils.leaves(p, MapColor.COLOR_LIGHT_GRAY));
        set.sapling = RUBlockUtils.register("ashen_sapling", p -> new SaplingBlock(RuTreeGrowers.ASHEN, p), Blocks.OAK_SAPLING);
        set.pottedSapling = RUBlockUtils.registerNoItem("potted_ashen_sapling", p -> new FlowerPotBlock(set.sapling.get(), p), Blocks.POTTED_OAK_SAPLING);
        return set;
    }

    public static NaturalSet cobalt() {
        NaturalSet set = new NaturalSet("cobalt", false);
        set.leaves = RUBlockUtils.register("cobalt_webbing", p -> RUBlockUtils.leaves(p, MapColor.COLOR_BLUE, true, LeavesBlock::new));
        set.sapling = RUBlockUtils.register("cobalt_sapling", p -> new RuNetherSaplingBlock(RuTreeGrowers.COBALT, p.sound(SoundType.NETHER_SPROUTS)), Blocks.OAK_SAPLING);
        set.pottedSapling = RUBlockUtils.registerNoItem("potted_cobalt_sapling", p -> new FlowerPotBlock(set.sapling.get(), p), Blocks.POTTED_OAK_SAPLING);
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
