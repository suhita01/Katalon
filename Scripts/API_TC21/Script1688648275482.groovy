import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.Assert

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

//WS.sendRequest(findTestObject('API_01'))

RequestObject requestObject = findTestObject('API_01')

 

def jsonslurper = new JsonSlurper()

 

def conTentType = new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json')

 

def acceptHeader = new TestObjectProperty('Accept', ConditionType.EQUALS, 'application/json')

 

requestObject.setHttpHeaderProperties(Arrays.asList(conTentType, acceptHeader))

 

def responseObject = WS.sendRequest(requestObject)

 

def responsevalue = jsonslurper.parseText(responseObject.getResponseText())

 

Assert.assertEquals(200, responseObject.getStatusCode())

 

println('Status Code '+responseObject.getStatusCode())

 

println('responsevalue ' + responsevalue)
