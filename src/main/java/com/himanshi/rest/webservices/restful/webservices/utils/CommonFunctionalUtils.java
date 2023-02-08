package com.himanshi.rest.webservices.restful.webservices.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.himanshi.rest.webservices.restful.webservices.model.OtpRequestParameters;

/**
 * @author Himanshi
 *
 */
@Component
public class CommonFunctionalUtils {
	
	public OtpRequestParameters deserStringToOtpRequestParameters(String jsonRequest, ObjectMapper ObjectMapper) throws JsonMappingException, JsonProcessingException {
		ObjectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		return ObjectMapper.readValue(jsonRequest, new TypeReference<OtpRequestParameters>() {});
	}
   
}
