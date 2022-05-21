package br.com.train.web.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import br.com.train.web.constants.TestRunnerConstants;
import br.com.train.web.models.AccessData;
import br.com.train.web.utils.PropertiesManager;
import br.com.train.web.utils.StringManager;
import br.com.train.web.utils.YamlManager;

public class AccessDataManager {
	private static AccessData accessData = new AccessData();

	public static boolean isCentralizedData(String data) throws FileNotFoundException, IOException {
		return StringManager.getListMatcherByRegex(data, "^\\$\\{.*\\}").size() > 0;
	}

	public static AccessData getData() throws FileNotFoundException, IOException {
		PropertiesManager enviromentProp = new PropertiesManager(
				TestRunnerConstants.ACCESS_PROPERTIES_PATH + File.separator + "envs.properties");
		loadData(enviromentProp.getProperties().getProperty("enviroment"), accessData);
		return accessData;
	}

	public static void loadData(String environment, AccessData dataObject) throws FileNotFoundException {
		List<Object> yamlContent = YamlManager
				.readYaml(TestRunnerConstants.ACCESS_PROPERTIES_PATH + File.separator + "acessData.yaml");
		Map<?, ?> environmentDataMap = Map.class.cast(Map.class.cast(yamlContent.get(0)).get(environment));
		dataObject.setEnvironment(environment);
		dataObject.setUrl(environmentDataMap.get("url").toString());
		dataObject.setUsername(environmentDataMap.get("username").toString());
		dataObject.setPassword(environmentDataMap.get("password").toString());
	}

}
