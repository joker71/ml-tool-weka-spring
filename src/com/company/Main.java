package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        KNNModel knnModel = new KNNModel("E:\\Learning\\Data mindning\\car_bin.arff", "E:\\Learning\\Data mindning\\car_bin_test.arff" );
        knnModel.buildKnn();
        knnModel.evalateKnn();
        knnModel.predictClassLabel("E:\\Learning\\Data mindning\\unlabel.arff", "E:\\Learning\\Data mindning\\pre4.arff");
    }
}
