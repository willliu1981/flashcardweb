package idv.test.test1;

import java.security.Key;
import java.util.Base64;

import idv.tool.Debug;
import idv.tool.JWTUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class Test1 {

	public static void main(String[] args) {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1ZWY4YTk3OS0xNDgxLTQ3NTUtYWU4ZC0zYzRjZDU3NDIxOWMiLCJzdWIiOiJ1X2FkbWluIiwiaXNzIjoieWVuIiwiaWF0IjoxNjQ4Mjc1NTQ4LCJleHAiOjE2NDgyNzY0NDh9.6uB4xCgEV-eSRPvhlw5ZavmStWn25HyZx2jgevOZ7sA";

		try {
			// Claims claims = JWTUtils.parseJWT(token);

			String payload = "eyJqdGkiOiI1ZWY4YTk3OS0xNDgxLTQ3NTUtYWU4ZC0zYzRjZDU3NDIxOWMiLCJzdWIiOiJ1X2FkbWluIiwiaXNzIjoieWVuIiwiaWF0IjoxNjQ4Mjc1NTQ4LCJleHAiOjE2NDgyNzY0NDh9";

			byte[] ds = Base64.getDecoder().decode(payload);
			Debug.test(new String(ds));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
