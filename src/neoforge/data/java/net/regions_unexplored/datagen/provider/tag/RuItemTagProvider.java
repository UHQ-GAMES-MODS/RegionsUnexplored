package net.regions_unexplored.datagen.provider.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.regions_unexplored.registry.RUBlocks;
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
        this.tag(ItemTags.BIRCH_LOGS).add(RUBlocks.SILVER_BIRCH_WOOD_SET.getLog().asItem());


        var ruLogs = this.tag(RuTags.LOGS_ITEM).add(RUBlocks.BAMBOO_LOG.get().asItem()).add(RUBlocks.SMALL_OAK_LOG.get().asItem());
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


        for (WoodSet set : RUBlocks.WOOD_SETS) {
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
        for (Block block : RUBlocks.PAINTED_PLANKS.getAll()) {
            planks.add(block.asItem());
        }
        for (Block block : RUBlocks.PAINTED_STAIRS.getAll()) {
            stairs.add(block.asItem());
        }
        for (Block block : RUBlocks.PAINTED_SLABS.getAll()) {
            slabs.add(block.asItem());
        }


        var saplings = this.tag(ItemTags.SAPLINGS);
        var leaves = this.tag(ItemTags.LEAVES);


        for (NaturalSet set : RUBlocks.NATURAL_SETS) {
            if (set.getSapling() != null) saplings.add(set.getSapling().asItem());
            if (set.getLeaves() != null) leaves.add(set.getLeaves().asItem());
        }
        this.tag(ItemTags.DIRT)
            .add(RUBlocks.ALPHA_GRASS_BLOCK.get().asItem())
            .add(RUBlocks.ASHEN_DIRT.get().asItem())
            .add(RUBlocks.CHALK_GRASS_BLOCK.get().asItem())
            .add(RUBlocks.DEEPSLATE_GRASS_BLOCK.get().asItem())
            .add(RUBlocks.DEEPSLATE_PRISMOSS.get().asItem())
            .add(RUBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get().asItem())
            .add(RUBlocks.PEAT_COARSE_DIRT.get().asItem())
            .add(RUBlocks.PEAT_PODZOL.get().asItem())
            .add(RUBlocks.PEAT_DIRT.get().asItem())
            .add(RUBlocks.PEAT_DIRT_PATH.get().asItem())
            .add(RUBlocks.PEAT_FARMLAND.get().asItem())
            .add(RUBlocks.PEAT_GRASS_BLOCK.get().asItem())
            .add(RUBlocks.PEAT_MUD.get().asItem())
            .add(RUBlocks.SILT_COARSE_DIRT.get().asItem())
            .add(RUBlocks.SILT_PODZOL.get().asItem())
            .add(RUBlocks.SILT_DIRT.get().asItem())
            .add(RUBlocks.SILT_DIRT_PATH.get().asItem())
            .add(RUBlocks.SILT_FARMLAND.get().asItem())
            .add(RUBlocks.SILT_GRASS_BLOCK.get().asItem())
            .add(RUBlocks.SILT_MUD.get().asItem())
            .add(RUBlocks.PRISMOSS.get().asItem())
            .add(RUBlocks.STONE_GRASS_BLOCK.get().asItem())
            .add(RUBlocks.ARGILLITE_GRASS_BLOCK.get().asItem())
            .add(RUBlocks.VIRIDESCENT_NYLIUM.get().asItem());
        this.tag(ItemTags.FLOWERS)
            .add(RUBlocks.HYACINTH_FLOWERS.get().asItem())
            .add(RUBlocks.ORANGE_CONEFLOWER.get().asItem())
            .add(RUBlocks.PURPLE_CONEFLOWER.get().asItem())
            .add(RUBlocks.BLUE_MAGNOLIA_FLOWERS.get().asItem())
            .add(RUBlocks.PINK_MAGNOLIA_FLOWERS.get().asItem())
            .add(RUBlocks.WHITE_MAGNOLIA_FLOWERS.get().asItem());
        this.tag(ItemTags.FOX_FOOD).add(RuItems.SALMONBERRY.get().asItem());
        this.tag(ItemTags.OAK_LOGS).add(RUBlocks.SMALL_OAK_LOG.get().asItem()).add(RUBlocks.STRIPPED_SMALL_OAK_LOG.get().asItem());
        this.tag(ItemTags.REDSTONE_ORES).add(RUBlocks.RAW_REDSTONE_BLOCK.get().asItem());
        var smallFlowers = this.tag(ItemTags.SMALL_FLOWERS)
                .add(RUBlocks.ALPHA_DANDELION.get().asItem())
                .add(RUBlocks.ALPHA_ROSE.get().asItem())
                .add(RUBlocks.ASTER.get().asItem())
                .add(RUBlocks.BLEEDING_HEART.get().asItem())
                .add(RUBlocks.BLUE_LUPINE.get().asItem())
                .add(RUBlocks.DAISY.get().asItem())
                .add(RUBlocks.DORCEL.get().asItem())
                .add(RUBlocks.FELICIA_DAISY.get().asItem())
                .add(RUBlocks.FIREWEED.get().asItem())
                .add(RUBlocks.GLISTERING_BLOOM.get().asItem())
                .add(RUBlocks.HIBISCUS.get().asItem())
                .add(RUBlocks.MALLOW.get().asItem())
                .add(RUBlocks.HYSSOP.get().asItem())
                .add(RUBlocks.PINK_LUPINE.get().asItem())
                .add(RUBlocks.POPPY_BUSH.get().asItem())
                .add(RUBlocks.SALMON_POPPY_BUSH.get().asItem())
                .add(RUBlocks.PURPLE_LUPINE.get().asItem())
                .add(RUBlocks.RED_LUPINE.get().asItem())
                .add(RUBlocks.TSUBAKI.get().asItem())
                .add(RUBlocks.WARATAH.get().asItem())
                .add(RUBlocks.WHITE_TRILLIUM.get().asItem())
                .add(RUBlocks.WILTING_TRILLIUM.get().asItem())
                .add(RUBlocks.YELLOW_LUPINE.get().asItem());
        var snowbelles = this.tag(RuTags.SNOWBELLE_ITEM);
        for (Block block : RUBlocks.SNOWBELLES.getAll()) {
            smallFlowers.add(block.asItem());
            snowbelles.add(block.asItem());
        }
        this.tag(ItemTags.TALL_FLOWERS).add(RUBlocks.TASSEL.get().asItem()).add(RUBlocks.DAY_LILY.get().asItem());
        this.tag(ItemTags.STAIRS).add(RUBlocks.CHALK_STAIRS.get().asItem()).add(RUBlocks.CHALK_BRICK_STAIRS.get().asItem()).add(RUBlocks.POLISHED_CHALK_STAIRS.get().asItem());
        this.tag(ItemTags.SLABS).add(RUBlocks.CHALK_SLAB.get().asItem()).add(RUBlocks.CHALK_BRICK_SLAB.get().asItem()).add(RUBlocks.POLISHED_CHALK_SLAB.get().asItem());
        this.tag(ItemTags.TRIM_MATERIALS).add(RUBlocks.PRISMARITE_CLUSTER.get().asItem());
        this.tag(ItemTags.WART_BLOCKS)
            .add(RUBlocks.GREEN_BIOSHROOM_BLOCK.get().asItem())
            .add(RUBlocks.BLUE_BIOSHROOM_BLOCK.get().asItem())
            .add(RUBlocks.PINK_BIOSHROOM_BLOCK.get().asItem())
            .add(RUBlocks.YELLOW_BIOSHROOM_BLOCK.get().asItem())
            .add(RUBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get().asItem())
            .add(RUBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get().asItem())
            .add(RUBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get().asItem())
            .add(RUBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get().asItem());


        this.tag(RuTags.HYACINTH_BLOOMS_ITEM)
                .add(RUBlocks.HYACINTH_BLOOM.get().asItem())
                .add(RUBlocks.TALL_HYACINTH_STOCK.get().asItem())
        ;
        this.tag(RuTags.PRISMARITE_CRYSTALS_ITEM)
                .add(RUBlocks.PRISMARITE_CLUSTER.get().asItem())
                .add(RUBlocks.LARGE_PRISMARITE_CLUSTER.get().asItem())
                .add(RUBlocks.HANGING_PRISMARITE.get().asItem())
        ;
        this.tag(RuTags.GRASS_ITEM)
                .add(RUBlocks.FROZEN_GRASS.get().asItem())
                .add(RUBlocks.MEDIUM_GRASS.get().asItem())
                .add(RUBlocks.SANDY_GRASS.get().asItem())
                .add(RUBlocks.STEPPE_GRASS.get().asItem())
                .add(RUBlocks.STEPPE_SHRUB.get().asItem())
                .add(RUBlocks.STONE_BUD.get().asItem())
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("minecraft", "short_grass")))
                .add(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("minecraft", "fern")))
        ;
        this.tag(RuTags.ASH_ITEM)
                .add(RUBlocks.ASH.get().asItem())
                .add(RUBlocks.VOLCANIC_ASH.get().asItem())
        ;
        this.tag(RuTags.BRANCHES_ITEM)
                .add(RUBlocks.ACACIA_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.BAOBAB_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.BIRCH_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.BLACKWOOD_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.CYPRESS_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.CHERRY_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.DARK_OAK_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.DEAD_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.EUCALYPTUS_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.JOSHUA_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.JUNGLE_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.KAPOK_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.LARCH_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.MANGROVE_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.MAPLE_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.MAUVE_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.OAK_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.PALM_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.PINE_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.REDWOOD_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.MAGNOLIA_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.SILVER_BIRCH_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.SOCOTRA_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.SPRUCE_NATURAL_SET.getBranch().asItem())
                .add(RUBlocks.WILLOW_NATURAL_SET.getBranch().asItem())
        ;
        this.tag(RuTags.BIOSHROOMS_ITEM)
                .add(RUBlocks.BLUE_BIOSHROOM.get().asItem())
                .add(RUBlocks.GREEN_BIOSHROOM.get().asItem())
                .add(RUBlocks.PINK_BIOSHROOM.get().asItem())
                .add(RUBlocks.YELLOW_BIOSHROOM.get().asItem())
                .add(RUBlocks.TALL_BLUE_BIOSHROOM.get().asItem())
                .add(RUBlocks.TALL_GREEN_BIOSHROOM.get().asItem())
                .add(RUBlocks.TALL_PINK_BIOSHROOM.get().asItem())
                .add(RUBlocks.TALL_YELLOW_BIOSHROOM.get().asItem())
        ;

        this.tag(RuTags.SHRUBS_ITEM)
                .add(RUBlocks.ACACIA_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.BAOBAB_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.BIRCH_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.BLACKWOOD_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.BRIMWOOD_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.CHERRY_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.MAGNOLIA_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.BLUE_MAGNOLIA_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.PINK_MAGNOLIA_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.WHITE_MAGNOLIA_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.CYPRESS_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.DARK_OAK_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.DEAD_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.DEAD_PINE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.EUCALYPTUS_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.FLOWERING_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.JOSHUA_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.KAPOK_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.JUNGLE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.GOLDEN_LARCH_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.LARCH_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.MANGROVE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.MAPLE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.RED_MAPLE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.ORANGE_MAPLE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.MAUVE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.OAK_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.PALM_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.PINE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.REDWOOD_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.ENCHANTED_BIRCH_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.SILVER_BIRCH_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.SOCOTRA_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.SPRUCE_NATURAL_SET.getShrub().asItem())
                .add(RUBlocks.WILLOW_NATURAL_SET.getShrub().asItem())
        ;
        this.tag(RuTags.BAMBOO_LOGS_ITEM)
                .add(RUBlocks.BAMBOO_LOG.get().asItem())
                .add(RUBlocks.STRIPPED_BAMBOO_LOG.get().asItem())
        ;
        this.tag(RuTags.BAOBAB_LOGS_ITEM)
                .add(RUBlocks.BAOBAB_WOOD_SET.getLog().asItem())
                .add(RUBlocks.BAOBAB_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.BAOBAB_WOOD_SET.getWood().asItem())
                .add(RUBlocks.BAOBAB_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.BRIMWOOD_LOGS_ITEM)
                .add(RUBlocks.BRIMWOOD_WOOD_SET.getLog().asItem())
                .add(RUBlocks.BRIMWOOD_WOOD_SET.getLogMagma().asItem())
                .add(RUBlocks.BRIMWOOD_WOOD_SET.getWood().asItem())
                .add(RUBlocks.BRIMWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.BRIMWOOD_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.BLUE_BIOSHROOM_LOGS_ITEM)
                .add(RUBlocks.BLUE_BIOSHROOM_WOOD_SET.getLog().asItem())
                .add(RUBlocks.BLUE_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.BLUE_BIOSHROOM_WOOD_SET.getWood().asItem())
                .add(RUBlocks.BLUE_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.BLACKWOOD_LOGS_ITEM)
                .add(RUBlocks.BLACKWOOD_WOOD_SET.getLog().asItem())
                .add(RUBlocks.BLACKWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.BLACKWOOD_WOOD_SET.getWood().asItem())
                .add(RUBlocks.BLACKWOOD_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.COBALT_LOGS_ITEM)
                .add(RUBlocks.COBALT_WOOD_SET.getLog().asItem())
                .add(RUBlocks.COBALT_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.COBALT_WOOD_SET.getWood().asItem())
                .add(RUBlocks.COBALT_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.CYPRESS_LOGS_ITEM)
                .add(RUBlocks.CYPRESS_WOOD_SET.getLog().asItem())
                .add(RUBlocks.CYPRESS_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.CYPRESS_WOOD_SET.getWood().asItem())
                .add(RUBlocks.CYPRESS_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.DEAD_LOGS_ITEM)
                .add(RUBlocks.ASHEN_WOOD_SET.getLog().asItem())
                .add(RUBlocks.DEAD_WOOD_SET.getLog().asItem())
                .add(RUBlocks.DEAD_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.ASHEN_WOOD_SET.getWood().asItem())
                .add(RUBlocks.DEAD_WOOD_SET.getWood().asItem())
                .add(RUBlocks.DEAD_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.EUCALYPTUS_LOGS_ITEM)
                .add(RUBlocks.EUCALYPTUS_WOOD_SET.getLog().asItem())
                .add(RUBlocks.EUCALYPTUS_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.EUCALYPTUS_WOOD_SET.getWood().asItem())
                .add(RUBlocks.EUCALYPTUS_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.GREEN_BIOSHROOM_LOGS_ITEM)
                .add(RUBlocks.GREEN_BIOSHROOM_WOOD_SET.getLog().asItem())
                .add(RUBlocks.GREEN_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.GREEN_BIOSHROOM_WOOD_SET.getWood().asItem())
                .add(RUBlocks.GREEN_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.JOSHUA_LOGS_ITEM)
                .add(RUBlocks.JOSHUA_WOOD_SET.getLog().asItem())
                .add(RUBlocks.JOSHUA_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.JOSHUA_WOOD_SET.getWood().asItem())
                .add(RUBlocks.JOSHUA_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.KAPOK_LOGS_ITEM)
                .add(RUBlocks.KAPOK_WOOD_SET.getLog().asItem())
                .add(RUBlocks.KAPOK_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.KAPOK_WOOD_SET.getWood().asItem())
                .add(RUBlocks.KAPOK_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.LARCH_LOGS_ITEM)
                .add(RUBlocks.LARCH_WOOD_SET.getLog().asItem())
                .add(RUBlocks.LARCH_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.LARCH_WOOD_SET.getWood().asItem())
                .add(RUBlocks.LARCH_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.MAGNOLIA_LOGS_ITEM)
                .add(RUBlocks.MAGNOLIA_WOOD_SET.getLog().asItem())
                .add(RUBlocks.MAGNOLIA_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.MAGNOLIA_WOOD_SET.getWood().asItem())
                .add(RUBlocks.MAGNOLIA_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.MAPLE_LOGS_ITEM)
                .add(RUBlocks.MAPLE_WOOD_SET.getLog().asItem())
                .add(RUBlocks.MAPLE_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.MAPLE_WOOD_SET.getWood().asItem())
                .add(RUBlocks.MAPLE_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.MAUVE_LOGS_ITEM)
                .add(RUBlocks.MAUVE_WOOD_SET.getLog().asItem())
                .add(RUBlocks.MAUVE_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.MAUVE_WOOD_SET.getWood().asItem())
                .add(RUBlocks.MAUVE_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.PALM_LOGS_ITEM)
                .add(RUBlocks.PALM_WOOD_SET.getLog().asItem())
                .add(RUBlocks.PALM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.PALM_WOOD_SET.getWood().asItem())
                .add(RUBlocks.PALM_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.PINE_LOGS_ITEM)
                .add(RUBlocks.PINE_WOOD_SET.getLog().asItem())
                .add(RUBlocks.PINE_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.PINE_WOOD_SET.getWood().asItem())
                .add(RUBlocks.PINE_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.PINK_BIOSHROOM_LOGS_ITEM)
                .add(RUBlocks.PINK_BIOSHROOM_WOOD_SET.getLog().asItem())
                .add(RUBlocks.PINK_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.PINK_BIOSHROOM_WOOD_SET.getWood().asItem())
                .add(RUBlocks.PINK_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.REDWOOD_LOGS_ITEM)
                .add(RUBlocks.REDWOOD_WOOD_SET.getLog().asItem())
                .add(RUBlocks.REDWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.REDWOOD_WOOD_SET.getWood().asItem())
                .add(RUBlocks.REDWOOD_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.SOCOTRA_LOGS_ITEM)
                .add(RUBlocks.SOCOTRA_WOOD_SET.getLog().asItem())
                .add(RUBlocks.SOCOTRA_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.SOCOTRA_WOOD_SET.getWood().asItem())
                .add(RUBlocks.SOCOTRA_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.WILLOW_LOGS_ITEM)
                .add(RUBlocks.WILLOW_WOOD_SET.getLog().asItem())
                .add(RUBlocks.WILLOW_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.WILLOW_WOOD_SET.getWood().asItem())
                .add(RUBlocks.WILLOW_WOOD_SET.getStrippedWood().asItem())
        ;
        this.tag(RuTags.YELLOW_BIOSHROOM_LOGS_ITEM)
                .add(RUBlocks.YELLOW_BIOSHROOM_WOOD_SET.getLog().asItem())
                .add(RUBlocks.YELLOW_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.YELLOW_BIOSHROOM_WOOD_SET.getWood().asItem())
                .add(RUBlocks.YELLOW_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
        ;
    }

    public void addCommonTags(HolderLookup.Provider provider) {
        this.tag(Tags.Items.STORAGE_BLOCKS_BONE_MEAL).add(RUBlocks.OVERGROWN_BONE_BLOCK.get().asItem());

        var fenceGates = this.tag(Tags.Items.FENCE_GATES_WOODEN);
        var fences = this.tag(Tags.Items.FENCES_WOODEN);
        for (WoodSet set : RUBlocks.WOOD_SETS) {
            if (set.getFenceGate() != null) fenceGates.add(set.getFenceGate().asItem());
            if (set.getFence() != null) fences.add(set.getFence().asItem());
        }
        this.tag(Tags.Items.FOODS_FRUIT)
            .add(RuItems.SALMONBERRY.get())
            .add(RuItems.HANGING_EARLIGHT_FRUIT.get());
        this.tag(Tags.Items.GEMS)
            .addTag(RuTags.PRISMARITE_CRYSTALS_ITEM);
        this.tag(Tags.Items.GLASS_BLOCKS)
            .add(RUBlocks.PRISMAGLASS.get().asItem());
        this.tag(Tags.Items.MUSHROOMS)
            .add(RUBlocks.BLUE_BIOSHROOM.get().asItem())
            .add(RUBlocks.TALL_BLUE_BIOSHROOM.get().asItem())
            .add(RUBlocks.GREEN_BIOSHROOM.get().asItem())
            .add(RUBlocks.TALL_GREEN_BIOSHROOM.get().asItem())
            .add(RUBlocks.PINK_BIOSHROOM.get().asItem())
            .add(RUBlocks.TALL_PINK_BIOSHROOM.get().asItem())
            .add(RUBlocks.YELLOW_BIOSHROOM.get().asItem())
            .add(RUBlocks.TALL_YELLOW_BIOSHROOM.get().asItem())
            .add(RUBlocks.MYCOTOXIC_MUSHROOMS.get().asItem());
        this.tag(Tags.Items.STONES)
                .add(RUBlocks.MOSSY_STONE.get().asItem())
                .add(RUBlocks.ARGILLITE.get().asItem())
                .add(RUBlocks.CHALK.get().asItem());
        this.tag(Tags.Items.GRAVELS)
                .add(RUBlocks.ASH.get().asItem())
                .add(RUBlocks.VOLCANIC_ASH.get().asItem());
        this.tag(Tags.Items.OBSIDIANS_CRYING)
                .add(RUBlocks.COBALT_OBSIDIAN.get().asItem());
        this.tag(Tags.Items.STRIPPED_LOGS)
                .add(RUBlocks.BAOBAB_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.BLACKWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.BLUE_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.BRIMWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.COBALT_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.CYPRESS_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.DEAD_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.EUCALYPTUS_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.GREEN_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.JOSHUA_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.KAPOK_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.LARCH_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.MAGNOLIA_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.MAPLE_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.MAUVE_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.PALM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.PINE_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.PINK_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.REDWOOD_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.SOCOTRA_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.WILLOW_WOOD_SET.getStrippedLog().asItem())
                .add(RUBlocks.YELLOW_BIOSHROOM_WOOD_SET.getStrippedLog().asItem())
        ;
        this.tag(Tags.Items.STRIPPED_WOODS)
                .add(RUBlocks.BAOBAB_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.BLACKWOOD_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.BLUE_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.BRIMWOOD_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.COBALT_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.CYPRESS_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.DEAD_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.EUCALYPTUS_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.GREEN_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.JOSHUA_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.KAPOK_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.LARCH_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.MAGNOLIA_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.MAPLE_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.MAUVE_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.PALM_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.PINE_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.PINK_BIOSHROOM_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.REDWOOD_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.SOCOTRA_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.WILLOW_WOOD_SET.getStrippedWood().asItem())
                .add(RUBlocks.YELLOW_BIOSHROOM_WOOD_SET.getStrippedWood().asItem());
    }
}
