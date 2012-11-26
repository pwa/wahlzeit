package org.wahlzeit.services;

import javax.mail.Session;


/**
 * @author pwa
 * 
 * this class serves to decouple the client code from the 
 * specific class names
 */
public final class EmailServerSingleAccessPoint {
//	
//	/**
//	 * 
//	 */
//	protected static final EmailServer REAL_INSTANCE = new SmtpEmailServer();
//	protected static final EmailServer NULL_INSTANCE = new NullEmailServer();
//
//	/**
//	 * 
//	 */
//	protected static EmailServer instance = getInstanceFromMode();
//	
//	/**
//	 * 
//	 */
//	public static EmailServer getInstance() {
//		return instance;
//	}
//	
//	
//	/**
//	 * 
//	 */
//	public static EmailServer getInstanceFromMode() {
//		if (SysLog.isInProductionMode()) {
//			return REAL_INSTANCE;
//		} else {
//			return NULL_INSTANCE;
//		}
//	}
//
//	/**
//	 * @methodtype set
//	 */
//	public static void setInstance(EmailServer server) {
//		instance = server;
//	}
//	
//	/**
//	 * 
//	 */
//	public static void setNullInstance() {
//		instance = NULL_INSTANCE;
//	}
}
