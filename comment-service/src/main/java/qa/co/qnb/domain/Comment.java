package qa.co.qnb.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tblComment")
public class Comment {
	@Id
	@Column(name ="uuid", nullable=false)
	private String uuid = UUID.randomUUID().toString();
	private Long postId;
	private Long id;
	private String name;
	private String email;
	private String body;
	
	public Comment() {
		
	}
	
	public Comment(String uuid, Long postId, Long id, String name, String email, String body) {
		super();
		this.uuid = uuid;
		this.postId = postId;
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}	
	
	
	
}
