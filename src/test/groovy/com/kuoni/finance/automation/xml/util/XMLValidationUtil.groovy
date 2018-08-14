package com.kuoni.finance.automation.xml.util

import groovy.sql.Sql
import groovy.util.slurpersupport.Node

import java.util.ArrayList

import javax.naming.Context
import javax.naming.InitialContext
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.Schema
import javax.xml.validation.SchemaFactory
import javax.xml.validation.Validator

import org.testng.asserts.SoftAssert
import org.xml.sax.SAXException

import com.sun.org.apache.bcel.internal.generic.RETURN;

import spock.lang.Shared;
import static org.junit.Assert.*

class XMLValidationUtil {

	SoftAssert softAssert= new SoftAssert()
	XmlParser xmlParser= new XmlParser()

	/*
	 * Unique Tag/Value ---<tag>Val<tag>---  Validation
	 * AND
	 * Multiple Occurrence of Tag/Value Validation for same values as:- 
	 * <tag>Val<tag>
	 * <tag>Val<tag>
	 * <tag>Val<tag>
	 * ...
	 */
	public def validateTagValue(Map<String, String> data, String xmlFile){
		def contentrecords = new XmlSlurper().parseText(xmlFile)
		List tagFound = new ArrayList();
		def temp
		data.each{ k, v ->
			println "${k}:${v}"
			def key = k.value.toString()
			temp = key
			def value = v.value.toString()
			contentrecords.childNodes().each { child ->
				child.name
				parseXml(child, key, value, tagFound)
			}
		}
		if(!tagFound.contains(temp)) {
			println "The given xml tag "+ temp + " doesn't exists in the response xml"
			assert false ,temp + "--- xml tag Is not available in response XMl"
		}
	}

	/*
	 * Unique TagAttribute/Value ---<Tag Attribute = "Value">---  Validation when this attributes appears for single time
	 * AND 
	 * Multiple Occurrence of TagAttribute/Value Validation for same values as:- 
	 * <Tag Attribute = "Value">---  
	 * <Tag Attribute = "Value">
	 * <Tag Attribute = "Value">
	 * ....
	 */
	public def validateAttrValue(Map<String, String> data, String xmlFile){
		def contentrecords = new XmlSlurper().parseText(xmlFile)
		Map tagFound = new HashMap()
		List temp
		data.each{ k, v ->
			println "${k}:${v}"
			def key = k.value.toString().tokenize(',')
			temp = key
			tagFound.clear()
			def value = v.value.toString()
			contentrecords.childNodes().each { child ->
				parseXmlAttribute(child, key, value, tagFound)
			}
		}
		if(tagFound.size()!=0){
			tagFound.each{ tag, attr ->
				if(!tag.equalsIgnoreCase(temp[0])){
					println "The given xml tag "+ temp[0] + " doesn't exists in the response xml"
					fail(temp[0] + "--- xml tag Is not available in response XMl")
				}else{
					if(!attr.equalsIgnoreCase(temp[1])){
						println attr + " is not an attributr of the xml element "+temp[0]
						fail(temp[1] + "--- attribute Is not available in response XML")
					}
				}
			}
		}else{
			println temp[0]+ ","+temp[1] + "--- XML Tag/attribute NOT vailable in response XMl  "
			fail(temp[0]+ ","+temp[1] + "--- XML Tag/attribute NOT vailable in response XMl ")
		}
	}


	/*
	 * Unique TagAttribute/Value ---<Tag Attribute = "Value">---  Validation when this attributes value pair appears at least one time in the xmlFile:-
	 * <Tag Attribute = "Value">---
	 * ....
	 */
	public def validateSingleAttrValue(Map<String, String> data, String xmlFile){

		groovy.util.Node node =xmlParser.parseText(xmlFile)
		Map tagFound = new HashMap()
		List temp
		int count=0
		data.each{ k, v ->
			println "${k}:${v}"
			def key = k.value.toString().tokenize(',')
			temp = key
			tagFound.clear()
			def value = v.value.toString()
			count = parseXmlAttribute1(node, key, value, tagFound,0)
		}
		if(count<1){
			assert false, "value is not matching";
		}
		/*println tagFound;
		 if(tagFound.size()!=0){
		 tagFound.each{ tag, attr ->
		 if(!tag.equalsIgnoreCase(temp[0])){
		 println "The given xml tag "+ temp[0] + " doesn't exists in the response xml"
		 assert false ,temp[0] + "--- xml tag Is not available in response XMl"
		 }else{
		 if(!attr.equalsIgnoreCase(temp[1])){
		 println attr + " is not an attributr of the xml element "+temp[0]
		 assert false ,temp[1] + "--- attribute Is not available in response XML"
		 }
		 }
		 }
		 }else{
		 println temp[0]+ ","+temp[1] + "--- XML Tag/attribute NOT vailable in response XMl  "
		 assert false ,temp[0]+ ","+temp[1] + "--- XML Tag/attribute NOT vailable in response XMl "
		 }*/
	}

	/*
	 * Multiple Value Occurrence for TagAttribute/Value Validation Ex
	 * <Tag Attribute = "Value1">---
	 * <Tag Attribute = "Value2">
	 * <Tag Attribute = "Value3">
	 * ....
	 */
	public def validateAttrMultiValue(Map<String, List> data, String xmlFile){
		List res = new ArrayList()
		List tempval = new ArrayList()
		Map tagFound = new HashMap();
		List tempkey

		def contentrecords = new XmlSlurper().parseText(xmlFile)
		data.each{ k, v ->
			println "${k}:${v}"
			def key = k.value.toString().tokenize(',')
			tempkey = key
			tempval = v
			tagFound.clear()
			contentrecords.childNodes().each { child ->
				parseXmlAttributeSameTag(child, key, v,res, tagFound)
			}
		}
		if(tagFound.size()!=0){
			tagFound.each{ tag, attr ->
				if(!tag.equalsIgnoreCase(tempkey[0])){
					println "The given xml tag "+ tempkey[0] + " doesn't exists in the response xml"
					assert false ,tempkey[0] + "--- xml tag Is not available in response XMl"
				}
				else{
					if(!attr.equalsIgnoreCase(tempkey[1])){
						println attr + " is not an attributr of the xml element "+tempkey[0]
						assert false ,tempkey[1] + "--- attribute Is not available in response XML"
					}
				}
			}
		}else{
			println tempkey[0]+ ","+tempkey[1] + "--- XML Tag/attribute NOT vailable in response XMl  "
			assert false ,tempkey[0]+ ","+tempkey[1] + "--- XML Tag/attribute NOT vailable in response XMl "
		}

		for(j in 0 .. tempval.size()-1){
			if(!res.contains(tempval[j])){
				println tempval[j] + " Is not available in response XMl"
				assert false ,tempval[j]+ "--- Is not available in response XMl"
			}
		}
	}

	/*
	 * Same tag with Multiple values for Tag/Value Validation Ex
	 * <Tag>"Value1"</Tag>---
	 * <Tag>"Value2"</Tag>
	 * <Tag>"Value3"</Tag>
	 * ....
	 */

	public def validateTagMultiValue(Map<String, List> data, String xmlFile){

		List res = new ArrayList()
		List temp = new ArrayList()
		List tagFound = new ArrayList()
		def tempkey
		def contentrecords = new XmlSlurper().parseText(xmlFile)

		data.each{ k, v ->
			println "${k}:${v}"
			def key = k.value.toString()
			temp = v
			tempkey = key
			contentrecords.childNodes().each { child ->
				parseXmlSingleTag(child, key, v, res , tagFound)
			}
		}
		if(!tagFound.contains(tempkey)) {
			println "The given xml tag "+ tempkey + " doesn't exists in the response xml"
			assert false ,tempkey + "--- xml tag Is not available in response XMl"
		}
		for(j in 0 .. temp.size()-1){
			if(!res.contains(temp[j])){
				println temp[j] + " Is not available in response XMl"
				assert false ,temp[j]+ "--- Is not available in response XMl"
			}
		}
	}


	/*
	 * Same tag with Multiple values for Tag/Value Validation for one Value among them Ex
	 * Verify <Tag Attribute = "value">"Val"</Tag>
	 * IN...      * 
	 * <Tag Attribute = "value1">"Val1"</Tag>
	 * <Tag Attribute =  "value2">"Val2"</Tag>
	 * <Tag Attribute = "value3">"Val3"</Tag>
	 * ....
	 */

	public def validateAttrTagValue(Map<String, String> data, String xmlFile){
		List res = new ArrayList()
		List tempval = new ArrayList()
		Map tagFound = new HashMap();
		List tempkey

		def contentrecords = new XmlSlurper().parseText(xmlFile)
		data.each{ k, v ->
			println "${k}:${v}"
			def key = k.value.toString().tokenize(',')
			tempkey = key
			def Values = v.value.toString().tokenize('&')
			tempval = Values
			tagFound.clear()
			contentrecords.childNodes().each { child ->
				parseXmlAttributeTag(child, key, Values,res, tagFound)
			}
		}
		if(tagFound.size()!=0){
			tagFound.each{ tag, attr ->
				if(!tag.equalsIgnoreCase(tempkey[0])){
					println "The given xml tag "+ tempkey[0] + " doesn't exists in the response xml"
					assert false ,tempkey[0] + "--- xml tag Is not available in response XMl"
				}
				else{
					if(!attr.equalsIgnoreCase(tempkey[1])){
						println attr + " is not an attributr of the xml element "+tempkey[0]
						assert false ,tempkey[1] + "--- attribute Is not available in response XML"
					}
				}
			}
		}else{
			println tempkey[0]+ ","+tempkey[1] + "--- XML Tag/attribute NOT vailable in response XMl  "
			assert false ,tempkey[0]+ ","+tempkey[1] + "--- XML Tag/attribute NOT vailable in response XMl "
		}

		for(j in 0 .. tempval.size()-1){
			if(!res.contains(tempval[j])){
				println tempval[j] + " Is not available in response XMl"
				assert false ,tempval[j]+ "--- Is not available in response XMl"
			}
		}
	}



	/*
	 * Same tag with the values in the Range for Tag/Value Validation Ex
	 *
	 * [Value1-value2] are in the range which is given to the request
	 *
	 * <Tag>"Value1"</Tag>---
	 * <Tag>"Value2"</Tag>
	 * <Tag>"Value3"</Tag>
	 * ....
	 *
	 */

	public def validateTagRangeValue(Map<String, String> data, String xmlFile){

		def contentrecords = new XmlSlurper().parseText(xmlFile)
		List tagFound = new ArrayList();
		def temp
		data.each{ k, v ->
			println "${k}:${v}"
			def key = k.value.toString()
			temp = key
			def rValue = v.value.toString().tokenize('-')
			int lowerlimit = Integer.parseInt(rValue[0])
			int upperlimit = Integer.parseInt(rValue[1])
			contentrecords.childNodes().each { child ->
				child.name
				parseXmlTagRange(child, key, lowerlimit,upperlimit, tagFound)
			}
		}
		if(!tagFound.contains(temp)) {
			println "The given xml tag "+ temp + " doesn't exists in the response xml"
			assert false ,temp + "--- xml tag Is not available in response XMl"
		}
	}


	public def parseXmlTagRange(groovy.util.slurpersupport.Node contentrecords, String k, int lowerlimit,int upperlimit, List tagList){

		contentrecords.childNodes().each { child ->
			if(child.name.equalsIgnoreCase(k)){
				tagList.add(child.name)
				try{
					int value = Integer.parseInt(child.text())
					if((value >= lowerlimit) && (value <= upperlimit)){
						println value + " is in the Range. "
					}else {
						println value + " is NOT in the Range. "
						assert false ,value +"---- is not in the range on Actual Response."
					}
				}catch(NumberFormatException ex){
					assert child.text().equalsIgnoreCase("NONE"),child.text() +" ---- is not an Expected Rating."
					println child.text() + " is in the Range. "
				}
			}
			parseXmlTagRange(child, k, lowerlimit,upperlimit,tagList)
		}
	}



	public def parseXmlAttributeTag(groovy.util.slurpersupport.Node contentrecords, List k, List v, List res, Map dataMap){

		contentrecords.childNodes().each { child ->
			child.attributes()
			child.attributes().each{ it ->
				it.key +"==" + it.value
				if(it.key.equalsIgnoreCase(k[1])){
					if(child.name().equalsIgnoreCase(k[0])){
						dataMap.put(child.name, null)
						def value = it.value
						dataMap.put(child.name,it.key)
						if(v[0].equalsIgnoreCase(value)){
							res.add(v[0])
							println v[0] + ' & ' + value + " both Atrributes match "
							def tagValue = (child.text()).trim()
							if(v[1].equalsIgnoreCase(tagValue)){
								println v[1] + ' & ' + tagValue + " both Tag values match "
								res.add(v[1])
							}
						}
					}
				}
			}
			parseXmlAttributeTag(child, k, v,res,dataMap)
		}
	}


	public def parseXml(groovy.util.slurpersupport.Node contentrecords, String k, String v, List tagList){

		contentrecords.childNodes().each { child ->
			if(child.name.equalsIgnoreCase(k)){
				tagList.add(child.name)
				def value = child.text()
				softAssert.assertTrue(value.equalsIgnoreCase(v), " Data is not maching")
				if(value.equalsIgnoreCase(v)){
					println value + ' & ' + v + " both match "
				}
				else {
					println value + ' & ' + v + " both DONT match "
					assertTrue(value +"---- is Actual Response" + " BUT  " + v + "----Is Expected response XMl", value.equalsIgnoreCase(v))
				}
			}
			parseXml(child, k, v, tagList)
		}
	}


	public def parseXmlAttribute(groovy.util.slurpersupport.Node contentrecords, List k, String v, Map dataMap){
		int count =0
		contentrecords.attributes().each{ it ->
			if((it.key.equalsIgnoreCase(k[1])) && (contentrecords.name.equals(k[0]))){
				dataMap.put(contentrecords.name, null)
				def value = it.value
				if(value.equalsIgnoreCase(v)){
					dataMap.put(contentrecords.name,it.key)
					println value + ' & ' + v + " both match "
					softAssert.assertTrue(value.equalsIgnoreCase(v), " Data is not maching")
				}
				else {
					println value + ' & ' + v + " both DONT match "
					assertTrue(value +"---- is Actual Response" + " BUT   " + v + "-----Is Expected response XMl", value.equalsIgnoreCase(v))
				}
			}
		}
		contentrecords.childNodes().each { child ->
			parseXmlAttribute(child, k, v,dataMap)
		}
	}

	public def parseXmlAttribute1(groovy.util.Node contentrecords, List k, String v, Map dataMap, int count){

		Iterator ittr = contentrecords.depthFirst().iterator()
		while(ittr.hasNext()){
			groovy.util.Node node=ittr.next()
			node.attributes().each{it ->
				if((it.key.equalsIgnoreCase(k[1])) && (node.name().equals(k[0]))){
					dataMap.put(node.name(), null)
					def value = it.value
					if(value.equalsIgnoreCase(v)){
						++count
						dataMap.put(node.name(),it.key)
						println value + ' & ' + v + " both match "
					}
				}
			}
		}
		return count
	}

	public def parseXmlAttributeSameTag(groovy.util.slurpersupport.Node contentrecords, List k, List v, List res, Map dataMap){

		contentrecords.childNodes().each { child ->
			child.attributes()
			child.attributes().each{ it ->
				it.key +"==" + it.value
				if(it.key.equalsIgnoreCase(k[1])){
					if(child.name().equalsIgnoreCase(k[0])){
						dataMap.put(child.name, it.key)
						def value = it.value
						for(e in 0 .. v.size()-1){
							if(v[e].equalsIgnoreCase(value)){
								dataMap.put(child.name,it.key)
								println v[e] + ' & ' + value + " both match "
								res.add(v[e])
								softAssert.assertTrue(v[e].equalsIgnoreCase(value), " Data is not maching")
								continue
							}
						}
					}
				}
			}
			parseXmlAttributeSameTag(child, k, v,res,dataMap)
		}
	}

	public def parseXmlSingleTag(groovy.util.slurpersupport.Node contentrecords, String k, List v, List res,  List tagList){

		contentrecords.childNodes().each { child ->
			if(child.name.equalsIgnoreCase(k)){
				tagList.add(child.name)
				def value = child.text()
				for(e in 0 .. v.size()-1){
					if(v[e].equalsIgnoreCase(value)){
						println v[e] + ' & ' + value + " both match "
						res.add(v[e])
						continue
					}
				}
			}
			parseXmlSingleTag(child, k, v, res,tagList)
		}
	}

	def setup() {
		softAssert = new SoftAssert()
	}

	def cleanup() {
		softAssert.assertAll()
	}
}
