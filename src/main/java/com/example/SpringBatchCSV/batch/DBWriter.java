package com.example.SpringBatchCSV.batch;

import com.example.SpringBatchCSV.entity.User;
import com.example.SpringBatchCSV.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Component
@Slf4j
public class DBWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void write(List<? extends User> users) throws Exception {
        log.info("[START] write users to database");

        userRepository.saveAll(users);

        log.info("[END] write users to database");
    }

}
