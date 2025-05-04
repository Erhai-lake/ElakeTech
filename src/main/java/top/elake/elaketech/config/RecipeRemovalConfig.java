package top.elake.elaketech.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.loading.FMLPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.elake.elaketech.ElakeTech;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecipeRemovalConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeRemovalConfig.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String CONFIG_FILE = "recipe_removal.json";
    
    private List<String> modsToRemove = new ArrayList<>();
    private List<String> recipesToRemove = new ArrayList<>();
    
    private static RecipeRemovalConfig INSTANCE;
    
    // 配方移除数据
    private final Set<String> modIds = new HashSet<>();
    private final Set<ResourceLocation> recipeIds = new HashSet<>();
    
    private RecipeRemovalConfig() {
        // 私有构造函数
    }
    
    public static RecipeRemovalConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RecipeRemovalConfig();
            INSTANCE.loadConfig();
        }
        return INSTANCE;
    }
    
    public Set<String> getModIds() {
        return modIds;
    }
    
    public Set<ResourceLocation> getRecipeIds() {
        return recipeIds;
    }
    
    public void loadConfig() {
        Path configDir = FMLPaths.CONFIGDIR.get().resolve(ElakeTech.MODID);
        File configFile = configDir.resolve(CONFIG_FILE).toFile();
        
        // 确保配置目录存在
        if (!configDir.toFile().exists()) {
            try {
                Files.createDirectories(configDir);
            } catch (IOException e) {
                return;
            }
        }
        
        // 如果配置文件不存在，创建默认配置
        if (!configFile.exists()) {
            createDefaultConfig(configFile);
        }
        
        // 读取配置
        try (FileReader reader = new FileReader(configFile)) {
            Type type = new TypeToken<RecipeRemovalConfig>() {}.getType();
            RecipeRemovalConfig config = GSON.fromJson(reader, type);
            
            // 更新实例数据
            if (config != null) {
                this.modsToRemove = config.modsToRemove;
                this.recipesToRemove = config.recipesToRemove;
                
                // 解析数据
                parseConfig();
                
            }
        } catch (Exception e) {
            this.modsToRemove = new ArrayList<>();
            this.recipesToRemove = new ArrayList<>();
        }
    }
    
    private void parseConfig() {
        // 清除旧数据
        modIds.clear();
        recipeIds.clear();
        
        // 添加模组ID
        modIds.addAll(modsToRemove);
        
        // 解析配方ID
        for (String recipeString : recipesToRemove) {
            try {
                recipeIds.add(ResourceLocation.parse(recipeString));
            } catch (Exception e) {
                LOGGER.warn("Invalid recipe ID in config: {}", recipeString);
            }
        }
    }
    
    private void createDefaultConfig(File configFile) {
        // 默认配置示例
        RecipeRemovalConfig defaultConfig = new RecipeRemovalConfig();
        defaultConfig.modsToRemove = new ArrayList<>();
        defaultConfig.recipesToRemove = new ArrayList<>();
        
        // 添加一些示例
        defaultConfig.modsToRemove.add("example_mod");
        defaultConfig.recipesToRemove.add("minecraft:furnace");
        defaultConfig.recipesToRemove.add("minecraft:diamond_block");
        
        try (FileWriter writer = new FileWriter(configFile)) {
            GSON.toJson(defaultConfig, writer);
            LOGGER.info("Created default recipe removal config file");
        } catch (IOException e) {
            LOGGER.error("Failed to create default config file", e);
        }
    }
}