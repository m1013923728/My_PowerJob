package tech.powerjob.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文本分页
 *
 * @author tjq
 * @since 2020/5/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringPageDTO {
    /**
     * 当前页数
     */
    private long index;
    /**
     * 总页数
     */
    private long totalPages;
    /**
     * 文本数据
     */
    private String data;

    public static StringPageDTO simple(String data) {
        StringPageDTO sp = new StringPageDTO();
        sp.index = 0;
        sp.totalPages = 1;
        sp.data = data;
        return sp;
    }
}
