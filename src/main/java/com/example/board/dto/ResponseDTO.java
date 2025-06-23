package com.example.board.dto;

import java.util.List;

import com.example.board.model.BoardEntity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDTO<T> {
	private String error;
	private List<T> data;
}
