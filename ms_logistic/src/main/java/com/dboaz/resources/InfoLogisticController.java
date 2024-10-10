package com.dboaz.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dboaz.ms_logistic.utils.constants.Route;
import com.dboaz.utils.models.GlobalInfo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Info")
@RestController
public class InfoLogisticController {

    private static final Logger LOG = LoggerFactory.getLogger(InfoLogisticController.class);

    @Value("${microservice.ms_logistic.name}") String name;
    @Value("${microservice.ms_logistic.version}") String version;
    @Value("${microservice.ms_logistic.description}") String description;

    @Operation(description = "Provide custom server info", responses = {
        @ApiResponse(responseCode = "200", description = "retrieve global info api", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalInfo.class))
        }),
    })
    @GetMapping(path = Route.GET_INFO)
    public ResponseEntity<GlobalInfo> getInfo() {
        var result = GlobalInfo.builder().name(name).version(version).description(description).build();

        LOG.debug(result.toString());
        return ResponseEntity.ok(result);
    }
}
