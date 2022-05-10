package com.company;

import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.gui.beans.DataSource;

public class MyDataModel {

    ConverterUtils.DataSource dataSource;
    Instances instances;

    public MyDataModel(){}
    public MyDataModel(String fileName) throws Exception{
        // tao model MyDataModel voi file dau vao fileName
        this.dataSource= new ConverterUtils.DataSource(fileName);
        this.instances= dataSource.getDataSet();
    }
    public Instances setData(double percent, boolean isTest) throws Exception
    {
        //inputData: data dau vao
        //percent: tỉ lệ phần trăm dữ liệu đc dữ lại
        //isTesst: true, nếu muốn tạo data test, false nếu muốn tạo data train
        RemovePercentage removePercentage = new RemovePercentage();
        removePercentage.setPercentage(percent);
        removePercentage.setInvertSelection(isTest);
        removePercentage.setInputFormat(this.instances);
        return  removePercentage.useFilter(this.instances, removePercentage);
    }

}
