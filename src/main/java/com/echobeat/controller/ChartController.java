package com.echobeat.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echobeat.model.Chart;
import com.echobeat.repository.ChartInterface;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ChartController {

    @Autowired
    private ChartInterface chartRepository;

    @GetMapping("/charts/{id}")
    public ResponseEntity<Chart> getChartById(@PathVariable("id") long id) {
        Chart chart = chartRepository.findById(id);

        if (chart != null) {
            return new ResponseEntity<>(chart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/charts")
    public ResponseEntity<List<Chart>> getAllCharts(){
        List<Chart> charts = chartRepository.findAll();

        if (charts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(charts, HttpStatus.OK);
        }
    }

    @PostMapping("/charts")
    public ResponseEntity<String> createChart(@RequestBody Chart chart) {
        try {
            chartRepository.save(chart);
            return new ResponseEntity<>("Chart created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/charts/{id}")
    public ResponseEntity<String> updateChart(@PathVariable("id") long id, @RequestBody Chart chart) {
        Chart existingChart = chartRepository.findById(id);

        if (existingChart != null) {
            existingChart.setChart_type(chart.getChart_type());
            existingChart.setChart_id(id);  // Assuming chart_id is already set in the path

            chartRepository.update(existingChart);
            return new ResponseEntity<>("Chart was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find chart with id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/charts/{id}")
    public ResponseEntity<String> deleteChart(@PathVariable("id") long id) {
        int result = chartRepository.deleteById(id);
        if (result > 0) {
            return new ResponseEntity<>("Chart was deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find chart with id=" + id, HttpStatus.NOT_FOUND);
        }
    }
}
