I created 5 services and they all work together 
	
-zuul-service - acts as a proxy for the other services. it is responsible for routing traffic to the relevant service. zuul service obtains route information from eureka-service 
	
-eureka-service - this service acts as a registry for service discovery, on start up a service registers itself with eureka-service so that zuul-service can be able to route traffic to correct destination 

-file-upload-service - service for uploading documents

-post-service - service for consuming posts from a 3rd party service, and associate a post with a document uploaded above.


-comment-service - service for consuming comments from a 3rd party service and associate the comment with the posts created above

available endpoints

	file-upload-service
			endpoint to upload	= http://localhost:8081/api/file-upload-service/uploadDocument
			endpoint to view = 	http://localhost:8081/api/file-upload-service/viewDocuments/user/
			endpoint to download = http://localhost:8081/api/file-upload-service/downloadDocument/user
			endpoint to delete =  http://localhost:8081/api/file-upload-service//deleteDocument/user/

	 post-service 

	 	endpoint to consume posts =	http://localhost:8081/api/post-service/userPosts/user/
	 	endpoint to view post = http://localhost:8081/api/post-service/userPost/post/
	 	endpoint to view post by document = http://localhost:8081/api/post-service/documentPosts/document/


	 comment-service 

	 	endpoint to consume comments =	http://localhost:8081/api/comment-service/userComments/post/
	 	endpoint to view by id = http://localhost:8081/api/comment-service/userComment/comment/
