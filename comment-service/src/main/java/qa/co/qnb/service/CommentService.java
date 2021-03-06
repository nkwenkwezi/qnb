package qa.co.qnb.service;

import java.util.List;

import qa.co.qnb.dto.CommentDTO;

public interface CommentService {
	public CommentDTO saveComment(CommentDTO commentDTO);
	public List<CommentDTO> findComments(long postId);
	public CommentDTO findComment(String commentUuid);

}
