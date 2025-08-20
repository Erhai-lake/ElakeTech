package top.elake.elaketech.client.ponder;

import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import top.elake.elaketech.ElakeTech;
import top.elake.elaketech.client.ponder.scenes.TestPonder;

/**
 * @author Elake Studio
 */
public class ElakeTechPonderRegisters {
    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        helper.forComponents(ElakeTech.loadResource("dry_rack"))
                .addStoryBoard("test/test_ponder", TestPonder::newTestPonder);
    }
}