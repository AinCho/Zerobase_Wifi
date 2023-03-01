package wifi01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class main {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public main() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public List ListLocation() {
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select * from location order by close desc";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int km = rs.getInt("km");
				String checkingPlace = rs.getString("checkingPlace");
				String district = rs.getString("district");
				String address = rs.getString("address");
				String detailAddress = rs.getString("detailAddress");
				int installFloors = rs.getInt("installFloors");
				String installType = rs.getString("installType");
				String installAgency = rs.getString("installAgency");
				String serviceType = rs.getString("serviceType");
				String netType = rs.getString("netType");
				Date installDate = rs.getDate("installDate");
				String indoorOutdoor = rs.getString("indoorOutdoor");
				String envWifi = rs.getString("envWifi");
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				Date operationDate = rs.getDate("operateionDate");
				
				WifiInfo vo = new WifiInfo();
				vo.setKm(km);
				vo.setCheckingPlace(checkingPlace);
				vo.setDistrict(district);
				vo.setAddress(address);
				vo.setDetailAddress(detailAddress);
				vo.setInstallFloors(installFloors);
				vo.setInstallType(installType);
				vo.setInstallAgency(installAgency);
				vo.setServiceType(serviceType);
				vo.setNetType(netType);
				vo.setInstallDate(installDate);
				vo.setIndoorOutdoor(indoorOutdoor);
				vo.setEnvWifi(envWifi);
				vo.setX(x);
				vo.setY(y);
				vo.setOperationDate(operationDate);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} return list;
	}
}
