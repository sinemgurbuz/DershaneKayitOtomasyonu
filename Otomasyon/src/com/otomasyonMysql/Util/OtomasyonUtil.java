package com.otomasyonMysql.Util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class OtomasyonUtil {
	
	static Connection conn=null;
	public static String hatamesajı;
	
	public static Connection bagla() {
		try {
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost/dershane","root","");
			return conn;
			
		} catch (Exception e) {
			// TODO: handle exception
			hatamesajı=e.getMessage().toString();
			return null;
		}
		
		
	}
	public static String MD5Sifreleme(String icerik) {
		
		try {
			MessageDigest  md=MessageDigest.getInstance("MD5");
			byte[] sifrelenmis=md.digest(icerik.getBytes());
			
			BigInteger no=new BigInteger(1,sifrelenmis);
			String hashIcerik=no.toString(16);
			while(hashIcerik.length()<32) {
				hashIcerik="0"+hashIcerik;
			}
			return hashIcerik;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	

}


