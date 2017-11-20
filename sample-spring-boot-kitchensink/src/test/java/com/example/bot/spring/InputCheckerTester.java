//package com.example.bot.spring;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.io.InputStream;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.google.common.io.ByteStreams;
//
//import com.linecorp.bot.client.LineMessagingClient;
//import com.linecorp.bot.model.ReplyMessage;
//import com.linecorp.bot.model.event.Event;
//import com.linecorp.bot.model.event.FollowEvent;
//import com.linecorp.bot.model.event.MessageEvent;
//import com.linecorp.bot.model.event.message.MessageContent;
//import com.linecorp.bot.model.event.message.TextMessageContent;
//import com.linecorp.bot.model.message.TextMessage;
//import com.linecorp.bot.spring.boot.annotation.LineBotMessages;
//
//import lombok.NonNull;
//import lombok.extern.slf4j.Slf4j;
//
//
//@RunWith(SpringRunner.class)
////@SpringBootTest(classes = { KitchenSinkTester.class, DatabaseEngine.class })
//@SpringBootTest(classes = { InputChecker.class, InputCheckerTester.class })
//public class InputCheckerTester {
//	@Autowired
//	private InputChecker checker;
//	private SQLDatabaseEngine database;
//
//	@Test
//	public void testValidName() throws Exception {
//		String valid_input = "valid";
//		String invalid_input = "asfahsfhasfuasoifuasoifuoasifuoaiufoiasufoiasufsfiaufoiaufoiausofiaus";
//		assertThat((checker.ValidName(valid_input)==true)&&(checker.ValidName(invalid_input)==false)).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidGender() throws Exception {
//		String valid_input1 = "M";
//		String valid_input2 = "F";
//		String invalid_input = "asfahsfhasfuasoifua";
//		assertThat((checker.ValidGender(valid_input1)==true)&&(checker.ValidGender(valid_input2)==true)&&(checker.ValidGender(invalid_input)==false)).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidHeight() throws Exception {
//
//		String valid_input1 = "100";
//		String valid_input2 = "51";
//		String valid_input3 = "259";
//		String invalid_input2 = "49";
//		String invalid_input3 = "261";
//		String invalid_input4 = "260";
//		String invalid_input5 = "50";
//
//
//		boolean check1 = (checker.ValidHeight(valid_input1)==true);
//		boolean check2 = (checker.ValidHeight(valid_input2)==true);
//		boolean check3 = (checker.ValidHeight(valid_input3)==true);
//
//		boolean check5 = (checker.ValidHeight(invalid_input2)==false);
//		boolean check6 = (checker.ValidHeight(invalid_input3)==false);
//		boolean check7 = (checker.ValidHeight(invalid_input4)==false);
//		boolean check8 = (checker.ValidHeight(invalid_input5)==false);
//
//		assertThat(check1&&check2&&check3&&check5&&check6&&check7&&check8).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidWeight() throws Exception {
//		String valid_input1 = "100";
//		String valid_input2 = "21";
//		String valid_input3 = "199";
//		String invalid_input2 = "19";
//		String invalid_input3 = "201";
//		String invalid_input4 = "200";
//		String invalid_input5 = "20";
//
//		boolean check2 = (checker.ValidWeight(valid_input2)==true);
//		boolean check3 = (checker.ValidWeight(valid_input3)==true);
//
////		boolean check4 = (checker.ValidWeight(invalid_input1)==false);
//		boolean check5 = (checker.ValidWeight(invalid_input2)==false);
//		boolean check6 = (checker.ValidWeight(invalid_input3)==false);
//		boolean check7 = (checker.ValidWeight(invalid_input4)==false);
//		boolean check8 = (checker.ValidWeight(invalid_input5)==false);
//
////		boolean thrown = false;
////		try {
////
////		}
////		catch (Exception e) {
////
////		}
//
//		assertThat(check2&&check3&&check5&&check6&&check7&&check8).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidAge() throws Exception {
//		String valid_input1 = "100";
//		String invalid_input1 = "6";
//		String invalid_input2 = "151";
//
//
//		boolean check1 = (checker.ValidAge(valid_input1)==true);
//
//
//		boolean check2 = (checker.ValidAge(invalid_input1)==false);
//		boolean check3 = (checker.ValidAge(invalid_input2)==false);
//
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidExercise() throws Exception {
//		String valid_input1 = "8";
//
//
//		String invalid_input1 = "18";
//		String invalid_input2 = "-1";
//
//
//		boolean check1 = (checker.ValidExercise(valid_input1)==true);
//
//		boolean check2 = (checker.ValidExercise(invalid_input1)==false);
//		boolean check3 = (checker.ValidExercise(invalid_input2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidBodyfat() throws Exception {
//		String valid_input1 = "40";
//
//
//		String invalid_input1 = "80";
//		String invalid_input2 = "1";
//
//		boolean check1 = (checker.ValidBodyfat(valid_input1)==true);
//
//		boolean check2 = (checker.ValidBodyfat(invalid_input1)==false);
//		boolean check3 = (checker.ValidBodyfat(invalid_input2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidCalories() throws Exception {
//		String valid_input1 = "40";
//
//		String invalid_input1 = "0";
//		String invalid_input2 = "15000";
//
//		boolean check1 = (checker.ValidCalories(valid_input1)==true);
//
//		boolean check2 = (checker.ValidCalories(invalid_input1)==false);
//		boolean check3 = (checker.ValidCalories(invalid_input2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidAmount() throws Exception {
//		String valid_input1 = "40";
//
//		String invalid_input1 = "0";
//		String invalid_input2 = "15000";
//
//		boolean check1 = (checker.ValidAmount(valid_input1)==true);
//
//		boolean check2 = (checker.ValidAmount(invalid_input1)==false);
//		boolean check3 = (checker.ValidAmount(invalid_input2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidDate() throws Exception {
//		String valid_input1 = "25000000";
//
//		String invalid_input1 = "0";
//		String invalid_input2 = "40000000";
//
//		boolean check1 = (checker.ValidDate(valid_input1)==true);
//
//		boolean check2 = (checker.ValidDate(invalid_input1)==false);
//		boolean check3 = (checker.ValidDate(invalid_input2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidCarbs() throws Exception {
//		String valid_input1 = "1500";
//
//		String invalid_input1 = "0";
//		String invalid_input2 = "3000";
//
//		boolean check1 = (checker.ValidCarbs(valid_input1)==true);
//
//		boolean check2 = (checker.ValidCarbs(invalid_input1)==false);
//		boolean check3 = (checker.ValidCarbs(invalid_input2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidProtein() throws Exception {
//		String valid_input1 = "500";
//
//		String invalid_input1 = "0";
//		String invalid_input2 = "1000";
//
//		boolean check1 = (checker.ValidProtein(valid_input1)==true);
//
//		boolean check2 = (checker.ValidProtein(invalid_input1)==false);
//		boolean check3 = (checker.ValidProtein(invalid_input2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidVegfruit() throws Exception {
//		String valid_input1 = "25";
//
//		String invalid_input1 = "0";
//		String invalid_input2 = "50";
//
//		boolean check1 = (checker.ValidVegfruit(valid_input1)==true);
//
//		boolean check2 = (checker.ValidVegfruit(invalid_input1)==false);
//		boolean check3 = (checker.ValidVegfruit(invalid_input2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testValidOtherinfo() throws Exception {
//		String valid_input1 = "2fasfasf5";
//
//		String invalid_input1 = "ValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfo";
//
//		boolean check1 = (checker.ValidOtherinfo(valid_input1)==true);
//
//		boolean check2 = (checker.ValidOtherinfo(invalid_input1)==false);
//
//		assertThat(check1&&check2).isEqualTo(true);
//	}
//
//	@Test
//	public void testAgeEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "50";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.AgeEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.AgeEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.AgeEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testGenderEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "M";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.GenderEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.GenderEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.GenderEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testNameEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "LIUCHENG";
//		String invalid_text1 = "fasfljkasflaksjflkasjflkasjflkajflkasjlfkjasklfjaslkfjasl";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.NameEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.NameEditting(invalid_text1, user, database, mode2)==false);
//
//		assertThat(check1&&check2).isEqualTo(true);
//	}
//
//	@Test
//	public void testWeightEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "60";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.WeightEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.WeightEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.WeightEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testHeightEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "180";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.HeightEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.HeightEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.HeightEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testBodyfatEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "40";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.BodyfatEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.BodyfatEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.BodyfatEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testExerciseEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "8";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.ExerciseEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.ExerciseEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.ExerciseEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testCaloriesEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "1000";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.CaloriesEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.CaloriesEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.CaloriesEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testCarbsEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "1000";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.CarbsEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.CarbsEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.CarbsEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testProteinEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "500";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.ProteinEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.ProteinEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.ProteinEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testVegfruitEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "25";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.VegfruitEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.VegfruitEditting(invalid_text1, user, database, mode2)==false);
//		boolean check3 =(checker.VegfruitEditting(invalid_text2, user, database, mode2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//
//	@Test
//	public void testOtherinfoEditting() {
//		Users user = new Users("r12r21i489y", "test_can_delete");
//
//		String valid_text1 = "25";
//		String invalid_text1 = "-ValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherialidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidalidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOthdOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfoValidOtherinfo";
//		String mode1 ="update";
//		String mode2 ="set";
//		String mode3 ="abc";
//
//		boolean check1 =(checker.OtherinfoEditting(valid_text1, user, database, mode2)==true);
//		boolean check2 =(checker.OtherinfoEditting(invalid_text1, user, database, mode2)==false);
//
//		assertThat(check1&&check2).isEqualTo(true);
//	}
//
//
//	@Test
//	public void testfoodAdd() {
//		FoodInfo test = new FoodInfo();
//
//		String valid_text1 = "25";
//		String invalid_text1 = "abc";
//		String invalid_text2 = "213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123213231231232132312312321323123123";
//
//		boolean check1 =(checker.foodAdd(valid_text1, test, database)==true);
//		boolean check2 =(checker.foodAdd(invalid_text1, test, database)==true);
//		boolean check3 =(checker.foodAdd(invalid_text2, test, database)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testenergyAdd() {
//		FoodInfo test1 = new FoodInfo();
//
//		String valid_text1 = "25";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//
//
//		boolean check1 =(checker.energyAdd(valid_text1, test1, database)==true);
//		boolean check2 =(checker.energyAdd(invalid_text1, test1, database)==false);
//		boolean check3 =(checker.energyAdd(invalid_text1, test1, database)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testproteinAdd() {
//		FoodInfo test1 = new FoodInfo();
//
//		String valid_text1 = "25";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//
//
//		boolean check1 =(checker.proteinAdd(valid_text1, test1, database)==true);
//		boolean check2 =(checker.proteinAdd(invalid_text1, test1, database)==false);
//		boolean check3 =(checker.proteinAdd(invalid_text1, test1, database)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testfiberAdd() {
//		FoodInfo test1 = new FoodInfo();
//
//		String valid_text1 = "25";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//
//
//		boolean check1 =(checker.fiberAdd(valid_text1, test1, database)==true);
//		boolean check2 =(checker.fiberAdd(invalid_text1, test1, database)==false);
//		boolean check3 =(checker.fiberAdd(invalid_text1, test1, database)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//
//	@Test
//	public void testpriceAdd() {
//		FoodInput test1 = new FoodInput("test", "20171111");
//
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//
//
//		boolean check2 =(checker.priceAdd(invalid_text1, test1, database)==false);
//		boolean check3 =(checker.priceAdd(invalid_text1, test1, database)==false);
//
//		assertThat(check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testFoodAdd() {
//		FoodInput test1 = new FoodInput("test", "20171111");
//
//		String valid_text1 = "25";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "asjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkasjjjjjjjjjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
//
//
//		boolean check1 =(checker.foodAdd(valid_text1, test1, database)==true);
//		boolean check2 =(checker.foodAdd(invalid_text1, test1, database)==true);
//		boolean check3 =(checker.foodAdd(invalid_text2, test1, database)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void test_priceAdd() {
//		FoodInfo test1 = new FoodInfo();
//
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//
//		boolean check2 =(checker.priceAdd(invalid_text1, test1, database)==false);
//		boolean check3 =(checker.priceAdd(invalid_text1, test1, database)==false);
//
//		assertThat(check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testamountAdd() {
//		FoodInput test1 = new FoodInput("test", "20171111");
//
//		String valid_text1 = "500";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//
//
//		boolean check1 =(checker.amountAdd(valid_text1, test1, database)==true);
//		boolean check2 =(checker.amountAdd(invalid_text1, test1, database)==false);
//		boolean check3 =(checker.amountAdd(invalid_text2, test1, database)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//	@Test
//	public void testdateCheck() {
//
//		String valid_text1 = "20171111";
//		String invalid_text1 = "-10";
//		String invalid_text2 = "abc";
//
//
//		boolean check1 =(checker.dateCheck(valid_text1)==true);
//		boolean check2 =(checker.dateCheck(invalid_text1)==false);
//		boolean check3 =(checker.dateCheck(invalid_text2)==false);
//
//		assertThat(check1&&check2&&check3).isEqualTo(true);
//	}
//
//}