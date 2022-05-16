package com.company;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class KNNModel extends MyDataModel{
    IBk iBk;
    Evaluation evaluation;
    public  KNNModel(String filename, String model_option, String data_option) throws Exception{
        super(filename,model_option,data_option);
    }
    public void buildKNN(String fileName) throws Exception {
        setTrainSet(fileName);
        this.trainSet.setClassIndex(this.trainSet.numAttributes()-1);
        this.iBk = new IBk();
        iBk.setOptions(model_options);
        iBk.buildClassifier(trainSet);
    }
    public void evaluationKNN(String fileName) throws Exception{
        this.setTestSet(fileName);
        this.testSet.setClassIndex(this.testSet.numAttributes()-1);
        Debug.Random rd = new Debug.Random();
        int folds = 10;
        this.evaluation = new Evaluation(this.trainSet);
        this.evaluation.crossValidateModel(this.iBk, this.testSet, folds,rd);
        System.out.println(this.evaluation.toSummaryString("ket qua danh gia\n", false));
        System.out.println(this.evaluation.toClassDetailsString());
        System.out.println(this.evaluation.toMatrixString());
    }
    public void predictLabel(String fileName, String fileOut) throws Exception {
        ConverterUtils.DataSource dataSource1 = new ConverterUtils.DataSource(fileName);
        Instances instances = dataSource1.getDataSet();
        instances.setClassIndex(instances.numAttributes() - 1);
        for(int i=0; i<instances.numInstances(); i++)
        {
            double pre = iBk.classifyInstance(instances.instance(i));
            instances.instance(i).setClassValue(pre);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
        bufferedWriter.write(instances.toString());
        bufferedWriter.newLine();;
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
