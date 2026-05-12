package com.yitu.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 批量导入记录请求
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchAddRecordsRequest {
    /**
     * 待导入记录列表
     */
    private List<CaptureFaceRecordInput> records;
}
