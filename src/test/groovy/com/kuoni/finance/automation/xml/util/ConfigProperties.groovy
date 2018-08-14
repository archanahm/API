package com.kuoni.finance.automation.xml.util

/*This class loads the config properties.*/

class ConfigProperties {

	static Properties props = null
	static final String env = System.getProperty("testEnv", "sit").toLowerCase()

	/**
	 * This method will return the property value for the given key
	 */
	def public static getValue(String key){
		if(props == null){
			loadProperties()
			props.get(key)
		}else{
			props.get(key)
		}
	}

	/**
	 * This method will return the property value for the given key
	 */
	def static getValueList(String key){
		String val
		if(props == null){
			loadProperties()
			val = props.get(key)
		}else{
			val = props.get(key)
		}
		Arrays.asList(val.split(","))
	}


	def private static loadProperties(){
		props = new Properties()
		File propsFile = new File("src/test/resources/environments/$env-config.properties")
		props.load(propsFile.newDataInputStream())
	}
}
