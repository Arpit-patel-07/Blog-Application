//package com.example.BlogApplication.Controllers;
//
//import com.example.BlogApplication.Dtos.CommentRequest;
//import com.example.BlogApplication.Dtos.CommentResponse;
//import com.example.BlogApplication.Services.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/Comment")
//public class CommentController {
//
//        @Autowired
//        private CommentService commentService;
//
//        @PostMapping("/create")
//        public ResponseEntity<CommentResponse> createComment(@RequestBody CommentRequest commentRequest){
//            CommentResponse commentResponse = commentService.createComment(commentRequest);
//            return new ResponseEntity<>(commentResponse,HttpStatus.CREATED);
//        }
//}
