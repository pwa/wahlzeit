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

import org.wahlzeit.services.SQLErrorCodes;

/**
 * Tier 0 Exception (data tier/data access tier):
 * represents an exception on the layer communicating directly 
 * with the database 
 */
public class ReadWriteException extends Exception {

	/**
	 * 
	 */
	private SQLErrorCodes errorCode = null;
	
	/**
	 * 
	 */
	public ReadWriteException(SQLErrorCodes err){
		super();
		this.errorCode = err;
	}
	
	/**
	 * 
	 */
	public SQLErrorCodes getErrorCode(){
		return errorCode;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 796018674019464408L;
	
}
