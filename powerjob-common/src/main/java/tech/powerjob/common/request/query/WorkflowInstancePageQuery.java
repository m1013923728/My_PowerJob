package tech.powerjob.common.request.query;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 任务实例分页查询
 *
 * @author tjq
 * @since 2024/11/21
 */
@Getter
@Setter
public class WorkflowInstancePageQuery extends PowerPageQuery {

    /**
     * 查询条件（NORMAL/WORKFLOW）
     */
    private Long wfInstanceIdEq;

    private Long workflowIdEq;

    private List<Integer> statusIn;


    private Date gmtCreateLt;
    private Date gmtCreateGt;

    private Date gmtModifiedLt;
    private Date gmtModifiedGt;
}
