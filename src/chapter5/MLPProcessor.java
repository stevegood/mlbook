package chapter5;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.Utils;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Steve on 6/7/2015.
 */
public class MLPProcessor {
    public MLPProcessor() {
        try {
            FileReader fr = new FileReader("vehicledata.arff");
            Instances training = new Instances(fr);

            training.setClassIndex(training.numAttributes() - 1);
            MultilayerPerceptron mlp = new MultilayerPerceptron();
            mlp.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H 4"));
            mlp.buildClassifier(training);

            FileReader tr = new FileReader("trainingdata.arff");
            Instances testdata = new Instances(tr);

            testdata.setClassIndex(testdata.numAttributes()-1);
            Evaluation eval = new Evaluation(training);
            eval.evaluateModel(mlp, testdata);
            System.out.println(eval.toSummaryString("\nResults\n*********\n", false));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MLPProcessor mlp = new MLPProcessor();
    }
}
