package chapter5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Steve on 6/7/2015.
 */
public class MLPData {

    private String[] classtype = new String[] { "Bike", "Car" , "Bus", "Truck" };

    public MLPData() {
        Random rand = new Random(System.nanoTime());
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("vehicledata.csv"));
            out.write("wheels,chassis,pax,vtype\n");
            for (int i = 0; i < 100000; i++) {
                StringBuilder sb = new StringBuilder();
                switch (rand.nextInt(4)) {
                    case 0:
                        sb.append((rand.nextInt(1) + 1) + ","); // num of wheels
                        sb.append((rand.nextInt(1) + 1) + ","); // chassis length
                        sb.append((rand.nextInt(1) + 1) + ","); // passenger number
                        sb.append(classtype[0] + "\n");
                        break;
                    case 1:
                        sb.append((rand.nextInt(2) + 4) + ","); // num of wheels
                        sb.append((rand.nextInt(4) + 1) + ","); // chassis length
                        sb.append((rand.nextInt(4) + 1) + ","); // passenger number
                        sb.append(classtype[1] + "\n");
                        break;
                    case 2:
                        sb.append((rand.nextInt(6) + 4) + ","); // num of wheels
                        sb.append((rand.nextInt(12) + 12) + ","); // chassis length
                        sb.append((rand.nextInt(30) + 10) + ","); // passenger number
                        sb.append(classtype[2] + "\n");
                        break;
                    case 3:
                        sb.append( "18,"); // num of wheels
                        sb.append((rand.nextInt(10) + 20) + ","); // chassis length
                        sb.append((rand.nextInt(2) + 1) + ","); // passenger number
                        sb.append(classtype[3] + "\n");
                        break;
                    default:
                        break;
                }
                out.write(sb.toString());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MLPData mlp = new MLPData();
    }
}
