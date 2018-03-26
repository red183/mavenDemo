package com.cnwanweb.quickframework.modules.quartz.common;

import com.cnwanweb.quickframework.common.utils.SpringContextHolder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by firecnwanweb on 2017/4/6.
 */
public class FireJobUtils {

    private static final Logger logger = LoggerFactory.getLogger(FireJobUtils.class);

    public static void executeInternal(JobExecutionContext context, String beanName) throws JobExecutionException {
        String triggerName = context.getTrigger().getKey().getName();
        logger.debug("start triggerName: {}", triggerName);
        try {
            FireJob fireJob = null;
            logger.debug("start: {}", beanName);
            fireJob = SpringContextHolder.getBean(beanName);
            fireJob.doJob();
            logger.debug("end: {}", beanName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new JobExecutionException(e);
        } finally {
            logger.debug("finally triggerName: {}", triggerName);
        }
    }

    public static void executeInternalState(JobExecutionContext context, String beanName) throws JobExecutionException {
        String triggerName = context.getTrigger().getKey().getName();
        logger.debug("start triggerName: {}", triggerName);
        FireStateJob fireJob = null;
        try {
            logger.debug("before: {}", beanName);
            fireJob = SpringContextHolder.getBean(beanName);
            if(fireJob.onBeforeJob(context)) {
                logger.debug("start: {}", beanName);
                fireJob.doJob(context);
                logger.debug("end: {}", beanName);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new JobExecutionException(e);
        } finally {
            if(fireJob != null) {
                fireJob.onFinalJob(context);
            }
            logger.debug("finally triggerName: {}", triggerName);
        }
    }

    public static Map<String, Object> findJobAndTriggers(Scheduler scheduler) throws SchedulerException {
        List<String> jobGroupNames = scheduler.getJobGroupNames();
        Map<String, Object> jobGroupMap = Maps.newHashMap();
        for(String jobGroupName : jobGroupNames) {
            Set<JobKey> jobKeySet = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroupName));
            List<Map<String, Object>> jobList = Lists.newArrayList();
            for(JobKey jobKey : jobKeySet) {
                String jobName = jobKey.getName();
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                Map<String, Object> jobInfoMap = Maps.newHashMap();
                jobInfoMap.put("jobGroupName", jobGroupName);
                jobInfoMap.put("jobName", jobName);
                List<Map<String, Object>> triggerList = Lists.newArrayList();
                for(Trigger trigger : triggers) {
                    Map<String, Object> triggerInfoMap = Maps.newHashMap();
                    CronTrigger cronTrigger = (CronTrigger)trigger;
                    TriggerKey triggerKey = cronTrigger.getKey();
                    String cronExpression = cronTrigger.getCronExpression();
                    triggerInfoMap.put("triggerGroup", triggerKey.getGroup());
                    triggerInfoMap.put("triggerName", triggerKey.getName());
                    triggerInfoMap.put("startTime", cronTrigger.getStartTime());
                    triggerInfoMap.put("endTime", cronTrigger.getEndTime());
                    triggerInfoMap.put("nextFireTime", cronTrigger.getNextFireTime());
                    triggerInfoMap.put("finalFireTime", cronTrigger.getFinalFireTime());
                    triggerInfoMap.put("cronExpression", cronExpression);
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
                    triggerInfoMap.put("triggerState", triggerState);
                    triggerList.add(triggerInfoMap);
                }
                jobInfoMap.put("triggers", triggerList);
                jobList.add(jobInfoMap);
            }
            jobGroupMap.put(jobGroupName, jobList);
        }
        return jobGroupMap;
    }

    public static List<Map<String, Object>> findTriggersToList(Scheduler scheduler) throws SchedulerException {
        List<String> jobGroupNames = scheduler.getJobGroupNames();
        List<Map<String, Object>> triggerList = Lists.newArrayList();
        for(String jobGroupName : jobGroupNames) {
            Set<JobKey> jobKeySet = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroupName));
            List<Map<String, Object>> jobList = Lists.newArrayList();
            for(JobKey jobKey : jobKeySet) {
                String jobName = jobKey.getName();
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for(Trigger trigger : triggers) {
                    Map<String, Object> triggerInfoMap = Maps.newHashMap();
                    CronTrigger cronTrigger = (CronTrigger)trigger;
                    TriggerKey triggerKey = cronTrigger.getKey();
                    String cronExpression = cronTrigger.getCronExpression();
                    triggerInfoMap.put("jobGroupName", jobGroupName);
                    triggerInfoMap.put("jobName", jobName);
                    triggerInfoMap.put("triggerGroup", triggerKey.getGroup());
                    triggerInfoMap.put("triggerName", triggerKey.getName());
                    triggerInfoMap.put("startTime", cronTrigger.getStartTime());
                    triggerInfoMap.put("endTime", cronTrigger.getEndTime());
                    triggerInfoMap.put("nextFireTime", cronTrigger.getNextFireTime());
                    triggerInfoMap.put("finalFireTime", cronTrigger.getFinalFireTime());
                    triggerInfoMap.put("cronExpression", cronExpression);
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
                    triggerInfoMap.put("triggerState", triggerState);
                    triggerList.add(triggerInfoMap);
                }
            }
        }
        return triggerList;
    }
}
