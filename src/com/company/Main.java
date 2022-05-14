package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
//        KNNModel model = new KNNModel("", null ,null);
//        model.buildKNN("E:\\Learning\\Java\\Machine_Learning_Spring_Weka\\src\\main\\resources\\arffs\\car_bin.arff");
//        model.evaluationKNN("E:\\Learning\\Java\\Machine_Learning_Spring_Weka\\src\\main\\resources\\arffs\\car_bin_test.arff");
//        model.predictLabel("E:\\Learning\\Java\\Machine_Learning_Spring_Weka\\src\\main\\resources\\arffs\\unlabel.arff", "C:\\Users\\nhath\\Documents\\pre.arff");
//        System.out.println(model);
        ANNModel model = new ANNModel("",
                "-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a -R"
                ,null);
        model.buildANNModel("E:\\Learning\\Java\\Machine_Learning_Spring_Weka\\src\\main\\resources\\arffs\\90.arff");
        model.evaluationANN("E:\\Learning\\Java\\Machine_Learning_Spring_Weka\\src\\main\\resources\\arffs\\10.arff");
        model.predictLabel("E:\\Learning\\Java\\Machine_Learning_Spring_Weka\\src\\main\\resources\\arffs\\unlabel1.arff", "C:\\Users\\nhath\\Documents\\pre.arff");
        System.out.println(model);

    }
}
