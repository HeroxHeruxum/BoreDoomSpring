package com.gruppe4.boredoom.backend.spring.service;

import com.gruppe4.boredoom.backend.spring.model.EvaluationData;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.Question;
import com.gruppe4.boredoom.backend.spring.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EvaluationService {

    private final QuestionRepository questionRepository;

    public EvaluationService(QuestionRepository questionRepository) {this.questionRepository = questionRepository;}

    public List<Media> getResult(List<EvaluationData> evaluationDataList) {

        for (EvaluationData evaluationData : evaluationDataList) {
            Question question = questionRepository.findQuestionById(evaluationData.getQuestionId()); // implement

        }

        return Collections.emptyList();
    }
}
