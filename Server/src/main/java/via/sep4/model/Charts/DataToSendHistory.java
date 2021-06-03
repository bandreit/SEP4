package via.sep4.model.Charts;

import java.util.List;

public class DataToSendHistory {
    private List<DataHistory> data;

    public DataToSendHistory() {
    }

    public List<DataHistory>  getData() {
        return data;
    }

    public void setData(List<DataHistory>  data) {
        this.data = data;
    }
}
