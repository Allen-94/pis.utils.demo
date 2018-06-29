package test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Coder {
	public static void main(String[] args) {
		String en = "Admin@123";
		String de = "VVZkU2RHRlhOVUZOVkVsNlEyYzlQUW89Cg==";
		int i = 0;
		for (; i < 3; i++) {
			System.out.println("en" + i + ":" + en);
			en = encoder(en);
			System.out.println("de" + i + ":" + de);
			de = decoder(de);
		}
		System.out.println("en" + i + ":" + en);
		en = encoder(en);
		System.out.println("de" + i + ":" + de);
		de = decoder(de);

	}

	public static String encoder(String text) {
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] textByte;
		try {
			textByte = text.getBytes("UTF-8");
			// 编码
			String encodedText = encoder.encodeToString(textByte);
			return encodedText;
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "error";
	}

	public static String decoder(String text) {
		final Base64.Decoder decoder = Base64.getDecoder();
		try {
			// 解码
			String decodedText = new String(decoder.decode(text), "UTF-8");
			return decodedText;
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "error";
	}
}
