package seminar_2;
import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

/**
 * task2_1
 */
public class task2_1 {
    public static void main(String[] args) {

        String jsonStr = readStringFromFile("data.json");

        JsonArray array = new Gson().fromJson(jsonStr, JsonArray.class);



        StringBuilder sb = new StringBuilder();



        for (JsonElement element : array) {

            JsonObject obj = element.getAsJsonObject();

            String surname = obj.get("фамилия").toString();

            String mark = obj.get("оценка").toString();

            String subject = obj.get("предмет").toString();



            sb.append("Студент ")

                    .append(surname)

                    .append(" получил ")

                    .append(mark)

                    .append(" по предмету ")

                    .append(subject)

                    .append(".n");

        }



        System.out.println(sb.toString());

    }



    private static String readStringFromFile(String fileName) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            StringBuilder sb = new StringBuilder();

            String line;

            while ((line = br.readLine()) != null) {

                sb.append(line);

            }

            br.close();

            return sb.toString();

        } catch(IOException e) {

            e.printStackTrace();

            return null;

        }

    }

}


