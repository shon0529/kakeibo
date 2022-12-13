package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.sql.DataSource;

import domain.Item;

public class ItemDaoImpl implements ItemDao {

	  private DataSource ds;

	  public ItemDaoImpl(DataSource ds) {
	    this.ds = ds;
	  }

	@Override
	public List<Item> findAll() throws Exception {
		List<Item> itemList = new ArrayList<>();
		
		try(Connection con = ds.getConnection()){
			
			//findAll文の準備
			String sql = "SELECT * FROM items";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = (Integer) rs.getObject("id");
				String contents = rs.getString("contents");
				Integer price = (Integer) rs.getObject("price");
				Date registered = rs.getTimestamp("registered");
				
				Item item = new Item();
				item.setId(id);
				item.setContents(contents);
				item.setPrice(price);
				item.setRegistered(registered);
				
				itemList.add(item);
			}
			}catch (Exception e) {
				throw new ServletException(e);
			}finally {
				
			}
		return itemList;
	}

	
	@Override
	public void insert(Item item) throws Exception {
		try(Connection con = ds.getConnection()){
			
			//INSERT文の準備（idは自動なので指定しない）
			String sql = "INSERT INTO items(contents, price, registered) VALUES(?, ?, NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, item.getContents());
			stmt.setObject(2, item.getPrice());
			
			stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	
	@Override
	public Item findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void update(Item item) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(Item item) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	protected Item mapToItem(ResultSet rs) throws Exception{
		Item item = new Item();
		item.setId((Integer) rs.getObject("id"));
		item.setContents(rs.getString("contents"));
		item.setPrice((Integer)rs.getObject("price"));
		item.setRegistered(rs.getTimestamp("registered"));
		item.setUpdated(rs.getTimestamp("updated"));
		return item;
	}
}
