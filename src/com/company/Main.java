package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        KNNModel knnModel = new KNNModel("E:\\Learning\\Data mindning\\iris.arff");
        knnModel.buildKnn();
        knnModel.evalateKnn();
        knnModel.predictClassLabel("E:\\Learning\\Data mindning\\unlabel.arff", "E:\\Learning\\Data mindning\\pre.arff");
    }
}
