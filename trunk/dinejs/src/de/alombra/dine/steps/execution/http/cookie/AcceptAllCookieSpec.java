package de.alombra.dine.steps.execution.http.cookie;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.cookie.CookieSpecBase;
import org.apache.commons.httpclient.cookie.MalformedCookieException;

public class AcceptAllCookieSpec extends CookieSpecBase {

	public static final String SPEC_IDENTIFIER = "acceptAll";
	
	@Override
	public void validate(String arg0, int arg1, String arg2, boolean arg3, Cookie arg4) throws MalformedCookieException {
		// do nothing as we accept all cookies
	}

	
	
}
