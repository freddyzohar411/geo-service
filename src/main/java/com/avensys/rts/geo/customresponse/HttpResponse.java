package com.avensys.rts.geo.customresponse;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pranay Patadiya This class is used to create a custom response for
 *         the API calls. It is used to return a custom response to the client.
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HttpResponse {
	private int code;
	private boolean error;
	private String message;
	private Object data;
	private Map<?, ?> audit;
	private LocalDateTime timestamp = LocalDateTime.now();
}
