package qa.co.qnb.convertor;

import java.util.UUID;

import qa.co.qnb.domain.Comment;
import qa.co.qnb.dto.CommentDTO;

public class Convertor {
	public static CommentDTO from(Comment comment) {
		return new CommentDTO(comment.getUuid(),comment.getPostId(),comment.getId(),comment.getName(),comment.getEmail(),comment.getBody());
		
	}
	
	public static Comment to(CommentDTO dto) {
		return new Comment(UUID.randomUUID().toString(),dto.getPostId(),dto.getId(),dto.getName(),dto.getEmail(),dto.getBody());
	}
}
