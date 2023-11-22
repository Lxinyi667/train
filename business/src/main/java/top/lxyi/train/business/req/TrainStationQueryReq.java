package top.lxyi.train.business.req;


import top.lxyi.train.common.req.PageReq;

public class TrainStationQueryReq extends PageReq {
    private String trainCode;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
public String toString() {
    return "TrainStationQueryReq{" +
    "} " + super.toString();
    }
}