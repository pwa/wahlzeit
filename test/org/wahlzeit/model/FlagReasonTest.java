/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.model;

import junit.framework.*;

public class FlagReasonTest extends TestCase {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(UserStatusTest.class);
	}

	public FlagReasonTest(String name) {
		super(name);
	}

	public void test_getFromInt() {
		// test success:
		FlagReason f = FlagReason.getFromInt(0);
		assertTrue(f == FlagReason.MISMATCH);

		// test failure:
		boolean exceptionThrown = false;
		try {
			f = FlagReason.getFromInt(Integer.MAX_VALUE);
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

	public void test_getFromString() {
		// test success:
		FlagReason f = FlagReason.getFromString("other");
		assertTrue(f == FlagReason.OTHER);

		// test failure:
		boolean exceptionThrown = false;
		try {
			f = FlagReason.getFromString("lilalaunebaer");
		} catch (IllegalArgumentException e) {
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
	}

	public void test_asInt() {
		FlagReason f = FlagReason.COPYRIGHT;
		int c = f.asInt();
		assertTrue(c == 2);

		FlagReason[] frs = FlagReason.values();
		int iter = 0;
		for (FlagReason fr : frs) {
			int i = fr.asInt();
			assertTrue(iter == i);
			iter++;
		}
	}

	public void test_asString() {
		FlagReason f = FlagReason.COPYRIGHT;
		String s = f.asString();
		assertTrue(s.equals("copyright"));
	}

	public void test_getAllValues() {
		FlagReason tmp = FlagReason.COPYRIGHT;
		FlagReason[] frs = tmp.getAllValues();
		int i = 0;
		for (FlagReason fr : frs) {
			assertTrue(fr == FlagReason.values()[i]);
			i++;
		}
	}

}
