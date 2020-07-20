package qa.co.qnb.service;

import java.util.List;

import qa.co.qnb.dto.PostDTO;

public interface PostService {
	public PostDTO savePost(PostDTO postDTO, String documentId);
	public List<PostDTO> findPostsUsingDocument(String documentId);
	public PostDTO findPost(String postUuid);
}
