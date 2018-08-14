package com.kuoni.finance.automation.xml.test

import javax.xml.bind.JAXBContext;
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.List;

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBElement
import javax.xml.bind.Marshaller
import javax.xml.bind.Unmarshaller
import javax.xml.datatype.XMLGregorianCalendar
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.util.EntityUtils
import org.spockframework.util.Assert;
import org.w3c.dom.Document

import spock.lang.Specification

import com.kuoni.finance.jaxb.obsapi.AddBookingRequest
import com.kuoni.finance.jaxb.obsapi.Request
import com.kuoni.finance.jaxb.obsapi.Response
import com.kuoni.finance.jaxb.obsapi.TBookingItem
import com.kuoni.finance.jaxb.obsapi.TBookingItems
import com.kuoni.finance.jaxb.obsapi.TBookingReference;
import com.kuoni.finance.jaxb.obsapi.TBookingReferenceInput
import com.kuoni.finance.jaxb.obsapi.TBookingReferences;
import com.kuoni.finance.jaxb.obsapi.THotelItem
import com.kuoni.finance.jaxb.obsapi.THotelRoom
import com.kuoni.finance.jaxb.obsapi.THotelRooms
import com.kuoni.finance.jaxb.obsapi.TItem
import com.kuoni.finance.jaxb.obsapi.TItemCity
import com.kuoni.finance.jaxb.obsapi.TItemRemarks
import com.kuoni.finance.jaxb.obsapi.TItemType
import com.kuoni.finance.jaxb.obsapi.TPaxIds
import com.kuoni.finance.jaxb.obsapi.TPaxName
import com.kuoni.finance.jaxb.obsapi.TPaxNames
import com.kuoni.finance.jaxb.obsapi.TPaxType
import com.kuoni.finance.jaxb.obsapi.TPeriodOfStay
import com.kuoni.finance.jaxb.obsapi.TRequestDetails
import com.kuoni.finance.jaxb.obsapi.TRequestMode
import com.kuoni.finance.jaxb.obsapi.TRequestorID
import com.kuoni.finance.jaxb.obsapi.TRequestorPreferences
import com.kuoni.finance.jaxb.obsapi.TResponseDetails
import com.kuoni.finance.jaxb.obsapi.TSearchAirportResponse;
import com.kuoni.finance.jaxb.obsapi.TSearchBookingItemResponse;
import com.kuoni.finance.jaxb.obsapi.TSource
import com.kuoni.qa.automation.common.properties.EnvironmentProperties
import com.kuoni.qa.automation.common.util.HttpUtil;
import com.kuoni.qa.automation.common.util.JaxbUtils
import com.kuoni.qa.automation.common.util.XmlUtil
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl
import java.sql.Connection
import java.sql.Statement
import java.sql.ResultSet

class SingleItemNoPay_VerisignTest extends Specification {
				
	def "verify SingleItem no pay with verisign"(){
		RequestTestData requestData = new RequestTestData()
		RequestDataDTO requestDataDto = requestData.getRequestDataDTO()
		
		given: "I am setting up the endpoint and "
		
		def url =requestData.getEndpointUrl("finance.api.url")
		
				
		Request requestWithData = requestData.getRequestWithData(requestDataDto)
		
		def xmlString = requestData.getMarshalXml(requestWithData)
					
		//String responseBody = postHttpXmlRequest(url,'application/xml', xmlString , "SingleItemBooking")
		String responseBody = HttpUtil.getStringPostResponse(url,'application/xml', xmlString , "SingleItemBooking")
		
		TResponseDetails responseDetails = requestData.getUnMarshalObject(responseBody)
		def bookingReferenceId = requestData.getBookingReferenceID(responseDetails)
		
		Thread.sleep(120000)
		
		//getting as400 database connection
		PaymentStatus paymentStausDetails = requestData.getPaymentStatusDetails(bookingReferenceId)
		println"Payment status "+paymentStausDetails.getPaymentStatus()
		println"Payment amount"+ paymentStausDetails.getAmount()
		
		
				
		Request requesModifyData = requestData.getModifyRequestWithData(requestDataDto, bookingReferenceId)
		
		def xmlModifyString = requestData.getMarshalXml(requesModifyData)
		
		println "MOdify xml :"+xmlModifyString 
					
		//String responseBody = postHttpXmlRequest(url,'application/xml', xmlString , "SingleItemBooking")
		String modifResponseBody = HttpUtil.getStringPostResponse(url,'application/xml', xmlModifyString , "SingleItemBooking")
		
		TResponseDetails modifyResponseDetails = requestData.getUnMarshalObject(modifResponseBody)
		def modifyBookingReferenceId = requestData.getBookingReferenceID(modifyResponseDetails)
		
		Thread.sleep(120000)
		
		//getting as400 database connection
		PaymentStatus ModifyPaymentStausDetails = requestData.getPaymentStatusDetails(modifyBookingReferenceId)
		println"Payment Modify status "+ModifyPaymentStausDetails.getPaymentStatus()
		println"Payment Modify amount"+ ModifyPaymentStausDetails.getAmount()
		
		// Cancel
		Request requesCancelData = requestData.getCancelRequestWithData(requestDataDto, modifyBookingReferenceId)
		
		def xmlCancelString = requestData.getMarshalXml(requesCancelData)
					
		//String responseBody = postHttpXmlRequest(url,'application/xml', xmlString , "SingleItemBooking")
		String cancelResponseBody = HttpUtil.getStringPostResponse(url,'application/xml', xmlCancelString , "SingleItemBooking")
		
		TResponseDetails cancelResponseDetails = requestData.getUnMarshalObject(cancelResponseBody)
		def cancelBookingReferenceId = requestData.getBookingReferenceID(cancelResponseDetails)
		
		Thread.sleep(120000)
		
		//getting as400 database connection
		PaymentStatus cancelPaymentStausDetails = requestData.getPaymentStatusDetails(cancelBookingReferenceId)
		println"Payment cancel status "+cancelPaymentStausDetails.getPaymentStatus()
		println"Payment cancel amount"+ cancelPaymentStausDetails.getAmount()
		
		
	
				
	}

	
	static String postHttpXmlRequest(String httpUrl,String contentType, String xmlBody, String testName) {
		Document doc
		HttpClient httpClient = new DefaultHttpClient()
		HttpResponse response
		String responseBody
		try {
			HttpPost httpPost = new HttpPost(httpUrl)
			httpPost.setHeader("Content-Type", "")

			HttpEntity reqEntity = new StringEntity(xmlBody, "UTF-8")
			reqEntity.setContentType(contentType)
			reqEntity.setChunked(true)

			httpPost.setEntity(reqEntity)

			response = httpClient.execute(httpPost)
						
			HttpEntity resEntity = response.getEntity()
			responseBody = EntityUtils.toString(resEntity)
							
			doc = XmlUtil.convertToXml(responseBody)
			savexmlFile(doc ,testName)
		}
		finally {

			httpClient.getConnectionManager().shutdown()
		}
		return responseBody
	}
	
}
