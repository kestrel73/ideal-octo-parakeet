package net.wuollet.jpa.interfaces.track;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.context.WebApplicationContext;

import net.wuollet.jpa.JpaTestsApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = JpaTestsApplication.class)
public class TrackingControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testPost() throws Exception {
		MockHttpServletRequestBuilder trackRequest = post("/track").param("trackingId", "01");

		Map<String, Object> model = mockMvc.perform(trackRequest).andReturn().getModelAndView().getModel();

		DeviceTrackingViewAdapter deviceTrackingViewAdapter = (DeviceTrackingViewAdapter) model.get("device");
		assertEquals("01", deviceTrackingViewAdapter.getTrackingId());
	}

	@Test
	public void cannotGetUnknownDevice() throws Exception {
		final String trackingId = "BADID";
		MockHttpServletRequestBuilder trackRequest = post("/track").param("trackingId", trackingId);
		Map<String, Object> model = mockMvc.perform(trackRequest).andReturn().getModelAndView().getModel();
		Errors errors = (Errors)model.get(BindingResult.MODEL_KEY_PREFIX + "trackingCommand");
		FieldError fe = errors.getFieldError("trackingId");
		assertEquals("device.unknown_id", fe.getCode());
		assertEquals(1, fe.getArguments().length);
		assertEquals(trackingId, fe.getArguments()[0]);
	}

}
