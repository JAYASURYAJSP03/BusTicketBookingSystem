package com.project.capstone.service;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.project.capstone.entity.Feedback;
import com.project.capstone.repository.FeedbackRepository;
import com.project.capstone.service.impl.FeedbackServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class FeedbackServiceImplTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

    @Test
    void testGetAllFeedbacks() {
        Feedback feedback1 = new Feedback(1L, "Good service!");
        Feedback feedback2 = new Feedback(2L, "Could be improved.");
        List<Feedback> feedbackList = Arrays.asList(feedback1, feedback2);

        when(feedbackRepository.findAll()).thenReturn(feedbackList);

        List<Feedback> result = feedbackService.getAllFeedbacks();
        assertEquals(2, result.size());
    }

    @Test
    void testSaveFeedback() {
        Feedback feedback = new Feedback(1L, "Great experience!");

        feedbackService.saveFeedback(feedback);

        verify(feedbackRepository, times(1)).save(feedback);
    }
}
