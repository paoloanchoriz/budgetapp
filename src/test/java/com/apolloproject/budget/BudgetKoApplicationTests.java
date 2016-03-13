package com.apolloproject.budget;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apolloproject.budget.BudgetKoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BudgetKoApplication.class)
@WebAppConfiguration
public class BudgetKoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
