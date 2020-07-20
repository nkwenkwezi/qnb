package qa.co.qnb.convertor;

import java.util.UUID;

import qa.co.qnb.domain.Post;
import qa.co.qnb.dto.PostDTO;

public class Convertor {
	public static PostDTO from(Post post) {
		return new PostDTO(post.getUuid(), post.getUserId(), post.getPostId(), post.getTitle(), post.getBody(), post.getDocumentId());
	}

	public static Post to(PostDTO dto) {
		return new Post(UUID.randomUUID().toString(), dto.getUserId(), dto.getId(), dto.getTitle(), dto.getBody(),
				dto.getDocumentId());
	}
}
