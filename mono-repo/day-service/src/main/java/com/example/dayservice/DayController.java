package com.example.dayservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/day")
@Tag(name = "Day", description = "Endpoints for retrieving the current day of the week")
public class DayController {

    @GetMapping
    @Operation(
        summary = "Get current day of week",
        description = "Returns the current day of the week along with the full date",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Current day returned successfully",
                content = @Content(schema = @Schema(implementation = Map.class))
            )
        }
    )
    public ResponseEntity<Map<String, String>> getCurrentDay() {
        LocalDate today = LocalDate.now();
        return ResponseEntity.ok(Map.of(
            "dayOfWeek",   today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH),
            "dayOfWeekShort", today.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH),
            "date",        today.toString()
        ));
    }
}
