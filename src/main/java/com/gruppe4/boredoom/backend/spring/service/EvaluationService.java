package com.gruppe4.boredoom.backend.spring.service;

import com.gruppe4.boredoom.backend.spring.model.EvaluationData;
import com.gruppe4.boredoom.backend.spring.model.Media;
import com.gruppe4.boredoom.backend.spring.model.MediaResultValue;
import com.gruppe4.boredoom.backend.spring.model.ResultValue;
import com.gruppe4.boredoom.backend.spring.model.enums.ActivityType;
import com.gruppe4.boredoom.backend.spring.model.enums.Setting;
import com.gruppe4.boredoom.backend.spring.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EvaluationService {

    private final QuestionRepository questionRepository;

    public EvaluationService(QuestionRepository questionRepository) {this.questionRepository = questionRepository;}

    public List<Media> getResult(List<EvaluationData> evaluationDataList) {

        Map<String, Map<String, Double>> evaluationMap = new HashMap<>();

        for (EvaluationData evaluationData : evaluationDataList) {
            if (evaluationMap.containsKey(evaluationData.))

        }

        return Collections.emptyList();
    }

    protected List<MediaResultValue> evaluateByEvaluationMap(Map<String, Map<String, Double>> evaluationMap, List<Media> allMedia) {
        double totalWeight = getTotalWeight(evaluationMap);

        List<ResultValue> allResults = new ArrayList<>();

        for (Map.Entry<String, Map<String, Double>> evaluationEntry : evaluationMap.entrySet()) {
            List<ResultValue> resultValues = getResultsForEvaluationType(evaluationEntry.getKey(), allMedia,
                    evaluationEntry.getValue());
            allResults.addAll(resultValues);
        }

        return getWeightedListForMatchingMedia(allResults, totalWeight, 5);
    }

    protected List<MediaResultValue> getWeightedListForMatchingMedia(List<ResultValue> resultValues, double totalWeight,
            int maxResults) {
        List<MediaResultValue> allMediaResultValues = getAllMatchingMedia(resultValues);
        return new EvaluationAlgorithm().evaluateResultValueList(allMediaResultValues, maxResults);
    }

    protected List<MediaResultValue> getAllMatchingMedia(List<ResultValue> resultValues) {
        List<MediaResultValue> allMediaResultValues = new ArrayList<>();

        for (ResultValue resultValue : resultValues) {

            for (Media media : resultValue.getResults()) {
                MediaResultValue newMrv = new MediaResultValue(media, resultValue.getWeight());

                addMediaResultValue(allMediaResultValues, newMrv);
            }
        }

        return allMediaResultValues;
    }

    protected void addMediaResultValue(List<MediaResultValue> list, MediaResultValue mrv) {
        boolean exists = false;

        for (MediaResultValue existingMrv : list) {
            if (existingMrv.equals(mrv)) {
                existingMrv.setWeight(existingMrv.getWeight() + mrv.getWeight());
                exists = true;
            }
        }

        if (!exists) {
            list.add(mrv);
        }
    }

    protected double getTotalWeight(Map<String, Map<String, Double>> evaluationMap) {
        double weight = 0;
        for (Map.Entry<String, Map<String, Double>> evaluationEntry : evaluationMap.entrySet()) {
            for (Map.Entry<String, Double> entry : evaluationEntry.getValue().entrySet()) {
                weight = weight + entry.getValue();
            }
        }
        return weight;
    }

    protected List<ResultValue> getResultsForEvaluationType(String evaluationType, List<Media> allMedia,
            Map<String, Double> evaluationValues) {
        List<ResultValue> resultValues = new ArrayList<>();

        for (Map.Entry<String, Double> evaluationValue : evaluationValues.entrySet()) {
            ResultValue resultValue = new ResultValue();
            resultValue.setName(evaluationValue.getKey());
            resultValue.setWeight(evaluationValue.getValue());
            resultValue.setResults(getResultsForEvaluationValue(allMedia, evaluationType, evaluationValue.getKey()));
            resultValues.add(resultValue);
        }

        return resultValues;
    }

    protected List<Media> getResultsForEvaluationValue(List<Media> allMedia, String evaluationType, String evaluationValue) {

        if (evaluationType.equals("ActivityType")) {
            return getResultsForActivityType(allMedia, evaluationValue);
        } else if (evaluationType.equals("Setting")) {
            return getResultsForSetting(allMedia, evaluationValue);
        }

        return null;
    }

    protected List<Media> getResultsForActivityType(List<Media> allMedia, String evaluationValue) {
        List<Media> results = new ArrayList<>();
        for (Media media : allMedia) {
            for (ActivityType activityType : media.getActivityTypes()) {
                if (activityType.equals(ActivityType.fromString(evaluationValue))) {
                    results.add(media);
                }
            }
        }
        return results;
    }

    protected List<Media> getResultsForSetting(List<Media> allMedia, String evaluationValue) {
        List<Media> results = new ArrayList<>();

        for (Media media : allMedia) {
            if (media.getSetting().equals(Setting.fromString(evaluationValue))) {
                results.add(media);
            }
        }

        return results;
    }
}
