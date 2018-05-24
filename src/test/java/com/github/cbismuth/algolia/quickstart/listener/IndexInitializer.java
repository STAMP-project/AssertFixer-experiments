package com.github.cbismuth.algolia.quickstart.listener;

import com.algolia.search.objects.tasks.async.AsyncTaskSingleIndex;
import org.springframework.retry.RetryCallback;

interface IndexInitializer extends RetryCallback<AsyncTaskSingleIndex, Exception> {

    // NOP
}
