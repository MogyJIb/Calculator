package by.gstu.ip.mogyjib;

import by.gstu.ip.mogyjib.models.Calculator;
import by.gstu.ip.mogyjib.utils.TaskUtil;

import java.io.IOException;

/**
 * The Calculator program is the application that
 * gets as input three files with math equation (input_1.txt,
 * input_2.txt, input_3.txt). In files each equation should
 * be written from new line.
 * <p>
 * Then it read each of them, solve all equation and
 * write answer to appropriate output files (output_1.txt,
 * output_2.txt, output_3.txt).
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 * @since 2018-02-17
 */
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
