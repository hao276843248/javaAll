import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigManager {
	private static Properties properties;
	private static ConfigManager configmanager;
	private ConfigManager(){
		properties=new Properties();
		InputStream is=this.getClass().getResourceAsStream("/jdbc.properties");
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ConfigManager getInstancs(){
		if(configmanager==null){
			configmanager=new ConfigManager();
		}
		return configmanager;
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
	
}
