package com.cnwanweb.quickframework.modules.quartz.common;

import java.io.Serializable;
import org.quartz.JobExecutionContext;

public interface FireStateJob extends Serializable {
    boolean onBeforeJob(JobExecutionContext var1);

    void doJob(JobExecutionContext var1);

    void onFinalJob(JobExecutionContext var1);
}
