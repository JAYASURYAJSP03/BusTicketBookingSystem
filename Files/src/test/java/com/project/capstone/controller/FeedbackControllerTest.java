package com.project.capstone.controller;

import com.project.capstone.controller.FeedbackController;
import com.project.capstone.entity.Feedback;
import com.project.capstone.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FeedbackControllerTest {

    @InjectMocks
    private FeedbackController feedbackController;

    @Mock
    private FeedbackService feedbackService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFeedbackForm() {
        String viewName = feedbackController.feedbackForm(model);

        assertEquals("FeedbackForm", viewName);
        verify(model).addAttribute(eq("feedback"), any(Feedback.class));
    }

    @Test
    public void testAllFeedbacks() {
        when(feedbackService.getAllFeedbacks()).thenReturn(List.of(new Feedback()));

        String viewName = feedbackController.allFeedbacks(model);

        assertEquals("viewFeedbacks", viewName);
        verify(model).addAttribute(eq("feedbacks"), anyList());
    }
}
