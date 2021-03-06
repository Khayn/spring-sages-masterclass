package spring.masterclass.sages.common.profiler;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Order(10)
@Log
@Aspect
public class Profiler {

    @Around("execution(* spring.masterclass.sages.payments.FakePaymentService.process(..))")
    //@Around("bean(paymentService)")
    //@Around(value = "@annotation(ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object result = proceedingJoinPoint.proceed();
        long totalTime = System.nanoTime() - startTime;

        log.info(String.format("%s executed in %d ns", proceedingJoinPoint.getSignature(), totalTime));

        return result;
    }
}
