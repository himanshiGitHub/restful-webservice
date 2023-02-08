/**
 * 
 */
package com.himanshi.rest.webservices.restful.webservices.model;

/**
 * @author Himanshi
 *
 */
public class OtpRequestParameters {
	
	private int length;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "OtpRequestParameters [length=" + length + "]";
	}

}
