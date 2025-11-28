package com.example.BlogApplication.Converters;

import com.example.BlogApplication.Dtos.PostRequest;
import com.example.BlogApplication.Dtos.PostResponse;
import com.example.BlogApplication.Entities.Post;

public class PostConverter {

        public static Post postRequestTopost(PostRequest postRequest){
                Post post = new Post();
                post.setPostContent(postRequest.getPostContent());
                post.setPostTitle(postRequest.getPostTitle());
                return post;
        }


    public static PostResponse postToPostResponse(Post post){
        PostResponse postResponse = new PostResponse();
        postResponse.setPostImage(post.getPostImage());
        postResponse.setPostContent(post.getPostContent());
        postResponse.setPostTitle(post.getPostTitle());
        postResponse.setPostId(post.getPostId());
        postResponse.setUser(post.getUser());
        postResponse.setCategory(post.getCategory());
        return postResponse;
    }
}
