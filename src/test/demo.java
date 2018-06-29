package test;

import com.yuyisz.pis.utils.EncodertAndDecoder;
import com.yuyisz.pis.utils.SystemApi;

public class demo {

	public static void main(String[] args) {
		String str = SystemApi.findServiceInfo();
		System.out.println(str);
		System.out.println("--------------------------------");
		str = SystemApi.findServiceInfo("hadoop");
		System.out.println(str);
		System.out.println("--------------------------------");
		str = SystemApi.findSystemServiceInfo();
		System.out.println(str);
		System.out.println("--------------------------------");
		str = SystemApi.findDBInfo();
		System.out.println(str);
		System.out.println("--------------------------------");
		str = SystemApi.findMQInfo();
		System.out.println(str);
		System.out.println("--------------------------------");
		str = SystemApi.findHDFSInfo();
		System.out.println(str);
		System.out.println("--------------------------------");
		str = SystemApi.findNTPInfo();
		System.out.println(str);
		System.out.println("--------------------------------");
		System.out
				.println("---------------VVZkU2RHRlhOVUZOVkVsNlEyYzlQUW89Cg==-----------------");
		System.out.println(EncodertAndDecoder.encoder("Admin@123"));
		System.out.println("---------------Admin@123-----------------");
		System.out.println(EncodertAndDecoder
				.decoder("VVZkU2RHRlhOVUZOVkVsNlEyYzlQUW89Cg=="));
	}

}
