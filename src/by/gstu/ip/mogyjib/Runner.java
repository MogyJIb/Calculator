package by.gstu.ip.mogyjib;


import by.gstu.ip.mogyjib.models.Calculator;
import by.gstu.ip.mogyjib.utils.TaskUtil;

import java.io.IOException;


public class Runner {
    public static void main(String[] args){

        TaskUtil firstTask = new TaskUtil(Calculator::calculateSimpleExpression),
            secondTask = new TaskUtil(Calculator::calculateComplexExpression),
            thirdTask = new TaskUtil(Calculator::calculateComplexExpression);

        try {
            firstTask.make("files\\input_1.txt",
                    "files\\output_1.txt");

            secondTask.make("files\\input_2.txt",
                    "files\\output_2.txt");

            thirdTask.make("files\\input_3.txt",
                    "files\\output_3.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
