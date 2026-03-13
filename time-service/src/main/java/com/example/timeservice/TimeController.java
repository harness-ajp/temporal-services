package com.example.timeservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/api/time")
@Tag(name = "Time", description = "Endpoints for retrieving the current time")
public class TimeController {

    @GetMapping
    @Operation(
        summary = "Get current time",
        description = "Returns the current UTC date and time in ISO-8601 format",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Current time returned successfully",
                content = @Content(schema = @Schema(implementation = Map.class))
            )
        }
    )
    public ResponseEntity<Map<String, String>> getCurrentTime() {
        ZonedDateTime now = ZonedDateTime.now();
        return ResponseEntity.ok(Map.of(
            "timestamp", now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
            "timezone",  now.getZone().getId()
        ));
    }
}
