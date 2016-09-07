package cn.evilcoder.temp;

/**
 * Created by huangshanqi on 2016/7/11.
 */
public class HypervisorDiskConfig {

    private String type = "ssd";
    private Integer sizePerDiskInGb;
    private Integer diskLeft;
    private Integer diskTotal;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HypervisorDiskConfig withType(String type) {
        this.type = type;
        return this;
    }

    public Integer getSizePerDiskInGb() {
        return sizePerDiskInGb;
    }

    public void setSizePerDiskInGb(Integer sizePerDiskInGb) {
        this.sizePerDiskInGb = sizePerDiskInGb;
    }

    public HypervisorDiskConfig withSizePerDiskInGb(Integer sizePerDiskInGb) {
        this.sizePerDiskInGb = sizePerDiskInGb;
        return this;
    }

    public Integer getDiskLeft() {
        return diskLeft;
    }

    public void setDiskLeft(Integer diskLeft) {
        this.diskLeft = diskLeft;
    }
    public HypervisorDiskConfig withDiskLeft(Integer diskLeft) {
        this.diskLeft = diskLeft;
        return this;
    }


    public Integer getDiskTotal() {
        return diskTotal;
    }

    public void setDiskTotal(Integer diskTotal) {
        this.diskTotal = diskTotal;
    }

    public HypervisorDiskConfig withDiskTotal(Integer diskTotal) {
        this.diskTotal = diskTotal;
        return this;
    }

    @Override
    public String toString() {
        return "HypervisorDiskConfig{"
                + "type='" + type + '\''
                + ", sizePerDiskInGb=" + sizePerDiskInGb
                + ", diskLeft=" + diskLeft
                + ", diskTotal=" + diskTotal
                + '}';
    }
}
