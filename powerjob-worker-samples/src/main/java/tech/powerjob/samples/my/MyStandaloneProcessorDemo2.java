package tech.powerjob.samples.my;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;
import tech.powerjob.worker.log.OmsLogger;

import java.sql.Timestamp;

@Slf4j
@Component
public class MyStandaloneProcessorDemo2 implements BasicProcessor {

    /**
     * {
     *   "currentRetryTimes": 0,
     *   "instanceId": 881216827735146800,
     *   "instanceMeta": {
     *     "ett": 1765874450000
     *   },
     *   "jobId": 1,
     *   "jobParams": "xxx=123",
     *   "maxRetryTimes": 1,
     *   "omsLogger": {},
     *   "taskId": "1#881216827735146688",
     *   "taskName": "OMS_ROOT_TASK",
     *   "workflowContext": {
     *     "appendedContextData": {},
     *     "data": {}
     *   }
     * }
     * @param context 任务上下文，可通过 jobParams 和 instanceParams 分别获取控制台参数和OpenAPI传递的任务实例参数
     * @return
     * @throws Exception
     */

    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        log.info("----MyStandaloneProcessorDemo2 {} {} {}", context.getJobParams(), new Timestamp(context.getInstanceMeta().getEtt()), JSON.toJSONString(context));
        // PowerJob 在线日志功能，使用该 Logger 打印的日志可以直接在 PowerJob 控制台查看
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("----StandaloneProcessorDemo2 start process,context is {}.", context);

        context.getWorkflowContext().appendData2WfContext(new Timestamp(System.currentTimeMillis()).toString(), "1");

        return new ProcessResult(true, "process successfully~");
    }
}
