package com.company;

import weka.classifiers.Evaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class KMeansModel extends MyDataModel {

    SimpleKMeans simpleKMeans;
    Evaluation evaluation;
    public KMeansModel(){}
    public KMeansModel(String filename, String model_option, String data_option) throws Exception{
        super(filename,model_option,data_option);
    }
    public void buildKMeansModel(String fileName) throws Exception{
        setTrainSet(fileName);
        simpleKMeans = new SimpleKMeans();
        simpleKMeans.setNumClusters(3);//so cum minh muon phan
        simpleKMeans.setDistanceFunction(new EuclideanDistance());
        simpleKMeans.buildClusterer(trainSet);
        System.out.println(simpleKMeans);
    }
    public void predictLabel(String fileName, String fileOut) throws Exception {
        ConverterUtils.DataSource dataSource1 = new ConverterUtils.DataSource(fileName);
        Instances instances = dataSource1.getDataSet();
        for(int i=0; i<instances.numInstances(); i++)
        {
            double pre = simpleKMeans.clusterInstance(instances.instance(i));
            System.out.println("Instance " + i + " belong to class " + pre);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
        bufferedWriter.write(instances.toString());
        bufferedWriter.newLine();;
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
