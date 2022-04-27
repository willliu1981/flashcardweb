package test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AfterHandler implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {

		if (bean.getClass().equals(Car.class)) {

			Car car = (Car) bean;
			if (car.getPrice() == 0) {
				car.setPrice(200000);
			}
		}

		return BeanPostProcessor.super.postProcessBeforeInitialization(bean,
				beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return BeanPostProcessor.super.postProcessAfterInitialization(bean,
				beanName);
	}

}
