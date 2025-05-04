package top.elake.elaketech.server.recipes.remove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.elake.elaketech.ElakeTech;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import net.neoforged.fml.loading.FMLPaths;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Qi-Month
 * @author Erhai-lake
 */
public class ItemRecipes {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemRecipes.class);

    /**
     * 该方法仅创建默认配置文件（如果不存在）
     */
    public static void removeRecipes() {
        createRemovalConfigIfNotExists();
    }

    /**
     * 创建一个包含默认移除项的配置文件
     */
    private static void createRemovalConfigIfNotExists() {
        Path configDir = FMLPaths.CONFIGDIR.get().resolve(ElakeTech.MODID);
        File configFile = configDir.resolve("recipe_removal.json").toFile();

        if (!configFile.exists()) {
            configDir.toFile().mkdirs();

            try {
                // 创建自定义的配置对象
                RecipeConfig config = new RecipeConfig();

                // 保存配置
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                try (FileWriter writer = new FileWriter(configFile)) {
                    gson.toJson(config, writer);
                }
            } catch (IOException e) {
                LOGGER.error("Failed to create recipe removal configuration file", e);
            }
        }
    }

    /**
     * 配方配置类
     */
    private static class RecipeConfig {
        List<String> modsToRemove = new ArrayList<>();
        List<String> recipesToRemove = new ArrayList<>();
    }
}