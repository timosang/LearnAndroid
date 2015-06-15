package com.timosang.junit.test;

import junit.framework.Assert;

import com.timosang.junit.util.Utils;

import android.test.AndroidTestCase;

public class Test extends AndroidTestCase {
	public void test(){
		int result  = Utils.add(3 , 5);
		assertEquals(8, result);
	}	
	
}

