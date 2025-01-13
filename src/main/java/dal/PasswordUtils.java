package dal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
	public static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] hashedBytes = md.digest(password.getBytes());

			StringBuilder sb = new StringBuilder();
			for (byte b : hashedBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
