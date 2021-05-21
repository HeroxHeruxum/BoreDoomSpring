package com.gruppe4.boredoom.backend.spring.service;

import com.gruppe4.boredoom.backend.spring.model.MediaResultValue;

import java.util.Comparator;
import java.util.List;

public class EvaluationAlgorithm {

    protected List<MediaResultValue> evaluateResultValueList(List<MediaResultValue> allMediaResults, int maxMediaResults) {

        allMediaResults.sort(new Comparator<MediaResultValue>() {
            @Override
            public int compare(MediaResultValue t1, MediaResultValue t2) {
                if (t1.getWeight() == t2.getWeight()) {
                    return 0;
                } else {
                    return t1.getWeight() < t2.getWeight() ? 1 : -1;
                }
            }
        });

        if (maxMediaResults > allMediaResults.size()) {
            maxMediaResults = allMediaResults.size();
        }

        return allMediaResults.subList(0, maxMediaResults);

    }
}
