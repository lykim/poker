package com.ruly.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CommonUtilities {
	public static int getRandomNumberBeetween(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}
