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

package org.wahlzeit.aspects;

import java.util.Hashtable;
import org.wahlzeit.services.AspectedEmailServer;
import org.wahlzeit.services.SmtpEmailServer;
import org.wahlzeit.handlers.MockEmailServer;
// import org.wahlzeit.main.Wahlzeit;
// import org.wahlzeit.AllTests;

/**
 * 
 * @author pwa
 */
public aspect EmailServerAspect {
	
	/**
	 * stores the Singleton instances
	 **/
	private Hashtable singletons = new Hashtable(); 

	/**
	 * the pointcut expression to address the test environment
	 */
	private pointcut testCode() : within(org.wahlzeit.AllTests);
	
	/**
	 * 
	 */
	Object around():
		call((AspectedEmailServer+).new(..)) 
		&& (!within(EmailServerAspect)) // because the  must create the instance with the new operator
		{

		Class singleton = MockEmailServer.class;

		if (singletons.get(singleton) == null) {
			
			// proceed and call the constructor ...
			// of course this instance can be destroyed!
			MockEmailServer m = new MockEmailServer();
			
			singletons.put(singleton, m); 
		}

		return (MockEmailServer)singletons.get(singleton);
	}

	/**
	 * the pointcut expression to address the application code
	 */
	pointcut applicationCode() : within(org.wahlzeit.main.Wahlzeit);
	
	/**
	 * 
	 */
	Object around(): call((AspectedEmailServer).new(..))
		&& (!within(EmailServerAspect))
		&& (applicationCode()) {                    

		// Class singleton = thisJoinPoint.getSignature().getDeclaringType();
		Class singleton = SmtpEmailServer.class;

		if (singletons.get(singleton) == null) {
			SmtpEmailServer e = new SmtpEmailServer();
			singletons.put(singleton, e); 
		}
		
		return singletons.get(singleton);
	}
}
