/**
 * 
 */
package com.himanshi.rest.webservices.restful.webservices.services;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.himanshi.rest.webservices.restful.webservices.model.OtpValue;

/**
 * @author Himanshi
 *
 */
@Component
public class OtpGeneratorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OtpGeneratorService.class);

	public OtpValue generateOtp(int length) {
		String numbers = "1234567890";
		Random random = new Random();
		char[] otp = new char[length];

		for(int i = 0; i< length ; i++) {
			otp[i] = numbers.charAt(random.nextInt(numbers.length()));
		}
		OtpValue otpVal = new OtpValue(Integer.parseInt(new String(otp)));
		LOGGER.info(" --- new otp generate ---- " + otpVal.getOtp());
		return otpVal;
	}

}
