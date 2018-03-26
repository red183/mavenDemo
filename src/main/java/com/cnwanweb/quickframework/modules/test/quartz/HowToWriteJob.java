package com.cnwanweb.quickframework.modules.test.quartz;

import com.cnwanweb.quickframework.modules.quartz.common.FireStateJob;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by firecnwanweb on 2017/4/6.
 */
public class HowToWriteJob implements FireStateJob {

    private static final Logger logger = LoggerFactory.getLogger(HowToWriteJob.class);

    private int index;

    @Override
    public boolean onBeforeJob(JobExecutionContext jobExecutionContext) {
        index++;
        boolean result = index%2 == 0;
        logger.info("I'm {}, result: {}", index, result);
        return result;
    }

    @Override
    public void doJob(JobExecutionContext jobExecutionContext) {
        logger.info("I'm {}", index);
    }

    @Override
    public void onFinalJob(JobExecutionContext jobExecutionContext) {
        logger.info("I'm {} say GoodBye!", index);
    }
}
