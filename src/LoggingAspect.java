import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    // Логируем все методы
    @Around("execution(* *(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();

        System.out.println("[INFO] Вызов метода: " + signature.getName());
        System.out.println("[INFO] Параметры: " + java.util.Arrays.toString(args));

        Object result = null;
        try {
            result = joinPoint.proceed(); // вызываем оригинальный метод
            System.out.println("[INFO] Возвращаемое значение: " + result);
        } catch (Throwable t) {
            System.out.println("[INFO] Исключение в методе " + signature.getName() + ": " + t);
            throw t;
        }
        return result;
    }
}
