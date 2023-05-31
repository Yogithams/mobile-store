package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Mobile;

public class MobileCRUD {

	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String url = "jdbc:mysql://localhost:3306/mobile_store";
	final static String user = "root";
	final static String password = "radha1";

	public static int insertmobile(Mobile m) {

		Connection c = null;
		String query = "insert into mobile values(?,?,?,?)";
		try {
			Class.forName(path);
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);

			ps.setInt(1, m.getId());
			ps.setString(2, m.getName());
			ps.setString(3, m.getBrand());
			ps.setDouble(4, m.getPrice());
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0;
	}

	public static Mobile getmobilebyid(int id) {

		Connection c = null;
		String query = "select * from mobile where id =?";
		try {
			Class.forName(path);
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Mobile m = new Mobile();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setPrice(rs.getDouble(4));
				return m;
			} else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	public static int deletemobile(int id) {
		Connection c = null;
		String query = "delete from mobile where id = ?";
		try {
			Class.forName(path);
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	public static ArrayList<Mobile> getAllMobiles() {
		ArrayList<Mobile> al = new ArrayList<Mobile>();
		Connection c = null;
		String query = "select * from mobile";
		try {
			Class.forName(path);
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mobile m = new Mobile();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setPrice(rs.getDouble(4));
				al.add(m);
			}
			return al;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}

	public ArrayList<Mobile> getMobilebyBrand(String brand) {
		ArrayList<Mobile> al = new ArrayList<Mobile>();
		Connection c = null;
		String query = "select * from mobile where brand=?";

		try {
			Class.forName(path);
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, brand);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Mobile m = new Mobile();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setPrice(rs.getDouble(4));
				al.add(m);
			}
			return al;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return al;
	}

	public static int updateMobilebyId(int id, Mobile m) {
		Connection c = null;
		String query = "update mobile set name=?,brand=?,price=? where id =?";

		try {
			Class.forName(path);
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, m.getName());
			ps.setString(2, m.getBrand());
			ps.setDouble(3, m.getPrice());
			ps.setInt(4, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}
	
	public static int[] BatchExecution(ArrayList<Mobile> mobile) {
		Connection c = null;
		String query = "insert into mobile values(?,?,?,?)";
		
		try {
			Class.forName(path);
			c=DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			for(Mobile m :mobile) {
				ps.setInt(1, m.getId());
				ps.setString(2, m.getName());
				ps.setString(3, m.getBrand());
				ps.setDouble(4, m.getPrice());
				ps.addBatch();
			}
			return ps.executeBatch();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
		
		
	}
	
	 public static int[] deletebyBatchExecution(int[] arr) {
	    	Connection c =null;
	    	String query = "delete from mobile where id =?";
	    	
	    	try {
				Class.forName(path);
				c=DriverManager.getConnection(url, user, password);
				PreparedStatement ps = c.prepareStatement(query);
				
				for(int id:arr) {
					ps.setInt(1, id);
					ps.addBatch();
				}
				
				return ps.executeBatch();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	finally {
	    		try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
			return null;
	    	
	    }
	

}
