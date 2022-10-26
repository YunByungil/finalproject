package joa.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.tree.ExpandVetoException;

public class test{

	public static void main(String[] args) {
		
		
		//오라클DB서버 접근 기본 정보
		String url		 ="jdbc:oracle:thin:@localhost:1521:xe";    
		String user		 ="scott";
		String password="1234";
		String driver     ="oracle.jdbc.driver.OracleDriver";
		
		Connection con=null; 				//DB연결
		PreparedStatement pstmt=null;    //SQL변환
		ResultSet rs=null;						//select 문 조회
		
		try{
			//1) 드라이버 로딩
			Class.forName(driver);
            
			//2) DB연결
			con=DriverManager.getConnection(url, user, password);
			System.out.println("~오라클DB서버 연결 성공~");
            
			
		}catch(Exception e){
			System.out.println("!실패!" + e);
		}finally{  //자원반납
			try{
				if(rs!=null){rs.close();}
			}catch(Exception e){}
			try{
				if(pstmt!=null){pstmt.close();}
			}catch(Exception e){}
			try{
				if(con!=null){con.close();}
			}catch(Exception e){}
		}//try end

	}//main() end
}//class end