package top.lxyi.train.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * @author mqxu
 * @date 2023/11/19
 * @description SnowUtil：封装hutool雪花算法
 **/
public class SnowUtil {
    /**
     * 数据中心
     */
    private static final long DATA_CENTER_ID = 1;
    /**
     * 机器标识
     */
    private static final long WORKER_ID = 1;

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(WORKER_ID, DATA_CENTER_ID).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(WORKER_ID, DATA_CENTER_ID).nextIdStr();
    }
}
