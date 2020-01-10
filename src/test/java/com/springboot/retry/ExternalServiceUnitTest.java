package com.springboot.retry;

import com.springboot.retry.exceptions.CustomJobException;
import com.springboot.retry.services.ExternalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = RetryApplication.class)
@RunWith(SpringRunner.class)
public class ExternalServiceUnitTest {

    @Autowired
    private ExternalService externalService;

    @Test
    @Transactional
    public void failedJobTest() throws CustomJobException {
        externalService.jobThatFails();
    }
}
