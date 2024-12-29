package net.dwayne.the.block.johnson;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class DwayneTheModJohnson implements ModInitializer {
  private static final String DWAYNE_THE_ID_JOHNSON = "dwayne_the_block_johnson";
  private static final Logger DWAYNE_THE_LOGGER_JOHNSON = LoggerFactory.getLogger(DWAYNE_THE_ID_JOHNSON);
  private static final ItemGroup DWAYNE_THE_ITEM_GROUP_JOHNSON = DwayneModItemGroup.createItemGroup();
  private static final SoundEvent DWAYNE_THE_SOUND_EVENT_JOHNSON = SoundEvent.createVariableRangeEvent(Identifier.of(DWAYNE_THE_ID_JOHNSON, "dwayne"));
  private static final AbstractBlock.Settings DWAYNE_THE_BLOCK_SETTINGS_JOHNSON = AbstractBlock.Settings.create()
          .instrument(NoteBlockInstrument.BASEDRUM)
          .strength(1.5F, 6.0F)
          .luminance(b -> 12)
          .sounds(BlockSoundGroup.AMETHYST_BLOCK)
          .toolRequired();
  private static final Map<Block, Item> DWAYNE_THE_MAP_JOHNSON = new HashMap<>();

  public static final Identifier DWAYNE_BLOCK_ID = dwayneTheIdentifierJohnson("dwayne_block");
  public static final Block DWAYNE_BLOCK = new DwayneBlock(DWAYNE_THE_BLOCK_SETTINGS_JOHNSON.key(RegistryKey.of(RegistryKeys.BLOCK, DWAYNE_BLOCK_ID)), DWAYNE_THE_SOUND_EVENT_JOHNSON);
  public static final Identifier DWAYNE_SLAB_ID = dwayneTheIdentifierJohnson("dwayne_slab");
  public static final Block DWAYNE_SLAB = new SlabBlock(DWAYNE_THE_BLOCK_SETTINGS_JOHNSON.key(RegistryKey.of(RegistryKeys.BLOCK, DWAYNE_SLAB_ID)));
  public static final Identifier DWAYNE_WALL_ID = dwayneTheIdentifierJohnson("dwayne_wall");
  public static final Block DWAYNE_WALL = new WallBlock(DWAYNE_THE_BLOCK_SETTINGS_JOHNSON.key(RegistryKey.of(RegistryKeys.BLOCK, DWAYNE_WALL_ID)));
  public static final Identifier DWAYNE_STAIRS_ID = dwayneTheIdentifierJohnson("dwayne_stairs");
  public static final Block DWAYNE_STAIRS = new DwayneStairs(DwayneTheModJohnson.DWAYNE_BLOCK.getDefaultState(), DWAYNE_THE_BLOCK_SETTINGS_JOHNSON.key(RegistryKey.of(RegistryKeys.BLOCK, DWAYNE_STAIRS_ID)));
  public static final Identifier DWAYNE_FLOWER_ID = dwayneTheIdentifierJohnson("dwayne_flower");
  public static final Block DWAYNE_FLOWER = new FlowerBlock(StatusEffects.SLOWNESS, 8, AbstractBlock.Settings.copy(Blocks.POPPY).strength(0.0F).nonOpaque().key(RegistryKey.of(RegistryKeys.BLOCK, DWAYNE_FLOWER_ID)));
  public static final Identifier POTTED_DWAYNE_ID = dwayneTheIdentifierJohnson("potted_dwayne");
  public static final Block POTTED_DWAYNE = new FlowerPotBlock(DWAYNE_FLOWER, AbstractBlock.Settings.copy(Blocks.FLOWER_POT).strength(0.0F).nonOpaque().key(RegistryKey.of(RegistryKeys.BLOCK, POTTED_DWAYNE_ID)));

  public static final Identifier DWAYNE_ITEM_ID = dwayneTheIdentifierJohnson("dwayne_item");
  public static final Item DWAYNE_ITEM = new Item(new Item.Settings().key(RegistryKey.of(RegistryKeys.ITEM, DWAYNE_ITEM_ID)));

  @Override
  public void onInitialize() {
    // dwayne 'the item groups' johnson
    dwayneTheRegisterJohnson(Registries.ITEM_GROUP, dwayneTheIdentifierJohnson(DWAYNE_THE_ID_JOHNSON), DWAYNE_THE_ITEM_GROUP_JOHNSON);

    // dwayne 'the items' johnson
    dwayneTheRegisterJohnson(Registries.ITEM, DWAYNE_ITEM_ID, DWAYNE_ITEM);

    // dwayne 'the blocks' johnson
    dwayneTheRegisterBlockJohnson(DWAYNE_BLOCK_ID, DWAYNE_BLOCK);
    dwayneTheRegisterBlockJohnson(DWAYNE_SLAB_ID, DWAYNE_SLAB);
    dwayneTheRegisterBlockJohnson(DWAYNE_WALL_ID, DWAYNE_WALL);
    dwayneTheRegisterBlockJohnson(DWAYNE_STAIRS_ID, DWAYNE_STAIRS);
    dwayneTheRegisterBlockJohnson(DWAYNE_FLOWER_ID, DWAYNE_FLOWER);
    dwayneTheRegisterBlockJohnson(POTTED_DWAYNE_ID, POTTED_DWAYNE);

    // dwayne 'the sounds' johnson
    dwayneTheRegisterJohnson(Registries.SOUND_EVENT, dwayneTheIdentifierJohnson("dwayne"), DWAYNE_THE_SOUND_EVENT_JOHNSON);

    // dwayne 'the message' johnson
    DWAYNE_THE_LOGGER_JOHNSON.info("Dwayne 'The Log' Johnson");
  }

  public static Item getItem(Block block) {
    return DWAYNE_THE_MAP_JOHNSON.get(block);
  }

  public static void dwayneTheRegisterBlockJohnson(Identifier dwayneTheIdJohnson, Block dwayneTheBlockJohnson) {
    var block = dwayneTheRegisterJohnson(Registries.BLOCK, dwayneTheIdJohnson, dwayneTheBlockJohnson);
    var item = dwayneTheRegisterJohnson(Registries.ITEM, dwayneTheIdJohnson, new BlockItem(dwayneTheBlockJohnson, new Item.Settings().key(RegistryKey.of(RegistryKeys.ITEM, dwayneTheIdJohnson)).blockTranslationKey()));
    System.out.println(new Item.Settings().key(RegistryKey.of(RegistryKeys.ITEM, dwayneTheIdJohnson)).blockTranslationKey().getItemModelId());

    DWAYNE_THE_MAP_JOHNSON.put(block, item);
  }

  public static <T> T dwayneTheRegisterJohnson(Registry<T> dwayneTheRegistryJohnson, Identifier dwayneTheIdJohnson, T dwayneTheObjectJohnson) {
    return Registry.register(dwayneTheRegistryJohnson, dwayneTheIdJohnson, dwayneTheObjectJohnson);
  }

  public static Identifier dwayneTheIdentifierJohnson(String dwayneThePathJohnson) {
    return Identifier.of(DWAYNE_THE_ID_JOHNSON, dwayneThePathJohnson);
  }
}
