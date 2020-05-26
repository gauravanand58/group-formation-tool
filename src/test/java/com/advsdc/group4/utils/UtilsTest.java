package com.advsdc.group4.utils;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsTest {

	@Test
	public void checkEmptyTest() {
		String value = Utils.emptyCheck(null);
		assumeTrue(value!="", value);
	}
}
