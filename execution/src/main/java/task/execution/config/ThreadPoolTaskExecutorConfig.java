package task.execution.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class ThreadPoolTaskExecutorConfig {

    @Value("${async_config.max_pool_size}")
    private int maxThreadPoolSize;

    @Value("${async_config.core_pool_size}")
    private int coreThreadPoolSize;

    @Value("${async_config.queue_capacity}")
    private int queueCapacity;

    @Value("${async_config.thread_name_prefix}")
    private String threadNamePrefix;

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(coreThreadPoolSize);
        executor.setMaxPoolSize(maxThreadPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        return executor;
    }
}
