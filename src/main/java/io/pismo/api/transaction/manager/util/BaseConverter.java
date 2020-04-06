package io.pismo.api.transaction.manager.util;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pismo.api.transaction.manager.configuration.SpringConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BaseConverter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier(value = SpringConfig.GENERIC_CONVERTER_OBJECT)
	private ObjectMapper objectMapper;

	public <T> Optional<T> fromObjectToClass(Object object, Class<T> clazz) {
		try {
			String json = this.objectMapper.writeValueAsString(object);
			return Optional.of(this.objectMapper.readValue(json, clazz));
		} catch (JsonProcessingException e) {
			log.error("Unable to convert Object to Entity {} Cause: {}", clazz, e.getMessage());
		} catch (Exception e) {
			log.error("Error to convert Object to Entity: {} Cause: {}", e.getMessage(), e);
		}

		return Optional.empty();

	}

	public <T> List<T> fromObjectListToClass(List<?> objects, Class<T> clazz) {

		logger.info("Converter Entity List to Object List | Class:  {}", clazz.getName());

		return objects.stream().map(ob -> fromObjectToClass(ob, clazz)).filter(Optional::isPresent).map(Optional::get)
				.collect(Collectors.toList());

	}

}
