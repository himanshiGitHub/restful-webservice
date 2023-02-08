package com.himanshi.rest.webservices.restful.webservices.model;

/**
 * @author Himanshi
 *
 */
public class OtpValue {
	private int otp;
	
	public OtpValue(int otp) {
		super();
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OtpValue [otp=" + otp + "]";
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public long getOtp() {
		return otp;
	}

}
