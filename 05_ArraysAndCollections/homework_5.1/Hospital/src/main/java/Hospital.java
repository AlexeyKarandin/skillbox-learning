public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] generatePatient = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            generatePatient[i] = (float) ((Math.random() * 8 + 32));
        }
        return generatePatient;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        float meanPatients = .0f;
        float sumTemperature = .0f;
        int healthPatient = 0;
        StringBuilder builder = new StringBuilder();
        for (float temperatureDatum : temperatureData) {
            sumTemperature += temperatureDatum;

            if ((temperatureDatum >= 36.2F) && (temperatureDatum <= 36.9F)) {
                healthPatient++;
            }
            builder.append(temperatureDatum).append(" ");
        }
        meanPatients = sumTemperature / temperatureData.length;
        String report =
                "Температуры пациентов: " + builder.toString().trim() +
                        "\nСредняя температура: " + String.format("%.2f", meanPatients) +
                        "\nКоличество здоровых: " + healthPatient;

        return report;
    }
}
