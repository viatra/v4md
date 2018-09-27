package com.incquerylabs.v4md.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ExampleTestCase.class,
	SnapshotTest.class
})
public class AllTests {}
