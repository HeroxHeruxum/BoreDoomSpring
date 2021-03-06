package com.gruppe4.boredoom.backend.spring.controller;

import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.MediaResultValue;
import com.gruppe4.boredoom.backend.spring.model.UserAnswer;
import com.gruppe4.boredoom.backend.spring.service.EvaluationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("/getResultData")
    public List<MediaResultValue> getMediaResultData(@RequestBody List<UserAnswer> userAnswers) {

        return evaluationService.getMediaResultData(userAnswers);
    }

    @PostMapping("/getResults")
    public List<Media> getResults(@RequestBody List<UserAnswer> userAnswers) {

        return evaluationService.getResults(userAnswers);
    }

}
