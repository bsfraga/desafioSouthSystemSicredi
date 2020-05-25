package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * This class contains methods to manage CPF csv file to use within the tests.
 *
 * @author bsfraga
 */
public class Cpf {

    /**
     * This method get a random valid CPF from  CPF_Valido.csv file and verify if the value has already been used
     * based on the CPF_Usado.csv file.
     * @return A valid CPF (String)
     *
     * @author bsfraga
     */
    public static String getOneCPF(){
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("src\\test\\resources\\docs\\CPF_Validos.csv"));

            String row = "";
            List<String[]> data = new ArrayList<>();

            while ((row = csvReader.readLine()) != null) {
                data.add(row.split(","));
            }
            System.out.println("Tamanho da lista de CPF: "+data.size());

            Random r = new Random();
            int index = r.nextInt(data.size());
            System.out.println("Index do CPF que será escolhido: "+index);

            String[] choosenData = data.get(r.nextInt(index));
            System.out.println("CPF Escolhido: "+choosenData[0]);

            if(verifyCPFUsage(choosenData[0])){
                System.out.println("CPF sem uso encontrado.");
                FileWriter fileWriter = new FileWriter("src\\test\\resources\\docs\\CPF_Usado.csv", true);
                fileWriter.append(String.join(",", choosenData[0]));
                fileWriter.append("\n");
                fileWriter.flush();
                fileWriter.close();
                return choosenData[0];
            }else{
                System.err.println("CPF já utilizado, tentando outro...");
                getOneCPF();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method verify if a valid CPF had already been used by consulting CPF_Usado.csv file.
     * @param choosenData (String)
     * @return boolean if the String has been on CPF_Usado.csv file;
     */
    public static boolean verifyCPFUsage(String choosenData){
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("src\\main\\resources\\docs\\CPF_Usado.csv"));
            String row = "";
            while((row = csvReader.readLine()) != null){
                if(row.equals(choosenData)){
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
