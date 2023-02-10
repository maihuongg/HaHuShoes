package HaHuShoes.Model;

public class CommentModel {
	
//	[id] [int] IDENTITY(1,1) NOT NULL,
//	[review] [nvarchar] (500) NULL,
//	[name] [nvarchar] (100) NULL,
//	[email] [nvarchar] (100) NULL,
	
	private int id;
	private String review;
	private String name;
	private String email;

	
	public CommentModel() {
		super();
	}
	
	
	public CommentModel(int id, String review, String name, String email) {
		super();
		this.id = id;
		this.review = review;
		this.name = name;
		this.email = email;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
