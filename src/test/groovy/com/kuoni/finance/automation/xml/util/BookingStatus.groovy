package com.kuoni.finance.automation.xml.util

/*This class loads the BookingStats properties.*/

class BookingStatus {

	static Properties props = null
	
	/**
	 * This method will return the property value for the given key
	 */
	def public static getValue(String key){
		if(props == null){
			loadProperties()
			//props.get(key)
			def isoText = ((String)props.get(key)).getBytes("ISO-8859-1")
			String value = new String(isoText, "UTF-8")
			value
		}else{
			//props.get(key)
			def isoText = ((String)props.get(key)).getBytes("ISO-8859-1")
			String value = new String(isoText, "UTF-8")
			value
		}
	}

	def private static loadProperties(){
		props = new Properties();
		File propsFile = new File("src/test/resources/environments/Booking.properties")
		props.load(propsFile.newDataInputStream())
	}
}
