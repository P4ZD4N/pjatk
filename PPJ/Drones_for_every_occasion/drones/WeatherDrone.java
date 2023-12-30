package drones;

public class WeatherDrone extends Drone {
    private double temperatureSensor;
    private double[] temperatureHistory = new double[0];
    private double humiditySensor;
    private double[] humidityHistory = new double[0];
    private double windSpeedMeter;
    private double[] windSpeedHistory = new double[0];

    public WeatherDrone(int uniqueId, String name, double weight, double enginePower, double batteryLevel) {
        super(uniqueId, name, weight, enginePower, batteryLevel);
    }

    public void transmitWeatherReport() {
        System.out.println("drones.Weather now: ");
        System.out.println("- Temperature: " + temperatureSensor + " °C");
        System.out.println("- Humidity: " + humiditySensor + "%");
        System.out.println("- Wind speed: " + windSpeedMeter + " km/h");
    }

    public void analyzeAtmosphericConditions() {
        if (temperatureHistory.length >= 2 && humidityHistory.length >= 2 && windSpeedHistory.length >= 2) {
            analyzeTemperature();
            analyzeHumidity();
            analyzeWindSpeed();
        } else if (temperatureHistory.length == 1 && humidityHistory.length == 1 && windSpeedHistory.length == 1)
            transmitWeatherReport();
        else
            System.out.println("No data");
    }

    private void analyzeTemperature() {
        double actualTemperature = temperatureHistory[temperatureHistory.length - 1];
        double previousTemperature = temperatureHistory[temperatureHistory.length  - 2];

        if (actualTemperature > previousTemperature)
            System.out.println("Temperature increased by " + (actualTemperature - previousTemperature) + " °C compared to previous measurement");
        else if (actualTemperature == previousTemperature)
            System.out.println("Temperature not changed compared to previous measurement");
        else if (actualTemperature < previousTemperature)
            System.out.println("Temperature dropped by " + (previousTemperature - actualTemperature) + " °C compared to previous measurement");
    }

    private void analyzeHumidity() {
        double actualHumidity = humidityHistory[humidityHistory.length - 1];
        double previousHumidity = humidityHistory[humidityHistory.length  - 2];

        if (actualHumidity > previousHumidity)
            System.out.println("Humidity increased by " + (actualHumidity - previousHumidity) + "% compared to previous measurement");
        else if (actualHumidity == previousHumidity)
            System.out.println("Humidity not changed compared to previous measurement");
        else if (actualHumidity < previousHumidity)
            System.out.println("Humidity decreased by " + (previousHumidity - actualHumidity) + "% compared to previous measurement");
    }

    private void analyzeWindSpeed() {
        double actualWindSpeed = windSpeedHistory[windSpeedHistory.length - 1];
        double previousWindSpeed = windSpeedHistory[windSpeedHistory.length  - 2];

        if (actualWindSpeed > previousWindSpeed)
            System.out.println("Wind speed increased by " + (actualWindSpeed - previousWindSpeed) + " km/h compared to previous measurement");
        else if (actualWindSpeed == previousWindSpeed)
            System.out.println("Wind speed not changed compared to previous measurement");
        else if (actualWindSpeed < previousWindSpeed)
            System.out.println("Wind speed decreased by " + (previousWindSpeed - actualWindSpeed) + " km/h compared to previous measurement");
    }

    public void calculateAverageTemperature(int index, double sum) {
        if (temperatureHistory.length >= 1) {
            sum += temperatureHistory[index];
            if (index == temperatureHistory.length - 1) {
                System.out.println("Average temperature: " + (sum / temperatureHistory.length));
                return;
            }
            calculateAverageTemperature(index + 1, sum);
        } else
            System.out.println("No data");
    }

    public void calculateAverageHumidity(int index, double sum) {
        if (humidityHistory.length >= 1) {
            sum += humidityHistory[index];
            if (index == humidityHistory.length - 1) {
                System.out.println("Average humidity: " + (sum / humidityHistory.length));
                return;
            }
            calculateAverageHumidity(index + 1, sum);
        } else
            System.out.println("No data");
    }

    public void calculateAverageWindSpeed(int index, double sum) {
        if (windSpeedHistory.length >= 1) {
            sum += windSpeedHistory[index];
            if (index == windSpeedHistory.length - 1) {
                System.out.println("Average wind speed: " + (sum / windSpeedHistory.length));
                return;
            }
            calculateAverageWindSpeed(index + 1, sum);
        } else
            System.out.println("No data");
    }

    void setTemperatureSensor(double temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public double[] getTemperatureHistory() {
        return temperatureHistory;
    }

    void setTemperatureHistory(double[] temperatureHistory) {
        this.temperatureHistory = temperatureHistory;
    }

    void setHumiditySensor(double humiditySensor) {
        this.humiditySensor = humiditySensor;
    }

    public double[] getHumidityHistory() {
        return humidityHistory;
    }

    void setHumidityHistory(double[] humidityHistory) {
        this.humidityHistory = humidityHistory;
    }

    void setWindSpeedMeter(double windSpeedMeter) {
        this.windSpeedMeter = windSpeedMeter;
    }

    public double[] getWindSpeedHistory() {
        return windSpeedHistory;
    }

    void setWindSpeedHistory(double[] windSpeedHistory) {
        this.windSpeedHistory = windSpeedHistory;
    }

    @Override
    public String toString() {
        return "WeatherDrone{" +
                "temperatureSensor=" + temperatureSensor +
                ", humiditySensor=" + humiditySensor +
                ", windSpeedMeter=" + windSpeedMeter +
                '}';
    }
}
