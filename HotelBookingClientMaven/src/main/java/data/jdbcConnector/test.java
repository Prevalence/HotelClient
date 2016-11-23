package data.jdbcConnector;

import java.sql.Connection;

public class test {
	public static void main (String args[]){
		Builder dd=new Builder();
		Connection conn=dd.BuildConnection();
	}
}
