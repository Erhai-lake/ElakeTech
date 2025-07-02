package top.elake.elaketech.event;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.Nullable;
import top.elake.elaketech.register.block.CommonBlock;
import top.elake.elaketech.util.MultiblockStructureBuilder;
import vazkii.patchouli.api.IMultiblock;

import static top.elake.elaketech.ElakeTech.MODID;

/**
 * @author Elake Studio
 */
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class Test {
    public static void register(IEventBus event) {
        event.register(Test.class);
    }

    @SubscribeEvent
    public static void rightClickBlockTell(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos blockPos = event.getPos();
        InteractionHand hand = event.getHand();
        BlockState blockState = level.getBlockState(blockPos);

        IMultiblock defineStructure = new MultiblockStructureBuilder(new String[][] {
                { "   ", " 0 ", "   " },
                { "AAA", "ACA", "AAA" }
        })
                .where('A', Blocks.STONE)
                .where('C', CommonBlock.REFRACTORY_BRICKS.get())
                .where('0', Blocks.OBSIDIAN)
                .build();

        @Nullable Rotation structure = defineStructure.validate(level, blockPos);

        if (structure == null) {
            return;
        }

        String message = "哇袄！！！";

        player.displayClientMessage(Component.literal(message), true);
    }
}