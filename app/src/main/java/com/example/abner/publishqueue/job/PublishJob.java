package com.example.abner.publishqueue.job;

import android.renderscript.RenderScript;
import android.util.SparseArray;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.Map;

/**
 * Created by Abner on 15/9/8.
 * QQ 230877476
 * Email nimengbo@gmail.com
 * github https://github.com/nimengbo
 */
public class PublishJob extends Job {
    //可以当做请求的key
    private long localId;

    private SparseArray<String> params;
    public PublishJob(SparseArray<String> params) {
        super(new Params(Priority.MID).requireNetwork().persist().groupBy("post_tweet"));//order of tweets matter, we don't want to send two in parallel

        localId = -System.currentTimeMillis();

        this.params = params;
    }

    @Override
    public void onAdded() {
        //TODO job已添加 用eventBus 回调 processing
    }

    @Override
    public void onRun() throws Throwable {
        //TODO 执行请求 执行完后 回调 success
    }

    @Override
    protected void onCancel() {
        //TODO 取消请求
    }
    //如果onRun 里抛出异常 会再跑一次这个
    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
