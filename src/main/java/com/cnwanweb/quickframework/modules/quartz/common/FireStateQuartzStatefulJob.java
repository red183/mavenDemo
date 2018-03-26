package com.cnwanweb.quickframework.modules.quartz.common;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * @author chenwy@china.kjlink.com
 *
 */
public class FireStateQuartzStatefulJob extends QuartzJobBean implements StatefulJob {

    private static final Logger logger = LoggerFactory.getLogger(FireStateQuartzStatefulJob.class);

    private String beanName;

    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        final String beanName = getBeanName();
        FireJobUtils.executeInternalState(context, beanName);
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}