package top.elake.elaketech.client.ponder.scenes;

import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;
import top.elake.elaketech.ElakeTech;

public class TestPonder {
    public static void newTestPonder(SceneBuilder scene, SceneBuildingUtil utils) {
        scene.title(ElakeTech.MODID + "test_ponder", "Test Ponder!");
        scene.showBasePlate();
        scene.idle(20);

        scene.addKeyframe();
        Selection notPlate = utils.select().fromTo(4, 1, 4, 4, 8, 4);
        scene.world().showSection(notPlate, Direction.DOWN);
        scene.idle(20);
    }
}