package qa.co.qnb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import qa.co.qnb.client.CommentClient;
import qa.co.qnb.constants.Constants;
import qa.co.qnb.dto.CommentDTO;
import qa.co.qnb.exception.CommentNotFoundException;
import qa.co.qnb.service.CommentService;

@RestController
public class CommentsController {
	@Autowired
	private CommentClient commentClient;
	@Autowired
	private CommentService commentService;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);
	
	@GetMapping( value ="/userComments/post/{postId}")
	public ResponseEntity<List<CommentDTO>> userComments(@PathVariable("postId")long postId){
		List<CommentDTO> list = commentClient.findComments(postId);
		logger.info("list {}", list);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<CommentDTO>>(list.stream().map(c -> commentService.saveComment(c)).collect(Collectors.toList()),HttpStatus.OK);
		} else {
			throw new CommentNotFoundException(Constants.COMMENT_NOT_FOUND);
		}
	}
	@GetMapping(value ="/userComment/comment/{commentUuid}")
	public ResponseEntity<CommentDTO> userComment(@PathVariable("commentUuid")String commentUuid){
		return new ResponseEntity<CommentDTO>(commentService.findComment(commentUuid), HttpStatus.OK);
	}

}
