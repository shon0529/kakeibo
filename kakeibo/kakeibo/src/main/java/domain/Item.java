package domain;

import java.util.Date;

public class Item {
	
	private Integer id;
	private String contents;
	private Integer price;
	private Date registered;
    private Date updated;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getRegistered() {
		return registered;
	}
	public void setRegistered(Date registered) {
		this.registered = registered;
	}
	public Date getUpdated() {
	    return updated;
	  }

	public void setUpdated(Date updated) {
	    this.updated = updated;
	  }
	
}
