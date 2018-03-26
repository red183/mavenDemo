package com.cnwanweb.quickframework.modules.quartz.common;

import java.io.Serializable;

/**
 *
 * @author wilson_chan_it@qq.com
 */
public interface FireJob extends Serializable {

    public void doJob();

}