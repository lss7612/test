package test.beanUtils;

import org.springframework.beans.BeanUtils;

import test.beanUtils.data.AfterCopy;
import test.beanUtils.data.BeforeCopy;

public class Test {

	public static void main(String[] args) {
		BeforeCopy before = new BeforeCopy();
		before.setAge("11");
		before.setName("A");
		
		AfterCopy after = new AfterCopy();
		
		BeanUtils.copyProperties(before, after);
		
		System.out.println(after);
		
	}
	
}
