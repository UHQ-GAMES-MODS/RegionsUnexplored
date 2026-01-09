package net.regions_unexplored.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.set.NaturalSet;
import net.regions_unexplored.block.set.WoodSet;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.item.RuItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RuItemTagProvider extends ItemTagsProvider {


    public RuItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, modId, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        addCommonTags(provider);

        this.tag(ItemTags.BAMBOO_BLOCKS).addTags(RuTags.BAMBOO_LOGS_ITEM);
        this.tag(ItemTags.BIRCH_LOGS).add(RuBlocks.SILVER_BIRCH_WOOD_SET.getLog().asItem());


        var ruLogs = this.tag(RuTags.LOGS_ITEM).add(RuBlocks.BAMBOO_LOG.get().asItem()).add(RuBlocks.SMALL_OAK_LOG.get().asItem());
        var nonFlammableWood = this.tag(ItemTags.NON_FLAMMABLE_WOOD);
        var logs = this.tag(ItemTags.LOGS);
        var logsThatBurn = this.tag(ItemTags.LOGS_THAT_BURN);
        var planks = this.tag(ItemTags.PLANKS);
        var stairs = this.tag(ItemTags.WOODEN_STAIRS);
        var slabs = this.tag(ItemTags.WOODEN_SLABS);
        var fences = this.tag(ItemTags.WOODEN_FENCES);
        var fenceGates = this.tag(ItemTags.FENCE_GATES);
        var doors = this.tag(ItemTags.WOODEN_DOORS);
        var trapdoors = this.tag(ItemTags.WOODEN_TRAPDOORS);
        var buttons = this.tag(ItemTags.WOODEN_BUTTONS);
        var pressurePlates = this.tag(ItemTags.WOODEN_PRESSURE_PLATES);
        var signs = this.tag(ItemTags.SIGNS);
        var hangingSigns = this.tag(ItemTags.HANGING_SIGNS);
        var boats = this.tag(ItemTags.BOATS);
        var chestBoats = this.tag(ItemTags.CHEST_BOATS);


        for (WoodSet set : RuBlocks.WOOD_SETS) {
            if (set.fireproof) {
                set.getAllBlocks().forEach(nonFlammableWood::add);
            }
            if (set.getLog() != null) {
                var tag = set.fireproof ? logs : logsThatBurn;
                tag.add(set.getLog().asItem());
                ruLogs.add(set.getLog().asItem());
            }
            if (set.getPlanks() != null) planks.add(set.getPlanks().asItem());
            if (set.getStairs() != null) stairs.add(set.getStairs().asItem());
            if (set.getSlab() != null) slabs.add(set.getSlab().asItem());
            if (set.getFence() != null) fences.add(set.getFence().asItem());
            if (set.getFenceGate() != null) fenceGates.add(set.getFenceGate().asItem());
            if (set.getDoor() != null) doors.add(set.getDoor().asItem());
            if (set.getTrapdoor() != null) trapdoors.add(set.getTrapdoor().asItem());
            if (set.getButton() != null) buttons.add(set.getButton().asItem());
            if (set.getPressurePlate() != null) pressurePlates.add(set.getPressurePlate().asItem());
            if (set.getSign() != null) signs.add(set.getSign().asItem());
            if (set.getHangingSign() != null) hangingSigns.add(set.getHangingSign().asItem());
            if (set.getBoat() != null) boats.add(set.getBoat());
            if (set.getChestBoat() != null) chestBoats.add(set.getChestBoat());
        }
        for (Block block : RuBlocks.PAINTED_PLANKS.getAll()) {
            planks.add(block.asItem());
        }
        for (Block block : RuBlocks.PAINTED_STAIRS.getAll()) {
            stairs.add(block.asItem());
        }
        for (Block block : RuBlocks.PAINTED_SLABS.getAll()) {
            slabs.add(block.asItem());
        }


        var saplings = this.tag(ItemTags.SAPLINGS);
        var leaves = this.tag(ItemTags.LEAVES);


        for (NaturalSet set : RuBlocks.NATURAL_SETS) {
            if (set.getSapling() != null) saplings.add(set.getSapling().asItem());
            if (set.getLeaves() != null) leaves.add(set.getLeaves().asItem());
        }
        this.tag(ItemTags.DIRT)
            .add(RuBlocks.ALPHA_GRASS_BLOCK.get().asItem())
            .add(RuBlocks.ASHEN_DIRT.get().asItem())
            .add(RuBlocks.CHALK_GRASS_BLOCK.get().asItem())
            .add(RuBlocks.DEEPSLATE_GRASS_BLOCK.get().asItem())
            .add(RuBlocks.DEEPSLATE_PRISMOSS.get().asItem())
            .add(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get().asItem())
            .add(RuBlocks.PEAT_COARSE_DIRT.get().asItem())
            .add(RuBlocks.PEAT_PODZOL.get().asItem())
            .add(RuBlocks.PEAT_DIRT.get().asItem())
            .add(RuBlocks.PEAT_DIRT_PATH.get().asItem())
            .add(RuBlocks.PEAT_FARMLAND.get().asItem())
            .add(RuBlocks.PEAT_GRASS_BLOCK.get().asItem())
            .add(RuBlocks.PEAT_MUD.get().asItem())
            .add(RuBlocks.SILT_COARSE_DIRT.get().asItem())
            .add(RuBlocks.SILT_PODZOL.get().asItem())
            .add(RuBlocks.SILT_DIRT.get().asItem())
            .add(RuBlocks.SILT_DIRT_PATH.get().asItem())
            .add(RuBlocks.SILT_FARMLAND.get().asItem())
            .add(RuBlocks.SILT_GRASS_BLOCK.get().asItem())
            .add(RuBlocks.SILT_MUD.get().asItem())
            .add(RuBlocks.PRISMOSS.get().asItem())
            .add(RuBlocks.STONE_GRASS_BLOCK.get().asItem())
            .add(RuBlocks.ARGILLITE_GRASS_BLOCK.get().asItem())
            .add(RuBlocks.VIRIDESCENT_NYLIUM.get().asItem());
        this.tag(ItemTags.FLOWERS)
            .add(RuBlocks.HYACINTH_FLOWERS.get().asItem())
            .add(RuBlocks.ORANGE_CONEFLOWER.get().asItem())
            .add(RuBlocks.PURPLE_CONEFLOWER.get().asItem())
            .add(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get().asItem())
            .add(RuBlocks.PINK_MAGNOLIA_FLOWERS.get().asItem())
            .add(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get().asItem());
        this.tag(ItemTags.FOX_FOOD).add(RuItems.SALMONBERRY.get().asItem());
        this.tag(ItemTags.OAK_LOGS).add(RuBlocks.SMALL_OAK_LOG.get().asItem()).add(RuBlocks.STRIPPED_SMALL_OAK_LOG.get().asItem());
        this.tag(ItemTags.REDSTONE_ORES).add(RuBlocks.RAW_REDSTONE_BLOCK.get().asItem());
        var smallFlowers = this.tag(ItemTags.SMALL_FLOWERS)
                .add(RuBlocks.ALPHA_DANDELION.get().asItem())
                .add(RuBlocks.ALPHA_ROSE.get().asItem())
                .add(RuBlocks.ASTER.get().asItem())
                .add(RuBlocks.BLEEDING_HEART.get().asItem())
                .add(RuBlocks.BLUE_LUPINE.get().asItem())
                .add(RuBlocks.DAISY.get().asItem())
                .add(RuBlocks.DORCEL.get().asItem())
                .add(RuBlocks.FELICIA_DAISY.get().asItem())
                .add(RuBlocks.FIREWEED.get().asItem())
                .add(RuBlocks.GLISTERING_BLOOM.get().asItem())
                .add(RuBlocks.HIBISCUS.get().asItem())
                .add(RuBlocks.MALLOW.get().asItem())
                .add(RuBlocks.HYSSOP.get().asItem())
                .add(RuBlocks.PINK_LUPINE.get().asItem())
                .add(RuBlocks.POPPY_BUSH.get().asItem())
                .add(RuBlocks.SALMON_POPPY_BUSH.get().asItem())
                .add(RuBlocks.PURPLE_LUPINE.get().asItem())
                .add(RuBlocks.RED_LUPINE.get().asItem())
                .add(RuBlocks.TSUBAKI.get().asItem())
                .add(RuBlocks.WARATAH.get().asItem())
                .add(RuBlocks.WHITE_TRILLIUM.get().asItem())
                .add(RuBlocks.WILTING_TRILLIUM.get().asItem())
                .add(RuBlocks.YELLOW_LUPINE.get().asItem());
        var snowbelles = this.tag(RuTags.SNOWBELLE_ITEM);
        for (Block block : RuBlocks.SNOWBELLES.getAll()) {
            smallFlowers.add(block.asItem());
            snowbelles.add(block.asItem());
        }
        this.tag(ItemTags.TALL_FLOWERS).add(RuBlocks.TASSEL.get().asItem()).add(RuBlocks.DAY_LILY.get().asItem());
        this.tag(ItemTags.STAIRS).add(RuBlocks.CHALK_STAIRS.get().asItem()).add(RuBlocks.CHALK_BRICK_STAIRS.get().asItem()).add(RuBlocks.POLISHED_CHALK_STAIRS.get().asItem());
        this.tag(ItemTags.SLABS).add(RuBlocks.CHALK_SLAB.get().asItem()).add(RuBlocks.CHALK_BRICK_SLAB.get().asItem()).add(RuBlocks.POLISHED_CHALK_SLAB.get().asItem());
        this.tag(ItemTags.TRIM_MATERIALS).add(RuBlocks.PRISMARITE_CLUSTER.get().asItem());
        this.tag(ItemTags.WART_BLOCKS)
            .add(RuBlocks.GREEN_BIOSHROOM_BLOCK.get().asItem())
            .add(RuBlocks.BLUE_BIOSHROOM_BLOCK.get().asItem())
            .add(RuBlocks.PINK_BIOSHROOM_BLOCK.get().asItem())
            .add(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get().asItem())
            .add(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get().asItem())
            .add(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get().asItem())
            .add(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get().asItem())
            .add(RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get().asItem());


        this.tag(RuTags.HYACINTH_BLOOMS_ITEM)
                .add(RuBlocks.HYACINTH_BLOOM.get().asItem())
                .add(RuBlocks.TALL_HYACINTH_STOCK.get().asItem())
        ;
        this.tag(RuTags.PRISMARITE_CRYSTALS_ITEM)
                .add(RuBlocks.PRISMARITE_CLUSTER.get().asItem())
                .add(RuBlocks.LARGE_PRISMARITE_CLUSTER.get().asItem())
                .add(RuBlocks.HANGING_PRISMARITE.get().asItem())
        ;
        this.tag(RuTags.GRASS_ITEM)
                .add(RuBlocks.FROZEN_GRASS.get().asItem())
                .add(RuBlocks.MEDIUM_GRASS.get().asItem())
                .add(RuBlocks.SANDY_GRASS.get().asItem())
                .add(RuBlocks.STEPPE_GRASS.get().asItem())
                .add(RuBlocks.STEPPE_SHRUB.get().asItem())
                .add(RuBlocks.STONE_BUD.get().asItem())
                .add(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("minecraft", "short_grass")))
                .add(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("minecraft", "fern")))
        ;
        this.tag(RuTags.ASH_ITEM)
                .add(RuBlocks.ASH.get().asItem())
                .add(RuBlocks.VOLCANIC_ASH.get().asItem())
        ;
        this.tag(RuTags.BRANCHES_ITEM)
                .add(RuBlocks.ACACIA_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.BAOBAB_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.BIRCH_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.BLACKWOOD_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.CYPRESS_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.CHERRY_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.DARK_OAK_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.DEAD_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.EUCALYPTUS_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.JOSHUA_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.JUNGLE_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.KAPOK_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.LARCH_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.MANGROVE_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.MAPLE_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.MAUVE_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.OAK_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.PALM_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.PINE_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.REDWOOD_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.MAGNOLIA_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.SILVER_BIRCH_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.SOCOTRA_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.SPRUCE_NATURAL_SET.getBranch().asItem())
                .add(RuBlocks.WILLOW_NATURAL_SET.getBranch().asItem())
        ;
        this.tag(RuTags.BIOSHROOMS_ITEM)
                .add(RuBlocks.BLUE_BIOSHROOM.get().asItem())
                .add(RuBlocks.GREEN_BIOSHROOM.get().asItem())
                .add(RuBlocks.PINK_BIOSHROOM.get().asItem())
                .add(RuBlocks.YELLOW_BIOSHROOM.get().asItem())
                .add(RuBlocks.TALL_BLUE_BIOSHROOM.get().asItem())
                .add(RuBlocks.TALL_GREEN_BIOSHROOM.get().asItem())
                .add(RuBlocks.TALL_PINK_BIOSHROOM.get().asItem())
                .add(RuBlocks.TALL_YELLOW_BIOSHROOM.get().asItem())
        ;

        this.tag(RuTags.SHRUBS_ITEM)
                .add(RuBlocks.ACACIA_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.BAOBAB_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.BIRCH_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.BLACKWOOD_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.BRIMWOOD_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.CHERRY_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.MAGNOLIA_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.CYPRESS_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.DARK_OAK_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.DEAD_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.DEAD_PINE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.EUCALYPTUS_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.FLOWERING_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.JOSHUA_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.KAPOK_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.JUNGLE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.LARCH_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.MANGROVE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.MAPLE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.RED_MAPLE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.MAUVE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.OAK_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.PALM_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.PINE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.REDWOOD_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.SILVER_BIRCH_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.SOCOTRA_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.SPRUCE_NATURAL_SET.getShrub().asItem())
                .add(RuBlocks.WILLOW_NATURAL_SET.getShrub().asItem())
        ;
        this.tag(RuTags.BAMBOO_LOGS_ITEM)
                .add(RuBlocks.BAMBOO_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BAMBOO_LOG.get().asItem())
        ;
        this.tag(RuTags.BAOBAB_LOGS_ITEM)
                .add(RuBlocks.BAOBAB_WOOD_SET.getLog().asItem())
                .add(RuBlocks.BAOBAB_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.BAOBAB_WOOD_SET.getWood().asItem())
                .add(RuBlocks.BAOBAB_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.BRIMWOOD_LOGS_ITEM)
                .add(RuBlocks.BRIMWOOD_WOOD_SET.getLog().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD_SET.getLogMagma().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD_SET.getWood().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.BLUE_BIOSHROOM_LOGS_ITEM)
                .add(RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getLog().asItem())
                .add(RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getWood().asItem())
                .add(RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.BLACKWOOD_LOGS_ITEM)
                .add(RuBlocks.BLACKWOOD_WOOD_SET.getLog().asItem())
                .add(RuBlocks.BLACKWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.BLACKWOOD_WOOD_SET.getWood().asItem())
                .add(RuBlocks.BLACKWOOD_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.COBALT_LOGS_ITEM)
                .add(RuBlocks.COBALT_WOOD_SET.getLog().asItem())
                .add(RuBlocks.COBALT_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.COBALT_WOOD_SET.getWood().asItem())
                .add(RuBlocks.COBALT_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.CYPRESS_LOGS_ITEM)
                .add(RuBlocks.CYPRESS_WOOD_SET.getLog().asItem())
                .add(RuBlocks.CYPRESS_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.CYPRESS_WOOD_SET.getWood().asItem())
                .add(RuBlocks.CYPRESS_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.DEAD_LOGS_ITEM)
                .add(RuBlocks.ASHEN_WOOD_SET.getLog().asItem())
                .add(RuBlocks.DEAD_WOOD_SET.getLog().asItem())
                .add(RuBlocks.DEAD_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.ASHEN_WOOD_SET.getWood().asItem())
                .add(RuBlocks.DEAD_WOOD_SET.getWood().asItem())
                .add(RuBlocks.DEAD_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.EUCALYPTUS_LOGS_ITEM)
                .add(RuBlocks.EUCALYPTUS_WOOD_SET.getLog().asItem())
                .add(RuBlocks.EUCALYPTUS_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.EUCALYPTUS_WOOD_SET.getWood().asItem())
                .add(RuBlocks.EUCALYPTUS_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.GREEN_BIOSHROOM_LOGS_ITEM)
                .add(RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getLog().asItem())
                .add(RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getWood().asItem())
                .add(RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.JOSHUA_LOGS_ITEM)
                .add(RuBlocks.JOSHUA_WOOD_SET.getLog().asItem())
                .add(RuBlocks.JOSHUA_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.JOSHUA_WOOD_SET.getWood().asItem())
                .add(RuBlocks.JOSHUA_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.KAPOK_LOGS_ITEM)
                .add(RuBlocks.KAPOK_WOOD_SET.getLog().asItem())
                .add(RuBlocks.KAPOK_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.KAPOK_WOOD_SET.getWood().asItem())
                .add(RuBlocks.KAPOK_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.LARCH_LOGS_ITEM)
                .add(RuBlocks.LARCH_WOOD_SET.getLog().asItem())
                .add(RuBlocks.LARCH_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.LARCH_WOOD_SET.getWood().asItem())
                .add(RuBlocks.LARCH_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.MAGNOLIA_LOGS_ITEM)
                .add(RuBlocks.MAGNOLIA_WOOD_SET.getLog().asItem())
                .add(RuBlocks.MAGNOLIA_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.MAGNOLIA_WOOD_SET.getWood().asItem())
                .add(RuBlocks.MAGNOLIA_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.MAPLE_LOGS_ITEM)
                .add(RuBlocks.MAPLE_WOOD_SET.getLog().asItem())
                .add(RuBlocks.MAPLE_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.MAPLE_WOOD_SET.getWood().asItem())
                .add(RuBlocks.MAPLE_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.MAUVE_LOGS_ITEM)
                .add(RuBlocks.MAUVE_WOOD_SET.getLog().asItem())
                .add(RuBlocks.MAUVE_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.MAUVE_WOOD_SET.getWood().asItem())
                .add(RuBlocks.MAUVE_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.PALM_LOGS_ITEM)
                .add(RuBlocks.PALM_WOOD_SET.getLog().asItem())
                .add(RuBlocks.PALM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.PALM_WOOD_SET.getWood().asItem())
                .add(RuBlocks.PALM_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.PINE_LOGS_ITEM)
                .add(RuBlocks.PINE_WOOD_SET.getLog().asItem())
                .add(RuBlocks.PINE_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.PINE_WOOD_SET.getWood().asItem())
                .add(RuBlocks.PINE_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.PINK_BIOSHROOM_LOGS_ITEM)
                .add(RuBlocks.PINK_BIOSHROOM_WOOD_SET.getLog().asItem())
                .add(RuBlocks.PINK_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.PINK_BIOSHROOM_WOOD_SET.getWood().asItem())
                .add(RuBlocks.PINK_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.REDWOOD_LOGS_ITEM)
                .add(RuBlocks.REDWOOD_WOOD_SET.getLog().asItem())
                .add(RuBlocks.REDWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.REDWOOD_WOOD_SET.getWood().asItem())
                .add(RuBlocks.REDWOOD_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.SOCOTRA_LOGS_ITEM)
                .add(RuBlocks.SOCOTRA_WOOD_SET.getLog().asItem())
                .add(RuBlocks.SOCOTRA_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.SOCOTRA_WOOD_SET.getWood().asItem())
                .add(RuBlocks.SOCOTRA_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.WILLOW_LOGS_ITEM)
                .add(RuBlocks.WILLOW_WOOD_SET.getLog().asItem())
                .add(RuBlocks.WILLOW_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.WILLOW_WOOD_SET.getWood().asItem())
                .add(RuBlocks.WILLOW_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.YELLOW_BIOSHROOM_LOGS_ITEM)
                .add(RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getLog().asItem())
                .add(RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getWood().asItem())
                .add(RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
        ;
    }

    public void addCommonTags(HolderLookup.Provider provider) {
        this.tag(Tags.Items.STORAGE_BLOCKS_BONE_MEAL).add(RuBlocks.OVERGROWN_BONE_BLOCK.get().asItem());

        var fenceGates = this.tag(Tags.Items.FENCE_GATES_WOODEN);
        var fences = this.tag(Tags.Items.FENCES_WOODEN);
        for (WoodSet set : RuBlocks.WOOD_SETS) {
            if (set.getFenceGate() != null) fenceGates.add(set.getFenceGate().asItem());
            if (set.getFence() != null) fences.add(set.getFence().asItem());
        }
        this.tag(Tags.Items.FOODS_FRUIT)
            .add(RuItems.SALMONBERRY.get())
            .add(RuItems.HANGING_EARLIGHT_FRUIT.get());
        this.tag(Tags.Items.GEMS)
            .addTag(RuTags.PRISMARITE_CRYSTALS_ITEM);
        this.tag(Tags.Items.GLASS_BLOCKS)
            .add(RuBlocks.PRISMAGLASS.get().asItem());
        this.tag(Tags.Items.MUSHROOMS)
            .add(RuBlocks.BLUE_BIOSHROOM.get().asItem())
            .add(RuBlocks.TALL_BLUE_BIOSHROOM.get().asItem())
            .add(RuBlocks.GREEN_BIOSHROOM.get().asItem())
            .add(RuBlocks.TALL_GREEN_BIOSHROOM.get().asItem())
            .add(RuBlocks.PINK_BIOSHROOM.get().asItem())
            .add(RuBlocks.TALL_PINK_BIOSHROOM.get().asItem())
            .add(RuBlocks.YELLOW_BIOSHROOM.get().asItem())
            .add(RuBlocks.TALL_YELLOW_BIOSHROOM.get().asItem())
            .add(RuBlocks.MYCOTOXIC_MUSHROOMS.get().asItem());
        this.tag(Tags.Items.STONES)
                .add(RuBlocks.MOSSY_STONE.get().asItem())
                .add(RuBlocks.ARGILLITE.get().asItem())
                .add(RuBlocks.CHALK.get().asItem());
        this.tag(Tags.Items.GRAVELS)
                .add(RuBlocks.ASH.get().asItem())
                .add(RuBlocks.VOLCANIC_ASH.get().asItem());
        this.tag(Tags.Items.OBSIDIANS_CRYING)
                .add(RuBlocks.COBALT_OBSIDIAN.get().asItem());
        this.tag(Tags.Items.STRIPPED_LOGS)
                .add(RuBlocks.BAOBAB_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.BLACKWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.COBALT_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.CYPRESS_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.DEAD_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.EUCALYPTUS_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.JOSHUA_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.KAPOK_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.LARCH_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.MAGNOLIA_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.MAPLE_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.MAUVE_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.PALM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.PINE_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.PINK_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.REDWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.SOCOTRA_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.WILLOW_WOOD_SET.getStrippedLog().asItem())
                .add(RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
        ;
        this.tag(Tags.Items.STRIPPED_WOODS)
                .add(RuBlocks.BAOBAB_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.BLACKWOOD_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.BLUE_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.COBALT_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.CYPRESS_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.DEAD_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.EUCALYPTUS_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.GREEN_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.JOSHUA_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.KAPOK_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.LARCH_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.MAGNOLIA_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.MAPLE_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.MAUVE_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.PALM_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.PINE_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.PINK_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.REDWOOD_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.SOCOTRA_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.WILLOW_WOOD_SET.getStrippedWood().asItem())
                .add(RuBlocks.YELLOW_BIOSHROOM_WOOD_SET.getStrippedWood().asItem());
    }
}
