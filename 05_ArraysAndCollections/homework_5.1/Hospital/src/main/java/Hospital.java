public class Hospital {

    private static final int minTemp = 32;
    private static final int maxTemp = 40;
    static final float maxTempHealth = 36.9F;
    static final float minTempHealth = 36.2F;


    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] generatePatient = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            generatePatient[i] = (float) (((Math.random() * (maxTemp - minTemp)) + minTemp));
        }
        return generatePatient;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        float meanPatients;
        float sumTemperature = .0f;
        int healthPatient = 0;
        StringBuilder builder = new StringBuilder();
        for (float temperatureDatum : temperatureData) {
            sumTemperature += temperatureDatum;

            if ((temperatureDatum >= minTempHealth) && (temperatureDatum <= maxTempHealth)) {
                healthPatient++;
            }
            builder.append(temperatureDatum).append(" ");
        }
        meanPatients = sumTemperature / temperatureData.length;

        return "Температуры пациентов: " + builder.toString().trim() +
                "\nСредняя температура: " + String.format("%.2f", meanPatients) +
                "\nКоличество здоровых: " + healthPatient;
    }
}
