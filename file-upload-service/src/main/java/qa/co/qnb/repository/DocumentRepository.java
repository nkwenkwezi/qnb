package qa.co.qnb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.co.qnb.domain.Document;

public interface DocumentRepository extends JpaRepository<Document, String> {
	public Optional<Document> findDocumentByUuidAndStatus(String fileUuid,boolean status);
	public Optional<Document> findDocumentByFileNameAndStatus(String fileName,boolean status);
	public Optional<List<Document>> findDocumentByUserUuidAndStatus(String userUuid,boolean status);
	public Optional<Document> findDocumentByUserUuidAndFileNameAndStatus(String userUuid,String fileName,boolean status);
	
}