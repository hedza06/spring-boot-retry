package com.springboot.retry.services;

import com.springboot.retry.domain.Job;
import com.springboot.retry.exceptions.CustomJobException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ExternalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalService.class);
    private int retryAttempts = 0;

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * Simulating job that fails
     *
     * @throws CustomJobException custom job exception
     */
    @Retryable(value = CustomJobException.class, maxAttempts = 5, backoff = @Backoff(delay = 3000))
    @SuppressWarnings("unused")
    public void jobThatFails() throws CustomJobException
    {
        retryAttempts++;
        LOGGER.error("Service failed. Attempt number: {}", retryAttempts);
        throw new CustomJobException("Error occurred in SQL!", retryAttempts);
    }

    /**
     * Recovering from failed job
     *
     * @param jobException custom job exception
     */
    @Recover
    @SuppressWarnings("unused")
    public void registerFailedJobAndRecover(CustomJobException jobException)
    {
        LOGGER.info("Registering failed job...");
        Job failedJob = registerFailedJobInDatabase(jobException.getMessage(), jobException.getRetryAttempts());
        LOGGER.info("Failed job registered. Data: {}", failedJob);

        LOGGER.info("Recovering from exception...");
        // do something else...
    }

    /**
     * Creating and persisting failed job in database
     *
     * @param message exception message
     * @param retryAttempts number of retry attempts
     * @return persisted Job Object
     */
    private Job registerFailedJobInDatabase(String message, int retryAttempts)
    {
        Job job = new Job();
        job.setExceptionMessage(message);
        job.setNumberOfAttempts(retryAttempts);

        entityManager.persist(job);
        return job;
    }
}
