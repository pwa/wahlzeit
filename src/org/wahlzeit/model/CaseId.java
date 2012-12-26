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

/**
 * A case id identifies a case with a unique number.
 * 
 * @author dirkriehle
 * 
 */
public class CaseId {

	/**
	 * 
	 */
	private final int intValue;

	/**
	 * 
	 */
	public int asInt() {
		return intValue;
	}

	/**
	 * 
	 */
	public static final CaseId NULL_ID = new CaseId(0);

	/**
	 * What a hack :-)
	 */
	public static final int ID_START = getFromString("x1abz") + 1;

	/**
	 * the CaseId constructor requires a value greater or equal than zero
	 */
	protected CaseId(int myValue) {
		if (myValue < 0)
			throw new IllegalArgumentException();

		intValue = myValue;
	}

	/**
	 * 
	 */
	public boolean isNullId() {
		return this == NULL_ID;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intValue;
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaseId other = (CaseId) obj;
		if (intValue != other.intValue)
			return false;
		return true;
	}

	/**
	 * 
	 */
	public boolean isEqualValue(CaseId other) {
		return other.intValue == intValue;
	}

	/**
	 * 
	 */
	public static String getFromInt(int id) {
		StringBuffer result = new StringBuffer(10);

		id += ID_START;
		for (; id > 0; id = id / 36) {
			char letterOrDigit;
			int modulus = id % 36;
			if (modulus < 10) {
				letterOrDigit = (char) ((int) '0' + modulus);
			} else {
				letterOrDigit = (char) ((int) 'a' - 10 + modulus);
			}
			result.insert(0, letterOrDigit);

		}
		return "x" + result.toString();
	}

	/**
	 * 
	 */
	public static int getFromString(String value) {
		int result = 0;
		for (int i = 1; i < value.length(); i++) {
			int temp = 0;
			char letterOrDigit = value.charAt(i);
			if (letterOrDigit < 'a') {
				temp = (int) letterOrDigit - '0';
			} else {
				temp = 10 + (int) letterOrDigit - 'a';
			}
			result = result * 36 + temp;
		}

		result -= ID_START;
		if (result < 0) {
			result = 0;
		}

		return result;
	}

}
