package com.example.composeweatherapp.core.executor

import com.example.domain.executor.ThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BaseExecutor @Inject constructor() : ThreadExecutor() {

    override val mainExecutor: Scheduler
        get() = Schedulers.io()

    override val postExecutor: Scheduler = AndroidSchedulers.mainThread()

}