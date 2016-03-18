package net.wuollet.jpa.interfaces.track;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import net.wuollet.jpa.domain.model.device.Device;
import net.wuollet.jpa.domain.model.device.DeviceRepository;
import net.wuollet.jpa.domain.model.device.TrackingId;
import net.wuollet.jpa.domain.model.event.WorkEvent;
import net.wuollet.jpa.domain.model.event.WorkEventRepository;

@Controller
@RequestMapping("/track")
public class TrackingController {

	@Autowired
	private DeviceRepository deviceRepository;
	@Autowired
	private WorkEventRepository workEventRepository;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String get(final TrackingCommand trackCommand) {
		return "track";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(final HttpServletRequest request, final TrackingCommand command, Model model, BindingResult bindingResult) {

		// validate TrackingCommand

		final TrackingId trackingId = new TrackingId(command.getTrackingId());
		final Device device = deviceRepository.findByTrackingId(trackingId);

		if (device != null) {
			final Locale locale = RequestContextUtils.getLocale(request);
			final List<WorkEvent> workEvents = workEventRepository.findByDeviceOrderByTimeOfDesc(device);
			model.addAttribute("device", new DeviceTrackingViewAdapter(device, messageSource, locale, workEvents));
		}

		return "track";
	}

}
