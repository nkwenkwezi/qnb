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

import qa.co.qnb.client.PostClient;
import qa.co.qnb.constants.Constants;
import qa.co.qnb.dto.PostDTO;
import qa.co.qnb.exception.PostNotFoundException;
import qa.co.qnb.service.PostService;

@RestController
public class PostController {
	@Autowired
	private PostClient postClient;
	@Autowired
	private PostService postService;
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@GetMapping(value = "/userPosts/user/{userId}/document/{documentId}")
	public ResponseEntity<List<PostDTO>> userPosts(@PathVariable("userId") long userId,
			@PathVariable("documentId") String documentId) {
		List<PostDTO> list = postClient.findPosts(userId);
		logger.info("list {}", list);
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<PostDTO>>(
					list.stream().map(s -> postService.savePost(s, documentId)).collect(Collectors.toList()),
					HttpStatus.OK);
		} else {
			throw new PostNotFoundException(Constants.POST_NOT_FOUND);
		}
	}
	@GetMapping(value ="/userPost/post/{postUuid}")
	public ResponseEntity<PostDTO> userPost(@PathVariable("postUuid") String postUuid) {
		logger.info("postUuid {}", postUuid);
		return new ResponseEntity<PostDTO>(postService.findPost(postUuid), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/documentPosts/document/{documentId}")
	public ResponseEntity<List<PostDTO>> documentPosts(@PathVariable("documentId")String documentId) {
		return new ResponseEntity<List<PostDTO>>(postService.findPostsUsingDocument(documentId),HttpStatus.OK);
	}
}
