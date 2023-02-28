package com.example.veridic.response;

import com.example.veridic.model.Station;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationListResponse {
    private List<Station> data;
    private HttpStatus statusCode;
    private String message;
}
