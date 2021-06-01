package via.sep4.service;

import org.springframework.stereotype.Service;
import via.sep4.model.Charts.Chart;
import via.sep4.model.Sensor.Sensor;
import via.sep4.model.Sensor.SensorRepository;
import via.sep4.model.Sensor.SensorType;
import via.sep4.model.SensorHistory.SensorHistory;
import via.sep4.model.SensorHistory.SensorHistoryRepository;

import java.sql.Timestamp;
import java.util.*;

@Service
public class SensorHistoryService {
    private SensorRepository sensorRepository;
    private SensorHistoryRepository historyRepository;

    public SensorHistoryService(SensorRepository sensorRepository, SensorHistoryRepository historyRepository) {
        this.sensorRepository = sensorRepository;
        this.historyRepository = historyRepository;
    }

    public List<Chart> getSensorHistoryByPeriod(long roomId, int period) {
        List<Sensor> allSensors = sensorRepository.findAll();
        List<Sensor> foundSensors = new ArrayList<>();
        List<Double> co2Values = new ArrayList<>();
        List<Double> temperatureValues = new ArrayList<>();
        List<Double> humidityValues = new ArrayList<>();
        List<SensorHistory> sensorHistoryList = historyRepository.findAll();
        List<SensorHistory> humiditySensors = new ArrayList<>();
        List<SensorHistory> temperatureSensors = new ArrayList<>();
        List<SensorHistory> co2Sensors = new ArrayList<>();
        List<Chart> chartsToSend = new ArrayList<>();

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        Calendar nowDate = new GregorianCalendar(year, month, day);
        Date currentDate = nowDate.getTime();


        for (int i = 0; i < allSensors.size(); i++) {
            if (allSensors.get(i).getRoom().getRoomid() == roomId)
                foundSensors.add(allSensors.get(i));
        }

        for (int j = 0; j < sensorHistoryList.size(); j++) {
            if (sensorHistoryList.get(j).getSensor().getSensorID() == foundSensors.get(0).getSensorID())
                co2Sensors.add(sensorHistoryList.get(j));
            else if (sensorHistoryList.get(j).getSensor().getSensorID() == foundSensors.get(1).getSensorID())
                humiditySensors.add(sensorHistoryList.get(j));
            else if (sensorHistoryList.get(j).getSensor().getSensorID() == foundSensors.get(2).getSensorID())
                temperatureSensors.add(sensorHistoryList.get(j));
        }

        Chart chartCO2 = new Chart();
        chartCO2.setSensorType(SensorType.CO2);
        chartCO2.setSensorId(foundSensors.get(0).getSensorID());
        getAverage(period, co2Values, co2Sensors, chartsToSend, currentDate, chartCO2);


        Chart chartHumidity = new Chart();
        chartHumidity.setSensorType(SensorType.HUMIDITY);
        chartHumidity.setSensorId(foundSensors.get(1).getSensorID());
        getAverage(period, humidityValues, humiditySensors, chartsToSend, currentDate, chartHumidity);


        Chart chartTemperature = new Chart();
        chartTemperature.setSensorType(SensorType.TEMPERATURE);
        chartTemperature.setSensorId(foundSensors.get(2).getSensorID());
        getAverage(period, temperatureValues, temperatureSensors, chartsToSend, currentDate, chartTemperature);

        return chartsToSend;

    }

    private void getAverage(int period, List<Double> values, List<SensorHistory> specificSensorsHistory, List<Chart> chartsToSend, Date currentDate, Chart chart) {
        int count = 0;
        double sum = 0;
        double avg;
        List<Date> timestamps = new ArrayList<>();
        Timestamp stamp = new Timestamp(currentDate.getTime());

//                Timestamp timestamp = sensors.get(k).getTimestamp();
//                Date date = new Date(timestamp.getTime());
//                Calendar calendar = new GregorianCalendar();
//                calendar.setTime(date);
//                int y = calendar.get(Calendar.YEAR);
//                int m = calendar.get(Calendar.MONTH);
//                int d = calendar.get(Calendar.DATE);
//                Calendar sensorDate = new GregorianCalendar(y, m, d);

        for (int i = period - 1; i >= 0; i--) {
            for (int k = 0; k < specificSensorsHistory.size(); k++) {
               stamp = specificSensorsHistory.get(k).getTimestamp();
                Date forSpecificHistory = new Date(stamp.getTime());
                if (forSpecificHistory.equals(minusDays(i))) {
                    sum += specificSensorsHistory.get(k).getValue();
                    count++;

                }
            }
            timestamps.add(stamp);
            avg = sum / count;
            values.add(avg);
        }
        chart.setAverage(values);
        chartsToSend.add(chart);
    }


    private Date minusDays(int period) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -period);
        return cal.getTime();
    }

}
