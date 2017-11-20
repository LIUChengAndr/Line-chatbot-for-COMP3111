package com.example.bot.spring;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.io.ByteStreams;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.MessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.LineBotMessages;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
//@SpringBootTest(classes = { KitchenSinkTester.class, DatabaseEngine.class })
@SpringBootTest(classes = { StageHandler.class, StageHandlerTester.class })
public class StageHandlerTester {
//	@Autowired
//	private StageHandler handler;
	
	@Test
	public void initStageHandlerTest() {
		StageHandler handler = new StageHandler();
		SQLDatabaseEngine db = new SQLDatabaseEngine();
		Users user = new Users("test");
		boolean thrown = false;
		user.setSubStage(0);
		db.pushUser(user);
		String[] validInput = 	{"valid ", 
								"validname",
								"M",
								"180",
								"70",
								"30"
								};
		String[] invalidInput = 	{"valid", 
								"invalidinvalidinvalidinvalidinvalidinvalidinvalidinvalidinvalidinvalidinvalidinvalidinvalidinvalidinvalid",
								"invalid",
								"invalid",
								"invalid",
								"invalid"
								};
		try {
			for(int subStage=0; subStage <=5; subStage++){
				user.setSubStage(subStage);
				handler.initStageHandler("test", validInput[subStage], user, db);
				handler.initStageHandler("test", invalidInput[subStage], user, db);
			}
		}catch (Exception e) {
			thrown = true;
		}
		assertThat(!thrown).isEqualTo(true);
	}

	@Test
	public void dietPlannerHandlerTest_case0() {
		StageHandler handler = new StageHandler();
		SQLDatabaseEngine db = new SQLDatabaseEngine();
		Users user = new Users("test");
		boolean thrown = false;
		user.setSubStage(0);
		db.pushUser(user);
		//case 0
	
		try {
				user.setBodyFat(0);
				handler.dietPlannerHandler("test", "test", user, db);
				user.setBodyFat(30);
				handler.dietPlannerHandler("test", "test", user, db);
		}catch (Exception e) {
			thrown = true;
		}
		assertThat(!thrown).isEqualTo(true);
	}
	
	@Test
	public void dietPlannerHandlerTest_case_lesethan_5() {
		StageHandler handler = new StageHandler();
		SQLDatabaseEngine db = new SQLDatabaseEngine();
		Users user = new Users("test");
		boolean thrown = false;
		db.pushUser(user);
		//case 0
		user.setSubStage(-1);
		handler.dietPlannerHandler("test", "5", user, db);
		user.setSubStage(-1);
		handler.dietPlannerHandler("test", "10", user, db);

		try {
			for(int subStage = 1; subStage < 5; subStage ++) {
				user.setSubStage(subStage);
				handler.dietPlannerHandler("test", "test", user, db);
			}
		}catch (Exception e) {
			thrown = true;
		}
		assertThat(!thrown).isEqualTo(true);
	}
	@Test
	public void dietPlannerHandlerTest_case_5() {
		StageHandler handler = new StageHandler();
		SQLDatabaseEngine db = new SQLDatabaseEngine();
		Users user = new Users("test");
		user.setGender('M');
		user.setAge(30);
		
		boolean thrown = false;
		db.pushUser(user);
		//case 5
		try {
			user.setSubStage(5);
			handler.dietPlannerHandler("test", "5", user, db);
			user.setSubStage(5);
			handler.dietPlannerHandler("test", "10", user, db);
		}catch (Exception e) {
			thrown = true;
		}
		assertThat(!thrown).isEqualTo(true);
	}
	
	
	
}

		
