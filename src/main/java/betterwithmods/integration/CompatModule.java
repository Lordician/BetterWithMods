package betterwithmods.integration;

import betterwithmods.module.Module;
import com.google.common.collect.Maps;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tyler on 5/24/17.
 */
public class CompatModule extends Module {
    private HashMap<String, String> compatRegistry = Maps.newHashMap();

    public void registerCompatFeature(String modid, String clazz) {
        compatRegistry.put(modid, clazz);
    }

    @Override
    public void addFeatures() {
        registerCompatFeature("biomesoplenty", "betterwithmods.integration.bop.BiomesOPlenty");
        registerCompatFeature("harvestcraft", "betterwithmods.integration.Harvestcraft");
        registerCompatFeature("crafttweaker", "betterwithmods.integration.minetweaker.MineTweaker");
        registerCompatFeature("quark", "betterwithmods.integration.Quark");
        registerCompatFeature("nethercore", "betterwithmods.integration.NetherCore");
        registerCompatFeature("actuallyadditions", "betterwithmods.integration.ActuallyAdditions");
        registerCompatFeature("immersiveengineering", "betterwithmods.integration.immersiveengineering.ImmersiveEngineering");
        this.load();
    }

    public void load() {
        for (Map.Entry<String, String> feature : compatRegistry.entrySet()) {
            String modId = feature.getKey();
            String classPath = feature.getValue();
            if (isLoaded(modId)) try {
                registerFeature(Class.forName(classPath).asSubclass(CompatFeature.class).newInstance());
                FMLLog.info(" [BWM] Successfully load compat for " + modId);
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                FMLLog.info(" [BWM] Compatibility class " + classPath + " could not be loaded. Report this!");
                e.printStackTrace();
            }
        }
    }

    private boolean isLoaded(String modId) {
        boolean loaded = Loader.isModLoaded(modId) && loadPropBool(modId.toLowerCase() + "_compat", "compatibility for ", true);
        return loaded;
    }

}