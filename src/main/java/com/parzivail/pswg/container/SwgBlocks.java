package com.parzivail.pswg.container;

import com.parzivail.pswg.Galaxies;
import com.parzivail.pswg.Resources;
import com.parzivail.pswg.block.*;
import com.parzivail.pswg.blockentity.*;
import com.parzivail.pswg.container.registry.RegistryHelper;
import com.parzivail.pswg.container.registry.RegistryName;
import com.parzivail.util.block.BlockUtils;
import com.parzivail.util.block.VoxelShapeUtil;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShapes;

import java.util.Random;

public class SwgBlocks
{
	public static class Barrel
	{
		@RegistryName("barrel_mos_eisley")
		public static final Block MosEisley = new TranslatingBlock((state, world, pos, context) -> {
			Random r = Resources.RANDOM;
			r.setSeed(state.getRenderingSeed(pos));

			float s = 4;
			float dx = r.nextFloat() * s;
			float dz = r.nextFloat() * s;

			return VoxelShapeUtil.getCenteredCube(9.2f, 15.6f, dx, dz);
		}, FabricBlockSettings.of(Material.METAL).nonOpaque());
	}

	public static class Crate
	{
		@RegistryName("crate_octagon_orange")
		public static final RotatingBlockWithGuiEntity OctagonOrange = new RotatingBlockWithGuiEntity(FabricBlockSettings.of(Material.METAL).nonOpaque(), CrateOctagonBlockEntity::new);
		@RegistryName("crate_octagon_gray")
		public static final RotatingBlockWithGuiEntity OctagonGray = new RotatingBlockWithGuiEntity(FabricBlockSettings.of(Material.METAL).nonOpaque(), CrateOctagonBlockEntity::new);
		@RegistryName("crate_octagon_black")
		public static final RotatingBlockWithGuiEntity OctagonBlack = new RotatingBlockWithGuiEntity(FabricBlockSettings.of(Material.METAL).nonOpaque(), CrateOctagonBlockEntity::new);
		@RegistryName("crate_octagon")
		public static final BlockEntityType<CrateOctagonBlockEntity> OctagonBlockEntityType = BlockEntityType.Builder.create(CrateOctagonBlockEntity::new, OctagonOrange, OctagonGray, OctagonBlack).build(null);

		@RegistryName("crate_mos_eisley")
		public static final RotatingBlockWithGuiEntity MosEisley = new RotatingBlockWithGuiEntity(FabricBlockSettings.of(Material.METAL).nonOpaque(), CrateMosEisleyBlockEntity::new);
		@RegistryName("crate_mos_eisley")
		public static final BlockEntityType<CrateMosEisleyBlockEntity> MosEisleyBlockEntityType = BlockEntityType.Builder.create(CrateMosEisleyBlockEntity::new, MosEisley).build(null);

		@RegistryName("crate_imperial_cube")
		public static final RotatingBlockWithGuiEntity ImperialCube = new RotatingBlockWithGuiEntity(FabricBlockSettings.of(Material.METAL).nonOpaque(), CrateImperialCubeBlockEntity::new);
		@RegistryName("crate_imperial_cube")
		public static final BlockEntityType<CrateImperialCubeBlockEntity> ImperialCubeBlockEntityType = BlockEntityType.Builder.create(CrateImperialCubeBlockEntity::new, ImperialCube).build(null);
	}

	public static class Door
	{
		public static final BlockTatooineHomeDoor TatooineHomeFiller = new BlockTatooineHomeDoor(FabricBlockSettings.of(Material.METAL).nonOpaque());
		public static final BlockTatooineHomeDoor TatooineHomeController = new BlockTatooineHomeDoorController(FabricBlockSettings.of(Material.METAL).nonOpaque());
		@RegistryName("door_tatooine_home")
		public static final BlockEntityType<TatooineHomeDoorBlockEntity> TatooineHomeBlockEntityType = BlockEntityType.Builder.create(TatooineHomeDoorBlockEntity::new, TatooineHomeController).build(null);
	}

	public static class Leaves
	{
		@RegistryName("leaves_sequoia")
		public static final LeavesBlock Sequoia = createLeavesBlock();

		private static LeavesBlock createLeavesBlock()
		{
			return new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().suffocates(BlockUtils::never).blockVision(BlockUtils::never));
		}
	}

	public static class Log
	{
		@RegistryName("log_sequoia")
		public static final PillarBlock Sequoia = createLogBlock(MaterialColor.WOOD, MaterialColor.BROWN);

		private static PillarBlock createLogBlock(MaterialColor topMaterialColor, MaterialColor sideMaterialColor)
		{
			return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> {
				return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor;
			}).strength(2.0F).sounds(BlockSoundGroup.WOOD));
		}
	}

	public static class Machine
	{
		@RegistryName("machine_spoked")
		public static final RotatingBlock Spoked = new RotatingBlockWithBounds(VoxelShapeUtil.getCenteredCube(10, 20), FabricBlockSettings.of(Material.METAL).nonOpaque());
	}

	public static class Ore
	{
		@RegistryName("beskar_ore")
		public static final Block Beskar = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("chromium_ore")
		public static final Block Chromium = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("cortosis_ore")
		public static final Block Cortosis = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("desh_ore")
		public static final Block Desh = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("diatium_ore")
		public static final Block Diatium = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("exonium_ore")
		public static final Block Exonium = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("helicite_ore")
		public static final Block Helicite = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("ionite_ore")
		public static final Block Ionite = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("kelerium_ore")
		public static final Block Kelerium = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("rubindum_ore")
		public static final Block Rubindum = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("thorolide_ore")
		public static final Block Thorolide = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("titanium_ore")
		public static final Block Titanium = new Block(FabricBlockSettings.of(Material.STONE));
	}

	public static class MaterialBlock
	{
		@RegistryName("beskar_block")
		public static final Block Beskar = new Block(FabricBlockSettings.of(Material.METAL));
		@RegistryName("chromium_block")
		public static final Block Chromium = new Block(FabricBlockSettings.of(Material.METAL));
		@RegistryName("cortosis_block")
		public static final Block Cortosis = new Block(FabricBlockSettings.of(Material.METAL));
		@RegistryName("desh_block")
		public static final Block Desh = new Block(FabricBlockSettings.of(Material.METAL));
		@RegistryName("durasteel_block")
		public static final Block Durasteel = new Block(FabricBlockSettings.of(Material.METAL));
		@RegistryName("plasteel_block")
		public static final Block Plasteel = new Block(FabricBlockSettings.of(Material.METAL));
		@RegistryName("titanium_block")
		public static final Block Titanium = new Block(FabricBlockSettings.of(Material.METAL));
	}

	public static class Light
	{
		@RegistryName("light_floor_wedge")
		public static final Block FloorWedge = new RotatingBlockWithBounds(VoxelShapeUtil.getCenteredCube(8, 5), FabricBlockSettings.of(Material.METAL).nonOpaque().luminance(15));
		@RegistryName("light_wall_cluster")
		public static final Block WallCluster = new RotatingBlockWithBounds(VoxelShapes.cuboid(0, 0.0625f, 0.0625f, 0.0625f, 0.9375f, 0.9375f), FabricBlockSettings.of(Material.METAL).nonOpaque().luminance(15));
	}

	public static class Plant
	{
		@RegistryName("funnel_flower")
		public static final Block FunnelFlower = new SwgFernBlock(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
		@RegistryName("blossoming_funnel_flower")
		public static final Block BlossomingFunnelFlower = new SwgFernBlock(AbstractBlock.Settings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS));
	}

	public static class Panel
	{
		@RegistryName("panel_imperial_base")
		public static final Block ImperialBase = new Block(FabricBlockSettings.of(Material.METAL).materialColor(MaterialColor.GRAY).sounds(BlockSoundGroup.METAL));
		@RegistryName("panel_imperial_black_base")
		public static final Block ImperialBlackBase = new Block(FabricBlockSettings.of(Material.METAL).materialColor(MaterialColor.BLACK).sounds(BlockSoundGroup.METAL));
		@RegistryName("panel_imperial_1")
		public static final PillarBlock Imperial1 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_2")
		public static final PillarBlock Imperial2 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_3")
		public static final PillarBlock Imperial3 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_1")
		public static final PillarBlock ImperialLight1 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_2")
		public static final PillarBlock ImperialLight2 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_3")
		public static final PillarBlock ImperialLight3 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_4")
		public static final PillarBlock ImperialLight4 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_5")
		public static final PillarBlock ImperialLight5 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_6")
		public static final PillarBlock ImperialLight6 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_tall_1")
		public static final PillarBlock ImperialLightTall1 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_tall_2")
		public static final PillarBlock ImperialLightTall2 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_tall_3")
		public static final PillarBlock ImperialLightTall3 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_tall_4")
		public static final PillarBlock ImperialLightTall4 = createLitPanel(MaterialColor.GRAY, MaterialColor.LIGHT_GRAY);
		@RegistryName("panel_imperial_light_decoy")
		public static final PillarBlock ImperialLightDecoy = createPanel(MaterialColor.GRAY, MaterialColor.GRAY);
		@RegistryName("panel_imperial_light_off")
		public static final PillarBlock ImperialLightOff = createPanel(MaterialColor.GRAY, MaterialColor.BLACK);
		@RegistryName("lab_wall")
		public static final Block LabWall = new Block(FabricBlockSettings.of(Material.STONE));

		private static PillarBlock createLitPanel(MaterialColor topMaterialColor, MaterialColor sideMaterialColor)
		{
			return new PillarBlock(AbstractBlock.Settings.of(Material.METAL, (blockState) -> {
				return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor;
			}).strength(2.0F).sounds(BlockSoundGroup.METAL).luminance(value -> 15));
		}

		private static PillarBlock createPanel(MaterialColor topMaterialColor, MaterialColor sideMaterialColor)
		{
			return new PillarBlock(AbstractBlock.Settings.of(Material.METAL, (blockState) -> {
				return blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor;
			}).strength(2.0F).sounds(BlockSoundGroup.METAL));
		}
	}

	public static class Pipe
	{
		@RegistryName("pipe_thick")
		public static final Block Thick = new SelfConnectingNodeBlock(FabricBlockSettings.of(Material.METAL).materialColor(MaterialColor.GRAY).nonOpaque().sounds(BlockSoundGroup.METAL));
	}

	public static class Sand
	{
		@RegistryName("sand_tatooine")
		public static final Block Tatooine = new FallingBlock(FabricBlockSettings.of(Material.AGGREGATE).strength(0.5F).sounds(BlockSoundGroup.SAND));
	}

	public static class Stone
	{
		@RegistryName("stone_temple")
		public static final Block Temple = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("stone_temple_bricks")
		public static final Block TempleBricks = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("stone_temple_bricks_chiseled")
		public static final Block TempleBricksChiseled = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("stone_temple_slab_side_smooth")
		public static final Block TempleSlabSideSmooth = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("stone_temple_smooth")
		public static final Block TempleSmooth = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("stone_massassi_bricks")
		public static final Block MassassiBricks = new Block(FabricBlockSettings.of(Material.STONE));
		@RegistryName("stone_massassi_smooth")
		public static final Block MassassiSmooth = new Block(FabricBlockSettings.of(Material.STONE));

		@RegistryName("stone_temple_stairs")
		public static final Block TempleStairs = new SwgStairsBlock(Temple.getDefaultState(), AbstractBlock.Settings.copy(Temple));
		@RegistryName("stone_temple_brick_stairs")
		public static final Block TempleBricksStairs = new SwgStairsBlock(TempleBricks.getDefaultState(), AbstractBlock.Settings.copy(TempleBricks));
		@RegistryName("stone_temple_brick_chiseled_stairs")
		public static final Block TempleBricksChiseledStairs = new SwgStairsBlock(TempleBricksChiseled.getDefaultState(), AbstractBlock.Settings.copy(TempleBricksChiseled));
		@RegistryName("stone_temple_slab_side_smooth_stairs")
		public static final Block TempleSlabSideSmoothStairs = new SwgStairsBlock(TempleSlabSideSmooth.getDefaultState(), AbstractBlock.Settings.copy(TempleSlabSideSmooth));
		@RegistryName("stone_temple_smooth_stairs")
		public static final Block TempleSmoothStairs = new SwgStairsBlock(TempleSmooth.getDefaultState(), AbstractBlock.Settings.copy(TempleSmooth));
		@RegistryName("stone_massassi_brick_stairs")
		public static final Block MassassiBrickStairs = new SwgStairsBlock(MassassiBricks.getDefaultState(), AbstractBlock.Settings.copy(MassassiBricks));
		@RegistryName("stone_massassi_smooth_stairs")
		public static final Block MassassiSmoothStairs = new SwgStairsBlock(MassassiSmooth.getDefaultState(), AbstractBlock.Settings.copy(MassassiSmooth));

		@RegistryName("stone_temple_slab")
		public static final Block TempleSlab = new SlabBlock(AbstractBlock.Settings.copy(Temple));
		@RegistryName("stone_temple_brick_slab")
		public static final Block TempleBricksSlab = new SlabBlock(AbstractBlock.Settings.copy(TempleBricks));
		@RegistryName("stone_temple_brick_chiseled_slab")
		public static final Block TempleBricksChiseledSlab = new SlabBlock(AbstractBlock.Settings.copy(TempleBricksChiseled));
		@RegistryName("stone_temple_brick_beveled_slab")
		public static final Block TempleBricksBeveledSlab = new SlabBlock(AbstractBlock.Settings.copy(TempleSlabSideSmooth));
		@RegistryName("stone_temple_smooth_slab")
		public static final Block TempleSmoothSlab = new SlabBlock(AbstractBlock.Settings.copy(TempleSmooth));
		@RegistryName("stone_massassi_brick_slab")
		public static final Block MassassiBrickSlab = new SlabBlock(AbstractBlock.Settings.copy(MassassiBricks));
		@RegistryName("stone_massassi_smooth_slab")
		public static final Block MassassiSmoothSlab = new SlabBlock(AbstractBlock.Settings.copy(MassassiSmooth));
	}

	public static class Tank
	{
		@RegistryName("tank_fusion")
		public static final Block Fusion = new RotatingBlock(FabricBlockSettings.of(Material.METAL).nonOpaque());
	}

	public static class MoistureVaporator
	{
		@RegistryName("moisture_vaporator_gx8")
		public static final BlockMoistureVaporator Gx8 = new BlockMoistureVaporator(FabricBlockSettings.of(Material.METAL).nonOpaque());
		@RegistryName("moisture_vaporator_gx8")
		public static final BlockEntityType<MoistureVaporatorBlockEntity> Gx8BlockEntityType = BlockEntityType.Builder.create(MoistureVaporatorBlockEntity::new, Gx8).build(null);
	}

	public static class Workbench
	{
		@RegistryName("blaster_workbench")
		public static final Block Blaster = new BlasterWorkbenchBlock(FabricBlockSettings.of(Material.METAL));
		@RegistryName("blaster_workbench")
		public static final BlockEntityType<BlasterWorkbenchBlockEntity> BlasterBlockEntityType = BlockEntityType.Builder.create(BlasterWorkbenchBlockEntity::new, Blaster).build(null);
		@RegistryName("lightsaber_forge")
		public static final Block Lightsaber = new LightsaberForgeBlock(FabricBlockSettings.of(Material.WOOD));
		@RegistryName("lightsaber_forge")
		public static final BlockEntityType<LightsaberForgeBlockEntity> LightsaberBlockEntityType = BlockEntityType.Builder.create(LightsaberForgeBlockEntity::new, Lightsaber).build(null);
	}

	public static void register()
	{
		RegistryHelper.registerAnnotatedFields(SwgBlocks.class, Block.class, SwgBlocks::registerBlock);
		RegistryHelper.registerAnnotatedFields(SwgBlocks.class, BlockEntityType.class, SwgBlocks::registerBlockEntityType);

		Registry.register(Registry.BLOCK, Resources.identifier("door_tatooine_home_controller"), Door.TatooineHomeController);
		Registry.register(Registry.BLOCK, Resources.identifier("door_tatooine_home"), Door.TatooineHomeFiller);
		Registry.register(Registry.ITEM, Resources.identifier("door_tatooine_home_controller"), new BlockTatooineHomeDoor.Item(Door.TatooineHomeController, new Item.Settings().group(Galaxies.Tab)));
	}

	public static void registerBlock(Block block, Identifier identifier)
	{
		Registry.register(Registry.BLOCK, identifier, block);
		Registry.register(Registry.ITEM, identifier, new BlockItem(block, new Item.Settings().group(Galaxies.Tab)));
	}

	public static void registerBlockEntityType(BlockEntityType<?> blockEntityType, Identifier identifier)
	{
		Registry.register(Registry.BLOCK_ENTITY_TYPE, identifier, blockEntityType);
	}
}
