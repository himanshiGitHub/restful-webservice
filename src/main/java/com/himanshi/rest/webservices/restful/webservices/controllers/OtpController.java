package com.himanshi.rest.webservices.restful.webservices.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.himanshi.rest.webservices.restful.webservices.model.OtpValue;
import com.himanshi.rest.webservices.restful.webservices.services.OtpGeneratorService;
import com.himanshi.rest.webservices.restful.webservices.utils.CommonFunctionalUtils;

/**
 * @author Himanshi
 *
 */
@RestController
public class OtpController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OtpController.class);
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	OtpGeneratorService otpService;
	
	@Autowired
	private CommonFunctionalUtils commonFunctionalUtils;
	
	@GetMapping(path = "/getOtp")
	public ResponseEntity<String> getNewOtp(@RequestBody String jsonRequest) {
		String strJsonResponse = "";
		LOGGER.info("Request body for /getOtp request is " + jsonRequest);
		try {
			int lengthOfOtp = commonFunctionalUtils.deserStringToOtpRequestParameters(jsonRequest, objectMapper).getLength();
			LOGGER.error("length of otp : " + lengthOfOtp);
			OtpValue otp = otpService.generateOtp(lengthOfOtp);
			strJsonResponse = objectMapper.writeValueAsString(otp);
			return	new ResponseEntity<>(strJsonResponse, HttpStatus.OK);
		} catch(JsonProcessingException e) {
			LOGGER.error("Failed to parse JSON sent as a part of request : " + e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
