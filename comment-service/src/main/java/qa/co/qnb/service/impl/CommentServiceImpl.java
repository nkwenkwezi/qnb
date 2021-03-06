package qa.co.qnb.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qa.co.qnb.constants.Constants;
import qa.co.qnb.convertor.Convertor;
import qa.co.qnb.domain.Comment;
import qa.co.qnb.dto.CommentDTO;
import qa.co.qnb.exception.CommentNotFoundException;
import qa.co.qnb.repository.CommentRepository;
import qa.co.qnb.service.CommentService;

@Transactional
@Service
public class CommentServiceImpl implements CommentService{
	private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);
	@Autowired
	private CommentRepository commentRepository;
	
	public CommentDTO saveComment(CommentDTO commentDTO) {
		logger.info("comment {}", commentDTO);
		Comment comment = commentRepository.save(Convertor.to(commentDTO));
		return Convertor.from(comment);
	}
	public List<CommentDTO> findComments(long postId){
		Optional<List<Comment>> comments = commentRepository.findCommentByPostId(postId);
		if (comments.isPresent() ) {
			return comments.get().stream().map(c -> new CommentDTO(c.getUuid(),postId, c.getId(), c.getName(), c.getEmail(), c.getBody())).collect(Collectors.toList());
		} else {
			throw new CommentNotFoundException(Constants.COMMENT_NOT_FOUND);
		}
	}
	public CommentDTO findComment(String commentUuid) {
		Comment comment = commentRepository.getOne(commentUuid);
		if(comment == null) {
			throw new CommentNotFoundException(Constants.COMMENT_NOT_FOUND);
		}
		return Convertor.from(comment);
	}
	
}

