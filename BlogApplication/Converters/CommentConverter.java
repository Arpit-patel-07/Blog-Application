package com.example.BlogApplication.Converters;


import com.example.BlogApplication.Dtos.CommentRequest;
import com.example.BlogApplication.Dtos.CommentResponse;
import com.example.BlogApplication.Entities.Comment;

public class CommentConverter {

        public static Comment commentRequestToComment(CommentRequest commentRequest){
            Comment comment = new Comment();
            comment.setComment(commentRequest.getComment());
            return comment;
        }

        public static CommentResponse commentToCommentResponse(Comment comment){
            CommentResponse commentResponse = new CommentResponse();
            commentResponse.setComment(comment.getComment());
            commentResponse.setPost(comment.getPost());
            commentResponse.setUser(comment.getUser());
            return commentResponse;
        }
}