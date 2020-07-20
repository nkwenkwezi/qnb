package qa.co.qnb.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tblPost")
public class Post {
	@Id
	@Column(name ="uuid", nullable = false)
	private String uuid = UUID.randomUUID().toString();
	@Column(name ="user_id", nullable = false)
	private Long userId;
	@Column(name ="post_id", nullable = false)
	private Long postId;
	@Column(name ="title", nullable = false)
	private String title;
	@Column(name ="body", nullable = false)
	private String body;
	@Column(name ="document_id", nullable = true)
	private String documentId;
	
	public Post() {
		
	}
	
	public Post(String uuid, Long userId, Long postId, String title, String body, String documentId) {
		super();
		this.uuid = uuid;
		this.userId = userId;
		this.postId = postId;
		this.title = title;
		this.body = body;
		this.documentId = documentId;
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long id) {
		this.postId = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	@Override
	public String toString() {
		return "Post [uuid=" + uuid + ", userId=" + userId + ", id=" + postId + ", title=" + title + ", body=" + body
				+ ", documentId=" + documentId + "]";
	}
	
	
	
	
	

}
