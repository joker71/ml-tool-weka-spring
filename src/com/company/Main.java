package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
//        KNNModel model = new KNNModel("", "-K 1 -W 0 -A \"weka.core.neighboursearch.LinearNNSearch -A \\\"weka.core.EuclideanDistance -R first-last\\\"\"" ,null);
//        model.buildKNN("C:\\Users\\nhath\\Documents\\80.arff");
//        model.evaluationKNN("C:\\Users\\nhath\\Documents\\20.arff");
//        model.predictLabel("C:\\Users\\nhath\\Documents\\unlabel1.arff", "C:\\Users\\nhath\\Documents\\pre.arff");
//        System.out.println(model);
        ANNModel model = new ANNModel("",
                "-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a -R"
                ,null);
        model.buildANNModel("C:\\Users\\nhath\\Documents\\80.arff");
        model.evaluationANN("C:\\Users\\nhath\\Documents\\20.arff");
        model.predictLabel("C:\\Users\\nhath\\Documents\\unlabel1.arff", "C:\\Users\\nhath\\Documents\\pre.arff");
        System.out.println(model);
//            KMeansModel model = new KMeansModel();
//            model.buildKMeansModel("C:\\Users\\nhath\\Documents\\iris_cluster.arff");
//            model.predictLabel("C:\\Users\\nhath\\Documents\\unlabel2.arff", "C:\\Users\\nhath\\Documents\\pre.arff");
    }
}
