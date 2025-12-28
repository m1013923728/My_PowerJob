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
public class InstancePageQuery extends PowerPageQuery {

    private Long instanceIdEq;
    private Long instanceIdLt;
    private Long instanceIdGt;

    /**
     * 根据业务外建查询
     */
    private String outerKeyEq;

    private Long jobIdEq;

    private List<Integer> statusIn;

    /**
     * 该任务实例的类型，1-普通/2-工作流（InstanceType）
     */
    private Integer typeEq;


    private Date gmtCreateLt;
    private Date gmtCreateGt;

    private Date gmtModifiedLt;
    private Date gmtModifiedGt;
}
