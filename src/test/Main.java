package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuyisz.pis.utils.DBUtil;
import com.yuyisz.pis.utils.RuntimeLogs;
import com.yuyisz.pis.utils.SystemApi;

public class Main {

	public static void main(String[] args) {

		System.out.println("+++++++++++++++DB+++++++++++++++");
		System.out.println(DBUtil.validateTableExist("t_operationlogs"));
		System.out.println(DBUtil.validateTableExist("t_operationlogs1"));
		System.out.println("+++++++++++++++DB+++++++++++++++");
		Connection conn = DBUtil.getConn();
		// RuntimeLogs.validateLogTableExist(conn);
		String sql = "select * from t_runtimelogs";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int len = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i < len; i++) {
					System.out.print(rs.getString(i) + "|");
				}
				System.out.println(rs.getString(len));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		System.out.println("+++++++++++++++DB+++++++++++++++");
		RuntimeLogs.addLog("WARN", "greenplum",
				"error sadasdasdsdd.....xasdax....xas.d.sa...");
		System.out.println("+++++++++++++++DB+++++++++++++++");

		System.out.println("===========1、获取数据库服务信息===========");
		System.out
				.println("===========e.g:192.168.2.16,gpadmin,gpadmin===========");
		String str = SystemApi.findDBInfo();
		System.out.println(str + "\n");

		System.out.println("===========2、获取消息中心信息===========");
		System.out
				.println("===========e.g:192.168.2.32,rabbitmqadmin,rabbitmqadmin===========");
		str = SystemApi.findMQInfo();
		System.out.println(str + "\n");

		System.out.println("===========3、获取FTP服务信息===========");
		System.out
				.println("===========e.g:[ftp1,192.168.2.35,ftpuser,ftpuser],[ftp2,192.168.2.37,ftpuser,ftpuser],[ftp3,192.168.2.68,ftpuser,ftpuser]===========");
		str = SystemApi.findFTPInfo();
		System.out.println(str + "\n");

		System.out.println("===========4、获取NTP服务信息===========");
		System.out.println("===========e.g:192.168.2.36===========");
		str = SystemApi.findNTPInfo();
		System.out.println(str + "\n");

		System.out.println("===========5、获取流媒体服务信息===========");
		System.out
				.println("===========e.g:[stream1,192.168.2.95,streamuser,streamuser],[stream2,192.168.2.99,ftpuser,ftpuser],[stream3,192.168.2.90,streamuser,streamuser]===========");
		str = SystemApi.findStreamInfo();
		System.out.println(str + "\n");

		System.out.println("===========6、流媒体服务获取本身标识===========");
		System.out.println("===========e.g:stream1===========");
		str = SystemApi.findStreamFlag();
		System.out.println(str + "\n");

		System.out.println("===========7、获取所有服务信息===========");
		str = SystemApi.findServiceInfo();
		System.out.println(str + "\n");

		System.out.println("===========test===========");
		str = SystemApi.findServiceInfo("hadoop");
		System.out.println(str + "\n");

	}

}
