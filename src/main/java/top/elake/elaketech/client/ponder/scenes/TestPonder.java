package top.elake.elaketech.client.ponder.scenes;

import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;
import net.minecraft.core.Direction;

public class TestPonder {
    public static void newTestPonder(SceneBuilder scene, SceneBuildingUtil utils) {
        scene.showBasePlate();
        scene.idle(20);

        scene.addKeyframe();
        Selection notPlate = utils.select().fromTo(4, 1, 0, 0, 8, 4);
        scene.world().showSection(notPlate, Direction.DOWN);
        scene.idle(20);
    }
}