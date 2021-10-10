#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ${package}.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.ylzl.eden.spring.boot.commons.lang.StringConstants;

import java.util.Arrays;

/**
 * 日志切面
 *
 * @author gyl
 * @since 1.0.0
 */
@Slf4j
@Aspect
public class LoggingAspect {

  @Pointcut(
      "within(@org.springframework.stereotype.Service *)"
          + " || within(@org.springframework.stereotype.Controller *)"
          + " || within(@org.springframework.stereotype.Component *)"
          + " || within(@org.springframework.web.bind.annotation.RestController *)")
  public void springBeanPointcut() {}

  @Pointcut(
      "within(${package}.client..*)"
          + " || within(${package}.repository..*)"
          + " || within(${package}.service..*)")
  public void applicationPackagePointcut() {}

  @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
    log.error(
        "Exception in {}.{}() with cause = '{}' and exception = '{}'",
        joinPoint.getSignature().getDeclaringTypeName(),
        joinPoint.getSignature().getName(),
        e.getCause() != null ? e.getCause() : "NULL",
        e.getMessage(),
        e);
  }

  @Around("applicationPackagePointcut() && springBeanPointcut()")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    if (log.isDebugEnabled()) {
      log.debug(
          "Enter: {}.{}() with argument[s] = {}",
          joinPoint.getSignature().getDeclaringTypeName(),
          joinPoint.getSignature().getName(),
          Arrays.toString(joinPoint.getArgs()));
    }
    try {
      Object result = joinPoint.proceed();
      if (log.isDebugEnabled()) {
        String str = result != null ? result.toString() : StringConstants.EMPTY;
        log.debug(
            "Exit: {}.{}() with result = {}",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(),
            str.length() > 500 ? str.substring(0, 500) : str);
      }
      return result;
    } catch (IllegalArgumentException e) {
      log.error(
          "Illegal argument: {} in {}.{}()",
          joinPoint.getSignature().getDeclaringTypeName(),
          joinPoint.getSignature().getName(),
          Arrays.toString(joinPoint.getArgs()));
      throw e;
    }
  }
}
