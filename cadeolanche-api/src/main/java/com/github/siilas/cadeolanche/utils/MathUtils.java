package com.github.siilas.cadeolanche.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class MathUtils {

	private static final int SCALE = 2;
	private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
	
	private MathUtils() {
		throw new IllegalStateException();
	}
	
	public static BigDecimal bigDecimal(Double number) {
		return setScale(new BigDecimal(number));
	}
	
	public static BigDecimal setScale(BigDecimal number) {
		return number.setScale(SCALE, ROUNDING_MODE);
	}

	public static BigDecimal multiply(BigDecimal number, BigDecimal multiplicand) {
		return setScale(number.multiply(multiplicand));
	}
	
	public static BigDecimal multiply(Double number, BigDecimal multiplicand) {
		return setScale(intValue(number).multiply(multiplicand));
	}
	
	public static BigDecimal intValue(Double number) {
		return new BigDecimal(number.intValue());
	}
	
}
