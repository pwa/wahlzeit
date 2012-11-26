package org.wahlzeit.services;

import junit.framework.TestCase;

import org.wahlzeit.handlers.MockEmailServer;
import org.wahlzeit.model.TagsTest;
import org.wahlzeit.services.AspectedEmailServer;
import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.EmailServer;
import org.wahlzeit.services.SmtpEmailServer;

public class EmailServerSingletonTest extends TestCase {
	public static void main(final String[] args) {
		junit.textui.TestRunner.run(TagsTest.class);
	}

	public EmailServerSingletonTest(final String name) {
		super(name);
	}

	public void testIdentity() {
		EmailServer e1 = new AspectedEmailServer();
		EmailServer e2 = new AspectedEmailServer();
		EmailServer e3 = new AspectedEmailServer();

		int e1id = System.identityHashCode(e1);
		int e2id = System.identityHashCode(e2);
		int e3id = System.identityHashCode(e3);

		System.out.println("Hash codes of EmailServers:" + "e1id: " + e1id
				+ " e2id: " + e2id + " e2id: " + e3id);
		assertTrue(e1id == e2id);
		assertTrue(e2id == e3id);
	}
	
	public void testClassCorrectness() {
		EmailServer e = new AspectedEmailServer();
		
		// must be a MockEmailServer, because we are in the testing environment
		assertTrue(e instanceof AspectedEmailServer);
		assertTrue(e instanceof MockEmailServer);
	}
}
