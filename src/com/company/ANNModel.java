package com.company;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Locale;

public class ANNModel extends MyDataModel{
    MultilayerPerceptron multilayerPerceptron;
    Evaluation evaluation;
    public ANNModel(){super();}
    public ANNModel(String filename, String model_option, String data_option) throws Exception{
        super(filename,model_option,data_option);
    }
    public void buildANNModel(String fileName) throws  Exception{
        setTrainSet(fileName);
        this.trainSet.setClassIndex(trainSet.numAttributes()-1);
        this.multilayerPerceptron = new MultilayerPerceptron();
        multilayerPerceptron.setOptions(model_options);
        multilayerPerceptron.buildClassifier(trainSet);
    }
    public void evaluationANN(String fileName) throws Exception{
        this.setTestSet(fileName);
        this.testSet.setClassIndex(this.testSet.numAttributes()-1);
        Debug.Random rd = new Debug.Random();
        int folds = 10;
        this.evaluation = new Evaluation(this.trainSet);
        this.evaluation.crossValidateModel(this.multilayerPerceptron, this.testSet, folds,rd);
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
            double pre = multilayerPerceptron.classifyInstance(instances.instance(i));
            instances.instance(i).setClassValue(pre);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
        bufferedWriter.write(instances.toString());
        bufferedWriter.newLine();;
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
