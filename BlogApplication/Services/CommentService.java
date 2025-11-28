//package com.example.BlogApplication.Services;
//
//import com.example.BlogApplication.Converters.CommentConverter;
//import com.example.BlogApplication.Dtos.CommentRequest;
//import com.example.BlogApplication.Dtos.CommentResponse;
//import com.example.BlogApplication.Entities.Comment;
//import com.example.BlogApplication.Exception.ResourceNotFoundException;
//import com.example.BlogApplication.Repositories.CommentRepositorie;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.Optional;
//
//@Service
//public class CommentService {
//
//    @Autowired
//    private CommentRepositorie commentRepositorie;
//
//    public CommentResponse createComment(CommentRequest commentRequest){
//        Comment comment = CommentConverter.commentRequestToComment(commentRequest);
//        return CommentConverter.commentToCommentResponse(commentRepositorie.save(comment));
//    }
//
//    public String updateComment(String comment, int commentId){
//
//        Optional<Comment> optionalComment = commentRepositorie.findById(commentId);
//
//        if(optionalComment.isEmpty()){
//            throw new ResourceNotFoundException("comment not found");
//        }
//        Comment previusComment = optionalComment.get();
//        previusComment.setComment(comment);
//        Comment savaComment = commentRepositorie.save(previusComment);
//        CommentResponse commentResponse = CommentConverter.commentToCommentResponse(savaComment);
//        return
//    }
//
//    public CommentResponse getAllCommentByPostId(int postId){
//        Comment comment = CommentConverter.commentRequestToComment(commentRequest);
//        return CommentConverter.commentToCommentResponse(commentRepositorie.save(comment));
//    }
//
//
//    public CommentResponse deleteComment(int commentId){
//        Comment comment = CommentConverter.commentRequestToComment(commentRequest);
//        return CommentConverter.commentToCommentResponse(commentRepositorie.save(comment));
//    }
//}
//
