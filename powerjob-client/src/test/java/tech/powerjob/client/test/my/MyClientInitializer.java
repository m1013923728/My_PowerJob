package tech.powerjob.client.test.my;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tech.powerjob.client.IPowerJobClient;
import tech.powerjob.client.PowerJobClient;
import tech.powerjob.common.request.http.SaveJobInfoRequest;
import tech.powerjob.common.request.http.SaveWorkflowRequest;
import tech.powerjob.common.request.query.InstancePageQuery;
import tech.powerjob.common.request.query.WorkflowInstancePageQuery;
import tech.powerjob.common.response.*;

import java.util.List;

/**
 * Initialize OhMyClient
 *
 * @author tjq
 * @since 1/16/21
 */
public class MyClientInitializer {

    protected static IPowerJobClient powerJobClient;

    @BeforeAll
    public static void initClient() throws Exception {
        powerJobClient = new PowerJobClient(Lists.newArrayList("127.0.0.1:7700", "127.0.0.1:7701"), "my-warehouse", "my-warehouse");
    }

    @Test
    public void test1() {
        ResultDTO<List<JobInfoDTO>> listResultDTO = powerJobClient.fetchAllJob();
        if (listResultDTO.isSuccess()) {
            System.out.println(listResultDTO.getMessage());
        }
        System.out.println(JSON.toJSONString(listResultDTO.getData()));
    }

    @Test
    public void test2() {
        SaveJobInfoRequest saveJobInfoRequest = new SaveJobInfoRequest();
        saveJobInfoRequest.setId(null);
        saveJobInfoRequest.setAppId(null);
        saveJobInfoRequest.setProcessorInfo(null);
        saveJobInfoRequest.setExecuteType(null);
        saveJobInfoRequest.setProcessorType(null);
        saveJobInfoRequest.setTimeExpressionType(null);
        saveJobInfoRequest.setTimeExpression(null);
        ResultDTO<Long> listResultDTO = powerJobClient.saveJob(saveJobInfoRequest);
    }

    @Test
    public void test3() {
        SaveWorkflowRequest saveWorkflowRequest = new SaveWorkflowRequest();
        ResultDTO<Long> listResultDTO = powerJobClient.saveWorkflow(saveWorkflowRequest);
    }

    @Test
    public void testInstancePage() {
        InstancePageQuery instancePageQuery = new InstancePageQuery();
        instancePageQuery.setJobIdEq(2L);
        instancePageQuery.setIndex(1);
        instancePageQuery.setPageSize(1);
        ResultDTO<PageResult<InstanceInfoDTO>> listResultDTO = powerJobClient.queryInstanceInfo(instancePageQuery);
        System.out.println(JSON.toJSONString(listResultDTO.getData()));
    }

    @Test
    public void testWFInstancePage() {
        WorkflowInstancePageQuery workflowInstancePageQuery = new WorkflowInstancePageQuery();
        workflowInstancePageQuery.setWorkflowIdEq(1L);
        workflowInstancePageQuery.setIndex(1);
        workflowInstancePageQuery.setPageSize(1);
        ResultDTO<PageResult<WorkflowInstanceInfoDTO>> listResultDTO = powerJobClient.queryWorkflowInstanceInfo(workflowInstancePageQuery);
        System.out.println(JSON.toJSONString(listResultDTO.getData()));
    }
}
