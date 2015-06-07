package chapter3;

import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Steve on 6/7/2015.
 */
public class TestClassifier {

    public static void main(String[] args) {

        WekaWrapper ww = new WekaWrapper();
        try {
            Instances unlabeld = new Instances(new BufferedReader(new FileReader("ladygaga.arff")));

            unlabeld.setClassIndex(unlabeld.numAttributes()-1);
            for (int i = 0; i < unlabeld.numInstances(); i++) {
                double clsLabel = ww.classifyInstance(unlabeld.instance(i));
                System.out.println(clsLabel + " -> " + unlabeld.classAttribute().value((int)clsLabel));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
