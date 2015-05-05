package dao;

import javax.persistence.Entity;

@Entity
public class QueryItem {
	public String id, title, text;

	public QueryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueryItem(String id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("id:\t").append(this.id).append("\n").
		append("title:\t").append(title).append("\n").
		append("text:\t").append(this.text).append("\n");
		
		return s.toString();
	}
	

}
