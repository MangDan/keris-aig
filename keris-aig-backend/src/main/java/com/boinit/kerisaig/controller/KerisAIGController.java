package com.boinit.kerisaig.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.boinit.kerisaig.jpa.GradeUnitRepository;
import com.boinit.kerisaig.jpa.LearningObjectiveRepository;
import com.boinit.kerisaig.jpa.ModelDownloadRepository;
import com.boinit.kerisaig.jpa.QuestionRepository;
import com.boinit.kerisaig.repository.entity.GradeUnit;
import com.boinit.kerisaig.repository.entity.LearningObjective;
import com.boinit.kerisaig.repository.entity.ModelDownload;
import com.boinit.kerisaig.repository.entity.Question;
import com.boinit.kerisaig.service.QuestionConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@CrossOrigin("*")
public class KerisAIGController {

    @Autowired
    QuestionConsumer questionConsumerService;

    @Autowired
    GradeUnitRepository gradeUnitRepository;

    @Autowired
    LearningObjectiveRepository learningObjectiveRepository;

    @Autowired
    QuestionRepository questionsRepository;

    @Autowired
    ModelDownloadRepository modelDownloadRepository;

    Logger logger = LoggerFactory.getLogger(KerisAIGController.class);

    @RequestMapping(value = "/api/v1/kerisaig/query/gradeunit", method = RequestMethod.GET)
    public List<GradeUnit> queryGradeUnit() throws Exception {
        List<GradeUnit> gradeUnit = gradeUnitRepository.findAll();
        return gradeUnit;
    }

    @RequestMapping(value = "/api/v1/kerisaig/query/learningobjective/{guno}", method = RequestMethod.GET)
    public Page<LearningObjective> queryLearningObjectives(Pageable pageable, @PathVariable(value = "guno") int guno)
            throws Exception {
        Page<LearningObjective> learningObjective = learningObjectiveRepository.findByGuno(pageable, guno);
        return learningObjective;
    }

    @RequestMapping(value = "/api/v1/kerisaig/query/question/{lbno}", method = RequestMethod.GET)
    public Page<Question> queryQuestions(Pageable pageable, @PathVariable(value = "lbno") int lbno) throws Exception {
        Page<Question> sampleQuestions = questionsRepository.findByLbno(pageable, lbno);
        return sampleQuestions;
    }

    @RequestMapping(value = "/api/v1/kerisaig/question/{qsno}", method = RequestMethod.GET)
    public Optional<Question> findQuestion(Pageable pageable, @PathVariable(value = "qsno") int qsno) throws Exception {
        Optional<Question> questions = questionsRepository.findByQsno(qsno);
        return questions;
    }

    @RequestMapping(value = "/api/v1/kerisaig/question/detection", method = RequestMethod.POST)
    public Optional<Question> detectionQuestion(@RequestBody Question question) throws Exception {
        logger.info(question.getBodyext()); // field이름과 같아야 한다.
        // Optional<Question> questions = questionsRepository.findByQsno(qsno);

        questionConsumerService.detectionQuestion(question);
        return null;
    }

    @RequestMapping(value = "/api/v1/kerisaig/question/generation", method = RequestMethod.POST)
    public Optional<Question> generationQuestion(@RequestBody Question question) throws Exception {
        // Optional<Question> questions = questionsRepository.findByQsno(qsno);
        return null;
    }

    @RequestMapping(value = "/api/v1/kerisaig/history/model/download", method = RequestMethod.POST)
    public List<ModelDownload> historyModelDownload(String[] modelid) throws Exception {
        if (modelid.length <= 0) {
            return null;
        }

        List<ModelDownload> results = new ArrayList<ModelDownload>();
        for (String mid : modelid) {
            logger.info(mid);

            ModelDownload instance = null;
            Optional<ModelDownload> optionalPost = modelDownloadRepository.findByModelID(mid);
            if (optionalPost.isPresent()) {
                instance = optionalPost.get();
                instance.setDownloadCount(instance.getDownloadCount() + 1);
            } else {
                instance = new ModelDownload();
                instance.setModelID(mid);
                instance.setDownloadCount(1);
            }

            modelDownloadRepository.save(instance);
            logger.info(instance.getModelID() + " : " + instance.getDownloadCount());
            results.add(instance);
        }

        return results;
    }

    public static void main(String[] args) {
        SpringApplication.run(KerisAIGController.class, args);
    }
}