package com.example.board.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.model.BoardEntity;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long>{
	Optional<BoardEntity> findById(Long id);
}
