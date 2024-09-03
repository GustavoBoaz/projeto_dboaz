package com.dboaz.unit.utils.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dboaz.utils.resources.RedirectController;

class RedirectControllerTest {
    
    @Test
    public void testRedirectToSwagger() {
        // Arrange
        var controller = new RedirectController();
        
        // Action
        var redirectView = controller.redirectToSwagger();
        
        // Assert
        assertEquals("/docs/swagger", redirectView.getUrl(), "URL should redirect to /docs/swagger");
    }
}
