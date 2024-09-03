package com.dboaz.utils.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * RedirectController is responsible for handling requests to specific base paths
 * and redirecting them to a desired target URL.
 *
 * <p>This controller is currently configured to redirect requests from the root path ("/")
 * and any path starting with "/swagger" to "/docs/swagger". The redirection modifies
 * the path in the browser, ensuring that the user is guided to the correct documentation page.
 *
 * <p>You can easily extend this class to handle other global redirects across your application.
 * Simply add more methods with {@link GetMapping} annotations that specify different source paths
 * and customize the {@link RedirectView} to point to different target URLs.
 *
 * Example usage:
 * <pre>
 * &#64;GetMapping("/old-page")
 * public RedirectView redirectToNewPage() {
 *     return new RedirectView("/new-page", true);
 * }
 * </pre>
 *
 * This approach centralizes the redirection logic, making it easy to manage all redirects
 * from a single location.
 *
 * @author Gustavo
 * @version 1.0.0
 * @since 2024-09-03
 */
@RestController
public class RedirectController {

    /**
     * Redirects requests to the root path ("/") or any path starting with "/swagger"
     * to the "/docs/swagger" page.
     *
     * <p>This redirection modifies the path in the browser to guide users to the correct
     * documentation page.
     *
     * @return a {@link RedirectView} that redirects the user to "/docs/swagger"
     */
    @GetMapping({ "/", "/swagger", "/docs"})
    public RedirectView redirectToSwagger() {
        return new RedirectView("/docs/swagger", true);
    }
}
