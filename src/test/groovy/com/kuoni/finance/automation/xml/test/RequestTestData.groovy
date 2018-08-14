/**
 * 
 */
package com.kuoni.finance.automation.xml.test

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBElement
import javax.xml.bind.Marshaller
import javax.xml.bind.Unmarshaller

import com.kuoni.finance.jaxb.obsapi.AddBookingRequest
import com.kuoni.finance.jaxb.obsapi.Request
import com.kuoni.finance.jaxb.obsapi.Response
import com.kuoni.finance.jaxb.obsapi.TBookingItem
import com.kuoni.finance.jaxb.obsapi.TBookingItems
import com.kuoni.finance.jaxb.obsapi.TBookingReferenceInput
import com.kuoni.finance.jaxb.obsapi.TBookingReferences
import com.kuoni.finance.jaxb.obsapi.TCancelBookingRequest
import com.kuoni.finance.jaxb.obsapi.TCity
import com.kuoni.finance.jaxb.obsapi.TCreditCardDetails
import com.kuoni.finance.jaxb.obsapi.THotelItem
import com.kuoni.finance.jaxb.obsapi.THotelRoom
import com.kuoni.finance.jaxb.obsapi.THotelRooms
import com.kuoni.finance.jaxb.obsapi.TItem
import com.kuoni.finance.jaxb.obsapi.TItemCity
import com.kuoni.finance.jaxb.obsapi.TItemRemarks
import com.kuoni.finance.jaxb.obsapi.TItemType
import com.kuoni.finance.jaxb.obsapi.TModifyBookingItem
import com.kuoni.finance.jaxb.obsapi.TModifyBookingItemRequest
import com.kuoni.finance.jaxb.obsapi.TModifyBookingItems
import com.kuoni.finance.jaxb.obsapi.TModifyBookingRequest
import com.kuoni.finance.jaxb.obsapi.TModifyHotelItem
import com.kuoni.finance.jaxb.obsapi.TPaxIds
import com.kuoni.finance.jaxb.obsapi.TPaxName
import com.kuoni.finance.jaxb.obsapi.TPaxNames
import com.kuoni.finance.jaxb.obsapi.TPaxType
import com.kuoni.finance.jaxb.obsapi.TPaymentGateway
import com.kuoni.finance.jaxb.obsapi.TPeriodOfStay
import com.kuoni.finance.jaxb.obsapi.TReferenceSourceInput
import com.kuoni.finance.jaxb.obsapi.TRequestDetails
import com.kuoni.finance.jaxb.obsapi.TRequestMode
import com.kuoni.finance.jaxb.obsapi.TRequestorID
import com.kuoni.finance.jaxb.obsapi.TRequestorPreferences
import com.kuoni.finance.jaxb.obsapi.TResponseDetails
import com.kuoni.finance.jaxb.obsapi.TSearchBookingItemResponse
import com.kuoni.finance.jaxb.obsapi.TSource
import com.kuoni.qa.automation.common.properties.EnvironmentProperties

/**
 * @author 104337
 *
 */
class RequestTestData {

	def EnvironmentProperties envprops = null;
	
	
	public static void main(String[] arga){
		RequestTestData t = new RequestTestData()
		BookingStatus status = t.getBookingStatusDetails("926509", "RT028DTA")
		println status.getBookingstatus()
	}
	
	
	def String getEndpointUrl(propertyName) {
		envprops = new EnvironmentProperties()
		return envprops.getValueForProperty(propertyName)
	}


	def Request getRequestWithData(RequestDataDTO requestDataDto) {
		// setting up data for source
		TSource tsource = getTSource(requestDataDto)

		//setting request details
		THotelRooms hotelRooms = getHotelRooms(requestDataDto);
		//setting hotel item data
		THotelItem hotelItem = getHotelItem(hotelRooms,requestDataDto)
		// setting up the bookingItems
		TBookingItems bookingItems = getBookingItems(hotelItem,requestDataDto)

		AddBookingRequest tAddBookingRequest = getAddBookingRequest(bookingItems,requestDataDto);

		TRequestDetails requestDetails = getRequestDetailsData(tAddBookingRequest)

		Request trequet = new Request()
		trequet.setSource(tsource)
		trequet.setRequestDetails(requestDetails)
		return trequet
	}

	def Request getModifyRequestWithData(RequestDataDTO requestDataDto,String bookingReferenceID) {
		// setting up data for source
		TSource tsource = getTSource(requestDataDto)

		TModifyBookingRequest tModifyBookingRequest = getModifyBookingRequest(requestDataDto,bookingReferenceID)

		TModifyBookingItemRequest tModifyBookingItemRequest = new TModifyBookingItemRequest()

		TBookingReferenceInput tBookingReferenceInput = getBookingReference(requestDataDto,bookingReferenceID)
		tModifyBookingItemRequest.setBookingReference(tBookingReferenceInput)

		//setting request details
		THotelRooms hotelRooms = getModifyHotelRooms(requestDataDto);
		//setting hotel item data
		TModifyHotelItem hotelItem = getModifyHotelItem(hotelRooms,requestDataDto)
		// setting up the bookingItems
		TModifyBookingItems bookingItems = getModifyBookingItems(hotelItem,requestDataDto)
		tModifyBookingItemRequest.setBookingItems(bookingItems)

		TRequestDetails requestDetails = getModifyRequestDetailsData(tModifyBookingRequest,tModifyBookingItemRequest)

		Request trequet = new Request()
		trequet.setSource(tsource)
		trequet.setRequestDetails(requestDetails)
		return trequet
	}

	def Request getCancelRequestWithData(RequestDataDTO requestDataDto,String bookingReferenceID) {
		// setting up data for source
		TSource tsource = getTSource(requestDataDto)

		TCancelBookingRequest tCancelBookingRequest = new TCancelBookingRequest()
		TBookingReferenceInput tBookingReferenceInput = getBookingReference(requestDataDto,bookingReferenceID)
		tCancelBookingRequest.setBookingReference(tBookingReferenceInput)

		TRequestDetails requestDetails = getCancelRequestDetailsData(tCancelBookingRequest)

		Request trequet = new Request()
		trequet.setSource(tsource)
		trequet.setRequestDetails(requestDetails)
		return trequet
	}

	private TRequestDetails getCancelRequestDetailsData(TCancelBookingRequest tCancelBookingRequest) {
		TRequestDetails requestDetails = new TRequestDetails();
		requestDetails.getSearchHotelPricePaxRequestOrAddBookingItemRequestOrAddBookingRequest().add(tCancelBookingRequest)

		return requestDetails
	}


	private TRequestDetails getModifyRequestDetailsData(TModifyBookingRequest tModifyBookingRequest,TModifyBookingItemRequest tModifyBookingItemRequest) {
		TRequestDetails requestDetails = new TRequestDetails();
		requestDetails.getSearchHotelPricePaxRequestOrAddBookingItemRequestOrAddBookingRequest().add(tModifyBookingItemRequest)
		//requestDetails.getSearchHotelPricePaxRequestOrAddBookingItemRequestOrAddBookingRequest().add(tModifyBookingRequest)

		return requestDetails
	}


	private TRequestDetails getRequestDetailsData(AddBookingRequest tAddBookingRequest) {
		TRequestDetails requestDetails = new TRequestDetails();
		requestDetails.getSearchHotelPricePaxRequestOrAddBookingItemRequestOrAddBookingRequest().add(tAddBookingRequest)
		return requestDetails
	}

	private AddBookingRequest getAddBookingRequest(TBookingItems bookingItems,RequestDataDTO requestDataDto) {
		AddBookingRequest tAddBookingRequest = new AddBookingRequest();
		getCommonBookingRequest(tAddBookingRequest, requestDataDto, bookingItems)
		return tAddBookingRequest
	}

	private getCommonBookingRequest(AddBookingRequest tAddBookingRequest, RequestDataDTO requestDataDto, TBookingItems bookingItems) {
		tAddBookingRequest.setCurrency(requestDataDto.getAddBookingCurrency())
		//tAddBookingRequest.setBookingName("")
		TBookingReferenceInput tBookingReferenceInput = new TBookingReferenceInput()
		tBookingReferenceInput.setValue(" "+requestDataDto.getBookignReference())
		//tBookingReferenceInput.setReferenceSource(TReferenceSourceInput.CLIENT)

		tAddBookingRequest.setBookingReference(tBookingReferenceInput)

		tAddBookingRequest.setBookingDepartureDate(requestDataDto.getDepartureDate())

		TPaxName tPaxName = new TPaxName();
		tPaxName.setValue(requestDataDto.getPaxName());
		tPaxName.setPaxId(requestDataDto.getPaxId())
		tPaxName.setPaxType(TPaxType.ADULT)
		TPaxNames tpaxNames = new TPaxNames();
		tpaxNames.getPaxName().add(tPaxName)
		tAddBookingRequest.setPaxNames(tpaxNames)
		tAddBookingRequest.setBookingItems(bookingItems)

		TPaymentGateway paymentGateway = new TPaymentGateway()
		paymentGateway.setCode(requestDataDto.getPaymentGateWayCode())



		//tAddBookingRequest.setPaymentGateway(paymentGateway)

		TCreditCardDetails creditCardDetails = new TCreditCardDetails();
		creditCardDetails.setCardType(requestDataDto.getCardType())
		creditCardDetails.setCardHolderName(requestDataDto.getCardHolderName())
		creditCardDetails.setAddressLine1(requestDataDto.getAddressLine1())
		TCity city = new TCity()
		city.setValue(requestDataDto.getCardCityName())
		creditCardDetails.setCityName(city)
		creditCardDetails.setZip(requestDataDto.getZipCode())
		creditCardDetails.setCountry(requestDataDto.getCardCountry())
		creditCardDetails.setCardNumber(requestDataDto.getCardNumber())
		creditCardDetails.setCardCV2(requestDataDto.getCardCV2())
		creditCardDetails.setExpiryMonth(requestDataDto.getCardExpiryMonth())
		creditCardDetails.setExpiryYear(requestDataDto.getCardExpiryYear())

		tAddBookingRequest.setCreditCard(creditCardDetails)
	}
	private TModifyBookingRequest getModifyBookingRequest(RequestDataDTO requestDataDto,String bookingReferenceID) {
		TModifyBookingRequest tModifyBookingRequest = new TModifyBookingRequest();
		//tAddBookingRequest.setCurrency(requestDataDto.getAddBookingCurrency())

		//tAddBookingRequest.setBookingName("")
		TBookingReferenceInput tBookingReferenceInput = getBookingReference(requestDataDto,bookingReferenceID)
		tBookingReferenceInput.setReferenceSource(TReferenceSourceInput.API)

		tModifyBookingRequest.setBookingReference(tBookingReferenceInput)

		tModifyBookingRequest.setBookingDepartureDate(requestDataDto.getDepartureDate())

		TPaxName tPaxName = new TPaxName();
		tPaxName.setValue(requestDataDto.getPaxName());
		tPaxName.setPaxId(requestDataDto.getPaxId())
		tPaxName.setPaxType(TPaxType.ADULT)
		TPaxNames tpaxNames = new TPaxNames();
		tpaxNames.getPaxName().add(tPaxName)
		tModifyBookingRequest.setPaxNames(tpaxNames)
		//tModifyBookingRequest.setBookingItems(bookingItems)

		TPaymentGateway paymentGateway = new TPaymentGateway()
		paymentGateway.setCode(requestDataDto.getPaymentGateWayCode())



		//tAddBookingRequest.setPaymentGateway(paymentGateway)

		/*TCreditCardDetails creditCardDetails = new TCreditCardDetails();
		 creditCardDetails.setCardType(requestDataDto.getCardType())
		 creditCardDetails.setCardHolderName(requestDataDto.getCardHolderName())
		 creditCardDetails.setAddressLine1(requestDataDto.getAddressLine1())
		 TCity city = new TCity()
		 city.setValue(requestDataDto.getCardCityName())
		 creditCardDetails.setCityName(city)
		 creditCardDetails.setZip(requestDataDto.getZipCode())
		 creditCardDetails.setCountry(requestDataDto.getCardCountry())
		 creditCardDetails.setCardNumber(requestDataDto.getCardNumber())
		 creditCardDetails.setCardCV2(requestDataDto.getCardCV2())
		 creditCardDetails.setExpiryMonth(requestDataDto.getCardExpiryMonth())
		 creditCardDetails.setExpiryYear(requestDataDto.getCardExpiryYear())
		 tModifyBookingRequest.setCreditCard(creditCardDetails)*/

		return tModifyBookingRequest
	}

	private TBookingReferenceInput getBookingReference(RequestDataDTO requestDataDto,String bookingReferenceID) {
		TBookingReferenceInput tBookingReferenceInput = new TBookingReferenceInput()
		tBookingReferenceInput.setReferenceSource(TReferenceSourceInput.API)
		tBookingReferenceInput.setValue(bookingReferenceID)
		return tBookingReferenceInput
	}

	private TBookingItems getBookingItems(THotelItem hotelItem,RequestDataDTO requestDataDto) {
		TBookingItems bookingItems = new TBookingItems();
		TBookingItem bookingItem = new TBookingItem();

		/*TBookingItems bookingItems = getInstance(TBookingItems)
		 TBookingItem bookingItem = getInstance(TBookingItem)*/
		bookingItem.setItemType(TItemType.HOTEL)
		bookingItem.setItemReference(requestDataDto.getBookingItemReference())
		TItemCity itemCity = new TItemCity();
		itemCity.setCode(requestDataDto.getItemCityCode())
		bookingItem.setItemCity(itemCity)
		TItem titem = new TItem();
		titem.setCode(requestDataDto.getItemCode())
		bookingItem.setItem(titem);
		bookingItem.setHotelItem(hotelItem)

		TItemRemarks itemRemarks = new TItemRemarks();
		bookingItem.setItemRemarks(itemRemarks)
		bookingItems.getBookingItem().add(bookingItem)
		return bookingItems
	}

	private <T> T getInstance(T objectName){
		T classInstance = (T) new T()
		return T
	}


	private TModifyBookingItems getModifyBookingItems(TModifyHotelItem hotelItem,RequestDataDTO requestDataDto) {
		TModifyBookingItems bookingItems = new TModifyBookingItems();
		TModifyBookingItem bookingItem = new TModifyBookingItem();

		bookingItem.setItemType(TItemType.HOTEL)
		bookingItem.setItemReference(requestDataDto.getBookingItemReference())
		TItemCity itemCity = new TItemCity();
		itemCity.setCode(requestDataDto.getItemCityCode())
		//bookingItem.setItemCity(itemCity)
		TItem titem = new TItem();
		titem.setCode(requestDataDto.getItemCode())
		//bookingItem.setItem(titem);
		bookingItem.setHotelItem(hotelItem)

		TItemRemarks itemRemarks = new TItemRemarks();
		bookingItem.setItemRemarks(itemRemarks)
		bookingItems.getBookingItem().add(bookingItem)
		return bookingItems
	}

	private THotelItem getHotelItem(THotelRooms hotelRooms,RequestDataDTO requestDataDto) {

		THotelItem hotelItem = getCommonHotelItem(requestDataDto)
		hotelItem.setHotelRooms(hotelRooms)
		return hotelItem
	}

	private THotelItem getCommonHotelItem(RequestDataDTO requestDataDto) {
		THotelItem hotelItem = new THotelItem();
		hotelItem.setAlternativesAllowed(requestDataDto.isAlternativesAllowed())
		TPeriodOfStay periodOfStay = new TPeriodOfStay();

		//XMLGregorianCalendar checkinDate = getCheckInAndDepartureDate()
		periodOfStay.setCheckInDate(requestDataDto.getCheckinDate())
		//periodOfStay.setCheckOutDate(requestDataDto.getCheckOutDate())
		periodOfStay.setDuration(requestDataDto.getDuration())
		hotelItem.setPeriodOfStay(periodOfStay)
		return hotelItem
	}

	private TModifyHotelItem getModifyHotelItem(THotelRooms hotelRooms,RequestDataDTO requestDataDto) {

		TModifyHotelItem tModifyHotelItem = new TModifyHotelItem();
		//tModifyHotelItem.setAlternativesAllowed(requestDataDto.isAlternativesAllowed())
		TPeriodOfStay periodOfStay = new TPeriodOfStay();

		//XMLGregorianCalendar checkinDate = getCheckInAndDepartureDate()
		periodOfStay.setCheckInDate(requestDataDto.getCheckinDate())
		periodOfStay.setCheckOutDate(requestDataDto.getCheckOutDate())
		//periodOfStay.setDuration(requestDataDto.getDuration())
		tModifyHotelItem.setPeriodOfStay(periodOfStay)
		//tModifyHotelItem.setHotelRooms(hotelRooms)
		return tModifyHotelItem
	}




	private THotelRooms getHotelRooms(RequestDataDTO requestDataDto) {
		THotelRoom hotelRomm = getHotelRoom(requestDataDto);
		THotelRooms hotelRooms = new THotelRooms()
		hotelRooms.getHotelRoom().add(hotelRomm)
		return hotelRooms
	}

	private THotelRoom getHotelRoom(RequestDataDTO requestDataDto) {
		THotelRoom hotelRomm = new THotelRoom();
		hotelRomm.setCode(requestDataDto.getHotelRoomCode())
		//hotelRomm.setId("001:SHE:15191:S11432:14124:24607")
		hotelRomm.setExtraBed(requestDataDto.isExtraBed())
		hotelRomm.setNumberOfCots(requestDataDto.getNumberOfCots())
		TPaxIds paxids = new TPaxIds();
		paxids.getPaxId().add(requestDataDto.getHotemRoomPaxID())
		hotelRomm.setPaxIds(paxids)
		return hotelRomm
	}

	private THotelRooms getModifyHotelRooms(RequestDataDTO requestDataDto) {
		THotelRoom hotelRomm = getHotelRoom(requestDataDto);
		hotelRomm.setId(requestDataDto.getHotelID())
		THotelRooms hotelRooms = new THotelRooms()
		hotelRooms.getHotelRoom().add(hotelRomm)
		return hotelRooms
	}

	private TSource getTSource(RequestDataDTO requestDataDto) {
		TSource tsource = new TSource()
		TRequestorID requestID = new TRequestorID();
		requestID.setClient(requestDataDto.getClientId())
		requestID.setEMailAddress(requestDataDto.getEmailID())
		requestID.setPassword(requestDataDto.getPassword())
		tsource.setRequestorID(requestID)
		TRequestorPreferences requestPreferences = new TRequestorPreferences()
		requestPreferences.setCountry(requestDataDto.getCountry())
		requestPreferences.setCurrency(requestDataDto.getCurrency())
		requestPreferences.setLanguage(requestDataDto.getLanguage())
		requestPreferences.setRequestMode(TRequestMode.SYNCHRONOUS)
		tsource.setRequestorPreferences(requestPreferences)
		return tsource
	}

	def PaymentStatus getPaymentStatusDetails(String bookingReferenceId, String siteId) {
		Connection connection = AS400DatabaseConnection.getAs400Connection();
		print "AS400 connection " +connection
		ResultSet resultSet
		PaymentStatus paymentStatus = null;
		def active = "y"
		int count = 0

		try{
			Statement stmt = connection.createStatement();
			paymentStatus = new PaymentStatus()
			//ResultSet rs = stmt.executeQuery("SELECT * FROM RTnnnDTA.YOUR_PF_FILE");
			//resultSet = stmt.executeQuery("SELECT PYLG_STS,PYLG_BKPVL FROM RT012DTA.RTPYLGP WHERE PYLG_BKUI = "+bookingReferenceId+"");
			//resultSet = stmt.executeQuery("SELECT PYLG_STS,PYLG_BKPVL FROM "+siteId + ".RTPYLGP WHERE PYLG_BKUI = "+bookingReferenceId+"");
			resultSet = stmt.executeQuery("SELECT PYLG_STS,PYLG_BKPVL FROM " + siteId + ".RTPYLGP WHERE PYLG_STS = 'OK' AND PYLG_BKUI = " + bookingReferenceId + "");
			println  "SELECT PYLG_STS,PYLG_BKPVL FROM " + siteId + ".RTPYLGP WHERE PYLG_STS = 'OK' AND PYLG_BKUI = " + bookingReferenceId + "";

			while (resultSet.next()) {
				count= resultSet.row

				if(resultSet.getString("PYLG_STS").equalsIgnoreCase("ok"))
				{
					paymentStatus.setPaymentStatus(resultSet.getString("PYLG_STS"))
					paymentStatus.setAmount(resultSet.getString("PYLG_BKPVL"))

				}
			}
		} catch (Exception exception) {
		}
		paymentStatus.setNumberOfRows(count)
		return paymentStatus
	}

	def BookingStatus getBookingStatusDetails(String bookingReferenceId, String siteId) {
		Connection connection = AS400DatabaseConnection.getAs400Connection();
		print "AS400 connection " +connection
		ResultSet resultSet
		BookingStatus bookingStatus = null;
		int count = 0
		int noOfTries = 1
		sleep(10000)
		try{
			Statement stmt = connection.createStatement();
			bookingStatus = new BookingStatus()
			resultSet = stmt.executeQuery("SELECT BKMS_STS, BKMS_GRSVL,BKMS_NETVL FROM " + siteId + ".RTBKMSP WHERE BKMS_BKUI = " + bookingReferenceId + "");
			println  " SELECT BKMS_STS, BKMS_GRSVL,BKMS_NETVL FROM " + siteId + ".RTBKMSP WHERE BKMS_BKUI = " + bookingReferenceId + ""

			while (resultSet.next()) {
				count= resultSet.row
				println "number of rows DB: $count"
				println " booking status in query DB : " +  resultSet.getString("BKMS_STS")
				if(resultSet.row == 1)
				{
					bookingStatus.setBookingstatus(resultSet.getString("BKMS_STS").trim())
					bookingStatus.setGrossamount(resultSet.getString("BKMS_GRSVL").toString().trim())
					bookingStatus.setNetamount(resultSet.getString("BKMS_NETVL").toString().trim())
					break
				}
			}

		} catch (Exception exception) {

	    exception.printStackTrace()
		}
		bookingStatus.setRowcount(count)
		return bookingStatus
	}

	/****************************************************************************************************************************************************************/

	def BookingStatus getBookingDetails(String bookingReferenceId, String siteId) {
		Connection connection = AS400DatabaseConnection.getAs400Connection();
		print "AS400 connection " + connection
		ResultSet resultSet
		BookingStatus bookingStatus = null
		int count = 0
		sleep(10000)
		try{
			Statement stmt = connection.createStatement();
			bookingStatus = new BookingStatus()
			resultSet = stmt.executeQuery("SELECT BKMS_STS, BKMS_GRSVL FROM  RT" + siteId + "DTA.RTBKMSP WHERE BKMS_BKUI = " + bookingReferenceId + "")
			println  "SELECT BKMS_STS, BKMS_GRSVL FROM  RT" + siteId + "DTA.RTBKMSP WHERE BKMS_BKUI = " + bookingReferenceId + ""

			while (resultSet.next()) {
				count= resultSet.row
				println "Number of rows DB: $count"
				println "Booking status in query DB : " +  resultSet.getString("BKMS_STS")
				if(resultSet.row == 1) {
					bookingStatus.setBookingstatus(resultSet.getString("BKMS_STS").trim())
					bookingStatus.setGrossamount(resultSet.getString("BKMS_GRSVL").toString().trim())
					break
				}
			}

		} catch (Exception exception) {

			exception.printStackTrace()
		}
		bookingStatus.setRowcount(count)
		return bookingStatus
	}

	def ItemBookingStatus getItemBookingDetails(String bookingReferenceId, String siteId, String bookingPaymentUniqueId) {
		Connection connection = AS400DatabaseConnection.getAs400Connection();
		print "AS400 connection " +connection
		ResultSet resultSet
		ItemBookingStatus itemStatus = null

		int count = 0
		int noOfTries = 1

		try{
			Statement stmt = connection.createStatement();
			itemStatus = new ItemBookingStatus()
			sleep (200000)
			resultSet = stmt.executeQuery("SELECT BKPY_STS, BKPY_BKPVL  FROM RT" + siteId + "DTA.RTBKPYP WHERE BKPY_BKUI = " + bookingReferenceId + " AND  BKPY_BKPUI = " + bookingPaymentUniqueId + " AND BKPY_ACTIV = 'Y'" + "")
			println "SELECT BKPY_STS, BKPY_BKPVL  FROM RT" + siteId + "DTA.RTBKPYP WHERE BKPY_BKUI = " + bookingReferenceId + " AND  BKPY_BKPUI = " + bookingPaymentUniqueId + " AND BKPY_ACTIV = 'Y'" + ""

			while (resultSet.next()) {
				count = resultSet.row
				println "Number of rows DB: $count"
				if(resultSet.row == 1) {
					itemStatus.setItemStatus(resultSet.getString("BKPY_STS").trim())
					itemStatus.setPaymentValue(resultSet.getString("BKPY_BKPVL").trim())
					break
				}
			}

		} catch (Exception exception) {

			exception.printStackTrace()
		}
		itemStatus.setRowCount(count)
		return itemStatus
	}

	/*****************************************************************************************************************************************************************/

	def PaymentStatus getPaymentStatusDetails(String bookingReferenceId , int row) {
		Connection connection = AS400DatabaseConnection.getAs400Connection();
		print "AS400 connection " +connection
		ResultSet resultSet
		PaymentStatus paymentStatus = null;
		def active = "y"
		int rows = 0

		try{
			Statement stmt = connection.createStatement();
			paymentStatus = new PaymentStatus()
			//ResultSet rs = stmt.executeQuery("SELECT * FROM RTnnnDTA.YOUR_PF_FILE");
			//resultSet = stmt.executeQuery("SELECT PYLG_STS,PYLG_BKPVL FROM RT012DTA.RTPYLGP WHERE PYLG_BKUI = "+bookingReferenceId+"");
			resultSet = stmt.executeQuery("SELECT PYLG_STS,PYLG_BKPVL FROM RT012DTA.RTPYLGP WHERE PYLG_BKUI = "+bookingReferenceId+"");

			while (resultSet.next()) {
				if(resultSet.row == row)
				{
					paymentStatus.setPaymentStatus(resultSet.getString("PYLG_STS"))
					paymentStatus.setAmount(resultSet.getString("PYLG_BKPVL"))
				}
			}
		} catch (Exception exception) {
		}
		paymentStatus.setNumberOfRows(resultSet.fetchSize)
		return paymentStatus
	}

	def String getBookingReferenceID(TResponseDetails responseDetails) {
		def bookingReferenceId
		List<JAXBElement<?>> listofResponse = responseDetails.getSearchHotelPricePaxResponseOrApartmentPriceBreakdownResponseOrAvailabilityCacheResponse()
		for (int i = 0; i < listofResponse.size(); i++) {
			JAXBElement<TSearchBookingItemResponse> searchResponse = listofResponse.get(i)
			TBookingReferences bookingReferences = searchResponse.getValue().getBookingReferences()
			bookingReferenceId = bookingReferences.getBookingReference().get(1).value
			println "booking reference id " +bookingReferenceId
		}
		return bookingReferenceId
	}

	def TResponseDetails getUnMarshalObject(String responseBody) {
		JAXBContext context = JAXBContext.newInstance( "com.kuoni.finance.jaxb.obsapi")
		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		JAXBElement<Response> s = (JAXBElement<Response>)jaxbUnmarshaller.unmarshal(new StringReader(responseBody));
		Response response = s.getValue()
		TResponseDetails responseDetails=response.getResponseDetails()
		return responseDetails
	}

	def String getMarshalXml(Request requestWithData) {
		JAXBContext context = JAXBContext.newInstance( "com.kuoni.finance.jaxb.obsapi")
		Marshaller marshller = context.createMarshaller();
		marshller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter stringWriter = new StringWriter();
		marshller.marshal(requestWithData, stringWriter);
		StringBuffer sb = stringWriter.buffer
		return sb.toString()
	}

	def RequestDataDTO getRequestDataDTO() {
		RequestDataDTO requestDataDto = new RequestDataDTO()

		//setting source test data
		requestDataDto.setClientId(249)
		requestDataDto.setEmailID("TEST@APITEST.COM")
		requestDataDto.setPassword("PASS")
		requestDataDto.setCountry("AU")
		requestDataDto.setCurrency("AUD")
		requestDataDto.setLanguage("en")
		//requestDataDto.setRequestMode("")

		requestDataDto.setAddBookingCurrency("AUD")

		requestDataDto.setBookignReference(requestDataDto.getDate(2014, 10, 18))
		requestDataDto.setDepartureDate(requestDataDto.getDate(2014, 07, 27))
		requestDataDto.setPaxId(1)
		requestDataDto.setPaxName("Jess Test")
		requestDataDto.setBookingItemReference(1)
		requestDataDto.setItemCityCode("DUB")
		requestDataDto.setItemCode("SHE")
		requestDataDto.setAlternativesAllowed(false)
		requestDataDto.setCheckinDate(requestDataDto.getDate(2014, 07, 27))
		requestDataDto.setCheckOutDate(requestDataDto.getDate(2014, 07, 29))
		requestDataDto.setDuration(2)
		requestDataDto.setHotelRoomCode("SB")
		requestDataDto.setHotelID("001:SHE:15191:S11432:14124:24607")
		requestDataDto.setExtraBed(false)
		requestDataDto.setNumberOfCots(0)
		requestDataDto.setHotemRoomPaxID(1)
		requestDataDto.setPaymentGateWayCode("EN")
		requestDataDto.setCardType("VS")
		requestDataDto.setCardHolderName("Jess Test")
		requestDataDto.setAddressLine1("141 High Street")
		requestDataDto.setCardCityName("London")
		requestDataDto.setZipCode("EN6 3RG")
		requestDataDto.setCardCountry("GB")
		requestDataDto.setCardNumber("4111111111111111")
		requestDataDto.setCardCV2("123")
		requestDataDto.setCardExpiryMonth("08")
		requestDataDto.setCardExpiryYear("2014")

		return requestDataDto
	}

}
