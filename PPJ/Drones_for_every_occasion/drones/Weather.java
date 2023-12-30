package drones;

public class Weather {
    private double temperature;
    private double humidity;
    private double windSpeed;

    public Weather(double temperature, double humidity, double windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public void sendDataTo(WeatherDrone weatherDrone) {
        weatherDrone.setTemperatureSensor(temperature);
        int oldTemperatureHistoryLength = weatherDrone.getTemperatureHistory().length;
        double[] temperatureHistoryWithNewTemperature = new double[oldTemperatureHistoryLength + 1];
        for (int i = 0; i < oldTemperatureHistoryLength; i++)
            temperatureHistoryWithNewTemperature[i] = weatherDrone.getTemperatureHistory()[i];
        temperatureHistoryWithNewTemperature[oldTemperatureHistoryLength] = temperature;
        weatherDrone.setTemperatureHistory(temperatureHistoryWithNewTemperature);

        weatherDrone.setHumiditySensor(humidity);
        int oldHumidityHistoryLength = weatherDrone.getHumidityHistory().length;
        double[] humidityHistoryWithNewHumidity = new double[oldHumidityHistoryLength + 1];
        for (int i = 0; i < oldHumidityHistoryLength; i++)
            humidityHistoryWithNewHumidity[i] = weatherDrone.getHumidityHistory()[i];
        humidityHistoryWithNewHumidity[oldHumidityHistoryLength] = humidity;
        weatherDrone.setHumidityHistory(humidityHistoryWithNewHumidity);

        weatherDrone.setWindSpeedMeter(windSpeed);
        int oldWindSpeedHistoryLength = weatherDrone.getWindSpeedHistory().length;
        double[] windSpeedHistoryWithNewWindSpeed = new double[oldWindSpeedHistoryLength + 1];
        for (int i = 0; i < oldWindSpeedHistoryLength; i++)
            windSpeedHistoryWithNewWindSpeed[i] = weatherDrone.getWindSpeedHistory()[i];
        windSpeedHistoryWithNewWindSpeed[oldWindSpeedHistoryLength] = windSpeed;
        weatherDrone.setWindSpeedHistory(windSpeedHistoryWithNewWindSpeed);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
