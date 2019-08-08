package cc.zhangpz.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigObject;

import java.util.List;
import java.util.Map;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class HoconConfigUtil {

  public Config getConfig(Config config, String path) {
    if (config == null || !config.hasPath(path)) {
      return null;
    }
    return config.getConfig(path);
  }

  public List<Config> getConfigList(Config config, String path) {
    if (config == null || !config.hasPath(path)) {
      return Lists.newArrayList();
    }
    return Lists.newArrayList(config.getConfigList(path));
  }

  public Map<String, Object> getMap(Config config, String path) {
    if (config == null || !config.hasPath(path)) {
      return Maps.newHashMap();
    }
    ConfigObject object = config.getObject(path);
    return object.unwrapped();
  }

  public String getString(Config config, String path, String defaultValue) {
    if (config == null || !config.hasPath(path)) {
      return defaultValue;
    }
    return config.getString(path);
  }

  public List<String> getStringList(Config config, String path) {
    if (config == null || !config.hasPath(path)) {
      return Lists.newArrayList();
    }
    return config.getStringList(path);
  }

  public int getInt(Config config, String path, int defaultValue) {
    if (config == null || !config.hasPath(path)) {
      return defaultValue;
    }
    return config.getInt(path);
  }

  public boolean getBoolean(Config config, String path, boolean defaultValue) {
    if (config == null || !config.hasPath(path)) {
      return defaultValue;
    }
    return config.getBoolean(path);
  }

}
