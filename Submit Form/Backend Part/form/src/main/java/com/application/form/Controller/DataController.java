package com.application.form.Controller;

import com.application.form.entity.Data;
import com.application.form.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @PostMapping
    public Data createData(@RequestBody Data data) {
        return dataRepository.save(data);
    }
}
