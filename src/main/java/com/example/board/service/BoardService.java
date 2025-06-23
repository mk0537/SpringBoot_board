package com.example.board.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.board.dto.BoardDTO;
import com.example.board.model.BoardEntity;
import com.example.board.repository.BoardRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository repository;
	private final BoardDTO dto;

	// 게시글 전체 조회
	public List<BoardDTO> getAllPosts() {
		return repository.findAll().stream()
				.map(BoardDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	// 게시글 추가
	public List<BoardDTO> createPost(BoardDTO dto) {
		BoardEntity entity = BoardDTO.fromDTO(dto);
		repository.save(entity);
		return getAllPosts();
	}
	
	   
	// id를 이용해서 1건 조회
	public BoardDTO getPostById(Long id) {
	    //id에 해당하는 게시물이 존재하는지 찾는다.
	    Optional<BoardEntity> option = repository.findById(id);
	      
	    BoardEntity entity = option.get();
	      
	    return BoardDTO.fromEntity(entity);
	      
	 }
	
	// 삭제하기
	public boolean deletePost(Long id) {
		 //id에 해당하는 게시물이 존재하는지 찾는다.
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
		      
		}
	
	// 수정하기
	public BoardDTO updatePost(Long id, BoardDTO dto) {
		//기존의 내용을 꺼냄
		BoardEntity entity = repository.findById(id).get();

		// 수정한 내용을 Entity에 반영
		entity.setTitle(dto.getTitle());
		entity.setAuthor(dto.getAuthor());
		entity.setContent(dto.getContent());
		
		return BoardDTO.fromEntity(repository.save(entity));
	}
	
	
}







