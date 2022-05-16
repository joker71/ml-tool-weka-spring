package com.company;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;


public class MyDataModel {
    Instances dataset;
    Instances testSet;
    Instances trainSet;
    String[] data_options;
    String[] model_options;
    ConverterUtils.DataSource dataSource;

    public MyDataModel() {
    }

    public MyDataModel(String filename, String model_option, String data_option) throws Exception {
        if (!filename.isEmpty()) {
            this.dataSource = new ConverterUtils.DataSource(filename);
            this.dataset = this.dataSource.getDataSet();
        }
        if (model_option != null) {
            this.model_options = weka.core.Utils.splitOptions(model_option);
        }
        if (data_option != null) {
            this.data_options = weka.core.Utils.splitOptions(data_option);
        }
    }

    public void setTestSet(String fileName) throws Exception {
        ConverterUtils.DataSource testDataSource = new ConverterUtils.DataSource(fileName);
        this.testSet = testDataSource.getDataSet();
    }

    public void setTrainSet(String fileName) throws Exception {
        ConverterUtils.DataSource trainSetSource = new ConverterUtils.DataSource(fileName);
        this.trainSet = trainSetSource.getDataSet();
    }
}
