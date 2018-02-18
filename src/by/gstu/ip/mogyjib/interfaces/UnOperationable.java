package by.gstu.ip.mogyjib.interfaces;

import by.gstu.ip.mogyjib.utils.ConvertionUtil;


public interface UnOperationable {
    UnOperationable SIN = x -> Math.sin(ConvertionUtil.toRadians(x));
    UnOperationable COS = x -> Math.cos(ConvertionUtil.toRadians(x));
    UnOperationable TG = x -> Math.tan(ConvertionUtil.toRadians(x));
    UnOperationable SQRT = Math::sqrt;
    UnOperationable ZERO = x -> 0;

    double calculate(double number);
}
