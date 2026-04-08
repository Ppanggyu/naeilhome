package com.spring.naeilhome.board.board_question.dao;

import java.util.List;

import com.spring.naeilhome.board.board_question.domain.QuestionDomain;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionDAO {
	void insertQuestion(QuestionDomain questionDomain);

	// 전체 문의사항 목록 조회
	List<QuestionDomain> selectAllQuestions();

	// 기존 메서드와 함께
	QuestionDomain selectQuestionByNo(int boardQuestionArticleNo);
	
	// 로그인한 사용자만 조회
	List<QuestionDomain> selectQuestionsByWriterId(String writerId);

}
