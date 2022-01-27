#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
//package ${package}.manager.xxljob;
//
//import com.xxl.job.core.biz.model.ReturnT;
//import com.xxl.job.core.handler.IJobHandler;
//import com.xxl.job.core.handler.annotation.JobHandler;
//import com.xxl.job.core.log.XxlJobLogger;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
///**
// * 用户任务调度
// *
// * @author gyl
// * @since 2.4.x
// */
//@JobHandler(value = "userJobHandler")
//@Slf4j
//@Component
//public class UserJobHandler extends IJobHandler {
//
//	@Override
//	public ReturnT<String> execute(String cmd) throws Exception {
//		XxlJobLogger.log("UserJobHandler execute successd!");
//		return SUCCESS;
//	}
//}
