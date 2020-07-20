
package qa.co.qnb.dto;

import java.io.Serializable;


public class CommentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private Long postId;
	private Long id;
	private String name;
	private String email;
	private String body;	
	
	

	public CommentDTO(String uuid,Long postId, Long id, String name, String email, String body) {
		super();
		this.uuid = uuid;
		this.postId = postId;
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
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
	

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "CommentDTO [postId=" + postId + ", id=" + id + ", name=" + name + ", email=" + email + ", body=" + body
				+ "]";
	}
	
}