package com.company;

import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.Range;
import weka.core.converters.ConverterUtils;

import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class KNNModel{
    IBk iBk;
    Evaluation evaluation;
    Instances test_data, train_data;
    String[] data_options;
    String[] model_options;
    public KNNModel(String fileName) throws Exception{
        //lấy file đầu vào
        MyDataModel myDataModel = new MyDataModel(fileName);
        //chia file thành bộ test và bộ train
        train_data = myDataModel.setData(70, false);
        test_data = myDataModel.setData(70, true);
    }
    public void buildKnn() throws Exception {
        //xây dựng model
        this.train_data.setClassIndex(this.train_data.numAttributes() - 1);
        this.iBk = new IBk(); //khoi tao mo hinh
        this.iBk.setOptions(model_options); //khoi tao mo hinh, dua option vao mo hinh
        this.iBk.buildClassifier(train_data); // xay dung mô hình
    }
    public void evalateKnn() throws Exception {
        this.test_data.setClassIndex(this.test_data.numAttributes() - 1);
        Debug.Random rd = new Debug.Random();
        //danh gia mo hinh 10 folds-cross validate model
        int folds = 10;
        this.evaluation = new Evaluation(this.test_data);
        this.evaluation.crossValidateModel(this.iBk, this.test_data ,folds, rd);
        System.out.println(this.evaluation.toSummaryString("ket qua danh gia mo hinh KNN", false));
    }
    public void predictClassLabel(String fileIn, String fileOut) throws Exception
    {
        //danh gia
        ConverterUtils.DataSource dataSource =  new ConverterUtils.DataSource(fileIn);
        Instances unLabel = dataSource.getDataSet();
        unLabel.setClassIndex(unLabel.numAttributes() - 1);
        //for tu dau den cuoi tung instans
        for (int i = 0; i < unLabel.numInstances()-1; i++)
        {
            //gan nhan cho tung doi tuong chua nhan
            double predict = iBk.classifyInstance(unLabel.instance(i));
            unLabel.instance(i).setClassValue(predict);
        }
        //ghi file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOut));
        bufferedWriter.write(unLabel.toString());
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
