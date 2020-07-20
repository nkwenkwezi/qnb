package qa.co.qnb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import qa.co.qnb.domain.Post;
public interface PostRepository extends JpaRepository<Post, String>{
	public Optional<List<Post>> findPostByDocumentId(String documentId);
	
}
