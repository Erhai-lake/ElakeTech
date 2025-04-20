package top.elake.elaketech.client.ponder;

import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.Direction;

/**
 * @author Qi-Month
 */
public class TestPonder {
    public static void testPonder(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("test_ponder", "Test Ponder");
        // 显示地板
        scene.showBasePlate();
        scene.configureBasePlate(0, 0, 5);
        scene.idle(20);

        //
        scene.addKeyframe();
//        scene.world().showSection(util.select().fromTo(, ), Direction.DOWN);
    }
}