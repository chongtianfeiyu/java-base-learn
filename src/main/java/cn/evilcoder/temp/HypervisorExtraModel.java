package cn.evilcoder.temp;

import java.util.List;

/**
 * Dcc 多盘信息存储到专属服务器的extra 字段
 * Created by huangshanqi on 2016/7/11.
 */
public class HypervisorExtraModel {

    private List<HypervisorDiskConfig> diskDetail;

    public List<HypervisorDiskConfig> getDiskDetail() {
        return diskDetail;
    }

    public void setDiskDetail(List<HypervisorDiskConfig> diskDetail) {
        this.diskDetail = diskDetail;
    }

    @Override
    public String toString() {
        return "HypervisorExtraModel{"
                + "diskDetail=" + diskDetail
                + '}';
    }

    /**
     * 获取对应磁盘类型总数目
     * @param type 磁盘类型,null 表示全部
     * @return
     */
    public int getDiskTotalCountByType(String type) {
        int result = 0;
        if (diskDetail == null) {
            return result;
        }
        for (HypervisorDiskConfig diskConfig : diskDetail) {
            if (null == type || diskConfig.getType().equalsIgnoreCase(type)) {
                result += diskConfig.getDiskTotal();
            }
        }
        return result;
    }

    /**
     * 获取对应磁盘类型总剩余数目
     * @param type 磁盘类型,null 表示全部
     * @return
     */
    public int getDiskLeftCountByType(String type) {
        int result = 0;
        if (diskDetail == null) {
            return result;
        }
        for (HypervisorDiskConfig diskConfig : diskDetail) {
            if (null == type || diskConfig.getType().equalsIgnoreCase(type)) {
                result += diskConfig.getDiskLeft();
            }
        }
        return result;
    }
}
