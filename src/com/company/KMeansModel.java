package com.company;

import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class KMeansModel {
    SimpleKMeans simpleKMeans;
    Instances train_data;
    String[] data_options;
    String[] model_options;
    public void buildKMeansModel(String fileName) throws  Exception
    {
        MyDataModel myDataModel = new MyDataModel(fileName);
        this.simpleKMeans = new SimpleKMeans();
        this.simpleKMeans.setNumClusters(4);
        this.simpleKMeans.setDistanceFunction(new EuclideanDistance());
        this.simpleKMeans.buildClusterer(myDataModel.instances);
        System.out.println(this.simpleKMeans);
    }
    public void predictCluster(String fileIn) throws Exception
    {
        ConverterUtils.DataSource dataSource =  new ConverterUtils.DataSource(fileIn);
        Instances unLabel = dataSource.getDataSet();
        for(int i = 0; i < unLabel.numInstances(); i++)
        {

        }
    }

}
