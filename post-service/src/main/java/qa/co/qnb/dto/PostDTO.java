package qa.co.qnb.dto;

import java.io.Serializable;



public class PostDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uuid;
	private Long userId;
	private Long id;
	private String title;
	private String body;
	private String documentId;
	
	public PostDTO(String uuid, Long userId, Long id, String title, String body, String documentId) {
		super();
		this.uuid = uuid;
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
		this.documentId = documentId;
	}
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	@Override
	public String toString() {
		return "PostDTO [uuid=" + uuid + ", userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body
				+ ", documentId=" + documentId + "]";
	}

	
	
	
}
