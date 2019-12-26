package com.htsc.carma.carma.point;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author DELL
 */
@Aspect
@Component
public class ServiceInterceptor {

    static Logger logger = LoggerFactory.getLogger(ServiceInterceptor.class);

    /**
     * 定义一个切入点. 解释下：
     *
     * ~ 第一个 * 代表任意修饰符及任意返回值. ~ 第二个 * 定义在web包或者子包 ~ 第三个 * 任意方法 ~ .. 匹配任意数量的参数.
     */
    static final String pCutStr = "execution(* com.htsc.carma.carma.api.service.*..*(..))";

    @Pointcut(value = pCutStr)
    public void logPointcut() {
    }

    @Around("logPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            if(result==null){
                //如果切到了 没有返回类型的void方法，这里直接返回
                return null;
            }
            long end = System.currentTimeMillis();
            logger.info("===================");
            String tragetClassName = joinPoint.getSignature().getDeclaringTypeName();
            String MethodName = joinPoint.getSignature().getName();
            // 参数
            Object[] args = joinPoint.getArgs();
            int argsSize = args.length;
            String argsTypes = "";
            String typeStr = joinPoint.getSignature().getDeclaringType().toString().split(" ")[0];
            String returnType = joinPoint.getSignature().toString().split(" ")[0];
            logger.info("类/接口:" + tragetClassName + "(" + typeStr + ")");
            logger.info("方法:" + MethodName);
            logger.info("参数个数:" + argsSize);
            logger.info("返回类型:" + returnType);
            logger.info("调用者："+Thread.currentThread().getStackTrace());
            if (argsSize > 0) {
                // 拿到参数的类型
                for (Object object : args) {
                    argsTypes += object.getClass().getTypeName().toString() + " ";
                }
                logger.info("参数类型：" + argsTypes);
            }

            Long total = end - start;
            logger.info("耗时: " + total + " ms!");
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            logger.info("====around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
                    + e.getMessage());
            throw e;
        }
    }
}
