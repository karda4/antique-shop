package ua.kardach.antiqueshop.controllers;

import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ua.kardach.antiqueshop.service.OrderService;
import ua.kardach.antiqueshop.service.UserService;

/**
 * @author Yura Kardach
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private UserService userServiceMock;
	@Mock
	private OrderService orderServiceMock;
	
	@Before
	public void setUp(){
		LoginController loginController = new LoginController();
		loginController.setUserService(userServiceMock);
		loginController.setOrderService(orderServiceMock);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController)
				.setHandlerExceptionResolvers(exceptionResolver())
				.setValidator(validator())
				.setViewResolvers(viewResolver())
				.build();
	}
	
	private HandlerExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		
		Properties exceptionMappings = new Properties();
		exceptionMappings.put("java.lang.Exception", "error/error");
		exceptionMappings.put("java.lang.RuntimeException", "error/error");
		
		exceptionResolver.setExceptionMappings(exceptionMappings);
		
		Properties statusCodes = new Properties();
		statusCodes.put("error/404", "404");
		statusCodes.put("error/error", "500");
		
		exceptionResolver.setStatusCodes(statusCodes);
		
		return exceptionResolver;
	}
	
	private Validator validator() {
		return new LocalValidatorFactoryBean();
	}

	private ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
}
